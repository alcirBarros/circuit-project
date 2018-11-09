package br.com.modulo.administracao.responsavel.dao;

import br.com.configuracao.util.StringUtil;
import br.com.modulo.administracao.aluno.model.Responsavel;
import com.exception.BusinessException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ResponsavelDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Responsavel salvar(Responsavel responsavel) {
        try {
            responsavel = em.merge(responsavel);
            return responsavel;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("Operador não tem permissão.");
        }
    }

    public Responsavel carregar(String nome) {
        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT ");
            query.append("    rsp.* ");
            query.append("FROM ");
            query.append("    tbresponsaveis rsp ");
            query.append("        inner join ");
            query.append("    tbpessoas pss on rsp.tbpessoas_id = pss.tbpessoas_id ");
            query.append("where ");
            query.append("    pss.tbpessoas_nome like :nome ");
            Query createNativeQuery = em.createNativeQuery(query.toString(), Responsavel.class);
            createNativeQuery.setParameter("nome",  nome);
            return (Responsavel) createNativeQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException rx) {
            System.out.println("Nome duplicado: " + nome);
            return null;
        }
    }

    public Responsavel carregarCPF(String cpf) {
        try {
            StringBuilder query = new StringBuilder();
            
            
            
            query.append("SELECT ");
            query.append("    rsp.*, pss.tbpessoas_cpf ");
            query.append("FROM ");
            query.append("    tbresponsaveis rsp ");
            query.append("        INNER JOIN ");
            query.append("    (SELECT pss.tbpessoas_id, REPLACE(REPLACE(pss.tbpessoas_cpf, '-', ''), '.', '') as tbpessoas_cpf FROM tbpessoas pss) pss ON rsp.tbpessoas_id = pss.tbpessoas_id ");
            query.append("where ");
            query.append("    pss.tbpessoas_cpf like :cpf ");             
            Query createNativeQuery = em.createNativeQuery(query.toString(), Responsavel.class);
            createNativeQuery.setParameter("cpf", StringUtil.removerCaracteresEspeciais(cpf));
            return (Responsavel) createNativeQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException rx) {
            System.out.println("CPF duplicado: " + cpf);
            return null;
        }
    }
}
