package testswithspring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpaRepoInterface extends JpaRepository<StudentJpaRepo, Long> {
    StudentJpaRepo getStudentJpaRepoInterfaceByName(String name);
}
