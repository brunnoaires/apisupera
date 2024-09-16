package com.supera.gerenciamentotarefas.DTO;

import com.supera.gerenciamentotarefas.Enum.Prioridade;
import lombok.Data;

@Data
public class ItemDTO {

    private String nome;
    private Prioridade prioridade; // Ou int, dependendo da sua implementação
    private Long listaId;
}