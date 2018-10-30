package br.com.modulo.administracao.instituicao.service;

import br.com.modulo.administracao.instituicao.dao.ClienteDao;
import br.com.modulo.administracao.instituicao.model.Instituicao;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements Serializable{

    private static final long serialVersionUID = -2209720507806533979L;
    
    @Autowired
    private ClienteDao clienteDao;

    public void salvar(Instituicao cliente) {
        clienteDao.salvar(cliente);
    }

    public static Instituicao alterar(Instituicao cliente) {
        return ClienteDao.alterar(cliente);
    }

    public static void excluir(Instituicao cliente) {
       ClienteDao.excluir(cliente);
    }

    public static List<Instituicao> listar() {
         return ClienteDao.listar();
    }
}
