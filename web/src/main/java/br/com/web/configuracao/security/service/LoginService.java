package br.com.web.configuracao.security.service;



import br.com.web.configuracao.security.model.Operador;
import br.com.web.configuracao.security.model.Role;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class LoginService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        
        Role role = new Role();
        
        Collection<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(role);
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USUARIO"));
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_VISUALIZAR_RELATORIO_CUSTOS"));
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_VISUALIZAR_RELATORIO_EQUIPE"));
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_CONSULTAR_FICHA_ALUNO"));
        
        
        
        return new Operador("Operador do Sistema", "admin", "$2a$16$h6zfpndZqr9hKlR2QoEiOeKE3lSy9HMB0hJcNmd.JDU07UdEivjF2", grantedAuthorityList);
    }

//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder(16).encode("!@#facil"));
//    }
}
