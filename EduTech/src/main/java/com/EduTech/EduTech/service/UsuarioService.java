package com.EduTech.EduTech.service;

import com.EduTech.EduTech.model.Usuario;
import com.EduTech.EduTech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.obtenerUsuarios();
    }

        public Usuario saveUsuario(Usuario usuario) {
            if (usuarioRepository.buscarPorRut(usuario.getRut()) != null) {
                throw new RuntimeException("Usuario ya existente");
            }

            return usuarioRepository.guardarUsuario(usuario);
        }
            public Usuario getUsuarioRut(int rut) {
                return usuarioRepository.buscarPorRut(rut);
            }

            public Usuario getUsuarioCorreo(String correo) {
                return usuarioRepository.buscarPorCorreo(correo);
            }

            public Usuario upadteUsuario(Usuario usuario) {
                return usuarioRepository.actualizarUsuario(usuario);
            }

            public String deleteUsuario(int rut) {
                usuarioRepository.eliminarUsuario(rut);
                return "Usuario con rut: "+ rut +"Eliminado";
            }

        }

