package br.com.modulo.configuracao.login.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "lgn_login")
public class Login implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lgn_id", nullable = false)
    private Integer id;

    @Column(name = "lgn_data_hora")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHora = new Date();

    @Column(name = "lgn_user_name", scale = 100, nullable = false)
    private String userNome;

    @Column(name = "lgn_password", scale = 100, nullable = false)
    private String password;

    public static Login criarInstancia() {
        Login login = new Login();
        return criarInstancia(login);
    }

    public static Login criarInstancia(Login login) {
        return login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getUserNome() {
        return userNome;
    }

    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
