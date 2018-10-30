package br.com.modulo.configuracao.instituicao.dao;

import br.com.modulo.configuracao.instituicao.model.Instituicao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InstituicaoDAO implements Serializable {

    private static final long serialVersionUID = -6466989861698789586L;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvar(Instituicao cliente) {
        em.persist(cliente);
    }

    @Transactional
    public Instituicao alterar(Instituicao cliente) {
        cliente = em.merge(cliente);
        return cliente;
    }

    @Transactional
    public void excluir(Instituicao cliente) {
        em.remove(cliente);
    }

    public List<Instituicao> listar() {
        return em.createQuery("select c from Cliente c order by c.cliente desc", Instituicao.class).getResultList();
    }
}
