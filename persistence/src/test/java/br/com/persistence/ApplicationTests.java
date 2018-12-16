package br.com.persistence;

import br.com.persistence.configuracao.database.DatabaseConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DatabaseConfig.class)
@RunWith(SpringRunner.class)
public class ApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("**********************************");
        System.out.println("**********************************");
        System.out.println("**********************************");
        System.out.println("**********************************");
    }

}
