package in.prakash.CurdOpeationSpring.repository;

import in.prakash.CurdOpeationSpring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//optional
 //@Repository

public interface StudentRepository extends JpaRepository<Student,Long> {


    Long id(Long id);
}
