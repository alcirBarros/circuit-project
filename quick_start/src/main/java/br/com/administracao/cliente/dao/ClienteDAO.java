package br.com.administracao.cliente.dao;

import br.com.administracao.cliente.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ClienteDAO implements Serializable {

    private static final long serialVersionUID = -6466989861698789586L;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvar(Cliente cliente) {
        em.persist(cliente);
    }

    @Transactional
    public Cliente alterar(Cliente cliente) {
        cliente = em.merge(cliente);
        return cliente;
    }

    @Transactional
    public void excluir(Cliente cliente) {
        em.remove(cliente);
    }

    public List<Cliente> listar() {
        return em.createQuery("select c from Cliente c order by c.cliente desc", Cliente.class).getResultList();
    }
}
