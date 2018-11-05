package br.com.modulo.administracao.registroimportacao.model;

import br.com.configuracao.scoped.AbstractEntidade;
import br.com.modulo.administracao.uploadedfile.model.Uploaded;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "rgt_registro")
public class Registro extends AbstractEntidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rgt_id", nullable = false)
    private Integer id;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rgt_data_hora", nullable = false)
    private Date dataHora = new Date();
    
    @OneToMany(mappedBy = "registro", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<UploadedRegistro> uploadedRegistroList = new ArrayList<>();

    @OneToMany(mappedBy = "registro", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<RegistroImportacao> registroImportacaoList = new ArrayList<>();

    @Override
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

    public void adcionarUploaded(Uploaded arquivo) {
        UploadedRegistro uploadedRegistro = new UploadedRegistro();
        uploadedRegistro.setRegistro(this);
        uploadedRegistro.setUploaded(arquivo);
        uploadedRegistroList.add(uploadedRegistro);
    }

    public List<UploadedRegistro> getUploadedRegistroList() {
        return uploadedRegistroList;
    }

    public void setUploadedRegistroList(List<UploadedRegistro> uploadedRegistroList) {
        this.uploadedRegistroList = uploadedRegistroList;
    }
    
    public List<RegistroImportacao> getRegistroImportacaoList() {
        return registroImportacaoList;
    }

    public void setRegistroImportacaoList(List<RegistroImportacao> registroImportacaoList) {
        this.registroImportacaoList = registroImportacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Registro other = (Registro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
