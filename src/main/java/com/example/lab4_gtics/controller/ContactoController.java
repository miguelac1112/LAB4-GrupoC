package com.example.lab4_gtics.controller;

import com.example.lab4_gtics.repository.CuentaRepository;
import com.example.lab4_gtics.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("contactos")
public class ContactoController {
    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    MascotaRepository mascotaRepository;

}
