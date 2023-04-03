package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
        name = "student_id_seq",
        sequenceName = "student_id_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_id_seq"
    )

    private long id;
    private String name;
    private String email;
    private LocalDate DOB;
    @Transient
    private int age;

    public Student(){}

    public Student(long id, String name, String email, LocalDate DOB) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.DOB = DOB;
    }

    public Student(String name, String email, LocalDate DOB) {
        this.name = name;
        this.email = email;
        this.DOB = DOB;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public int getAge() {
        return Period.between(DOB, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }


}
