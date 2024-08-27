package com.gamestore.controller;

import com.gamestore.dto.DipendenteDTO; // Assicurati di avere un DTO per Dipendente
import com.gamestore.service.DipendenteService; // Assicurati di avere un servizio per Dipendente
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //è un'annotazione in Java utilizzata all'interno del framework Spring, particolarmente in Spring Boot, per indicare che una classe è un controller web che gestisce richieste HTTP -->
@RequestMapping("/dipendenti")  //  è un'annotazione in Spring utilizzata per mappare richieste HTTP a metodi specifici in un controller
public class DipendenteController {

    @Autowired //  è un'annotazione in Spring utilizzata per iniettare automaticamente le dipendenze in una classe.
    private DipendenteService dipendenteService; // Servizio per gestire le operazioni sui dipendenti

    @PostMapping // è un'annotazione in Spring utilizzata per mappare una richiesta HTTP POST a un metodo specifico all'interno di un controller. 
    public DipendenteDTO save(@RequestBody DipendenteDTO dipendenteDTO) {
        return dipendenteService.save(dipendenteDTO); // Salva un nuovo dipendente
    }

    @GetMapping
    public List<DipendenteDTO> findAll() {
        return dipendenteService.findAll(); // Trova e restituisce tutti i dipendenti
    }

    @GetMapping("/{id}")
    public Optional<DipendenteDTO> findById(@PathVariable Long id) {
        return dipendenteService.findById(id); // Trova e restituisce un dipendente per ID
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        dipendenteService.deleteById(id); // Elimina un dipendente per ID
    }

    @PutMapping("/{id}")
    public DipendenteDTO update(@RequestBody DipendenteDTO dipendenteDTO, @PathVariable int id) {
        dipendenteDTO.setIdDipendente(id); // Imposta l'ID del dipendente
        return dipendenteService.update(dipendenteDTO); // Aggiorna un dipendente esistente
    }
}
 //path variable nel mapping quando si riceve una richiesta essa sara catturata  come il valore dato dopo il path ad es 1 sara segnato come id