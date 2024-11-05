package com.Student_Management_System.Tutorial_02.service.impl;
import com.Student_Management_System.Tutorial_02.model.student;
import com.Student_Management_System.Tutorial_02.repository.StudentRepository;
import com.Student_Management_System.Tutorial_02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    
@Autowired
private StudentRepository studentRepsitory;

@Override
public student saveStudent(student student){
return studentRepsitory.save(student);
}

@Override
public List<student> getAllStudent() {
return studentRepsitory.findAll();
}

@Override
public student getStudentById(long id) {
Optional<student> student = studentRepsitory.findById(id);
if(student.isPresent()){
return student.get();
}else {
throw new RuntimeException();
}
}

@Override
public student updateStudent(student student, long id) {
student existingStudent =
studentRepsitory.findById(id).orElseThrow(
()-> new RuntimeException()
);
existingStudent.setFirstName(student.getFirstName());
existingStudent.setLastName(student.getLastName());
existingStudent.setEmail(student.getEmail());
existingStudent.setDepartment(student.getDepartment());
existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());

studentRepsitory.save(existingStudent);
return existingStudent;
}

@Override
public void deleteStudent(long id) {

studentRepsitory.findById(id).orElseThrow(()-> new
RuntimeException());

studentRepsitory.deleteById(id);
}
}