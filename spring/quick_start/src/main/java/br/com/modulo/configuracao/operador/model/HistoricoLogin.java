package br.com.modulo.configuracao.operador.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "hlg_historico_login")
public class HistoricoLogin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hlg_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pss_id", referencedColumnName = "pss_id", foreignKey = @ForeignKey(name = "fk_hlg_pss_id"))
    private Operador operador;

    @Column(name = "hlg_data_hora")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataHora;

    public static HistoricoLogin criarInstancia() {
        HistoricoLogin historicoLogin = new HistoricoLogin();
        return criarInstancia(historicoLogin);
    }

    public static HistoricoLogin criarInstancia(HistoricoLogin operador) {
        return operador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}