package br.com.web.configuracao.sistema.controller;

import br.com.web.configuracao.sistema.model.Configuracao;
import javax.annotation.PostConstruct;
import javax.persistence.NoResultException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("singleton")
public class ConfiguracaoMb {

    private static final long serialVersionUID = 5536807419037622604L;
    
    private Configuracao configuracao = new Configuracao();
    

    @PostConstruct
    public void init() {
        try {
            configuracao.setTitulo("Sistema");
            configuracao.setVersao("1.00.00.00");
        } catch (NoResultException e) {
            e.printStackTrace();
        }
    }

    public String getLogo() {
        return configuracao.getLogo();
    }

    public String getTitulo() {
        return configuracao.getTitulo();
    }

    public String getVersao() {
        return configuracao.getVersao();
    }

}
