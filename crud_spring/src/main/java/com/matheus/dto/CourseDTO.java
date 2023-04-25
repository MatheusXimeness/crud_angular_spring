package com.matheus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

// record é uma classe imutavel do java pois a partir do momento que vc instancia o construtor, esses serão os dados.
public record CourseDTO(
        @JsonProperty("_id") Long id,
        @NotNull @NotBlank @Length(min = 5, max = 100) String nome,
        @NotNull @Length( max = 10) @Pattern(regexp = "Back-end|Front-end") String category) {


}
