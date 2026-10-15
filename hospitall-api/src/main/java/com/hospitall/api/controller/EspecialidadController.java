package com.hospitall.api.controller;

import com.hospitall.api.entity.Especialidad;
import com.hospitall.api.service.EspecialidadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    private final EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping
    public ResponseEntity<List<Especialidad>> obtenerTodas() {

        return ResponseEntity.ok(
                especialidadService.obtenerTodas()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> obtenerPorId(
            @PathVariable Integer id
    ) {

        return ResponseEntity.ok(
                especialidadService.obtenerPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<Especialidad> crear(
            @RequestBody Especialidad especialidad
    ) {

        Especialidad nuevaEspecialidad =
                especialidadService.guardar(especialidad);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevaEspecialidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> actualizar(
            @PathVariable Integer id,
            @RequestBody Especialidad especialidad
    ) {

        return ResponseEntity.ok(
                especialidadService.actualizar(id, especialidad)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer id
    ) {

        especialidadService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
    
}