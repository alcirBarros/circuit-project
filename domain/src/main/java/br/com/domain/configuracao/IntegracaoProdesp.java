//package br.com.domain.configuracao;
//
//import br.gov.sp.educacao.ensemble.SecretariaMunicipal;
//import br.gov.sp.educacao.ensemble.SecretariaMunicipalSoap;
//import java.util.Map;
//import javax.xml.ws.BindingProvider;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public abstract class IntegracaoProdesp {
//
//    protected SecretariaMunicipalSoap secretariaMunicipalSoap;
//
//    protected final String LOGIN = "SME734";
//    protected final String SENHA = "f1s0ev92\\oK-";
//    protected final String URL = "https://homologacaointegracaosed.educacao.sp.gov.br/educacao/Sec.BS.SecretariaMunicipal.cls";
//
//    public IntegracaoProdesp() {
//        SecretariaMunicipal secretariaMunicipal = new SecretariaMunicipal();
//
//        secretariaMunicipalSoap = secretariaMunicipal.getSecretariaMunicipalSoap();
//        Map<String, Object> requestContext = ((BindingProvider) secretariaMunicipalSoap).getRequestContext();
//        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, URL);
//    }
//
//
//
//}
