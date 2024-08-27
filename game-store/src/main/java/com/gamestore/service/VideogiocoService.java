package com.gamestore.service;

import com.gamestore.dto.VideogiocoDTO;
import com.gamestore.model.Videogioco;
import com.gamestore.repository.VideogiocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideogiocoService {

    @Autowired
    private VideogiocoRepository videogiocoRepository;

    public VideogiocoDTO save(VideogiocoDTO videogiocoDTO) {
        Videogioco videogioco = new Videogioco();
        videogioco.setTitolo(videogiocoDTO.getTitolo());
        videogioco.setPrezzo(videogiocoDTO.getPrezzo());
        videogioco = videogiocoRepository.save(videogioco);
        videogiocoDTO.setIdVideogioco(videogioco.getIdVideogioco());
        return videogiocoDTO;
    }

    public List<VideogiocoDTO> findAll() {
        return videogiocoRepository.findAll().stream()
                .map(videogioco -> new VideogiocoDTO())
                .collect(Collectors.toList());
    }

    public Optional<VideogiocoDTO> findById(Long id) {
        return videogiocoRepository.findById(id)
                .map(videogioco -> new VideogiocoDTO());
    }

    public void deleteById(Long id) {
        videogiocoRepository.deleteById(id);
    }

    public VideogiocoDTO update(VideogiocoDTO videogiocoDTO) {
        if (videogiocoRepository.existsById((long) videogiocoDTO.getIdVideogioco())) {
            Videogioco videogioco = new Videogioco();
            videogioco.setIdVideogioco(videogiocoDTO.getIdVideogioco());
            videogioco.setTitolo(videogiocoDTO.getTitolo());
            videogioco.setPrezzo(videogiocoDTO.getPrezzo());
            videogioco = videogiocoRepository.save(videogioco);
            return videogiocoDTO;
        } else {
            throw new RuntimeException("Videogioco not found");
        }
    }
}