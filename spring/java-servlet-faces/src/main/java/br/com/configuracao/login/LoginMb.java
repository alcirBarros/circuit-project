package br.com.configuracao.login;

import br.com.modulo.administracao.mensagem.service.MensagemService;
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
    private MensagemService mensagemService;

    @PostConstruct
    private void init() {
        System.out.println("Init LoginMb.java");
        String autowiredTest = mensagemService.autowiredTest();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login", "PrimeFaces Rocks."+autowiredTest));
    }

    public void carregarTela() {
        String autowiredTest = mensagemService.autowiredTest();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login", "PrimeFaces Rocks carregarTela."+autowiredTest));
    }

    public void login() {
        String autowiredTest = mensagemService.autowiredTest();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login", "PrimeFaces Rocks login."+autowiredTest));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login", "PrimeFaces Rocks."+autowiredTest));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login", "PrimeFaces Rocks."+autowiredTest));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login", "PrimeFaces Rocks."+autowiredTest));
    }
}
