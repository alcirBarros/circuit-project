package br.com.modulo.administracao.responsavel.service;

import br.com.modulo.administracao.aluno.model.Aluno;
import br.com.modulo.administracao.aluno.model.Pessoa;
import br.com.modulo.administracao.aluno.model.Responsavel;
import br.com.modulo.administracao.aluno.model.Usuario;
import br.com.modulo.administracao.aluno.service.AlunoService;
import br.com.modulo.administracao.pessoa.service.PessoaService;
import br.com.modulo.administracao.responsavel.dao.ResponsavelDAO;
import br.com.modulo.administracao.uploadedfile.model.RegistroImportacao;
import br.com.modulo.administracao.usuario.service.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelDAO responsavelDAO;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private UsuarioService usuarioService;

    public Responsavel salvar(Responsavel responsavel) {
        return responsavelDAO.salvar(responsavel);
    }

    public Responsavel carregar(String nome) {
        return responsavelDAO.carregar(nome);
    }

    public Responsavel carregarResponsavel(RegistroImportacao registroImportacao) {
        String nomeResponsavel = registroImportacao.getNomeResponsavel();
        Responsavel responsavel = responsavelDAO.carregar(nomeResponsavel);
        responsavel = Optional.ofNullable(responsavel).orElse(createResponsavel(registroImportacao));

        String nomeAluno = registroImportacao.getNomeAluno();
        Aluno aluno = alunoService.localizar(nomeAluno);
//        aluno = alunoService.salvar(aluno);
        responsavel.adicionarAluno(aluno);
        return responsavel;
    }

    private Responsavel createResponsavel(RegistroImportacao registro) {
        String nomeResponsavel = registro.getNomeResponsavel();
        Pessoa pessoa = pessoaService.carregar(nomeResponsavel);
        pessoa = Optional.ofNullable(pessoa).orElse(Pessoa.criarInstanciaResponsavel(registro));
        Responsavel responsavel = Responsavel.criarInstancia(pessoa);
        Usuario usuario = usuarioService.carregarUsuario(registro);
        responsavel.setUsuario(usuario);
        return responsavel;
    }

}
