package com.EduTech.EduTech.controller;

import com.EduTech.EduTech.model.Curso;
import com.EduTech.EduTech.model.Usuario;
import com.EduTech.EduTech.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con los Usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Obtener todos los Usuarios", description = "Obtiene una lista de todas los Usuarios")
    public List<Usuario> listarUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PostMapping
    @Operation(summary = "Agregar Usuarios", description = "Agrega un Usuario")
    public Usuario agregarUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping("/rut/{rut}")
    @Operation(summary = "Buscar Usuarios por RUT", description = "Busca un Usuario por su RUT")
    public Usuario buscarUsuarioPorRut(@PathVariable String rut){
        return usuarioService.getUsuarioRut(rut);
    }

    @GetMapping("/correo/{correo}")
    @Operation(summary = "Buscar Usuario por Correo", description = "Busca un Usuario solo por su Correo")
    public Usuario buscarUsuarioPorCorreo(@PathVariable String correo){
        return usuarioService.getUsuarioCorreo(correo);
    }

    @PutMapping("/rut/{rut}")
    @Operation(summary = "Actualizar Usuarios", description = "Actualiza un Usuario existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente!!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Curso.class))),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado :c")
    })
    public Usuario actualizarUsuario(@PathVariable String rut, @RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuario);

    }

    @DeleteMapping("/rut/{rut}")
    @Operation(summary = "Eliminar Usuarios", description = "Elimina un Usuario por su RUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario Eliminado exitosamente!!"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado :c")
    })
    public String eliminarUsuario(@PathVariable String rut) {
        return usuarioService.deleteUsuario(rut);
    }

}
