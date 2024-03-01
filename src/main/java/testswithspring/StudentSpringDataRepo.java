package testswithspring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Entity
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentSpringDataRepo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

}

