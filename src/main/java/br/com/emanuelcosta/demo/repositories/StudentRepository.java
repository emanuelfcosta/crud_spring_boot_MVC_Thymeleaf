package br.com.emanuelcosta.demo.repositories;

import br.com.emanuelcosta.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
