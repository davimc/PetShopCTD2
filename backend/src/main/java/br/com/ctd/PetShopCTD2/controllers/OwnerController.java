package br.com.ctd.PetShopCTD2.controllers;

import br.com.ctd.PetShopCTD2.dtos.owner.OwnerDTO;
import br.com.ctd.PetShopCTD2.dtos.owner.OwnerNewDTO;
import br.com.ctd.PetShopCTD2.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService service;

    @GetMapping
    public ResponseEntity<Page<OwnerDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findDto(id));
    }

    @PostMapping
    public ResponseEntity<OwnerDTO> insert(@RequestBody OwnerNewDTO newDto) {
        OwnerDTO dto = service.insert(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
