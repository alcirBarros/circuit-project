package br.com.modulo.administracao.registroimportacao.model;

import br.com.configuracao.scoped.AbstractEntidade;
import br.com.modulo.administracao.uploadedfile.model.Uploaded;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "upr_uploaded_registro")
public class UploadedRegistro extends AbstractEntidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "upr_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "rgt_id", referencedColumnName = "rgt_id", foreignKey = @ForeignKey(name = "fk_upr_upr_id"))
    private Registro registro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "upl_id", referencedColumnName = "upl_id", foreignKey = @ForeignKey(name = "fk_upr_upl_id"))
    private Uploaded uploaded;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public Uploaded getUploaded() {
        return uploaded;
    }

    public void setUploaded(Uploaded uploaded) {
        this.uploaded = uploaded;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UploadedRegistro other = (UploadedRegistro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
