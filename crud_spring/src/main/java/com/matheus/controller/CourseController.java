package com.matheus.controller;

import com.matheus.dto.CourseDTO;
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
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO create(@RequestBody @Valid @NotNull CourseDTO course ){ //requestBody indica que estou trazendo parte de um curso
        return courseService.create(course);
    }
    // -------- -------- //

    // -------- READ -------- //
    @GetMapping // R(read)
    public @ResponseBody List<CourseDTO> list () {
        return courseService.list();
    }

    @GetMapping("/{id}") // R(read by id)
    public CourseDTO findById(@PathVariable @NotNull @Positive Long id) { // @PathVariable indica que vem uma variavel no caminho da API
        return courseService.findById(id);
    }
    // -------- -------- //


    // -------- UPDATE -------- //
    @PutMapping("/{id}") // U(update)
    public CourseDTO update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid @NotNull CourseDTO course) {
        return courseService.update(id, course);
    }
    // -------- -------- //

    // -------- DELETE -------- //
    @DeleteMapping("/{id}") // D(delete)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        courseService.delete(id);
    }
    // -------- -------- //

}
