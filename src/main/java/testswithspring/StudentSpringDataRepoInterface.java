package testswithspring;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import testswithspring.StudentSpringDataRepo;

import java.util.List;

public interface StudentSpringDataRepoInterface extends CrudRepository<StudentSpringDataRepo, Long> {

    //custom method name, name should match field name, with no Typo at startUp
    StudentSpringDataRepo getStudentByName(String name);

    //custom Java persistence query language JPQL, with no Typo check at startUp
    @Query(value = "Select s from Student s")
    List<StudentSpringDataRepo> getAllStudentsCustom();

    //Native SQL -> no query check at startUp so we need integration tests to check
    @Query(value = "Select * from Students", nativeQuery = true)
    List<StudentSpringDataRepo> getAllStudentsNative();

}
