package br.com.configuracao.principal;

import br.com.configuracao.mensagem.service.MensagemService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request") 
public class PrincipalMb implements Serializable {
    
    @Autowired
    private MensagemService mensagemService;

    @PostConstruct
    private void init() {
        String autowiredTest = mensagemService.autowiredTest();
        System.out.println("Init PrincipalMb.java"+autowiredTest);
    }
    
    public void carregarTela(){
        String autowiredTest = mensagemService.autowiredTest();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Principal", "PrimeFaces Rocks."+autowiredTest));
    }
}