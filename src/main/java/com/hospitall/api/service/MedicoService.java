package com.hospitall.api.service;

import com.hospitall.api.entity.Medico;
import com.hospitall.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> obtenerTodos() {
        return medicoRepository.findAll();
    }

    public Medico obtenerPorId(Integer id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Médico no encontrado"
                ));
    }

    public Medico guardar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico actualizar(Integer id, Medico datos) {

        Medico medico = obtenerPorId(id);

        medico.setNombre(datos.getNombre());
        medico.setApellido(datos.getApellido());
        medico.setNumeroDocumento(datos.getNumeroDocumento());
        medico.setTelefono(datos.getTelefono());
        medico.setCorreo(datos.getCorreo());
        medico.setEspecialidad(datos.getEspecialidad());
        medico.setEstado(datos.getEstado());

        return medicoRepository.save(medico);
    }

    public void eliminar(Integer id) {

        Medico medico = obtenerPorId(id);

        medicoRepository.delete(medico);
    }
}