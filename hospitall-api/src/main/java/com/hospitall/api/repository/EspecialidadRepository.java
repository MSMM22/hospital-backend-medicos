package com.hospitall.api.repository;

import com.hospitall.api.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {
}