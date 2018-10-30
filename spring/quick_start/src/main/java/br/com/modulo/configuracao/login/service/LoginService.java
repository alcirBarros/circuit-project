package br.com.modulo.configuracao.login.service;

import br.com.modulo.configuracao.login.dao.LoginDAO;
import br.com.modulo.configuracao.login.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    
    
    @Autowired
    private LoginDAO loginDAO;

    public void login(Login login) {
        
    }
    
}
