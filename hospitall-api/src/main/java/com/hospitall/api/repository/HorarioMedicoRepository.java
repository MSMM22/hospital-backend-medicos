package com.hospitall.api.repository;

import com.hospitall.api.entity.HorarioMedico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioMedicoRepository
        extends JpaRepository<HorarioMedico, Integer> {
}