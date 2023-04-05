package com.matheus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Entity // nesse caso utilizando entity é criada uma tabela com o nome dessa classe no BD
//@Table(name = "cursos") - isso é p/ caso ja tenha um bd legado e vc deseja ref sua table
@SQLDelete(sql = "UPDATE Course SET status = 'Inativo' WHERE id = ?") // toda vez que eu tentar remover um registro, oq vai acontecer na verdade é que ele será atualizado
@Where(clause = "status = 'Ativo'") // toda vez que eu fizer um select na base de dados o Hibernate vai fazer esse append dentro do filtro
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Length( max = 10)
    @Pattern(regexp = "Back-end|Front-end")
    @Column(length = 10, nullable = false)
    private String category;

    @NotNull
    @Length( max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    private String status = "Ativo";
}
