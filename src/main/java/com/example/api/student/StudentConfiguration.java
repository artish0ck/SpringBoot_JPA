package com.example.api.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            studentRepository.saveAll(List.of(
                    new Student("Alex", "alex@gmail.com", LocalDate.of(2010, Month.FEBRUARY, 15)),
                    new Student("Bobby", "bob@gmail.com", LocalDate.of(2001, Month.MARCH, 31))
            ));
        };
    }
}
