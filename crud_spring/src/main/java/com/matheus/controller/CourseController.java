package com.matheus.controller;

import com.matheus.model.Course;
import com.matheus.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor // lombok cria o construtor automaticamente
public class CourseController {

    private final CourseRepository courseRepository; // final diz que n podemos alterar o val dessa inst durante o life cycle

    @GetMapping
    public List<Course> list () {
        return courseRepository.findAll();
    }
}
