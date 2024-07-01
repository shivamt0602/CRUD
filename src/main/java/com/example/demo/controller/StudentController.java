package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Student;
import com.example.demo.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable(name = "id") String _id,
                                 @RequestBody Student updatedStudent) {
        return studentService.updateStudent(_id, updatedStudent.getName(), updatedStudent.getAddress());
    }

    @DeleteMapping("/deleteStudent/{id}")
    public Student deleteStudent(@PathVariable(name = "id") String _id) {
        return studentService.removeStudent(_id);
    }
    
}
