package com.gamestore.repository;

import com.gamestore.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
}
  // qui diciamo che l interfaccia dipendenterepository estende jparepository in modo da poter utilizzare le operazioni crud

// forniscono un interfaccia per l accesso ai dati e l interazione con il databse sono responsabili delle operazioni crud