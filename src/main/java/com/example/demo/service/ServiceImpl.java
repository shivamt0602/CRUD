package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.example.demo.Models.Student;

@Service
public class ServiceImpl implements StudentService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String saveStudent(Student student) {
        mongoTemplate.insert(student, "disciples");
        return student.get_id();
    }

    @Override
    public List<Student> getAllStudents() {
        return mongoTemplate.findAll(Student.class, "disciples");
    }

    @Override
    public Student updateStudent(String _id, String name, String address) {
        Student existingStudent = mongoTemplate.findById(_id, Student.class, "disciples");
        if (existingStudent != null) {
            if (name != null) {
                existingStudent.setName(name);
            }
            if (address != null) {
                existingStudent.setAddress(address);
            }
            mongoTemplate.save(existingStudent, "disciples");
            return existingStudent;
        }
        return null; // or throw an exception if the student is not found
    }

    @Override
    public Student removeStudent(String _id) {
        Student student = mongoTemplate.findById(_id, Student.class, "disciples");
        if (student != null) {
            mongoTemplate.remove(student, "disciples");
        }
		return student;
    }
}
