package br.com.webservice.services.security;

import br.com.domain.consultafichaaluno.model.ConsultarFichaAluno;
//import br.com.persistence.integracao.consultafichaaluno.ConsultarFichaAlunoService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("private/fichaaluno")
public class ConsultarFichaAlunoWs {

//    @Autowired
//    private ConsultarFichaAlunoService consultarFichaAlunoService;


    @GET
    @Path("/status")
    @Produces("application/json")
    public Response status() {
        return Response.status(200).build();
    }


//    @GET
//    @Path("/consultarfichaaluno")
//    @Produces("application/json")
//    public ConsultarFichaAluno consultarFichaAluno() {
//        ConsultarFichaAluno consultarFichaAluno = ConsultarFichaAluno.criarInstancia();
//        consultarFichaAluno.getConsultaRA().setInRA("116584739");
//        consultarFichaAluno.getConsultaRA().setInUF("SP");
//        consultarFichaAluno.getConsultaRA().setInDigitoRA("5");
//        consultarFichaAlunoService.consultarFichaAluno(consultarFichaAluno);
//        return Response.status(200).entity(consultarFichaAluno).build();
//        return consultarFichaAluno;
//    }

}
