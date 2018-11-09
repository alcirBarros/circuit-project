package br.com.modulo.administracao.registroimportacao.model;

import br.com.configuracao.scoped.AbstractEntidade;
import br.com.modulo.administracao.uploadedfile.model.Uploaded;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "rgt_registro")
public class Registro extends AbstractEntidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rgt_id", nullable = false)
    private Integer id;

    @Column(name = "rgt_descricao", length = 45, nullable = false)
    private String descricao = new String();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rgt_data_hora", nullable = false)
    private Date dataHora = new Date();

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "registro", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UploadedRegistro> uploadedRegistroList = new ArrayList<>();

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "registro", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<RegistroImportacao> registroImportacaoList = new ArrayList<>();

    public void adcionarUploaded(Uploaded arquivo) {
        UploadedRegistro uploadedRegistro = new UploadedRegistro();
        uploadedRegistro.setRegistro(this);
        uploadedRegistro.setUploaded(arquivo);
        uploadedRegistroList.add(uploadedRegistro);
    }

    public void excluir(UploadedRegistro uploadedRegistro) {
        uploadedRegistroList.remove(uploadedRegistro);
    }

    private RegistroImportacao contenRegistroImportacao(RegistroImportacao registroImportacao) {
        Predicate<RegistroImportacao> predicate;
        predicate = new Predicate<RegistroImportacao>() {
            @Override
            public boolean test(RegistroImportacao t) {
                boolean nomeAluno = (t.getNomeAluno() != null && t.getNomeAluno().equals(registroImportacao.getNomeAluno()));
                boolean nomeResponsavel = (t.getNomeResponsavel() != null && t.getNomeResponsavel().equals(registroImportacao.getNomeResponsavel()));
                boolean cpfResponsavel = (t.getCpfResponsavel() != null && t.getCpfResponsavel().equals(registroImportacao.getCpfResponsavel()));
                return (nomeAluno && nomeResponsavel && cpfResponsavel);
            }
        };
        return registroImportacaoList.stream().filter(predicate).findAny().orElse(null);
    }

    public void adcionarRegistroImportacao(RegistroImportacao registroImportacao) {
        try {
            if (contenRegistroImportacao(registroImportacao) == null) {
                registroImportacao.setRegistro(this);
                registroImportacaoList.add(registroImportacao);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public long totalRegistro() {
        return registroImportacaoList.stream().count();
    }

    public long totalInconsistencia() {
        return registroImportacaoList.stream().filter(x -> !x.getInconsistenciaEnum().equals(InconsistenciaEnum.SEM_INCONSISTENCIA)).count();
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
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
