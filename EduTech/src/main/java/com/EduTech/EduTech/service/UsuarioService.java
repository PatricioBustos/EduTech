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

    public List<Usuario> findAll() {
        return usuarioRepository.obtenerUsuarios();
    }

        public Usuario saveUsuario(Usuario usuario) {
            if (!usuario.getRut().matches("\\d+")){
                throw new IllegalArgumentException("El RUT solo debe contener numeros!!");
            }
            if (usuarioRepository.buscarPorRut(usuario.getRut()) != null) {
                throw new RuntimeException("Usuario ya existente");
            }
            if (usuarioRepository.buscarPorRut(usuario.getRut()) != null) {
                    throw new RuntimeException("Correo ya existente, use otro porfavor");
            }
            return usuarioRepository.guardarUsuario(usuario);
        }
            public Usuario getUsuarioRut(String rut) {
                Usuario usuario = usuarioRepository.buscarPorRut(rut);
                if (usuario == null) {
                    throw new RuntimeException("No se encontró un usuario con el RUT " + rut);
                }
                return usuario;
            }

            public Usuario getUsuarioCorreo(String correo) {
                Usuario usuario = usuarioRepository.buscarPorCorreo(correo);
                if (usuario == null) {
                    throw new RuntimeException("No se encontró un usuario con el correo " + correo);
                }
                return usuario;
            }

            public Usuario updateUsuario(Usuario usuario) {
                if (usuarioRepository.buscarPorRut(usuario.getRut()) == null) {
                    throw new RuntimeException("No se puede actualizar. Usuario con RUT " + usuario.getRut() + " no existe.");
                }
                return usuarioRepository.actualizarUsuario(usuario);
            }

            public String deleteUsuario(String rut) {
                Usuario usuario = usuarioRepository.buscarPorRut(rut);
                if (usuario == null) {
                    throw new RuntimeException("No se puede eliminar. Usuario con RUT " + rut + " no existe.");
                }
                usuarioRepository.eliminarUsuario(rut);
                return "Usuario con RUT " + rut + " eliminado correctamente.";
            }
        }

