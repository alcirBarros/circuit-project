package br.com.modulo.administracao.pessoa.service;

import br.com.modulo.administracao.aluno.model.Pessoa;
import br.com.modulo.administracao.pessoa.dao.PessoaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaDAO pessoaDAO;

    public void salvar(Pessoa pessoa) {
        pessoaDAO.salvar(pessoa);
    }

    public Pessoa alterar(Pessoa pessoa) {
        return pessoaDAO.alterar(pessoa);
    }

    public Pessoa carregarCPF(String cpf) {
        return pessoaDAO.carregarCPF(cpf);
    }
}
