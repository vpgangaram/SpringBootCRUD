package com.example.demo.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository StudentR;

@Autowired
public StudentService(StudentRepository StudentR) {
    this.StudentR = StudentR;
}

    public List<Student> getStudents() {
		return StudentR.findAll();
	}

    public void addStudent(Student student) {
        Optional<Student> StudentByEmail = StudentR.findStudentByEmail(student.getEmail());
        if (StudentByEmail.isPresent()) {
           throw new IllegalStateException("Already Exists");
        }
        StudentR.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists =StudentR.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("Not Exists");
        }

        StudentR.deleteById(studentId);
    }
}
