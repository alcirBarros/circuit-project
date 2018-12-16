package br.com.web.configuracao.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Entity
@Table(name = "opr_operador")
public class Operador extends User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String username;
    private String password;
    
//    @OneToMany
//    private List<Role> roles = new ArrayList<>();

//    private Collection<GrantedAuthority> authorities;
    
    public Operador(String nome, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.nome = nome;
        this.username = username;
        this.password = password;
//        this.roles = (List<Role>) authorities;
    }

    public String getNome() {
        return nome;
    }
}
