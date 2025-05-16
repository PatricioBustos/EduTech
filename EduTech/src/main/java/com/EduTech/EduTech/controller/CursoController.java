package com.EduTech.EduTech.controller;

import com.EduTech.EduTech.model.Curso;
import com.EduTech.EduTech.service.CursoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clases")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listarCursos(){
        return cursoService.getCurso();
    }

    @PostMapping
    public Curso agregarCurso(@RequestBody Curso curso){
        return cursoService.saveCurso(curso);
    }

    @GetMapping("{idCurso}")
    public Curso buscarCurso(@PathVariable int idCurso){
        return cursoService.getCurso(idCurso);
    }

    @GetMapping("{correo}")
    public Curso buscarUsuario(@PathVariable String correo){
        return cursoService.getUsuarioCorreo(correo);
    }

    @PutMapping("{rut}")
    public Curso actualizarUsuario(@PathVariable int rut, @RequestBody Curso usuario) {
        return cursoService.upadteUsuario(usuario);
    }

    @DeleteMapping("{rut}")
    public String eliminarUsuario(@PathVariable int rut) {
        return cursoService.deleteUsuario(rut);
    }

}
