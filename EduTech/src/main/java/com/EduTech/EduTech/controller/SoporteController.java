package com.EduTech.EduTech.controller;

import com.EduTech.EduTech.model.Soporte;
import com.EduTech.EduTech.service.SoporteService;
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
@RequestMapping("/api/v1/soportes")
@Tag(name = "Soporte", description = "Operaciones relacionadas con los Tickets de Soporte")
public class SoporteController {

    @Autowired
    private SoporteService soporteService;

    @GetMapping
    @Operation(summary = "Obtener todos los Tickets", description = "Obtiene una lista de todas los Tickets")
    public List<Soporte> listaTickets() {
        return soporteService.findAll();
    }

    @PostMapping
    @Operation(summary = "Agregar Tickets", description = "Agrega un Ticket")
    public Soporte agregarTicket(@RequestBody Soporte soporte) {
        return soporteService.saveSoporte(soporte);
    }

    @GetMapping("/{idTicket}")
    @Operation(summary = "Buscar Tickets", description = "Busca un Ticket mediante su ID")
    public Soporte buscarTicket(@PathVariable int idTicket) {
        return soporteService.findById(idTicket);
    }

    @PutMapping("/{idTicket}")
    @Operation(summary = "Actualizar Ticket", description = "Actualiza un Ticket existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket actualizado correctamente!!",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Soporte.class))),
            @ApiResponse(responseCode = "404", description = "Ticket no encontrado :c")
    })
    public Soporte actualizarTicket(@PathVariable int idTicket, @RequestBody Soporte soporte) {
        soporte.setIdTicket(idTicket);  // Asegurar que el id venga del path
        return soporteService.updateTicket(soporte);
    }

    @DeleteMapping("/{idTicket}")
    @Operation(summary = "Eliminar Ticket", description = "Elimina un Ticket por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket Eliminado exitosamente!!"),
            @ApiResponse(responseCode = "404", description = "Ticket no encontrado :c")
    })
    public String eliminarTicket(@PathVariable int idTicket) {
        return soporteService.deleteTicket(idTicket);
    }

}
