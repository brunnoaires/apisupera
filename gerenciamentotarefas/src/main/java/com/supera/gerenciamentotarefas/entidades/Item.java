package com.supera.gerenciamentotarefas.entidades;

import com.supera.gerenciamentotarefas.Enum.Prioridade;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "lista_id", nullable = false)
    private Lista lista;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
}