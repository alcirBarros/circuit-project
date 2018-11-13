package br.com.modulo.administracao.aluno.model;

import br.com.configuracao.util.StringUtil;
import br.com.modulo.administracao.registroimportacao.model.RegistroImportacao;
import com.exception.BusinessException;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbpessoas")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbpessoas_id", length = 10, nullable = false)
    private Integer id;

    @Column(name = "tbpessoas_nome")
    private String nome;

    @Column(name = "tbpessoas_cpf")
    private String cpf;

    public static Pessoa criarInstancia() {
        Pessoa pessoa = new Pessoa();
        return criarInstancia(pessoa);
    }

    public static Pessoa criarInstancia(Pessoa pessoa) {
        return pessoa;
    }

    public static Pessoa criarInstancia(RegistroImportacao registroImportacao) {
        Pessoa pessoa = criarInstancia();
        pessoa.setNome(registroImportacao.getNomeResponsavel());
        pessoa.setCpf(validatorCPF(registroImportacao.getCpfResponsavel()));
        return pessoa;
    }

    private static String validatorCPF(String cpf) {
        try {
            String removerCaracteresEspeciais = StringUtil.removerCaracteresEspeciais(cpf);
            return (removerCaracteresEspeciais.length() > 14) ? removerCaracteresEspeciais.substring(0, 14) : cpf;
        } catch (Exception e) {
            throw new BusinessException("Registro CPF invalido: " + cpf);
        }
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
        this.nome = (nome != null) ? nome.trim().toUpperCase() : nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = (cpf != null) ? cpf.trim().toUpperCase() : cpf;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
