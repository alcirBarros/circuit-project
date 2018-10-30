package br.com.modulo.administracao.aluno.dao;

import br.com.modulo.administracao.aluno.model.Aluno;
import br.com.modulo.administracao.uploadedfile.model.RegistroImportacao;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AlunoDAO {

    @PersistenceContext
    private EntityManager em;

    public Aluno carregar(RegistroImportacao registroImportacao) {
        try {
            String nomeAluno = registroImportacao.getNomeAluno();
            StringBuilder query = new StringBuilder();
            query.append("SELECT ");
            query.append("    aln.* ");
            query.append("FROM ");
            query.append("    tbcadastro_alunos aln ");
            query.append("        inner join ");
            query.append("    tbpessoas pss on aln.tbpessoas_id = pss.tbpessoas_id ");
            query.append("WHERE ");
            query.append("    pss.tbpessoas_nome like :nome ");
            Query createNativeQuery = em.createNativeQuery(query.toString(), Aluno.class);
            createNativeQuery.setParameter("nome", "%".concat(nomeAluno.trim().toUpperCase()).concat("%"));
            Aluno aluno = (Aluno) createNativeQuery.getSingleResult();
            return aluno;
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException rx) {
            return null;
        }
    }
}
