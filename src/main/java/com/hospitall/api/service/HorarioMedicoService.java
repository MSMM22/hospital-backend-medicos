package com.hospitall.api.service;

import com.hospitall.api.entity.HorarioMedico;
import com.hospitall.api.repository.HorarioMedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioMedicoService {

    private final HorarioMedicoRepository horarioRepository;

    public HorarioMedicoService(
            HorarioMedicoRepository horarioRepository) {

        this.horarioRepository = horarioRepository;
    }

    public List<HorarioMedico> obtenerTodos() {
        return horarioRepository.findAll();
    }

    public HorarioMedico obtenerPorId(Integer id) {

        return horarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Horario no encontrado"
                        ));
    }

    public HorarioMedico guardar(HorarioMedico horario) {
        return horarioRepository.save(horario);
    }

    public HorarioMedico actualizar(
            Integer id,
            HorarioMedico datos) {

        HorarioMedico horario = obtenerPorId(id);

        horario.setMedico(datos.getMedico());
        horario.setDiaSemana(datos.getDiaSemana());
        horario.setHoraInicio(datos.getHoraInicio());
        horario.setHoraFin(datos.getHoraFin());

        return horarioRepository.save(horario);
    }

    public void eliminar(Integer id) {

        HorarioMedico horario = obtenerPorId(id);

        horarioRepository.delete(horario);
    }
}