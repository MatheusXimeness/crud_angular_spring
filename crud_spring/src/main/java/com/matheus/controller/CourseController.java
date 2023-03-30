package com.matheus.controller;

import com.matheus.model.Course;
import com.matheus.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping // C(create)
    public ResponseEntity<Course> create(@RequestBody Course course ){ //requestBody faz com que os atributos se encaixem
        //System.out.println(hero.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseRepository.save(course )); //esse retorno mostra para o desenvolvedor o status da requisição
    }

}
