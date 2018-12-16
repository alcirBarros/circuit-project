package br.com.web.configuracao.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Authorization implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

//    @Autowired
//    private HttpServletRequest request;
    
    private static List<User> users = new ArrayList();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        String name = authentication.getName();
        
        Object credentials = authentication.getCredentials();
        
        String password_ = credentials.toString();
        
        System.out.println("credentials class: " + credentials.getClass());
        
        
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        
        String username = String.valueOf(auth.getPrincipal());
        String password = String.valueOf(auth.getCredentials());

        User user = (User) userDetailsService.loadUserByUsername(username);

        if (user == null) {
            throw new BadCredentialsException("usuario nao encontrado");
        }

        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }

        Collection<GrantedAuthority> grantedAuthorityList = user.getAuthorities();
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, password, grantedAuthorityList);
        
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Authentication auth_ = new UsernamePasswordAuthenticationToken(name, password, grantedAuthorities);

        return usernamePasswordAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

//    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//        System.out.println(encoder.encode("password"));
//
//    }
}
