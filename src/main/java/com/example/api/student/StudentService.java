package com.example.api.student;

import com.example.api.response.RestApiException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> list() {
        return studentRepository.findAll();
    }

    public void add(Student student) {
        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {
            throw new RestApiException("Email is already used");
        }
        studentRepository.save(student);
    }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void update(Student student) {
        Optional<Student> row = studentRepository.findById(student.getId());
        if (row.isPresent()) {
            Student studentToUpdate = row.get();
            if (!student.getName().isEmpty()){
                studentToUpdate.setName(student.getName());
            }
            if (student.getDob() != null){
                studentToUpdate.setDob(student.getDob());
            }
            studentRepository.save(studentToUpdate);
        }

    }

}
