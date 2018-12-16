//package br.com.domain.consultafichaaluno.service;
//
//import br.com.domain.configuracao.IntegracaoProdesp;
//
//import br.com.domain.consultafichaaluno.model.ConsultarFichaAluno;
//import br.com.domain.consultafichaaluno.model.FichaAluno;
//import br.com.domain.consultafichaaluno.model.ListaAlunos;
//
//import br.gov.sp.educacao.ensemble.ArrayOfFichaAlunoFichaAluno;
//import br.gov.sp.educacao.ensemble.ArrayOfListaAlunosListaAlunos;
//import java.util.ArrayList;
//
//import java.util.List;
//
//import javax.xml.ws.Holder;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FichaAlunoService extends IntegracaoProdesp {
//
//    public ConsultarFichaAluno localizar(ConsultarFichaAluno consultarFichaAluno) {
//
//        Holder<String> outProcessoID = new Holder<>();
//        Holder<String> outSucesso = new Holder<>();
//        Holder<String> outErro = new Holder<>();
//
//        Holder<ArrayOfFichaAlunoFichaAluno> fichasAluno = new Holder<>();
//        Holder<ArrayOfListaAlunosListaAlunos> listaAlunos = new Holder<>();
//
//        secretariaMunicipalSoap.consultarFichaAluno(LOGIN, SENHA, consultarFichaAluno.getConsultaDocumentos(), consultarFichaAluno.getConsultaFonetica(), consultarFichaAluno.getConsultaNomeCompleto(), consultarFichaAluno.getConsultaRA(), outSucesso, outErro, fichasAluno, listaAlunos, outProcessoID);
//
//        consultarFichaAluno.setOutProcessoID(outProcessoID.value);
//        consultarFichaAluno.setOutSucesso(outSucesso.value);
//        consultarFichaAluno.setOutErro(outErro.value);
//
//        consultarFichaAluno.setFichaAlunoList(converterTo(fichasAluno.value));
//        consultarFichaAluno.setAlunoList(converter(listaAlunos.value));
//
//        return consultarFichaAluno;
//    }
//
//    private List<FichaAluno> converterTo(ArrayOfFichaAlunoFichaAluno value) {
//        List<br.gov.sp.educacao.ensemble.FichaAluno> fichaAlunoList_ = (value != null) ? value.getFichaAluno() : new ArrayList();
//        List<FichaAluno> fichaAlunoList = new ArrayList<>();
//        fichaAlunoList_.stream().forEach(x -> {fichaAlunoList.add(FichaAluno.criarInstancia(x));});
//        return fichaAlunoList;
//    }
//
//    private List<ListaAlunos> converter(ArrayOfListaAlunosListaAlunos value) {
//        List<br.gov.sp.educacao.ensemble.ListaAlunos> listaAlunos = (value != null) ? value.getListaAlunos() : new ArrayList();
//        List<ListaAlunos> fichaAlunos = new ArrayList<>();
//        listaAlunos.stream().forEach(x->{fichaAlunos.add(ListaAlunos.criarInstancia(x));});
//        return fichaAlunos;
//    }
//
//}
