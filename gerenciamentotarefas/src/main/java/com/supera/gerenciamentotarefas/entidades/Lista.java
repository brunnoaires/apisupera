package com.supera.gerenciamentotarefas.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "lista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> itens = new ArrayList<>();

    // Método para adicionar um item à lista
    public void adicionarItem(Item item) {
        item.setLista(this);
        this.itens.add(item);
    }
}


