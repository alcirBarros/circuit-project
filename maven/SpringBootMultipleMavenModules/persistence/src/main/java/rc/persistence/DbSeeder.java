package rc.persistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rc.domain.Hotel;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DbSeeder
        //implements CommandLineRunner
{

    @Autowired
    private HotelRepository hotelRepository;


//    @Override
//    public void run(String... strings) throws Exception {
//        Hotel marriot = new Hotel("Marriot", 5, true);
//        Hotel ibis = new Hotel("Ibis", 3, false);
//        Hotel goldenTulip = new Hotel("Golden Tulip", 4, true);
//
//        List<Hotel> hotels = new ArrayList<>();
//        hotels.add(marriot);
//        hotels.add(ibis);
//        hotels.add(goldenTulip);
//
//        this.hotelRepository.save(hotels);
//    }
}
