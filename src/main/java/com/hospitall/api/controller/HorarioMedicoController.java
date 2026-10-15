package com.hospitall.api.controller;

import com.hospitall.api.entity.HorarioMedico;
import com.hospitall.api.service.HorarioMedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioMedicoController {

    private final HorarioMedicoService horarioService;

    public HorarioMedicoController(
            HorarioMedicoService horarioService) {

        this.horarioService = horarioService;
    }

    @GetMapping
    public ResponseEntity<List<HorarioMedico>> obtenerTodos() {

        return ResponseEntity.ok(
                horarioService.obtenerTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioMedico> obtenerPorId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                horarioService.obtenerPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<HorarioMedico> crear(
            @RequestBody HorarioMedico horario) {

        HorarioMedico nuevo =
                horarioService.guardar(horario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioMedico> actualizar(
            @PathVariable Integer id,
            @RequestBody HorarioMedico horario) {

        return ResponseEntity.ok(
                horarioService.actualizar(id, horario)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer id) {

        horarioService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}