package com.project.todolist_back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Column(nullable = false)
    private String nome;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = true)
    private boolean realizado;

    @Column(nullable = true)
    private int prioridade;
}
