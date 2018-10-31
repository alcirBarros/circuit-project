package br.com.modulo.administracao.usuario.service;

import br.com.modulo.administracao.aluno.model.Usuario;
import br.com.modulo.administracao.registroimportacao.model.RegistroImportacao;
import br.com.modulo.administracao.usuario.dao.UsuarioDAO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    public Usuario carregarUsuario(RegistroImportacao registro) {
        String cpfResponsavel = registro.getCpfResponsavel();
        Usuario usuario = usuarioDAO.carregar(cpfResponsavel);
        return Optional.ofNullable(usuario).orElse(Usuario.criarInstancia(registro));
    }

}
