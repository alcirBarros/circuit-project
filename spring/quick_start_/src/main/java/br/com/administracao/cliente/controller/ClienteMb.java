package br.com.administracao.cliente.controller;

import br.com.administracao.cliente.model.Cliente;
import br.com.administracao.cliente.model.ContatoRealizado;
import br.com.administracao.cliente.service.ClienteService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class ClienteMb implements Serializable {

    private static final long serialVersionUID = -2753121484297994226L;

    @Autowired
    private ClienteService clienteService;

    private List<Cliente> clienteList = new ArrayList<>();

    private Cliente cliente = Cliente.criarInstancia();
    private ContatoRealizado contatoRealizado = ContatoRealizado.criarInstancia();

    @PostConstruct
    private void init() {
        System.out.println("Init ClienteMb.java");
    }

    public void inserir() {
    }

    public void salvar() {
        clienteService.salvar(cliente);
    }

    public void alterar() {

    }

    public void visualizar() {
    }

    public void excluir() {
        cliente = new Cliente();
        contatoRealizado = new ContatoRealizado();
        clienteList = clienteService.listar();

    }

    public void cancelar() {
        cliente = new Cliente();
        contatoRealizado = new ContatoRealizado();
    }

    public void adicionar() {
        cliente.adicionar(contatoRealizado);
        contatoRealizado = new ContatoRealizado();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public ContatoRealizado getContatoRealizado() {
        return contatoRealizado;
    }

    public void setContatoRealizado(ContatoRealizado contatoRealizado) {
        this.contatoRealizado = contatoRealizado;
    }
}
