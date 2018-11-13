package br.com.modulo.administracao.pessoa.dao;

import br.com.configuracao.util.StringUtil;
import br.com.modulo.administracao.aluno.model.Pessoa;
import com.exception.BusinessException;
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

    @Transactional
    public void salvar(Pessoa pessoa) {
        em.persist(pessoa);
    }

    @Transactional
    public Pessoa alterar(Pessoa pessoa) {
        return em.merge(pessoa);
    }

    public Pessoa carregarCPF(String cpf) {
        try {
            StringBuilder query = new StringBuilder();
            query.append("select pss.* from ");
            query.append("        tbpessoas pss ");
            query.append("    inner join ");
            query.append("(SELECT pss.tbpessoas_id, REPLACE(REPLACE(REPLACE(pss.tbpessoas_cpf, '-', ''), '.', ''), ' ','')  as tbpessoas_cpf FROM tbpessoas pss) tmp on pss.tbpessoas_id = tmp.tbpessoas_id ");
            query.append("where ");
            query.append("    tmp.tbpessoas_cpf = :cpf ");
            Query createNativeQuery = em.createNativeQuery(query.toString(), Pessoa.class);
            createNativeQuery.setParameter("cpf", StringUtil.removerCaracteresEspeciais(cpf));
            return (Pessoa) createNativeQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException rx) {
            throw new BusinessException("Registro duplicado");
        }
    }
}
