package br.com.configuracao.login;

import br.com.configuracao.mensagem.service.MensagemService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ManagedBean
@RequestScoped
public class LoginMb implements Serializable {

    @Inject
    private MensagemService mensagemService;

    @PostConstruct
    private void init() {
        System.out.println("Init LoginMb.java");
        String autowiredTest = mensagemService.injectTeste();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login", "PrimeFaces Rocks init." + autowiredTest));
    }

    public void carregarTela() {
        String autowiredTest = mensagemService.injectTeste();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login", "PrimeFaces Rocks carregarTela." + autowiredTest));
    }

    public void login() {
        String autowiredTest = mensagemService.injectTeste();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login", "PrimeFaces Rocks login." + autowiredTest));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login", "PrimeFaces Rocks." + autowiredTest));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login", "PrimeFaces Rocks." + autowiredTest));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login", "PrimeFaces Rocks." + autowiredTest));
    }
}
