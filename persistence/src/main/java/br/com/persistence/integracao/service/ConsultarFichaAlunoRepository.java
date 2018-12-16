package br.com.persistence.integracao.service;


import br.com.domain.consultafichaaluno.model.ConsultarFichaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultarFichaAlunoRepository extends JpaRepository<ConsultarFichaAluno, Integer> {
}
