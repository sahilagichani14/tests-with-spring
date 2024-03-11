package testswithspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@SpringBootTest //it loads all context but we want to test only data tier so we use
@DataJpaTest
@RunWith(SpringRunner.class) // this is must for autowiring testEntityManager
//@ComponentScan(basePackages = {"testswithspring"})
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class StudentJpaRepoTest {
    @Autowired
    StudentJpaRepoInterface studentJpaRepoInterface;
    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void testGetStudentByName(){
        StudentJpaRepo studentJpaRepo = StudentJpaRepo.builder()
                .name("ABCD")
                .build();
        //testEntityManager.persist(studentJpaRepo);
        studentJpaRepoInterface.save(studentJpaRepo);
        List<StudentJpaRepo> studentJpaRepos = studentJpaRepoInterface.findAll();
        System.out.println(studentJpaRepos);

        //StudentJpaRepo savedStudentJpaRepo = studentJpaRepoInterface.saveAndFlush(studentJpaRepo);
        //StudentJpaRepo studentJpaRepo1 = studentJpaRepoInterface.getStudentJpaRepoInterfaceByName("Sahil");
        //Assertions.assertEquals(studentJpaRepo1.getId(), Optional.ofNullable(null));
        //Assertions.assertEquals(studentJpaRepo1.getName(), "Sahil");
    }
}
