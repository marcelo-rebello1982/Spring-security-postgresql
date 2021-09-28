package com.heroku.demo.config;

import com.heroku.demo.model.Student;
import com.heroku.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;


@Service
public class DBService {


    @Autowired
    private StudentRepository studentRepository;


    public void instantiateTestDatabase() throws ParseException {


        Student student = new Student(null, "Student Name", "last name", "email@email", "password", null);
        studentRepository.save(student);
    }
}
