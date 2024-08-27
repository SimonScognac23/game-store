package com.gamestore.controller;

import com.gamestore.dto.TipologiaDTO;

import com.gamestore.service.TipologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipologie")
public class TipologiaController {

    @Autowired
    private TipologiaService tipologiaService;

    @PostMapping
    public TipologiaDTO save(@RequestBody TipologiaDTO tipologiaDTO) {
        return tipologiaService.save(tipologiaDTO);
    }

    @GetMapping
    public List<TipologiaDTO> findAll() {
        return tipologiaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TipologiaDTO> findById(@PathVariable Long id) {
        return tipologiaService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        tipologiaService.deleteById(id);
    }

    @PutMapping("/{id}")
    public TipologiaDTO update(@RequestBody TipologiaDTO tipologiaDTO, @PathVariable int id) {
        tipologiaDTO.setIdTipologia(id);
        return tipologiaService.update(tipologiaDTO);
    }
}
