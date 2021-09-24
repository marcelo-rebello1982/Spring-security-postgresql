package com.heroku.demo;


import com.heroku.demo.model.Role;
import com.heroku.demo.model.Student;
import com.heroku.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InsertData implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final StudentRepository studentRepository;

    @Autowired
    public InsertData(PasswordEncoder passwordEncoder, StudentRepository studentRepository) {
        this.passwordEncoder = passwordEncoder;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Creating Role
        Role roles = new Role();
        roles.setRole("STUDENT");

        Student marcelo = new Student();
        marcelo.setFirstName("Marcelo");
        marcelo.setLastName("Martins");
        marcelo.setEmail("mp.rebello.martins@gmail.com");
        marcelo.setPassword(passwordEncoder.encode("123456"));
        marcelo.addRole(roles);
        studentRepository.save(marcelo);




    }
}