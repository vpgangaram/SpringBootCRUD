package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner CLI(StudentRepository repositery){
        return args -> {
            Student john = new Student(
                "John",
                "lyhxr@example.com",
                LocalDate.of(2000, Month.JANUARY, 1)
            );
            Student jane = new Student(
                "Jane",
                "ychag@example.com",
                LocalDate.of(2001, Month.FEBRUARY, 1)
            );
            Student wick = new Student(
                "Wick",
                "ychag@example.com",
                LocalDate.of(2002, Month.MARCH, 1)
            );

            repositery.saveAll(
                List.of(john,jane,wick)
            );

        };
    }
    
}
