package com.EduTech.EduTech.assemblers;

import com.EduTech.EduTech.controller.SoporteControllerV2;
import com.EduTech.EduTech.model.Soporte;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SoporteModelAssembler implements RepresentationModelAssembler<Soporte, EntityModel<Soporte>> {
    @Override
    public EntityModel<Soporte> toModel(Soporte soporte) {
        return EntityModel.of(soporte,
                linkTo(methodOn(SoporteControllerV2.class).getSoporteByIdTicket(soporte.getIdTicket())).withSelfRel(),
                linkTo(methodOn(SoporteControllerV2.class).getAllSoportes()).withRel("soporte"));
    }
}
