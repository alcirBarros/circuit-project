package br.com.configuracao.security.security;

import br.com.configuracao.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Authorization authorization;

    @Autowired
    private LoginSuccess loginSuccess;

    @Autowired
    private LogoutSuccess logoutSuccess;

    @Autowired
    private LoginService ssUserDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("root").password("$2a$16$ztHxCLzhq/fF5O3dvJWgY.XQ/1cIJRgn5aNhpQk/I5n6n49kn4Jm2").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/img/**", "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/javax.faces.resource/**")
                .permitAll()
                //.antMatchers("/**").permitAll()
                //              .antMatchers("/dashboard").hasRole("DASHBOARD")
                //              .antMatchers("/usuario").hasRole("USUARIO")
                //                .antMatchers("/resources/**", "/webjars/**").permitAll()

                //                              .antMatchers("/vendas/relatorios/equipe").hasRole("VISUALIZAR_RELATORIO_EQUIPE")
                //                              .antMatchers("/vendas/relatorios/custos").hasRole("VISUALIZAR_RELATORIO_CUSTOS")
                //                              .antMatchers("/pages/**").access("hasRole('ADMIN') and hasIpAddress('123.123.123.123')") // pass SPEL using access method

                .anyRequest()
                .authenticated()
                .and()
                    .httpBasic()
                .and()
                    .exceptionHandling()
                .and()
                    .formLogin()
                        .defaultSuccessUrl("/index.xhtml")
//                        .successHandler(loginSuccess)
                        .loginPage("/pages/private/login/login.xhtml")
                        .usernameParameter("formLogin:username")
                        .passwordParameter("formLogin:password")
                        .failureUrl("/pages/private/login/login.xhtml?error=1")
                        .permitAll()
                .and()
                    .rememberMe()
                .and()
                    .logout()
                    .logoutUrl("/logout.xhtml")
                    .logoutSuccessUrl("/logout.xhtml?logout")
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID")
                    .logoutSuccessHandler(logoutSuccess)
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(authorization);
        builder.userDetailsService(ssUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(16);
    }

}
