package br.com.modulo.administracao.aluno.service;

import br.com.modulo.administracao.aluno.dao.AlunoDAO;
import br.com.modulo.administracao.aluno.model.Aluno;
import br.com.modulo.administracao.registroimportacao.model.RegistroImportacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoDAO alunoDAO;

    public Aluno salvar(Aluno aluno) {
        return alunoDAO.salvar(aluno);
    }

    public Aluno carregar(RegistroImportacao registroImportacao) {
        return alunoDAO.carregar(registroImportacao);
    }

    public Aluno localizar(String nomeAluno) {
        return alunoDAO.localizar(nomeAluno);
    }
}
