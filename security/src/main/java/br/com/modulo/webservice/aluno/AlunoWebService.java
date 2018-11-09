//package br.com.modulo.webservice.aluno;
//
//import br.com.modulo.webservice.model.AlunoWs;
//import br.com.modulo.administracao.aluno.service.AlunoService;
//import java.util.ArrayList;
//import java.util.List;
//import javax.annotation.PostConstruct;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.core.Response;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//
//@Component
//@Path("/aluno")
//public class AlunoWebService {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Autowired
//    private AlunoService alunoService;
//
//    @PostConstruct
//    private void init() {
//    }
//
//    @POST
//    @Path("/post")
////    @PreAuthorize("")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response post() {
//        return Response.ok().build();
//    }
//
//    @GET
//    @Path("/get")
//    @Produces({MediaType.APPLICATION_JSON})
//    public List<String> get() {
//        List<String> listString = new ArrayList<>();
//        listString.add("teste");
//        return listString;
//    }
//
//    @GET
//    @Path("/getObject")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response getObject() {
//        AlunoWs aluno = new AlunoWs();
//        return Response.ok().type(MediaType.APPLICATION_JSON).entity(aluno).build();
//    }
//
//    @GET
//    @Path("/getObject2")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getObject(@PathParam("codigo") Integer codigo) {
//        AlunoWs aluno = new AlunoWs();
//        return Response.ok().type(MediaType.APPLICATION_JSON).entity(aluno).build();
//    }
//
//    @POST
//    @Path("/inserir")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response inserir(AlunoWs aluno) {
//        return Response.ok().type(MediaType.APPLICATION_JSON).entity(aluno).build();
//    }
//
//    @POST
//    @Path("/excluir")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response excluir(AlunoWs aluno) {
//        return Response.ok().type(MediaType.APPLICATION_JSON).entity(aluno).build();
//    }
//}
