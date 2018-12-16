package br.com.web.modulo.integracao.consultarfichaaluno.controller;

//import br.com.domain.consultafichaaluno.service.ConsultarFichaAluno;
import br.com.domain.consultafichaaluno.model.ConsultarFichaAluno;
//import br.com.persistence.integracao.consultafichaaluno.ConsultarFichaAlunoService;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("request")
public class ConsultarFichaAlunoMb {

//    @Autowired
//    private ConsultarFichaAlunoService consultarFichaAlunoService;

//    private ConsultarFichaAluno consultarFichaAluno = ConsultarFichaAluno.criarInstancia();

    @PostConstruct
    public void init() {
        System.out.println("**********************************************************************************************");
        System.out.println("*");
        System.out.println(this.getClass().getPackage().getName());
        System.out.println("*");
        System.out.println("**********************************************************************************************");
    }

    public void carregarTela() {
        try {
//            consultarFichaAluno.getConsultaRA().setInRA("116584739");
//            consultarFichaAluno.getConsultaRA().setInUF("SP");
//            consultarFichaAluno.getConsultaRA().setInDigitoRA("5");
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }

    public void inserir() {
    }

    public void salvar() {
        try {

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }

    public void alterar() {

    }

    public void visualizar() {
    }

    public void excluir() {

    }

    public void cancelar() {
    }

    public void processar() {
        try {

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }

    public void localizar() {
        try {
//            consultarFichaAluno = consultarFichaAlunoService.consultarFichaAluno(consultarFichaAluno);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
        }
    }

//    //Get/s e Set/s
//    public ConsultarFichaAluno getConsultarFichaAluno() {
//        return consultarFichaAluno;
//    }
//
//    public void setConsultarFichaAluno(ConsultarFichaAluno consultarFichaAluno) {
//        this.consultarFichaAluno = consultarFichaAluno;
//    }

}
