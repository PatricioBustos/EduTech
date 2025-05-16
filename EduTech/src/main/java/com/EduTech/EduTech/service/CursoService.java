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
        return cursorepository.guardarCurso(curso);
    }

    public Curso getCurso(int idCurso) {
        return cursorepository.buscarPorId(idCurso);
    }

    public Curso getCursoActualizar(Curso curso) {
        return cursorepository.actualizarCurso(curso);
    }


    public String deleteUsuario( int idCurso) {
        cursorepository.eliminarCurso(idCurso);
        return "curso con id: "+ idCurso +"Eliminado correctamente";
    }

}
