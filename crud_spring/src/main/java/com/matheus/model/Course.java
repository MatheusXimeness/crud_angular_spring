package com.matheus.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity // nesse caso utilizando entity é criada uma tabela com o nome dessa classe no BD
//@Table(name = "cursos") - isso é p/ caso ja tenha um bd legado e vc deseja ref sua table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String category;
}
