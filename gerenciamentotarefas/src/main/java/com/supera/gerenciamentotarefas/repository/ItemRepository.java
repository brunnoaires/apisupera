package com.supera.gerenciamentotarefas.repository;

import com.supera.gerenciamentotarefas.entidades.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {}

