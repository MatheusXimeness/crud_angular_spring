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

    @GetMapping // R(read)
    public List<Course> list () {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}") // R(read by id)
    public ResponseEntity<Course> findById(@PathVariable Long id) { // @PathVariable indica que vem uma variavel no caminho da API
        return courseRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping // C(create)
    public ResponseEntity<Course> create(@RequestBody Course course ){ //requestBody indica que estou trazendo parte de um curso
        //System.out.println(hero.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseRepository.save(course )); //esse retorno mostra para o desenvolvedor o status da requisição
    }

    @PutMapping("/{id}") // U(update)
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course) {
        return courseRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(course.getName());
                    recordFound.setCategory(course.getCategory());
                    Course updated = courseRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
