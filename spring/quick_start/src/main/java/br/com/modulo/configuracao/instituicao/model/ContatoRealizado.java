//package br.com.modulo.configuracao.instituicao.model;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.Objects;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import org.hibernate.envers.Audited;
//
//@Entity
//@Audited
//@Table(name = "ctr_contatos_realizados")
//public class ContatoRealizado implements Serializable {
//
//    private static final long serialVersionUID = -2335773225611788518L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ctr_id", nullable = false)
//    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "cln_id", referencedColumnName = "cln_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ctr_cln_id"))
//    private Instituicao cliente;
//
//    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
//    @Column(name = "ctr_data", nullable = false)
//    private Date date;
//
//    @Column(name = "ctr_descricao", scale = 4000, nullable = false)
//    private String descricao;
//
//    public static ContatoRealizado criarInstancia() {
//        ContatoRealizado contatoRealizado = new ContatoRealizado();
//        return criarInstancia(contatoRealizado);
//    }
//
//    public static ContatoRealizado criarInstancia(ContatoRealizado contatoRealizado) {
//        return contatoRealizado;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Instituicao getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Instituicao cliente) {
//        this.cliente = cliente;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 29 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final ContatoRealizado other = (ContatoRealizado) obj;
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        return true;
//    }
//}
