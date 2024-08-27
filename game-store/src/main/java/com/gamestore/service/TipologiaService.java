package com.gamestore.service;

import com.gamestore.dto.TipologiaDTO;
import com.gamestore.model.Tipologia;
import com.gamestore.repository.TipologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipologiaService {

    @Autowired
    private TipologiaRepository tipologiaRepository;

    public TipologiaDTO save(TipologiaDTO tipologiaDTO) {
        Tipologia tipologia = new Tipologia();
        tipologia.setNome(tipologiaDTO.getNome());
        tipologia = tipologiaRepository.save(tipologia);
        tipologiaDTO.setIdTipologia(tipologia.getIdTipologia());
        return tipologiaDTO;
    }

    public List<TipologiaDTO> findAll() {
        return tipologiaRepository.findAll().stream()
                .map(tipologia -> new TipologiaDTO())
                .collect(Collectors.toList());
    }

    public Optional<TipologiaDTO> findById(Long id) {
        return tipologiaRepository.findById(id)
                .map(tipologia -> new TipologiaDTO());
    }

    public void deleteById(Long id) {
        tipologiaRepository.deleteById(id);
    }

    public TipologiaDTO update(TipologiaDTO tipologiaDTO) {
        if (tipologiaRepository.existsById((long) tipologiaDTO.getIdTipologia())) {
            Tipologia tipologia = new Tipologia();
            tipologia.setIdTipologia(tipologiaDTO.getIdTipologia());
            tipologia.setNome(tipologiaDTO.getNome());
            tipologia = tipologiaRepository.save(tipologia);
            return tipologiaDTO;
        } else {
            throw new RuntimeException("Tipologia not found");
        }
    }
}
