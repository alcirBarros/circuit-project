
import hello.Application;
import hello.CountryClient;
import hello.wsdl.GetCountryResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class CountryClientTest {

    @Autowired
    private CountryClient countryClient;

    @Test
    public void status() {
        GetCountryResponse response = countryClient.getCountry("Spain");
        System.err.println(response.getCountry().getCurrency());
    }
}
