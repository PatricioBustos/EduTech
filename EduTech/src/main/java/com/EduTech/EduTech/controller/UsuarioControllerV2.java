package com.EduTech.EduTech.controller;

import com.EduTech.EduTech.assemblers.UsuarioModelAssembler;
import com.EduTech.EduTech.model.Usuario;
import com.EduTech.EduTech.service.UsuarioService;
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
@RequestMapping("/api/v2/Usuarios")
public class UsuarioControllerV2 {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioModelAssembler assembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Usuario>> getAllUsuarios() {
        List<EntityModel<Usuario>> usuario = usuarioService.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(usuario,
                linkTo(methodOn(UsuarioControllerV2.class).getAllUsuarios()).withSelfRel());
    }

    @GetMapping(value = "/rut/{rut}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Usuario> getUsuarioByRut(@PathVariable String rut) {
        Usuario usuario = usuarioService.getUsuarioRut(rut);
        return assembler.toModel(usuario);
    }

    @GetMapping(value = "/correo/{correo}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Usuario> getUsuarioByCorreo(@PathVariable String correo) {
        Usuario usuario = usuarioService.getUsuarioCorreo(correo);
        return assembler.toModel(usuario);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Usuario>> createUsuario(@RequestBody Usuario usuario) {
        Usuario newUsuario = usuarioService.saveUsuario(usuario);
        return ResponseEntity
                .created(linkTo(methodOn(UsuarioControllerV2.class).getUsuarioByRut(newUsuario.getRut())).toUri())
                .body(assembler.toModel(newUsuario));
    }

    @PutMapping(value = "/rut/{rut}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Usuario>> updateUsuario(@PathVariable String rut, @RequestBody Usuario usuario) {
        usuario.setRut(rut);
        Usuario updatedUsuario = usuarioService.updateUsuario(usuario);
        return ResponseEntity
                .ok(assembler.toModel(updatedUsuario));
    }

    @DeleteMapping(value = "/rut/{rut}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> deleteUsuario(@PathVariable String rut) {
        usuarioService.deleteUsuario(rut);
        return ResponseEntity.noContent().build();
    }
}
