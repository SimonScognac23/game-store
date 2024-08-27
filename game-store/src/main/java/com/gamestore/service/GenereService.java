package com.gamestore.service;



import com.gamestore.dto.GenereDTO;
import com.gamestore.model.Genere;
import com.gamestore.repository.GenereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenereService {
    @Autowired
    private GenereRepository genereRepository;

    public GenereDTO save(GenereDTO genereDTO) {
        Genere genere = new Genere();
        genere.setIdGenere(genereDTO.getIdGenere());
        genere.setNome(genereDTO.getNome());
        genere = genereRepository.save(genere);
       
        genereDTO.setIdGenere(genere.getIdGenere());
        return genereDTO;
    }

    public List<GenereDTO> findAll() {
        return genereRepository.findAll().stream()
                .map(genere -> {
                    GenereDTO dto = new GenereDTO();
                    dto.setIdGenere(genere.getIdGenere());
                    dto.setNome(genere.getNome());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public Optional<GenereDTO> findById(Long id) {
        return genereRepository.findById(id)
                .map(genere -> {
                    GenereDTO dto = new GenereDTO();
                    dto.setIdGenere(genere.getIdGenere());
                    dto.setNome(genere.getNome());
                    return dto;
                });
    }

    public void deleteById(Long id) {
        genereRepository.deleteById(id);
    }

    public GenereDTO update(GenereDTO genereDTO) {
        if (genereRepository.existsById((long) genereDTO.getIdGenere())) {
            Genere genere = new Genere();
            genere.setIdGenere(genereDTO.getIdGenere());
            genere.setNome(genereDTO.getNome());
            genere = genereRepository.save(genere);
           
            return genereDTO;
        } else {
            throw new RuntimeException("Genere not found");
        }
    }
}