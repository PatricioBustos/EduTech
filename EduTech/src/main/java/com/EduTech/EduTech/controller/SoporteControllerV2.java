package com.EduTech.EduTech.controller;

import com.EduTech.EduTech.assemblers.SoporteModelAssembler;
import com.EduTech.EduTech.model.Soporte;
import com.EduTech.EduTech.model.Usuario;
import com.EduTech.EduTech.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/Soportes")
public class SoporteControllerV2 {
    @Autowired
    private SoporteService soporteService;

    @Autowired
    private SoporteModelAssembler assembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Soporte>> getAllSoportes() {
        List<EntityModel<Soporte>> soporte = soporteService.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(soporte,
                linkTo(methodOn(SoporteControllerV2.class).getAllSoportes()).withSelfRel());
    }

    @GetMapping(value = "/idTicket}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Soporte> getSoporteByIdTicket(@PathVariable int idTicket) {
        Soporte soporte = soporteService.findById(idTicket);
        return assembler.toModel(soporte);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Soporte>> createSoporte(@RequestBody Soporte soporte) {
        Soporte newSoporte = soporteService.saveSoporte(soporte);
        return ResponseEntity
                .created(linkTo(methodOn(SoporteControllerV2.class).getSoporteByIdTicket(newSoporte.getIdTicket())).toUri())
                .body(assembler.toModel(newSoporte));
    }

    @PutMapping(value = "/idTicket}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Soporte>> updateSoporte(@PathVariable int idTicket, @RequestBody Soporte soporte) {
        soporte.setIdTicket(idTicket);
        Soporte updatedSoporte = soporteService.updateTicket(soporte);
        return ResponseEntity
                .ok(assembler.toModel(updatedSoporte));
    }

    @DeleteMapping(value = "/idTicket}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> deleteSoporte(@PathVariable int idTicket) {
        soporteService.deleteTicket(idTicket);
        return ResponseEntity.noContent().build();
    }
}
