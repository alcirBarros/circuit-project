//package br.com.domain.consultafichaaluno.model;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "lln_list_aluno")
//public class ListaAlunos implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "lln_id", nullable = false)
//    private Integer id;
//
//    @Column(name = "lln_ra", columnDefinition="TEXT")
//    private String outRA;
//    
//    @Column(name = "lln_digito_ra", columnDefinition="TEXT")
//    private String outDigitoRA;
//    
//    @Column(name = "lln_uf_ra", columnDefinition="TEXT")
//    private String outUFRA;
//    
//    @Column(name = "lln_nome_aluno", columnDefinition="TEXT")
//    private String outNomeAluno;
//    
//    @Column(name = "lln_nome_mae", columnDefinition="TEXT")
//    private String outNomeMae;
//    
//    @Column(name = "lln_data_nascimento", columnDefinition="TEXT")
//    private String outDataNascimento;
//
//    public static ListaAlunos criarInstancia() {
//        return new ListaAlunos();
//    }
//
//    public static ListaAlunos criarInstancia(br.gov.sp.educacao.ensemble.ListaAlunos fichaAluno_) {
//        ListaAlunos fichaAluno = criarInstancia();
//        fichaAluno.setOutRA(fichaAluno_.getOutRA());
//        fichaAluno.setOutDigitoRA(fichaAluno_.getOutDigitoRA());
//        fichaAluno.setOutUFRA(fichaAluno_.getOutUFRA());
//        fichaAluno.setOutNomeAluno(fichaAluno_.getOutNomeAluno());
//        fichaAluno.setOutNomeMae(fichaAluno_.getOutNomeMae());
//        fichaAluno.setOutDataNascimento(fichaAluno_.getOutDataNascimento());
//        return fichaAluno;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getOutRA() {
//        return outRA;
//    }
//
//    public void setOutRA(String outRA) {
//        this.outRA = outRA;
//    }
//
//    public String getOutDigitoRA() {
//        return outDigitoRA;
//    }
//
//    public void setOutDigitoRA(String outDigitoRA) {
//        this.outDigitoRA = outDigitoRA;
//    }
//
//    public String getOutUFRA() {
//        return outUFRA;
//    }
//
//    public void setOutUFRA(String outUFRA) {
//        this.outUFRA = outUFRA;
//    }
//
//    public String getOutNomeAluno() {
//        return outNomeAluno;
//    }
//
//    public void setOutNomeAluno(String outNomeAluno) {
//        this.outNomeAluno = outNomeAluno;
//    }
//
//    public String getOutNomeMae() {
//        return outNomeMae;
//    }
//
//    public void setOutNomeMae(String outNomeMae) {
//        this.outNomeMae = outNomeMae;
//    }
//
//    public String getOutDataNascimento() {
//        return outDataNascimento;
//    }
//
//    public void setOutDataNascimento(String outDataNascimento) {
//        this.outDataNascimento = outDataNascimento;
//    }
//
//}
