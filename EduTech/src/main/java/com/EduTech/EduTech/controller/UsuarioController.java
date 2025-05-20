package com.EduTech.EduTech.controller;

import com.EduTech.EduTech.model.Usuario;
import com.EduTech.EduTech.service.UsuarioService;
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

    @GetMapping("/rut/{rut}")
    public Usuario buscarUsuarioPorRut(@PathVariable String rut){
        return usuarioService.getUsuarioRut(rut);
    }

    @GetMapping("/correo/{correo}")
    public Usuario buscarUsuarioPorCorreo(@PathVariable String correo){
        return usuarioService.getUsuarioCorreo(correo);
    }

    @PutMapping("/rut/{rut}")
    public Usuario actualizarUsuario(@PathVariable String rut, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuario);

    }

    @DeleteMapping("/rut/{rut}")
    public String eliminarUsuario(@PathVariable String rut) {
        return usuarioService.deleteUsuario(rut);
    }

}
