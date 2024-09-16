package com.supera.gerenciamentotarefas.Service;

import com.supera.gerenciamentotarefas.DTO.ItemDTO;
import com.supera.gerenciamentotarefas.Enum.Prioridade;
import com.supera.gerenciamentotarefas.Interface.ItemServiceInterface;
import com.supera.gerenciamentotarefas.entidades.Item;
import com.supera.gerenciamentotarefas.entidades.Lista;
import com.supera.gerenciamentotarefas.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.supera.gerenciamentotarefas.repository.ItemRepository;
import com.supera.gerenciamentotarefas.repository.ListaRepository;

import java.util.List;

@Service
public class ItemService implements ItemServiceInterface {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ListaRepository listaRepository;

    @Override
    public Item criarItem(Long listaId, ItemDTO itemDTO) {
        // Busca a lista pelo ID
        Lista lista = listaRepository.findById(listaId)
                .orElseThrow(() -> new ResourceNotFoundException("Lista não encontrada com id: " + listaId));

        Item novoItem = new Item();
        novoItem.setNome("Novo Item");
        novoItem.setPrioridade(Prioridade.ALTA); // Define a prioridade como ALTA
        novoItem.setLista(lista);

        lista.getItens().add(novoItem);
        listaRepository.save(lista);
        return novoItem;
    }

    @Override
    public List<Item> buscarTodosItens() {
        return itemRepository.findAll();
    }

    @Override
    public Item buscarItemPorId(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item não encontrado com id: " + id));
    }

    @Override
    public Item atualizarItem(Long id, ItemDTO itemDTO) {
        Item itemExistente = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item não encontrado com id: " + id));

        itemExistente.setNome(itemDTO.getNome());

        return itemRepository.save(itemExistente);
    }

    @Override
    public void deletarItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item não encontrado com id: " + id));

        itemRepository.delete(item);
    }

    public Item salvar(Item item) {
        return itemRepository.save(item);
    }

}


