package com.Student_Management_System.Tutorial_02.service;
import com.Student_Management_System.Tutorial_02.model.student;
import java.util.List;

public interface StudentService {
student saveStudent(student student);
List<student> getAllStudent();
student getStudentById(long id);
student updateStudent(student student,long id);
void deleteStudent(long id);
}
