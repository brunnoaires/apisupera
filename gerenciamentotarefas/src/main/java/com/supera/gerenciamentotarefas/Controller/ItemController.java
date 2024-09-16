package com.supera.gerenciamentotarefas.Controller;

import com.supera.gerenciamentotarefas.DTO.ItemDTO;
import com.supera.gerenciamentotarefas.Service.ItemService;
import com.supera.gerenciamentotarefas.Service.ListaService;
import com.supera.gerenciamentotarefas.entidades.Item;
import com.supera.gerenciamentotarefas.entidades.Lista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    ListaService listaService;
    ItemService itemService;

    @PostMapping("/itens")
    public ResponseEntity<Item> criarItem(@RequestBody ItemDTO itemDTO) {
        Item novoItem = new Item();
        novoItem.setNome(itemDTO.getNome());
        novoItem.setPrioridade(itemDTO.getPrioridade());

        // Associa o item à lista


        Lista lista = listaService.buscarPorId(itemDTO.getListaId());
        novoItem.setLista(lista);



        itemService.salvar(novoItem);

        return ResponseEntity.ok(novoItem);
    }
}

