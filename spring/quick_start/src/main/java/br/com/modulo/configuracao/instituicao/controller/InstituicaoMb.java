package br.com.modulo.configuracao.instituicao.controller;

import br.com.modulo.configuracao.instituicao.model.Instituicao;
import br.com.modulo.configuracao.instituicao.service.ClienteService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class InstituicaoMb implements Serializable {

    private static final long serialVersionUID = -2753121484297994226L;

    @Autowired
    private ClienteService clienteService;

    private List<Instituicao> instituicaoList = new ArrayList<>();

    private Instituicao instituicao = Instituicao.criarInstancia();

    @PostConstruct
    private void init() {
        System.out.println("Init ClienteMb.java");
    }

    public void inserir() {
    }

    public void salvar() {
        clienteService.salvar(instituicao);
    }

    public void alterar() {

    }

    public void visualizar() {
    }

    public void excluir() {
        instituicao = Instituicao.criarInstancia();
        instituicaoList = clienteService.listar();
    }

    public void cancelar() {
        instituicao = new Instituicao();
    }

    
    //Get/s e Set/s
    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao cliente) {
        this.instituicao = cliente;
    }

    public List<Instituicao> getInstituicaoList() {
        return instituicaoList;
    }
}