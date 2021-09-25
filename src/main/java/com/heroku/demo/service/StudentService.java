package com.heroku.demo.service;


import com.heroku.demo.model.Student;
import com.heroku.demo.repository.StudentRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements UserDetailsService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findByEmail(email));

        if (studentOptional.isPresent()) {
            return studentOptional.get();
        }
        throw new UsernameNotFoundException("Dados inválidos");
    }

}