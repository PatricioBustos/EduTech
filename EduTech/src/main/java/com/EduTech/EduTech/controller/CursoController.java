package com.EduTech.EduTech.controller;

import com.EduTech.EduTech.model.Curso;
import com.EduTech.EduTech.service.CursoService;

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

    @GetMapping("/idCurso/{idCurso}")
    public Curso buscarCursoId(@PathVariable int idCurso){
        return cursoService.getCursoId (idCurso);
    }

    @GetMapping("/nombreCurso/{nombreCurso}")
    public Curso buscarCursoNombre(@PathVariable String nombreCurso){ return cursoService.getCursoNombre(nombreCurso);
    }

    @PutMapping("/idCurso/{idCurso}")
    public Curso actualizarCurso(@PathVariable int idCurso, @RequestBody Curso curso) {
        return cursoService.getCursoActualizar(curso);
    }

    @DeleteMapping("/idCurso/{idCurso}")
    public String eliminarCurso (@PathVariable int idCurso) {
        return cursoService.deleteCurso(idCurso);
    }

}
