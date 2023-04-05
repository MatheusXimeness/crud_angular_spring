package com.matheus.controller;

import com.matheus.model.Course;
import com.matheus.repository.CourseRepository;
import com.matheus.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/courses")
//@AllArgsConstructor // lombok cria o construtor automaticamente
public class CourseController {

    private final CourseService courseService; // final diz que n podemos alterar o val dessa inst durante o life cycle

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // -------- CREATE -------- //
    @PostMapping // C(create)
    public ResponseEntity<Course> create(@RequestBody @Valid Course course ){ //requestBody indica que estou trazendo parte de um curso
        //System.out.println(hero.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.create(course )); //esse retorno mostra para o desenvolvedor o status da requisição
    }
    // -------- -------- //

    // -------- READ -------- //
    @GetMapping // R(read)
    public @ResponseBody List<Course> list () {
        return courseService.list();
    }

    @GetMapping("/{id}") // R(read by id)
    public ResponseEntity<Course> findById(@PathVariable @NotNull @Positive Long id) { // @PathVariable indica que vem uma variavel no caminho da API
        return courseService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    // -------- -------- //


    // -------- UPDATE -------- //
    @PutMapping("/{id}") // U(update)
    public ResponseEntity<Course> update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Course course) {
        return courseService.update(id, course)
                .map(recordFound -> ResponseEntity.ok().body(recordFound) )
                .orElse(ResponseEntity.notFound().build());
    }
    // -------- -------- //

    // -------- DELETE -------- //
    @DeleteMapping("/{id}") // D(delete)
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id) {
        if( courseService.delete(id) ) {
            return ResponseEntity.noContent().<Void>build();
        }
        return ResponseEntity.notFound().build();
    }
    // -------- -------- //

}
