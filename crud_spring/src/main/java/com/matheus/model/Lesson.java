package com.matheus.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 11, nullable = false)
    private String youtubeUrl;

    @ManyToOne(fetch = FetchType.LAZY, // somenente quando for acionado o getCourse é que esse mapeamento sera chamado
               optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Course course;
}
