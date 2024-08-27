package com.gamestore.service;

import com.gamestore.dto.TitolareDTO;
import com.gamestore.model.Titolare;
import com.gamestore.repository.TitolareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TitolareService {

    @Autowired
    private TitolareRepository titolareRepository;

    public TitolareDTO save(TitolareDTO titolareDTO) {
        Titolare titolare = new Titolare();
        titolare.setNome(titolareDTO.getNome());
        titolare.setCognome(titolareDTO.getCognome());
        titolare = titolareRepository.save(titolare);
        titolareDTO.setIdTitolare(titolare.getIdTitolare());
        return titolareDTO;
    }

    public List<TitolareDTO> findAll() {
        return titolareRepository.findAll().stream()
                .map(titolare -> new TitolareDTO())
                .collect(Collectors.toList());
    }

    public Optional<TitolareDTO> findById(Long id) {
        return titolareRepository.findById(id)
                .map(titolare -> new TitolareDTO());
    }

    public void deleteById(Long id) {
        titolareRepository.deleteById(id);
    }

    public TitolareDTO update(TitolareDTO titolareDTO) {
        if (titolareRepository.existsById((long) titolareDTO.getIdTitolare())) {
            Titolare titolare = new Titolare();
            titolare.setIdTitolare(titolareDTO.getIdTitolare());
            titolare.setNome(titolareDTO.getNome());
            titolare.setCognome(titolareDTO.getCognome());
            titolare = titolareRepository.save(titolare);
            return titolareDTO;
        } else {
            throw new RuntimeException("Titolare not found");
        }
    }
}