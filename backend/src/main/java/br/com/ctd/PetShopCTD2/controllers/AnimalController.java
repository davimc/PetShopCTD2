package br.com.ctd.PetShopCTD2.controllers;

import br.com.ctd.PetShopCTD2.dtos.animal.AnimalDTO;
import br.com.ctd.PetShopCTD2.dtos.animal.AnimalNewDTO;
import br.com.ctd.PetShopCTD2.dtos.animal.AnimalUpdateDTO;
import br.com.ctd.PetShopCTD2.services.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping
    public ResponseEntity<Page<AnimalDTO>> findAll(@PageableDefault(sort = "name") Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findDto(id));
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> create(@RequestBody @Valid AnimalNewDTO newDto) {
        AnimalDTO dto = service.insert(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalDTO> update(@RequestBody @Valid AnimalUpdateDTO dto, @PathVariable Long id) {
        return ResponseEntity.accepted().body(service.update(id, dto));
    }
}
