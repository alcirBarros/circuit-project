package br.com.modulo.administracao.aluno.model;


import br.com.configuracao.util.StringUtil;
import br.com.modulo.administracao.registroimportacao.model.RegistroImportacao;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbusuarios")
public class Usuario implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbusuarios_id", nullable = false)
    private Integer id;

    @Column(name = "tbusuarios_login")
    private String login;

    @Column(name = "tbusuarios_senha")
    private String senha;

    @Column(name = "tbusuarios_apelido")
    private String apelido;

    @Column(name = "tbPerfil_id")
    private Integer perfilId;

    @Column(name = "tbusuarios_tipo")
    private String tipoUsuario;

    public static Usuario criarInstancia() {
        Usuario usuario = new Usuario();
        return usuario;
    }

    public static Usuario criarInstancia(Usuario usuario) {
        usuario = Optional.ofNullable(usuario).orElse(criarInstancia());
        return usuario;
    }

    public static Usuario criarInstancia(RegistroImportacao registroImportacao) {
        Usuario usuario = criarInstancia();
        usuario.setApelido(StringUtil.removerCaracteresEspeciais(registroImportacao.getCpfResponsavel()));
        usuario.setLogin(StringUtil.removerCaracteresEspeciais(registroImportacao.getCpfResponsavel()));
        usuario.setSenha("1234mudar");
        usuario.setPerfilId(20);
        usuario.setTipoUsuario("R");
        return usuario;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Integer getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Integer perfilId) {
        this.perfilId = perfilId;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
