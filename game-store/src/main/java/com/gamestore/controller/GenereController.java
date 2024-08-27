
package com.gamestore.controller;
import com.gamestore.dto.GenereDTO;




import com.gamestore.service.GenereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/generi")
public class GenereController {

    @Autowired
    private GenereService genereService;

    @PostMapping
    public GenereDTO save(@RequestBody GenereDTO genereDTO) {
        return genereService.save(genereDTO);
    }

    @GetMapping
    public List<GenereDTO> findAll() {
        return genereService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<GenereDTO> findById(@PathVariable Long id) {
        return genereService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        genereService.deleteById(id);
    }

    @PutMapping("/{id}")
    public GenereDTO update(@RequestBody GenereDTO genereDTO, @PathVariable int id) {
        genereDTO.setIdGenere(id);
        return genereService.update(genereDTO);
    }
}