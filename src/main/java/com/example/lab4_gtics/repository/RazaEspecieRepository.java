package com.example.lab4_gtics.repository;

import com.example.lab4_gtics.entity.RazaEspecie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazaEspecieRepository extends JpaRepository<RazaEspecie, Integer> {
}