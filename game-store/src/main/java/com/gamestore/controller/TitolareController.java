package com.gamestore.controller;



import com.gamestore.dto.TitolareDTO;

import com.gamestore.service.TitolareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/titolari")
public class TitolareController {

    @Autowired
    private TitolareService titolareService;

    @PostMapping
    public TitolareDTO save(@RequestBody TitolareDTO titolareDTO) {
        return titolareService.save(titolareDTO);
    }

    @GetMapping
    public List<TitolareDTO> findAll() {
        return titolareService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TitolareDTO> findById(@PathVariable Long id) {
        return titolareService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        titolareService.deleteById(id);
    }

    @PutMapping("/{id}")
    public TitolareDTO update(@RequestBody TitolareDTO titolareDTO, @PathVariable int id) {
        titolareDTO.setIdTitolare(id);
        return titolareService.update(titolareDTO);
    }
}
