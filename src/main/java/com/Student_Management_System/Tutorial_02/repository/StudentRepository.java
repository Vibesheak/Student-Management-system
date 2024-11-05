package com.Student_Management_System.Tutorial_02.repository;
import com.Student_Management_System.Tutorial_02.model.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<student,Long> {

}