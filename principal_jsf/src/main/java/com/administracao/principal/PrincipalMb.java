package com.administracao.principal;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class PrincipalMb implements Serializable {

    @PostConstruct
    private void init() {
        System.out.println("Init PrincipalMb.java");
    }
    
    public void carregarTela(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Principal", "PrimeFaces Rocks."));
    }

    
}