package com.example.api.student;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
public class Student {
    @Id
    @SequenceGenerator(name="student_sequence",
            sequenceName = "student_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")
    private Long id;
    private String name;
    private LocalDate dob;
    @Column(unique = true)
    private String email;



    public Student() {
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
