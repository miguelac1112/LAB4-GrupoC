package com.example.lab4_gtics.repository;

import com.example.lab4_gtics.entity.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Integer> {
}