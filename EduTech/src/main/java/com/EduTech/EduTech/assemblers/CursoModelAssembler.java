package com.EduTech.EduTech.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.EduTech.EduTech.controller.CursoControllerV2;
import com.EduTech.EduTech.model.Curso;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class CursoModelAssembler implements RepresentationModelAssembler<Curso, EntityModel<Curso>> {
    @Override
    public EntityModel<Curso> toModel(Curso curso) {
        return EntityModel.of(curso,
                linkTo(methodOn(CursoControllerV2.class).getCursoByCodigo(curso.getIdCurso())).withSelfRel(),
                linkTo(methodOn(CursoControllerV2.class).getAllCursos()).withRel("cursos"));
    }
}