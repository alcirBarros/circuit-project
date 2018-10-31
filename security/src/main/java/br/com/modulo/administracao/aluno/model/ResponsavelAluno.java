package br.com.modulo.administracao.aluno.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbresponsaveis_tbcadastro_alunos")
public class ResponsavelAluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbresponsaveis_tbcadastro_alunos_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tbresponsaveis_id", referencedColumnName = "tbresponsaveis_id")
    private Responsavel responsavel;

    @ManyToOne
    @JoinColumn(name = "tbcadastro_alunos_id", referencedColumnName = "tbcadastro_alunos_id")
    private Aluno aluno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final ResponsavelAluno other = (ResponsavelAluno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getDisplay() {        
        StringBuilder registro = new StringBuilder();
        registro.append(this.getClass().getName());
        registro.append("{");
        registro.append("id=").append(aluno.getPessoa().getId()).append(",");
        registro.append("nome_aluno=").append(aluno.getPessoa().getNome()).append(",");
        registro.append("id_responsavel=").append(responsavel.getPessoa().getId()).append(",");
        registro.append("nome_responsavel=").append(responsavel.getPessoa().getNome());
        registro.append("}");
        return registro.toString();
    }
}
