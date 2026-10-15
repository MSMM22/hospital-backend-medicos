package com.hospitall.api.controller;

import com.hospitall.api.entity.Medico;
import com.hospitall.api.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<Medico>> obtenerTodos() {

        return ResponseEntity.ok(
                medicoService.obtenerTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> obtenerPorId(
            @PathVariable Integer id
    ) {

        return ResponseEntity.ok(
                medicoService.obtenerPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<Medico> crear(
            @RequestBody Medico medico
    ) {

        Medico nuevoMedico =
                medicoService.guardar(medico);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevoMedico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizar(
            @PathVariable Integer id,
            @RequestBody Medico medico
    ) {

        return ResponseEntity.ok(
                medicoService.actualizar(id, medico)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer id
    ) {

        medicoService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
