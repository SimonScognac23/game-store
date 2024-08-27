package com.gamestore.repository;

import com.gamestore.model.Tipologia;
import com.gamestore.model.Videogioco;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideogiocoRepository extends JpaRepository<Videogioco, Long> {
	
	}