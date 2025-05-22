package com.EduTech.EduTech.repository;

import com.EduTech.EduTech.model.Soporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class SoporteRepository {
    private List<Soporte> listaTicket = new ArrayList<>();

    public List<Soporte> obtenerSoportes() {return listaTicket;}

    public Soporte buscarPorId (int idTicket) {
        for (Soporte soporte : listaTicket){
            if (soporte.getIdTicket() == idTicket){
                return soporte;
            }
        }
        return null;
    }

    public Soporte guardarTicket(Soporte ticket){
        listaTicket.add(ticket);
        return ticket;
    }

    public Soporte actualizarTicket(Soporte soporte) {
        for (int i = 0; i < listaTicket.size(); i++) {
            if (listaTicket.get(i).getIdTicket() == soporte.getIdTicket()) {

                Soporte soporteExistente = listaTicket.get(i);


                soporteExistente.setUsuario(soporte.getUsuario());
                soporteExistente.setTipoConsulta(soporte.getTipoConsulta());
                soporteExistente.setDescripcionProblema(soporte.getDescripcionProblema());

                return soporteExistente;
            }
        }
        return null;
    }

    public void eliminarTicket(int idTicket){
        Soporte soporte = buscarPorId(idTicket);
        if (soporte != null){
            listaTicket.remove(soporte);
        }
    }


}
