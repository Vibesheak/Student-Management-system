package com.Student_Management_System.Tutorial_02.controller;
import com.Student_Management_System.Tutorial_02.model.student;
import com.Student_Management_System.Tutorial_02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")

public class StudentController {
@Autowired
private StudentService studentService;
@PostMapping
public ResponseEntity<student> saveEmployee(@RequestBody student student){
return new
ResponseEntity<student>(studentService.saveStudent(student),
HttpStatus.CREATED);
}

@GetMapping
public List<student> getAllStudents(){
return studentService.getAllStudent();
}

@GetMapping("{id}")

public ResponseEntity<student> getStudentById(@PathVariable("id") long studentID){
return new
ResponseEntity<student>(studentService.getStudentById(studentID),HttpStatus.OK);
}


@PutMapping("{id}")
public ResponseEntity<student> updateStudent(@PathVariable("id") long id, @RequestBody student student){
return new
ResponseEntity<student>(studentService.updateStudent(student,id),HttpStatus.OK);
}

@DeleteMapping("{id}")
public ResponseEntity<String> deleteStudent(@PathVariable("id") long
id){

studentService.deleteStudent(id);
return new ResponseEntity<String>("Student deletedSuccessfully.",HttpStatus.OK);
}
}