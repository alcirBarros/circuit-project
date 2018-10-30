package br.com.modulo.administracao.instituicao.dao;

import br.com.modulo.administracao.instituicao.model.Instituicao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ClienteDao implements Serializable {

    private static final long serialVersionUID = -6466989861698789586L;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvar(Instituicao cliente) {
        em.persist(cliente);
    }

    public static Instituicao alterar(Instituicao cliente) {
//        em.getTransaction().begin();
//        cliente = em.merge(cliente);
//        em.getTransaction().commit();
        return cliente;
    }

    public static void excluir(Instituicao cliente) {
//        em.getTransaction().begin();
//        em.remove(cliente);
//        em.getTransaction().commit();
    }

    public static List<Instituicao> listar() {
//        return em.createQuery("select cli from Cliente cli order by cli.cliente desc", Cliente.class).getResultList();
        return null;
    }
}
