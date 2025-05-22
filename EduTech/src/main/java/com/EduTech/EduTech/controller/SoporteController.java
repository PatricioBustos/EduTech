package com.EduTech.EduTech.controller;

import com.EduTech.EduTech.model.Soporte;
import com.EduTech.EduTech.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/soportes")
public class SoporteController {

    @Autowired
    private SoporteService soporteService;

    @GetMapping
    public List<Soporte> listaTickets() {
        return soporteService.getSoportes();
    }

    @PostMapping
    public Soporte agregarTicket(@RequestBody Soporte soporte) {
        return soporteService.saveSoporte(soporte);
    }

    // Buscar soporte por id
    @GetMapping("/{idTicket}")
    public Soporte buscarTicket(@PathVariable int idTicket) {
        return soporteService.getTicketId(idTicket);
    }

    // Actualizar soporte (usando PUT y path correcto)
    @PutMapping("/{idTicket}")
    public Soporte actualizarTicket(@PathVariable int idTicket, @RequestBody Soporte soporte) {
        soporte.setIdTicket(idTicket);  // Asegurar que el id venga del path
        return soporteService.updateTicket(soporte);
    }

    @DeleteMapping("/{idTicket}")
    public String eliminarTicket(@PathVariable int idTicket) {
        return soporteService.deleteTicket(idTicket);
    }

}
