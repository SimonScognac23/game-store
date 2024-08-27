package com.gamestore.controller;


import com.gamestore.dto.VideogiocoDTO;
import com.gamestore.service.VideogiocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videogiochi")
public class VideogiocoController {

    @Autowired
    private VideogiocoService videogiocoService;

    @PostMapping
    public VideogiocoDTO save(@RequestBody VideogiocoDTO videogiocoDTO) {
        return videogiocoService.save(videogiocoDTO);
    }

    @GetMapping
    public List<VideogiocoDTO> findAll() {
        return videogiocoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<VideogiocoDTO> findById(@PathVariable Long id) {
        return videogiocoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        videogiocoService.deleteById(id);
    }

    @PutMapping("/{id}")
    public VideogiocoDTO update(@RequestBody VideogiocoDTO videogiocoDTO, @PathVariable int id) {
        videogiocoDTO.setIdVideogioco(id);
        return videogiocoService.update(videogiocoDTO);
    }
}

