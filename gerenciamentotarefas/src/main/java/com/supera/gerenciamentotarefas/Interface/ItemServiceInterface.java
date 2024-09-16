package com.supera.gerenciamentotarefas.Interface;

import com.supera.gerenciamentotarefas.DTO.ItemDTO;
import com.supera.gerenciamentotarefas.entidades.Item;

import java.util.List;

public interface ItemServiceInterface {
        Item criarItem(Long listaId, ItemDTO itemDTO);
        List<Item> buscarTodosItens();
        Item buscarItemPorId(Long id);
        Item atualizarItem(Long id, ItemDTO itemDTO);
        void deletarItem(Long id);
    }
