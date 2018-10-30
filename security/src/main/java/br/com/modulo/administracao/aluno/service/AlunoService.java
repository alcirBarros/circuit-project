package br.com.modulo.administracao.aluno.service;

import br.com.modulo.administracao.aluno.dao.AlunoDAO;
import br.com.modulo.administracao.aluno.model.Aluno;
import br.com.modulo.administracao.uploadedfile.model.RegistroImportacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoDAO alunoDAO;

    public Aluno carregar(RegistroImportacao registroImportacao) {
        return alunoDAO.carregar(registroImportacao);
    }
}
