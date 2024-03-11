package testswithspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentJpaRepoInterface studentJpaRepoInterface;
    public void add(StudentJpaRepo studentJpaRepo) {
        studentJpaRepoInterface.save(studentJpaRepo);
    }
}
