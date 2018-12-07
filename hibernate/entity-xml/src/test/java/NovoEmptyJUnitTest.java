
import br.column.ColumnType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.cfg.AnnotationConfiguration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NovoEmptyJUnitTest {

    public NovoEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateDB");
        EntityManager em = entityManagerFactory.createEntityManager();

        {
            ColumnType columnType = new ColumnType();
            columnType.setColumnString("AAAAAAAAAAAAAAA");
            columnType.setColumnInteger(1111111);
            columnType.setColumnLong(11111111111L);
            columnType.setColumnBoolean(Boolean.FALSE);
            columnType.setColumnDataTime(new Date());
            columnType.setColumnDate(new Date());
            columnType.setColumnTime(new Date());
            columnType.setColumnBigInteger(BigInteger.ONE);
            columnType.setColumnBigDecimal(BigDecimal.ONE);
            columnType.setDuration(Duration.ofDays(1));

            em.getTransaction().begin();
            em.persist(columnType);
            em.getTransaction().commit();
        }
        {
            ColumnType columnType = em.find(ColumnType.class, 1);
            columnType.setColumnString("FFFFFFFF55FFFF8888FFFFFf");
            em.getTransaction().begin();
            em.merge(columnType);
            em.getTransaction().commit();
        }

        ColumnType find = em.find(ColumnType.class, 1);

        System.out.println(find);

    }

}
