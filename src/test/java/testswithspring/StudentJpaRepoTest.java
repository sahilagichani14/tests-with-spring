package testswithspring;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest //it loads all context but we want to test only data tier so we use
//@DataJpaTest
//@RunWith(SpringRunner.class)
@EnableJpaRepositories
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class StudentJpaRepoTest {
    @Autowired
    private StudentJpaRepoInterface studentJpaRepoInterface;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testGetStudentByName(){
        StudentJpaRepo studentJpaRepo = StudentJpaRepo.builder()
                .id(2l)
                .name("ABCD")
                .build();
        StudentJpaRepo savedStudentJpaRepo = studentJpaRepoInterface.save(studentJpaRepo);

        StudentJpaRepo studentJpaRepo1 = studentJpaRepoInterface.getStudentJpaRepoInterfaceByName("Sahil");
        Assertions.assertEquals(studentJpaRepo1.getId(), null);
        Assertions.assertEquals(studentJpaRepo1.getName(), "Sahil");
    }
}
