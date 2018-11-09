package br.com.modulo.administracao.pessoa.dao;

import br.com.modulo.administracao.aluno.model.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PessoaDAO {

    @PersistenceContext
    private EntityManager em;

    public Pessoa carregar(String nome) {
        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT ");
            query.append("    * ");
            query.append("FROM ");
            query.append("    tbpessoas pss ");
            query.append("where ");
            query.append("    pss.tbpessoas_nome = :nome ");
            Query createNativeQuery = em.createNativeQuery(query.toString(), Pessoa.class);
            createNativeQuery.setParameter("nome", nome);
            return (Pessoa) createNativeQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException rx) {
            System.out.println("Registro duplicado: " + nome);
            return null;
        }
    }

    @Transactional
    public void salvar(Pessoa pessoa) {
        em.persist(pessoa);
    }

    @Transactional
    public Pessoa alterar(Pessoa pessoa) {
         pessoa = em.merge(pessoa);
         return pessoa;
    }
}
