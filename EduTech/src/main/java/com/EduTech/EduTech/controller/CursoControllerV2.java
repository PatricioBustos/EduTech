package com.EduTech.EduTech.controller;

import com.EduTech.EduTech.assemblers.CursoModelAssembler;
import com.EduTech.EduTech.model.Curso;
import com.EduTech.EduTech.service.CursoService;
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
@RequestMapping("/api/v2/cursos")
public class CursoControllerV2 {
    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoModelAssembler assembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Curso>> getAllCursos() {
        List<EntityModel<Curso>> curso = cursoService.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(curso,
                linkTo(methodOn(CursoControllerV2.class).getAllCursos()).withSelfRel());
    }

    @GetMapping(value = "/idCurso/{idCurso}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Curso> getCursoByCodigo(@PathVariable int idCurso) {
        Curso curso = cursoService.findById(idCurso);
        return assembler.toModel(curso);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Curso>> createCurso(@RequestBody Curso curso) {
        Curso newCurso = cursoService.saveCurso(curso);
        return ResponseEntity
                .created(linkTo(methodOn(CursoControllerV2.class).getCursoByCodigo(newCurso.getIdCurso())).toUri())
                .body(assembler.toModel(newCurso));
    }

    @PutMapping(value = "/idCurso/{idCurso}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Curso>> updateCurso(@PathVariable int idCurso, @RequestBody Curso curso) {
        curso.setIdCurso(idCurso);
        Curso updatedCurso = cursoService.saveCurso(curso);
        return ResponseEntity
                .ok(assembler.toModel(updatedCurso));
    }

    @DeleteMapping(value = "/idCurso/{idCurso}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> deleteCurso(@PathVariable int idCurso) {
        cursoService.deleteCurso(idCurso);
        return ResponseEntity.noContent().build();
    }
}
