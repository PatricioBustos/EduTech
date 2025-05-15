package com.EduTech.EduTech.repository;

import com.EduTech.EduTech.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class CursoRepository {
    
    private List<Curso> listaCursos = new ArrayList<>();

    public List<Curso> obtenerCursos() {
        return listaCursos;
    }

    public Curso buscarPorId(int idCurso) {
        for ( Curso curso : listaCursos){
            if (curso.getIdCurso() == idCurso){
                return curso;
            }
        }
        return null;
    }
    
    public Curso guardarCurso(Curso clases){
        listaCursos.add(clases);
        return clases;
    }

    public Curso actualizarCurso(Curso curso) {
        for (int i = 0; i < listaCursos.size(); i++) {
            if (listaCursos.get(i).getIdCurso() == curso.getIdCurso()) {
                Curso cursoExistente = listaCursos.get(i);
                cursoExistente.setIdCurso(curso.getIdCurso());
                cursoExistente.setNombreCurso(curso.getNombreCurso());
                cursoExistente.setIdUsuarioEncargado(curso.getIdUsuarioEncargado());
                cursoExistente.setNombreUsuarioEncargado(curso.getNombreUsuarioEncargado());




                return cursoExistente;
            }
        }
        return null;
    }

    public void eliminarCurso(int idCurso){
        Curso curso = buscarPorId(idCurso);
        if(curso != null) {
            listaCursos.remove(curso);
        }
    }

}
    
