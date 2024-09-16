package com.supera.gerenciamentotarefas.DTO;

import lombok.Data;
import java.util.List;

@Data
public class ListaComItensDTO {

    private String nome;
    private List<ItemDTO> itens;
}