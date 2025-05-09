package com.EduTech.EduTech.controller;

import com.EduTech.EduTech.model.Usuario;
import com.EduTech.EduTech.service.UsuarioService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PostMapping
    public Usuario agregarUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping("{rut}")
    public Usuario buscarUsuario(@PathVariable int rut){
        return usuarioService.getUsuarioRut(rut);
    }

    @GetMapping("{correo}")
    public Usuario buscarUsuario(@PathVariable String correo){
        return usuarioService.getUsuarioCorreo(correo);
    }

    @PutMapping("{rut}")
    public Usuario actualizarUsuario(@PathVariable int rut, @RequestBody Usuario usuario) {
        return usuarioService.upadteUsuario(usuario);
    }

    @DeleteMapping("{rut}")
    public String eliminarUsuario(@PathVariable int rut) {
        return usuarioService.deleteUsuario(rut);
    }

}
