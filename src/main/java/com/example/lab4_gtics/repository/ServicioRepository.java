package com.example.lab4_gtics.repository;

import com.example.lab4_gtics.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {


    @Query(value = "select * from servicio where mascota_idmascota=?1 ",nativeQuery = true)
    List<Servicio> ServicioXMascota (int id);

}