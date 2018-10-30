package br.com.administracao.cliente.service;

import br.com.administracao.cliente.dao.ClienteDAO;
import br.com.administracao.cliente.model.Cliente;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements Serializable {

    private static final long serialVersionUID = -2209720507806533979L;

    @Autowired
    private ClienteDAO clienteDAO;

    public void salvar(Cliente cliente) {
        clienteDAO.salvar(cliente);
    }

    public Cliente alterar(Cliente cliente) {
        return clienteDAO.alterar(cliente);
    }

    public void excluir(Cliente cliente) {
        clienteDAO.excluir(cliente);
    }

    public List<Cliente> listar() {
        return clienteDAO.listar();
    }
}
