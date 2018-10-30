package br.com.modulo.configuracao.pessoa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "pss_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pss_id", nullable = false)
    private Integer id;

    @Column(name = "pss_nome", length = 255, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "pss_data_nascimento")
    private Date dataNascimento;

    public static Pessoa criarInstancia() {
        Pessoa pessoa = new Pessoa();
        return criarInstancia(pessoa);
    }

    public static Pessoa criarInstancia(Pessoa pessoa) {
        return pessoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
}
