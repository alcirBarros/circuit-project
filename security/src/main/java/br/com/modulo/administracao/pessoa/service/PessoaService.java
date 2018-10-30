package br.com.modulo.administracao.pessoa.service;

import br.com.modulo.administracao.aluno.model.Pessoa;
import br.com.modulo.administracao.pessoa.dao.PessoaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaDAO pessoaDAO;
    
    public Pessoa carregar(String nome) {
        return pessoaDAO.carregar(nome);
    }
}
