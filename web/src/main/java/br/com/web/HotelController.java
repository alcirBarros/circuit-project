//package br.com.web;
//
//import br.gov.sp.educacao.ensemble.SecretariaMunicipal;
//import br.gov.sp.educacao.ensemble.SecretariaMunicipalSoap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@RestController
//public class HotelController {
//
//    @RequestMapping("/")
//    public String welcome() {//Welcome page, non-rest
//        return "Welcome to RestTemplate Example.";
//    }
//
//    @GetMapping("/hotels")
//    public String getHotels() {
//        SecretariaMunicipal secretariaMunicipal = new SecretariaMunicipal();
//        SecretariaMunicipalSoap secretariaMunicipalSoap = secretariaMunicipal.getSecretariaMunicipalSoap();
//        return "Status OK";
//    }
//}
