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
//@Table(name = "fln_ficha_aluno")
//public class FichaAluno implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "fln_id", nullable = false)
//    private Integer id;
//
//    @Column(name = "fln_bairro", columnDefinition="TEXT")
//    private String outBairro;
//
//    @Column(name = "fln_baolsa_familia", columnDefinition="TEXT")
//    private String outBolsaFamilia;
//
//    @Column(name = "fln_cep", columnDefinition="TEXT")
//    private String outCEP;
////    
//    @Column(name = "fln_cpf", columnDefinition="TEXT")
//    private String outCPF;
////    
//    @Column(name = "fln_cidade", columnDefinition="TEXT")
//    private String outCidade;
////
//////    private ArrayOfoutDeficienciasItemString outDeficiencias;
////    
//    @Column(name = "fln_cod_pais_origem", columnDefinition="TEXT")
//    private String outCodPaisOrigem;
//
//    @Column(name = "fln_cor_raca", columnDefinition="TEXT")
//    private String outCorRaca;
//
//    @Column(name = "fln_ddd", columnDefinition="TEXT")
//    private String outDDD;
//
//    @Column(name = "fln_data_alteracao", columnDefinition="TEXT")
//    private String outDataAlteracao;
//
//    @Column(name = "fln_data_emis_reg_nasc", columnDefinition="TEXT")
//    private String outDataEmisRegNasc;
//
//    @Column(name = "fln_data_emissao_rg", columnDefinition="TEXT")
//    private String outDataEmissaoRG;
//
//    @Column(name = "fln_data_entrada_brasil", columnDefinition="TEXT")
//    private String outDataEntrBrasil;
//
//    @Column(name = "fln_data_nascimento", columnDefinition="TEXT")
//    private String outDataNascimento;
//
//    @Column(name = "fln_desc_municipio", columnDefinition="TEXT")
//    private String outDescMunNasc;
//
//    @Column(name = "fln_digito_ra", columnDefinition="TEXT")
//    private String outDigitoRA;
//
//    @Column(name = "fln_digito_rg", columnDefinition="TEXT")
//    private String outDigitoRG;
//
//    @Column(name = "fln_endereco", columnDefinition="TEXT")
//    private String outEndereco;
//
//    @Column(name = "fln_erro", columnDefinition="TEXT")
//    private String outErro;
//
//    @Column(name = "fln_fone_recado", columnDefinition="TEXT")
//    private String outFoneRecado;
//
//    @Column(name = "fln_fone_residencial", columnDefinition="TEXT")
//    private String outFoneResidencial;
//
//    @Column(name = "fln_gemeo", columnDefinition="TEXT")
//    private String outGemeo;
//
//    @Column(name = "fln_ident_aluno_mec", columnDefinition="TEXT")
//    private String outIdentAlunoMEC;
//
//    @Column(name = "fln_mobilidade_reduzida", columnDefinition="TEXT")
//    private String outMobilidadeReduzida;
//
//    @Column(name = "fln_nascionalidade", columnDefinition="TEXT")
//    private String outNacionalidade;
//
//    @Column(name = "fln_nome_aluno", columnDefinition="TEXT")
//    private String outNomeAluno;
//
//    @Column(name = "fln_nome_mae", columnDefinition="TEXT")
//    private String outNomeMae;
//
//    @Column(name = "fln_nome_pai", columnDefinition="TEXT")
//    private String outNomePai;
//
//    @Column(name = "fln_nome_pais_origem", columnDefinition="TEXT")
//    private String outNomePaisOrigem;
//
//    @Column(name = "fln_num_nis", columnDefinition="TEXT")
//    private String outNumNis;
//
//    @Column(name = "fln_num_rg", columnDefinition="TEXT")
//    private String outNumRG;
//
//    @Column(name = "fln_num_registro_nascimento", columnDefinition="TEXT")
//    private String outNumRegNasc;
//
//    @Column(name = "fln_observacao_recado", columnDefinition="TEXT")
//    private String outObsRecado;
//
//    @Column(name = "fln_operador", columnDefinition="TEXT")
//    private String outOperador;
//
//    @Column(name = "fln_ra", columnDefinition="TEXT")
//    private String outRA;
//
//    @Column(name = "fln_sexo", columnDefinition="TEXT")
//    private String outSexo;
//
//    @Column(name = "fln_uf", columnDefinition="TEXT")
//    private String outUF;
//
//    @Column(name = "fln_uf_nascimento", columnDefinition="TEXT")
//    private String outUFNascimento;
//
//    @Column(name = "fln_uf_ra", columnDefinition="TEXT")
//    private String outUFRA;
//
//    @Column(name = "fln_uf_rg", columnDefinition="TEXT")
//    private String outUFRG;
//
//    @Column(name = "fln_zona", columnDefinition="TEXT")
//    private String outZona;
//
//////    private TipoCertidaoResp outCertidaoResp;
//    
//    @Column(name = "fln_auxilio_leitor", columnDefinition="TEXT")
//    private String outAuxilioLeitor;
////    
//    @Column(name = "fln_auxilio_transcricao", columnDefinition="TEXT")
//    private String outAuxilioTranscricao;
//
//    @Column(name = "fln_ddd_cel", columnDefinition="TEXT")
//    private String outDDDCel;
//
//    @Column(name = "fln_fone_cel", columnDefinition="TEXT")
//    private String outFoneCel;
//
//    @Column(name = "fln_guia_interprete", columnDefinition="TEXT")
//    private String outGuiaInterprete;
//
//    @Column(name = "fln_interprete_libras", columnDefinition="TEXT")
//    private String outInterpreteLibras;
//
//    @Column(name = "fln_leitura_labial", columnDefinition="TEXT")
//    private String outLeituraLabial;
//
//    @Column(name = "fln_nenhum", columnDefinition="TEXT")
//    private String outNenhum;
//
//    @Column(name = "fln_prova_ampliada", columnDefinition="TEXT")
//    private String outProvaAmpliada;
//
//    @Column(name = "fln_prova_brasil", columnDefinition="TEXT")
//    private String outProvaBraile;
//
//    @Column(name = "fln_sms", columnDefinition="TEXT")
//    private String outSMS;
//
//    @Column(name = "fln_tam_dezesseis", columnDefinition="TEXT")
//    private String outTam16;
//
//    @Column(name = "fln_tam_vinte", columnDefinition="TEXT")
//    private String outTam20;
//
//    @Column(name = "fln_tamaho_vinte_quatro", columnDefinition="TEXT")
//    private String outTam24;
//
//    @Column(name = "fln_cuidador", columnDefinition="TEXT")
//    private String outCuidador;
//
//    @Column(name = "fln_email", columnDefinition="TEXT")
//    private String outEmail;
//
//    @Column(name = "fln_irmao", columnDefinition="TEXT")
//    private String outIrmaos;
//
//    @Column(name = "fln_nome_social", columnDefinition="TEXT")
//    private String outNomeSocial;
//
//    @Column(name = "fln_profissional_saude", columnDefinition="TEXT")
//    private String outProfisSaude;
//
//    @Column(name = "fln_quilombola", columnDefinition="TEXT")
//    private String outQuilombola;
//
//    @Column(name = "fln_latitude", columnDefinition="TEXT")
//    private String outLatitude;
//
//    @Column(name = "fln_longitude", columnDefinition="TEXT")
//    private String outLongitude;
//
//    @Column(name = "fln_logradouro", columnDefinition="TEXT")
//    private String outLogradouro;
//
//    @Column(name = "fln_numero", columnDefinition="TEXT")
//    private String outNumero;
//
//    @Column(name = "fln_complemento", columnDefinition="TEXT")
//    private String outComplemento;
//
////    private FichaAlunoEndIndicativo outEndIndicativo;
//    public static FichaAluno criarInstancia() {
//        return new FichaAluno();
//    }
//
//    public static FichaAluno criarInstancia(br.gov.sp.educacao.ensemble.FichaAluno fichaAluno_) {
//        FichaAluno fichaAluno = criarInstancia();
//        fichaAluno.setOutBairro(fichaAluno_.getOutBairro());
//        fichaAluno.setOutBolsaFamilia(fichaAluno_.getOutBolsaFamilia());
//        fichaAluno.setOutCEP(fichaAluno_.getOutCEP());
//        fichaAluno.setOutCPF(fichaAluno_.getOutCPF());
//        fichaAluno.setOutCidade(fichaAluno_.getOutCidade());
////        fichaAluno.setOutDeficiencias(fichaAluno_.getOutDeficiencias());
//        fichaAluno.setOutCodPaisOrigem(fichaAluno_.getOutCodPaisOrigem());
//        fichaAluno.setOutCorRaca(fichaAluno_.getOutCorRaca());
//        fichaAluno.setOutDDD(fichaAluno_.getOutDDD());
//        fichaAluno.setOutDataAlteracao(fichaAluno_.getOutDataAlteracao());
//        fichaAluno.setOutDataEmisRegNasc(fichaAluno_.getOutDataEmisRegNasc());
//        fichaAluno.setOutDataEmissaoRG(fichaAluno_.getOutDataEmissaoRG());
//        fichaAluno.setOutDataEntrBrasil(fichaAluno_.getOutDataEntrBrasil());
//        fichaAluno.setOutDataNascimento(fichaAluno_.getOutDataNascimento());
//        fichaAluno.setOutDescMunNasc(fichaAluno_.getOutDescMunNasc());
//        fichaAluno.setOutDigitoRA(fichaAluno_.getOutDigitoRA());
//        fichaAluno.setOutDigitoRG(fichaAluno_.getOutDigitoRG());
//        fichaAluno.setOutEndereco(fichaAluno_.getOutEndereco());
//        fichaAluno.setOutErro(fichaAluno_.getOutErro());
//        fichaAluno.setOutFoneRecado(fichaAluno_.getOutFoneRecado());
//        fichaAluno.setOutFoneResidencial(fichaAluno_.getOutFoneResidencial());
//        fichaAluno.setOutGemeo(fichaAluno_.getOutGemeo());
//        fichaAluno.setOutIdentAlunoMEC(fichaAluno_.getOutIdentAlunoMEC());
//        fichaAluno.setOutMobilidadeReduzida(fichaAluno_.getOutMobilidadeReduzida());
//        fichaAluno.setOutNacionalidade(fichaAluno_.getOutNacionalidade());
//        fichaAluno.setOutNomeAluno(fichaAluno_.getOutNomeAluno());
//        fichaAluno.setOutNomeMae(fichaAluno_.getOutNomeMae());
//        fichaAluno.setOutNomePai(fichaAluno_.getOutNomePai());
//        fichaAluno.setOutNomePaisOrigem(fichaAluno_.getOutNomePaisOrigem());
//        fichaAluno.setOutNumNis(fichaAluno_.getOutNumNis());
//        fichaAluno.setOutNumRG(fichaAluno_.getOutNumRG());
//        fichaAluno.setOutNumRegNasc(fichaAluno_.getOutNumRegNasc());
//        fichaAluno.setOutObsRecado(fichaAluno_.getOutObsRecado());
//        fichaAluno.setOutOperador(fichaAluno_.getOutOperador());
//        fichaAluno.setOutRA(fichaAluno_.getOutRA());
//        fichaAluno.setOutSexo(fichaAluno_.getOutSexo());
//        fichaAluno.setOutUF(fichaAluno_.getOutUF());
//        fichaAluno.setOutUFNascimento(fichaAluno_.getOutUFNascimento());
//        fichaAluno.setOutUFRA(fichaAluno_.getOutUFRA());
//        fichaAluno.setOutUFRG(fichaAluno_.getOutUFRG());
//        fichaAluno.setOutZona(fichaAluno_.getOutZona());
////        fichaAluno.setOutCertidaoResp(fichaAluno_.getOutCertidaoResp());
//        fichaAluno.setOutAuxilioLeitor(fichaAluno_.getOutAuxilioLeitor());
//        fichaAluno.setOutAuxilioTranscricao(fichaAluno_.getOutAuxilioTranscricao());
//        fichaAluno.setOutDDDCel(fichaAluno_.getOutDDDCel());
//        fichaAluno.setOutFoneCel(fichaAluno_.getOutFoneCel());
//        fichaAluno.setOutGuiaInterprete(fichaAluno_.getOutGuiaInterprete());
//        fichaAluno.setOutInterpreteLibras(fichaAluno_.getOutInterpreteLibras());
//        fichaAluno.setOutLeituraLabial(fichaAluno_.getOutLeituraLabial());
//        fichaAluno.setOutNenhum(fichaAluno_.getOutNenhum());
//        fichaAluno.setOutProvaAmpliada(fichaAluno_.getOutProvaAmpliada());
//        fichaAluno.setOutProvaBraile(fichaAluno_.getOutProvaBraile());
//        fichaAluno.setOutSMS(fichaAluno_.getOutSMS());
//        fichaAluno.setOutTam16(fichaAluno_.getOutTam16());
//        fichaAluno.setOutTam20(fichaAluno_.getOutTam20());
//        fichaAluno.setOutTam24(fichaAluno_.getOutTam24());
//        fichaAluno.setOutCuidador(fichaAluno_.getOutCuidador());
//        fichaAluno.setOutEmail(fichaAluno_.getOutEmail());
//        fichaAluno.setOutIrmaos(fichaAluno_.getOutIrmaos());
//        fichaAluno.setOutNomeSocial(fichaAluno_.getOutNomeSocial());
//        fichaAluno.setOutProfisSaude(fichaAluno_.getOutProfisSaude());
//        fichaAluno.setOutQuilombola(fichaAluno_.getOutQuilombola());
//        fichaAluno.setOutLatitude(fichaAluno_.getOutLatitude());
//        fichaAluno.setOutLongitude(fichaAluno_.getOutLongitude());
//        fichaAluno.setOutLogradouro(fichaAluno_.getOutLogradouro());
//        fichaAluno.setOutNumero(fichaAluno_.getOutNumero());
//        fichaAluno.setOutComplemento(fichaAluno_.getOutComplemento());
////        fichaAluno.setOutEndIndicativo(fichaAluno_.getOutEndIndicativo());
//
//        return fichaAluno;
//
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
//    public String getOutBairro() {
//        return outBairro;
//    }
//
//    public void setOutBairro(String outBairro) {
//        this.outBairro = outBairro;
//    }
//
//    public String getOutBolsaFamilia() {
//        return outBolsaFamilia;
//    }
//
//    public void setOutBolsaFamilia(String outBolsaFamilia) {
//        this.outBolsaFamilia = outBolsaFamilia;
//    }
//
//    public String getOutCEP() {
//        return outCEP;
//    }
//
//    public void setOutCEP(String outCEP) {
//        this.outCEP = outCEP;
//    }
//
//    public String getOutCPF() {
//        return outCPF;
//    }
//
//    public void setOutCPF(String outCPF) {
//        this.outCPF = outCPF;
//    }
//
//    public String getOutCidade() {
//        return outCidade;
//    }
//
//    public void setOutCidade(String outCidade) {
//        this.outCidade = outCidade;
//    }
//
//    public String getOutCodPaisOrigem() {
//        return outCodPaisOrigem;
//    }
//
//    public void setOutCodPaisOrigem(String outCodPaisOrigem) {
//        this.outCodPaisOrigem = outCodPaisOrigem;
//    }
//
//    public String getOutCorRaca() {
//        return outCorRaca;
//    }
//
//    public void setOutCorRaca(String outCorRaca) {
//        this.outCorRaca = outCorRaca;
//    }
//
//    public String getOutDDD() {
//        return outDDD;
//    }
//
//    public void setOutDDD(String outDDD) {
//        this.outDDD = outDDD;
//    }
//
//    public String getOutDataAlteracao() {
//        return outDataAlteracao;
//    }
//
//    public void setOutDataAlteracao(String outDataAlteracao) {
//        this.outDataAlteracao = outDataAlteracao;
//    }
//
//    public String getOutDataEmisRegNasc() {
//        return outDataEmisRegNasc;
//    }
//
//    public void setOutDataEmisRegNasc(String outDataEmisRegNasc) {
//        this.outDataEmisRegNasc = outDataEmisRegNasc;
//    }
//
//    public String getOutDataEmissaoRG() {
//        return outDataEmissaoRG;
//    }
//
//    public void setOutDataEmissaoRG(String outDataEmissaoRG) {
//        this.outDataEmissaoRG = outDataEmissaoRG;
//    }
//
//    public String getOutDataEntrBrasil() {
//        return outDataEntrBrasil;
//    }
//
//    public void setOutDataEntrBrasil(String outDataEntrBrasil) {
//        this.outDataEntrBrasil = outDataEntrBrasil;
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
//    public String getOutDescMunNasc() {
//        return outDescMunNasc;
//    }
//
//    public void setOutDescMunNasc(String outDescMunNasc) {
//        this.outDescMunNasc = outDescMunNasc;
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
//    public String getOutDigitoRG() {
//        return outDigitoRG;
//    }
//
//    public void setOutDigitoRG(String outDigitoRG) {
//        this.outDigitoRG = outDigitoRG;
//    }
//
//    public String getOutEndereco() {
//        return outEndereco;
//    }
//
//    public void setOutEndereco(String outEndereco) {
//        this.outEndereco = outEndereco;
//    }
//
//    public String getOutErro() {
//        return outErro;
//    }
//
//    public void setOutErro(String outErro) {
//        this.outErro = outErro;
//    }
//
//    public String getOutFoneRecado() {
//        return outFoneRecado;
//    }
//
//    public void setOutFoneRecado(String outFoneRecado) {
//        this.outFoneRecado = outFoneRecado;
//    }
//
//    public String getOutFoneResidencial() {
//        return outFoneResidencial;
//    }
//
//    public void setOutFoneResidencial(String outFoneResidencial) {
//        this.outFoneResidencial = outFoneResidencial;
//    }
//
//    public String getOutGemeo() {
//        return outGemeo;
//    }
//
//    public void setOutGemeo(String outGemeo) {
//        this.outGemeo = outGemeo;
//    }
//
//    public String getOutIdentAlunoMEC() {
//        return outIdentAlunoMEC;
//    }
//
//    public void setOutIdentAlunoMEC(String outIdentAlunoMEC) {
//        this.outIdentAlunoMEC = outIdentAlunoMEC;
//    }
//
//    public String getOutMobilidadeReduzida() {
//        return outMobilidadeReduzida;
//    }
//
//    public void setOutMobilidadeReduzida(String outMobilidadeReduzida) {
//        this.outMobilidadeReduzida = outMobilidadeReduzida;
//    }
//
//    public String getOutNacionalidade() {
//        return outNacionalidade;
//    }
//
//    public void setOutNacionalidade(String outNacionalidade) {
//        this.outNacionalidade = outNacionalidade;
//    }
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
//    public String getOutNomePai() {
//        return outNomePai;
//    }
//
//    public void setOutNomePai(String outNomePai) {
//        this.outNomePai = outNomePai;
//    }
//
//    public String getOutNomePaisOrigem() {
//        return outNomePaisOrigem;
//    }
//
//    public void setOutNomePaisOrigem(String outNomePaisOrigem) {
//        this.outNomePaisOrigem = outNomePaisOrigem;
//    }
//
//    public String getOutNumNis() {
//        return outNumNis;
//    }
//
//    public void setOutNumNis(String outNumNis) {
//        this.outNumNis = outNumNis;
//    }
//
//    public String getOutNumRG() {
//        return outNumRG;
//    }
//
//    public void setOutNumRG(String outNumRG) {
//        this.outNumRG = outNumRG;
//    }
//
//    public String getOutNumRegNasc() {
//        return outNumRegNasc;
//    }
//
//    public void setOutNumRegNasc(String outNumRegNasc) {
//        this.outNumRegNasc = outNumRegNasc;
//    }
//
//    public String getOutObsRecado() {
//        return outObsRecado;
//    }
//
//    public void setOutObsRecado(String outObsRecado) {
//        this.outObsRecado = outObsRecado;
//    }
//
//    public String getOutOperador() {
//        return outOperador;
//    }
//
//    public void setOutOperador(String outOperador) {
//        this.outOperador = outOperador;
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
//    public String getOutSexo() {
//        return outSexo;
//    }
//
//    public void setOutSexo(String outSexo) {
//        this.outSexo = outSexo;
//    }
//
//    public String getOutUF() {
//        return outUF;
//    }
//
//    public void setOutUF(String outUF) {
//        this.outUF = outUF;
//    }
//
//    public String getOutUFNascimento() {
//        return outUFNascimento;
//    }
//
//    public void setOutUFNascimento(String outUFNascimento) {
//        this.outUFNascimento = outUFNascimento;
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
//    public String getOutUFRG() {
//        return outUFRG;
//    }
//
//    public void setOutUFRG(String outUFRG) {
//        this.outUFRG = outUFRG;
//    }
//
//    public String getOutZona() {
//        return outZona;
//    }
//
//    public void setOutZona(String outZona) {
//        this.outZona = outZona;
//    }
//
////    public TipoCertidaoResp getOutCertidaoResp() {
////        return outCertidaoResp;
////    }
////
////    public void setOutCertidaoResp(TipoCertidaoResp outCertidaoResp) {
////        this.outCertidaoResp = outCertidaoResp;
////    }
//    public String getOutAuxilioLeitor() {
//        return outAuxilioLeitor;
//    }
//
//    public void setOutAuxilioLeitor(String outAuxilioLeitor) {
//        this.outAuxilioLeitor = outAuxilioLeitor;
//    }
//
//    public String getOutAuxilioTranscricao() {
//        return outAuxilioTranscricao;
//    }
//
//    public void setOutAuxilioTranscricao(String outAuxilioTranscricao) {
//        this.outAuxilioTranscricao = outAuxilioTranscricao;
//    }
//
//    public String getOutDDDCel() {
//        return outDDDCel;
//    }
//
//    public void setOutDDDCel(String outDDDCel) {
//        this.outDDDCel = outDDDCel;
//    }
//
//    public String getOutFoneCel() {
//        return outFoneCel;
//    }
//
//    public void setOutFoneCel(String outFoneCel) {
//        this.outFoneCel = outFoneCel;
//    }
//
//    public String getOutGuiaInterprete() {
//        return outGuiaInterprete;
//    }
//
//    public void setOutGuiaInterprete(String outGuiaInterprete) {
//        this.outGuiaInterprete = outGuiaInterprete;
//    }
//
//    public String getOutInterpreteLibras() {
//        return outInterpreteLibras;
//    }
//
//    public void setOutInterpreteLibras(String outInterpreteLibras) {
//        this.outInterpreteLibras = outInterpreteLibras;
//    }
//
//    public String getOutLeituraLabial() {
//        return outLeituraLabial;
//    }
//
//    public void setOutLeituraLabial(String outLeituraLabial) {
//        this.outLeituraLabial = outLeituraLabial;
//    }
//
//    public String getOutNenhum() {
//        return outNenhum;
//    }
//
//    public void setOutNenhum(String outNenhum) {
//        this.outNenhum = outNenhum;
//    }
//
//    public String getOutProvaAmpliada() {
//        return outProvaAmpliada;
//    }
//
//    public void setOutProvaAmpliada(String outProvaAmpliada) {
//        this.outProvaAmpliada = outProvaAmpliada;
//    }
//
//    public String getOutProvaBraile() {
//        return outProvaBraile;
//    }
//
//    public void setOutProvaBraile(String outProvaBraile) {
//        this.outProvaBraile = outProvaBraile;
//    }
//
//    public String getOutSMS() {
//        return outSMS;
//    }
//
//    public void setOutSMS(String outSMS) {
//        this.outSMS = outSMS;
//    }
//
//    public String getOutTam16() {
//        return outTam16;
//    }
//
//    public void setOutTam16(String outTam16) {
//        this.outTam16 = outTam16;
//    }
//
//    public String getOutTam20() {
//        return outTam20;
//    }
//
//    public void setOutTam20(String outTam20) {
//        this.outTam20 = outTam20;
//    }
//
//    public String getOutTam24() {
//        return outTam24;
//    }
//
//    public void setOutTam24(String outTam24) {
//        this.outTam24 = outTam24;
//    }
//
//    public String getOutCuidador() {
//        return outCuidador;
//    }
//
//    public void setOutCuidador(String outCuidador) {
//        this.outCuidador = outCuidador;
//    }
//
//    public String getOutEmail() {
//        return outEmail;
//    }
//
//    public void setOutEmail(String outEmail) {
//        this.outEmail = outEmail;
//    }
//
//    public String getOutIrmaos() {
//        return outIrmaos;
//    }
//
//    public void setOutIrmaos(String outIrmaos) {
//        this.outIrmaos = outIrmaos;
//    }
//
//    public String getOutNomeSocial() {
//        return outNomeSocial;
//    }
//
//    public void setOutNomeSocial(String outNomeSocial) {
//        this.outNomeSocial = outNomeSocial;
//    }
//
//    public String getOutProfisSaude() {
//        return outProfisSaude;
//    }
//
//    public void setOutProfisSaude(String outProfisSaude) {
//        this.outProfisSaude = outProfisSaude;
//    }
//
//    public String getOutQuilombola() {
//        return outQuilombola;
//    }
//
//    public void setOutQuilombola(String outQuilombola) {
//        this.outQuilombola = outQuilombola;
//    }
//
//    public String getOutLatitude() {
//        return outLatitude;
//    }
//
//    public void setOutLatitude(String outLatitude) {
//        this.outLatitude = outLatitude;
//    }
//
//    public String getOutLongitude() {
//        return outLongitude;
//    }
//
//    public void setOutLongitude(String outLongitude) {
//        this.outLongitude = outLongitude;
//    }
//
//    public String getOutLogradouro() {
//        return outLogradouro;
//    }
//
//    public void setOutLogradouro(String outLogradouro) {
//        this.outLogradouro = outLogradouro;
//    }
//
//    public String getOutNumero() {
//        return outNumero;
//    }
//
//    public void setOutNumero(String outNumero) {
//        this.outNumero = outNumero;
//    }
//
//    public String getOutComplemento() {
//        return outComplemento;
//    }
//
//    public void setOutComplemento(String outComplemento) {
//        this.outComplemento = outComplemento;
//    }
//
////    public FichaAlunoEndIndicativo getOutEndIndicativo() {
////        return outEndIndicativo;
////    }
////
////    public void setOutEndIndicativo(FichaAlunoEndIndicativo outEndIndicativo) {
////        this.outEndIndicativo = outEndIndicativo;
////    }
//}
