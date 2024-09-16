package com.supera.gerenciamentotarefas.Service;

import com.supera.gerenciamentotarefas.DTO.ItemDTO;
import com.supera.gerenciamentotarefas.DTO.ListaComItensDTO;
import com.supera.gerenciamentotarefas.entidades.Item;
import com.supera.gerenciamentotarefas.entidades.Lista;
import com.supera.gerenciamentotarefas.exceptions.ResourceNotFoundException;
import com.supera.gerenciamentotarefas.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.supera.gerenciamentotarefas.repository.ListaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Lista criarListaComItens(ListaComItensDTO dto) {
        // Cria a nova lista
        Lista lista = new Lista();
        lista.setNome(dto.getNome());

        // Cria e associa os itens à lista
        for (ItemDTO itemDTO : dto.getItens()) {
            Item item = new Item();
            item.setNome(itemDTO.getNome());
            item.setLista(lista); // Associa o item à lista
            lista.getItens().add(item);
        }

        // Salva a lista e os itens
        Lista novaLista = listaRepository.save(lista);
        itemRepository.saveAll(lista.getItens());

        return novaLista;


    }

    public Lista criarLista(Lista lista) {
        // Lógica para salvar a lista no banco
        return listaRepository.save(lista);
    }

    public Lista buscarPorId(Long id) {
        return listaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lista não encontrada"));
    }
}

