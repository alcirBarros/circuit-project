package rc.web;

import br.gov.sp.educacao.ensemble.SecretariaMunicipal;
import br.gov.sp.educacao.ensemble.SecretariaMunicipalSoap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rc.domain.Hotel;
import rc.persistence.HotelRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

//    public HotelController(HotelRepository hotelRepository) {
//        this.hotelRepository = hotelRepository;
//    }

//    @RequestMapping("/")
//    public String welcome() {//Welcome page, non-rest
//        return "Welcome to RestTemplate Example.";
//    }

    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        SecretariaMunicipal secretariaMunicipal = new SecretariaMunicipal();
        SecretariaMunicipalSoap secretariaMunicipalSoap = secretariaMunicipal.getSecretariaMunicipalSoap();
        List<Hotel> hotels = this.hotelRepository.findAll();
        return hotels;
    }
}
