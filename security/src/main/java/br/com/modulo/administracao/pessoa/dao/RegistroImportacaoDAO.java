package br.com.modulo.administracao.pessoa.dao;

import br.com.modulo.administracao.registroimportacao.model.Registro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RegistroImportacaoDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvar(Registro registro) {
        em.persist(registro);
    }

    @Transactional
    public Registro alterar(Registro registro) {
        return em.merge(registro);
    }

    public Registro carregar(Integer registroId) {
        try {
            return em.find(Registro.class, registroId);
        } catch (NoResultException e) {
            return null;
        }
    }

    public Registro localizar(Integer registroId) {
        return em.find(Registro.class, registroId);
    }

    public List<Registro> listar() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        query.append("    rgt.* ");
        query.append("FROM ");
        query.append("    rgt_registro rgt ");
        query.append("order by rgt.rgt_data_hora desc ");
        return em.createNativeQuery(query.toString(), Registro.class).getResultList();
    }
}
