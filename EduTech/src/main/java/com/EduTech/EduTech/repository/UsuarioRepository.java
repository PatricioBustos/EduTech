package com.EduTech.EduTech.repository;

import com.EduTech.EduTech.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class UsuarioRepository {

    private List<Usuario> listaUsuarios = new ArrayList<>();

    public List<Usuario> obtenerUsuarios() {
        return listaUsuarios;
    }

    public Usuario buscarPorRut(String rut) {
        for ( Usuario usuario : listaUsuarios){
            if (usuario.getRut() != null && usuario.getRut().equals(rut)) {
                return usuario;
            }
        }
        return null;
    }
    public Usuario buscarPorCorreo(String correo){
        for (Usuario usuario : listaUsuarios){
            if (usuario.getCorreo() != null && usuario.getCorreo().equals(correo)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario guardarUsuario(Usuario user){
        listaUsuarios.add(user);
        return user;
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getRut() != null &&
                    listaUsuarios.get(i).getRut().equals(usuario.getRut())) {

                Usuario usuarioExistente = listaUsuarios.get(i);
                usuarioExistente.setDv(usuario.getDv());
                usuarioExistente.setNombre(usuario.getNombre());
                usuarioExistente.setApellidoPaterno(usuario.getApellidoPaterno());
                usuarioExistente.setApellidoMaterno(usuario.getApellidoMaterno());
                usuarioExistente.setCorreo(usuario.getCorreo());
                return usuarioExistente;
            }
        }
        return null;
    }

    public void eliminarUsuario(String rut){
        Usuario usuario = buscarPorRut(rut);
        if(usuario != null) {
            listaUsuarios.remove(usuario);
        }
    }

}
