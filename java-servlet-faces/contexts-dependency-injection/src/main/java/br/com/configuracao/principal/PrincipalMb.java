package br.com.configuracao.principal;


import br.com.configuracao.mensagem.service.MensagemService;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ManagedBean
@RequestScoped
public class PrincipalMb {

    @Inject
    private MensagemService messagemService;

    @PostConstruct
    private void init() {
        String injectTeste = messagemService.injectTeste();
        System.out.println("br.com.configuracao.principal.PrincipalMb.init()");
    }

    public void carregarTela() {
        String injectTeste = messagemService.injectTeste();
        System.out.println("br.com.configuracao.principal.PrincipalMb.init()");
    }

}
