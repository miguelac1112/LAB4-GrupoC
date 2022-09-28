package com.example.lab4_gtics.repository;

import com.example.lab4_gtics.entity.OpcionServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionServicioRepository extends JpaRepository<OpcionServicio, Integer> {
}