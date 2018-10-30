package br.com.modulo.configuracao.operador.model;

import br.com.modulo.configuracao.pessoa.model.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "opr_operador")
@PrimaryKeyJoinColumn(name = "pss_id", referencedColumnName = "pss_id", foreignKey = @ForeignKey(name = "fk_opr_pss_id"))
public class Operador extends Pessoa implements Serializable {

    @Column(name = "opr_user_name", scale = 100, nullable = false)
    private String userNome;

    @Column(name = "opr_password", scale = 100, nullable = false)
    private String password;

    @OneToMany(mappedBy = "operador", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<HistoricoLogin> historicoLoginList = new ArrayList<>();

    public static Operador criarInstancia() {
        Operador operador = new Operador();
        return criarInstancia(operador);
    }

    public static Operador criarInstancia(Operador operador) {
        return operador;
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
