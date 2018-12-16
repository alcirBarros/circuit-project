package br.com.domain.consultafichaaluno.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cfl_consultar_ficha_aluno")
public class ConsultarFichaAluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cfl_id", nullable = false)
    private Integer id;

    @Column(name = "cfl_codigo_processo")
    private String outProcessoID;

    @Column(name = "cfl_sucesso")
    private String outSucesso;

    @Column(name = "cfl_erro")
    private String outErro;

//    @JoinColumn(name = "cdc_id")
//    @ManyToOne(cascade = CascadeType.ALL)
//    private ConsultaDocumentos consultaDocumentos;

//    @JoinColumn(name = "cfn_id")
//    @ManyToOne(cascade = CascadeType.ALL)
//    private ConsultaFonetica consultaFonetica;
//
//    @JoinColumn(name = "cnc_id")
//    @ManyToOne(cascade = CascadeType.ALL)
//    private ConsultaNomeCompleto consultaNomeCompleto;
//
//    @JoinColumn(name = "cra_id")
//    @ManyToOne(cascade = CascadeType.ALL)
//    private ConsultaRA consultaRA;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "lfc_aluno_ficha_consulta",
//            joinColumns = {
//                @JoinColumn(name = "cfl_id", referencedColumnName = "cfl_id", foreignKey = @ForeignKey(name = "fk_lfc_cfl_id"))},
//            inverseJoinColumns = {
//                @JoinColumn(name = "fln_id", referencedColumnName = "fln_id", foreignKey = @ForeignKey(name = "fk_lfc_fln_id"))})
//    private List<FichaAluno> fichaAlunoList = new ArrayList<>();
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "llt_aluno_list",
//            joinColumns = {
//                @JoinColumn(name = "cfl_id", referencedColumnName = "cfl_id", foreignKey = @ForeignKey(name = "fk_llt_cfl_id"))},
//            inverseJoinColumns = {
//                @JoinColumn(name = "lln_id", referencedColumnName = "lln_id", foreignKey = @ForeignKey(name = "fk_llt_lln_id"))})
//    private List<ListaAlunos> alunoList = new ArrayList<>();

//    public static ConsultarFichaAluno criarInstancia() {
//        ConsultarFichaAluno consultarFichaAluno = new ConsultarFichaAluno();
//        consultarFichaAluno.setConsultaDocumentos(new ConsultaDocumentos());
//        consultarFichaAluno.setConsultaFonetica(new ConsultaFonetica());
//        consultarFichaAluno.setConsultaNomeCompleto(new ConsultaNomeCompleto());
//        consultarFichaAluno.setConsultaRA(new ConsultaRA());
//        return consultarFichaAluno;
//    }
//
//    public static ConsultarFichaAluno criarInstancia(ConsultarFichaAluno consultarFichaAluno) {
//
//        if (consultarFichaAluno.getConsultaDocumentos() == null) {
//            consultarFichaAluno.setConsultaDocumentos(new ConsultaDocumentos());
//        }
//
//        if (consultarFichaAluno.getConsultaFonetica() == null) {
//            consultarFichaAluno.setConsultaFonetica(new ConsultaFonetica());
//        }
//
//        if (consultarFichaAluno.getConsultaNomeCompleto() == null) {
//            consultarFichaAluno.setConsultaNomeCompleto(new ConsultaNomeCompleto());
//        }
//
//        if (consultarFichaAluno.getConsultaRA() == null) {
//            consultarFichaAluno.setConsultaRA(new ConsultaRA());
//        }
//        return consultarFichaAluno;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutProcessoID() {
        return outProcessoID;
    }

    public void setOutProcessoID(String outProcessoID) {
        this.outProcessoID = outProcessoID;
    }

    public String getOutSucesso() {
        return outSucesso;
    }

    public void setOutSucesso(String outSucesso) {
        this.outSucesso = outSucesso;
    }

    public String getOutErro() {
        return outErro;
    }

    public void setOutErro(String outErro) {
        this.outErro = outErro;
    }

//    public ConsultaDocumentos getConsultaDocumentos() {
//        return consultaDocumentos;
//    }
//
//    public void setConsultaDocumentos(ConsultaDocumentos consultaDocumentos) {
//        this.consultaDocumentos = consultaDocumentos;
//    }
//
//    public ConsultaFonetica getConsultaFonetica() {
//        return consultaFonetica;
//    }
//
//    public void setConsultaFonetica(ConsultaFonetica consultaFonetica) {
//        this.consultaFonetica = consultaFonetica;
//    }
//
//    public ConsultaNomeCompleto getConsultaNomeCompleto() {
//        return consultaNomeCompleto;
//    }
//
//    public void setConsultaNomeCompleto(ConsultaNomeCompleto consultaNomeCompleto) {
//        this.consultaNomeCompleto = consultaNomeCompleto;
//    }
//
//    public ConsultaRA getConsultaRA() {
//        return consultaRA;
//    }
//
//    public void setConsultaRA(ConsultaRA consultaRA) {
//        this.consultaRA = consultaRA;
//    }
//
//    public List<FichaAluno> getFichaAlunoList() {
//        return fichaAlunoList;
//    }
//
//    public void setFichaAlunoList(List<FichaAluno> fichaAlunoList) {
//        this.fichaAlunoList = fichaAlunoList;
//    }
//
//    public List<ListaAlunos> getAlunoList() {
//        return alunoList;
//    }
//
//    public void setAlunoList(List<ListaAlunos> alunoList) {
//        this.alunoList = alunoList;
//    }
}
