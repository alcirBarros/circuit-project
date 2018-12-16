//package br.com.persistence.integracao.consultafichaaluno;
//
//import br.com.domain.configuracao.IntegracaoProdesp;
//import br.com.domain.consultafichaaluno.model.ConsultarFichaAluno;
//import br.com.domain.consultafichaaluno.service.FichaAlunoService;
//import br.com.persistence.integracao.service.ConsultaRaRepository;
//
//import br.com.persistence.integracao.service.ConsultarFichaAlunoRepository;
////import br.com.persistence.integracao.service.ConsultarFichaAlunoResponseRepository;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ConsultarFichaAlunoService extends IntegracaoProdesp {
//
//    @Autowired
//    private ConsultaRaRepository consultaRaRepository;
//
//    @Autowired
//    private ConsultarFichaAlunoRepository consultarFichaAlunoRepository;
//
//    @Autowired
//    private FichaAlunoService fichaAlunoService;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @PostConstruct
//
//    private void init() {
//        System.out.println(this.getClass().getPackage().getName());
//    }
//
//    private ConsultarFichaAluno beforeMethod(ConsultarFichaAluno consultarFichaAluno) {
//        return consultarFichaAluno;
//    }
//
//    public ConsultarFichaAluno consultarFichaAluno(ConsultarFichaAluno consultarFichaAluno) {
//        consultarFichaAluno = beforeMethod(consultarFichaAluno);
//        consultarFichaAluno = fichaAlunoService.localizar(consultarFichaAluno);
//        consultarFichaAluno = afterMethod(consultarFichaAluno);
//        return consultarFichaAluno;
//    }
//
//    private ConsultarFichaAluno afterMethod(ConsultarFichaAluno consultarFichaAluno) {
//        return consultarFichaAlunoRepository.save(consultarFichaAluno);
//    }
//
//}
