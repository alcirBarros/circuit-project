package br.com.modulo.administracao.instituicao.controller;

import br.com.modulo.administracao.instituicao.model.Instituicao;
import br.com.modulo.administracao.instituicao.service.ClienteService;

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

    private List<Instituicao> clienteList = new ArrayList<>();

    private Instituicao cliente = new Instituicao();

    @PostConstruct
    private void init() {
        System.out.println("Init ClienteMb.java");
    }

    public void inserir() {
    }

    public void salvar() {
        try {
            clienteService.salvar(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterar() {

    }

    public void visualizar() {
    }

    public void excluir() {
        cliente = new Instituicao();
        clienteList = ClienteService.listar();

    }

    public void cancelar() {
        cliente = new Instituicao();
    }

    public void adicionar() {

    }

    public Instituicao getCliente() {
        return cliente;
    }

    public void setCliente(Instituicao cliente) {
        this.cliente = cliente;
    }

    public List<Instituicao> getClienteList() {
        return clienteList;
    }

}
