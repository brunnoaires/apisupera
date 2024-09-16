package com.supera.gerenciamentotarefas.repository;

import com.supera.gerenciamentotarefas.entidades.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaRepository extends JpaRepository<Lista, Long> {
}
