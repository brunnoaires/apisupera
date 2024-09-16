package com.supera.gerenciamentotarefas.Controller;


import com.supera.gerenciamentotarefas.DTO.ListaComItensDTO;
import com.supera.gerenciamentotarefas.Service.ListaService;
import com.supera.gerenciamentotarefas.entidades.Item;
import com.supera.gerenciamentotarefas.entidades.Lista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/listas")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @PostMapping
    public ResponseEntity<Lista> criarLista(@RequestBody Lista lista) {
        Lista novaLista = listaService.criarLista(lista);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaLista);
    }
}


