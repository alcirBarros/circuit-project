package br.com.web.configuracao.principal;

import br.com.web.configuracao.security.model.Operador;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@Scope("session")
public class PrincipalMb {

    @Autowired
    private Operador operador;

    @Autowired
    private Authentication authentication;
    
    @PostConstruct
    private void init(){
        System.out.println("A"); 
    }
    
    private String firstName = "";
    private String lastName = "";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String showGreeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hello " + authentication.getName() + "!";
    }
}
