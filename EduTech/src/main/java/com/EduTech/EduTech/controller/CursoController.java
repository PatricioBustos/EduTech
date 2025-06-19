package com.EduTech.EduTech.controller;

import com.EduTech.EduTech.model.Curso;
import com.EduTech.EduTech.service.CursoService;

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
@RequestMapping("/api/v1/clases")
@Tag(name = "Cursos", description = "Operaciones relacionadas con los cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    @Operation(summary = "Obtener todos los Cursos", description = "Obtiene una lista de todas los cursos")
    public List<Curso> listarCursos(){
        return cursoService.getCurso();
    }

    @PostMapping
    @Operation(summary = "Agregar Cursos", description = "Agrega Cursos")
    public Curso agregarCurso(@RequestBody Curso curso){
        return cursoService.saveCurso(curso);
    }

    @GetMapping("/idCurso/{idCurso}")
    @Operation(summary = "Buscar Cursos por ID", description = "Busca un Curso por su ID de Curso")
    public Curso buscarCursoId(@PathVariable int idCurso){
        return cursoService.getCursoId (idCurso);
    }

    @GetMapping("/nombreCurso/{nombreCurso}")
    @Operation(summary = "Buscar Cursos por su Nombre", description = "Busca un Curso solo por su Nombre")
    public Curso buscarCursoNombre(@PathVariable String nombreCurso){ return cursoService.getCursoNombre(nombreCurso);
    }

    @PutMapping("/idCurso/{idCurso}")
    @Operation(summary = "Actualizar Cursos", description = "Actualiza un curso existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso actualizado correctamente!!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Curso.class))),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
})
    public Curso actualizarCurso(@PathVariable int idCurso, @RequestBody Curso curso) {
        curso.setIdCurso(idCurso);
        return cursoService.getCursoActualizar(curso);
    }

    @DeleteMapping("/idCurso/{idCurso}")
    @Operation(summary = "Eliminar un Cursos", description = "Elimina cursos por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso Eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado :c")
    })
    public String eliminarCurso (@PathVariable int idCurso) {
        return cursoService.deleteCurso(idCurso);
    }

}
