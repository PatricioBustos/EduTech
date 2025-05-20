package com.EduTech.EduTech.service;

import com.EduTech.EduTech.model.Curso;
import com.EduTech.EduTech.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CursoService {

    @Autowired
    private CursoRepository cursorepository;

    public List<Curso> getCurso() {return cursorepository.obtenerCursos();
    }

    public Curso saveCurso(Curso curso) {
        if (curso.getNombreCurso() == null || curso.getNombreCurso().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del curso no debe estar vacío");
        }

        if (cursorepository.buscarPorId(curso.getIdCurso()) != null) {
            throw new RuntimeException("El ID del curso ya existe, utiliza otro!!");
        }

        return cursorepository.guardarCurso(curso);
    }

    public Curso getCursoId(int idCurso) {
        return cursorepository.buscarPorId(idCurso);
    }

    public Curso getCursoNombre(String nombreCurso) {
        return cursorepository.buscarPorNombre(nombreCurso);
    }


    public Curso getCursoActualizar(Curso curso) {
        return cursorepository.actualizarCurso(curso);
    }


    public String deleteCurso( int idCurso) {
        cursorepository.eliminarCurso(idCurso);
        return "curso con id: "+ idCurso +"Eliminado correctamente";
    }

}
