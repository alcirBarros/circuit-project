package br.com.configuracao.security.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LogoutSuccess extends HttpStatusReturningLogoutSuccessHandler implements LogoutSuccessHandler {
   
    @Override
    public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException, ServletException {
        super.onLogoutSuccess(request, response, authentication);
        final String refererUrl = request.getHeader("Referer");
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        String requestURI = request.getRequestURI();
        
        System.out.println(refererUrl);
    }
}
