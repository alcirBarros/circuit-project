package br.com.modulo.administracao.uploadedfile.model;

import br.com.configuracao.scoped.AbstractEntidade;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
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

@Entity
@Table(name = "rgt_registro")
public class Registro extends AbstractEntidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rgt_id", nullable = false)
    private Integer id;

    @Column(name = "rgt_arquivo")
    private File arquivo;

    @OneToMany(mappedBy = "registro", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<RegistroImportacao> registroImportacaoList = new ArrayList<>();

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
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
