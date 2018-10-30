package br.com.modulo.administracao.mensagem.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class MensagemService {

    private String autowiredTest = "Teste Autowired";

    public String autowiredTest() {
        return autowiredTest;
    }
}