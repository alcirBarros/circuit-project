package br.com.modulo.configuracao.instituicao.service;

import br.com.modulo.configuracao.instituicao.dao.InstituicaoDAO;
import br.com.modulo.configuracao.instituicao.model.Instituicao;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements Serializable {

    private static final long serialVersionUID = -2209720507806533979L;

    @Autowired
    private InstituicaoDAO clienteDAO;

    public void salvar(Instituicao cliente) {
        clienteDAO.salvar(cliente);
    }

    public Instituicao alterar(Instituicao cliente) {
        return clienteDAO.alterar(cliente);
    }

    public void excluir(Instituicao cliente) {
        clienteDAO.excluir(cliente);
    }

    public List<Instituicao> listar() {
        return clienteDAO.listar();
    }
}
