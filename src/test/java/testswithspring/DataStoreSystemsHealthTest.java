package testswithspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataStoreSystemsHealthTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void dbPrimaryIsOk(){
        try {
            DatabaseMetaData databaseMetaData = dataSource.getConnection().getMetaData();
            String catalogName = dataSource.getConnection().getCatalog();

            assertThat(databaseMetaData, is(notNullValue()));
            assertThat(catalogName, is(equalTo("spring-tdd")));

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
