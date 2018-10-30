package br.com.modulo.configuracao.login.controller;

import br.com.modulo.configuracao.login.model.Login;
import br.com.modulo.configuracao.login.service.LoginService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class LoginMb implements Serializable {

    @Autowired
    private LoginService loginService;

    private Login login = Login.criarInstancia();

    @PostConstruct
    private void init() {
        System.out.println("Init LoginMb.java");
    }

    public void carregarTela() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login", "PrimeFaces Rocks carregarTela."));
    }

    public void authorizationLogin() {
        try {
            loginService.login(login);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login", "PrimeFaces Rocks carregarTela."));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Login getLogin() {
        return login;
    }
}
