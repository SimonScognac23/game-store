package com.gamestore.service;

import com.gamestore.dto.DipendenteDTO;


import com.gamestore.model.Dipendente;
import com.gamestore.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Service // annotazione che serve per definire una classe che interagisce con il db
public class DipendenteService {
    @Autowired // annotazione di spring indica che iniettiamo il repository necessario per interagire con il databse
    private DipendenteRepository dipendenteRepository;
    
    // CREATE

    public DipendenteDTO save(DipendenteDTO dipendenteDTO) {  // il client fornisce un oggettodto
        Dipendente dipendente = new Dipendente();   // creazione di una nuova entita dipendente        
        dipendente.setIdDipendente(dipendenteDTO.getIdDipendente()); 
        dipendente.setNome(dipendenteDTO.getNome()); // chiama il metodo getnome sull oggetto dip.dto x ottenere il nome che è stato inviato dal client dopo imposta il nome ottenuto sull entita dipendente con set
        dipendente.setCognome(dipendenteDTO.getCognome());
        dipendente = dipendenteRepository.save(dipendente);  // salvare l entita nel database
       
        dipendenteDTO.setIdDipendente(dipendente.getIdDipendente()); // aggiorna l id del DTO con l ID generato
        return dipendenteDTO;  // resituzione del dto aggiornato
    }    
    
    // READ LETTURA DI TUTTI I RECORD

    public List<DipendenteDTO> findAll() {     // metodo findALL che ottiene una lista di tutti i record dipendente nel databse   tramite List 
        return dipendenteRepository.findAll().stream() // convertito in stream per operazioni tipo map
              .map(dipendente -> {   // permette di trasformare il dipendente a dipendentedto e lo aggiunge alla lista di collectorstolist
                   DipendenteDTO dto = new DipendenteDTO();
 dto.setIdDipendente(dipendente.getIdDipendente()); // get= metodo per chiamare getiddip. su oggetto dipendente che è un istanza della classe Dipendente e restituisce il valore dell ' ID del dipendente. dopodiche viene impostato il valore dell id del dipendente ottenuto tramite set nel DTO 
                  dto.setNome(dipendente.getNome());
                 dto.setCognome(dipendente.getCognome());
                  return dto;
               })
             
               .collect(Collectors.toList());   // raccoglie tutti i dati in una lista     
    }

    public Optional<DipendenteDTO> findById(Long id) {   // usare optional è buono per evitare il null pointerexception e per gestire situazioni in cui l entita non viene trovata
        return dipendenteRepository.findById(id)  // viene chiamato il metodo findby id del repository x cercare un dipendente con id specificato l id è dato dal client
                .map(dipendente -> {
                    DipendenteDTO dto = new DipendenteDTO(); // se trovato viene convertito il record in dto
                    dto.setIdDipendente(dipendente.getIdDipendente());
                    dto.setNome(dipendente.getNome());
                    dto.setCognome(dipendente.getCognome());
                    return dto; // restituzione del dto al client quindi il recordo con nome cognome e id
                });
        

    }
    public void deleteById(Long id) {
        dipendenteRepository.deleteById(id);
    }

    public DipendenteDTO update(DipendenteDTO dipendenteDTO) {
        if (dipendenteRepository.existsById((long) dipendenteDTO.getIdDipendente())) {  //Converte l'ID del dipendente da int  a long perché il metodo existsById richiede un Long.
            Dipendente dipendente = new Dipendente();
            dipendente.setIdDipendente(dipendenteDTO.getIdDipendente());//Imposta i campi idDipendente, nome e cognome del nuovo oggetto Dipendente con i valori presi dal DipendenteDTO.
            dipendente.setNome(dipendenteDTO.getNome());
            dipendente.setCognome(dipendenteDTO.getCognome());
            dipendente = dipendenteRepository.save(dipendente);// il metodo save restituisce l'oggetto Dipendente salvato, che viene riassegnato alla variabile dipendente.
           
            return dipendenteDTO;
        } else {
            throw new RuntimeException("Dipendente not found");
        }
    }
}