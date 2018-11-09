package br.com.modulo.administracao.registroimportacao.model;

import br.com.configuracao.scoped.AbstractEntidade;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rip_registro_importacao")
public class RegistroImportacao extends AbstractEntidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rip_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "rgt_id", referencedColumnName = "rgt_id", nullable = false, foreignKey = @ForeignKey(name = "fk_rip_rgt_id"))
    private Registro registro;

    @Column(name = "rip_nome_aluno")
    private String nomeAluno;

    @Column(name = "rip_nome_responsavel")
    private String nomeResponsavel;

    @Column(name = "rip_cpf_responsavel")
    private String cpfResponsavel;

    @Column(name = "rip_inconsistencia_enum", length = 45)
    private InconsistenciaEnum inconsistenciaEnum = InconsistenciaEnum.SEM_INCONSISTENCIA;

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

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public InconsistenciaEnum getInconsistenciaEnum() {
        return inconsistenciaEnum;
    }

    public void setInconsistenciaEnum(InconsistenciaEnum inconsistenciaEnum) {
        this.inconsistenciaEnum = inconsistenciaEnum;
    }

    public static boolean isNULL(RegistroImportacao registroImportacao) {
        if (!Objects.isNull(registroImportacao)) {
            if (registroImportacao.getId() != null) {
                return false;
            }
            if (registroImportacao.getRegistro() != null) {
                return false;
            }
            if (registroImportacao.getNomeAluno() != null && !registroImportacao.getNomeAluno().trim().equals("")) {
                return false;
            }
            if (registroImportacao.getNomeResponsavel() != null && !registroImportacao.getNomeResponsavel().trim().equals("")) {
                return false;
            }
            if (registroImportacao.getCpfResponsavel() != null && !registroImportacao.getCpfResponsavel().trim().equals("")) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final RegistroImportacao other = (RegistroImportacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
