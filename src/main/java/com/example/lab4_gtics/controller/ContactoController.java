package com.example.lab4_gtics.controller;

import com.example.lab4_gtics.entity.Cuenta;
import com.example.lab4_gtics.repository.CuentaRepository;
import com.example.lab4_gtics.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("contactos")
public class ContactoController {
    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    MascotaRepository mascotaRepository;




    @GetMapping("/nuevo")
    public String nuevoContacto() {
        return "contacto/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarContacto(Cuenta cuenta, RedirectAttributes attr){
        attr.addFlashAttribute("msg1", "Contacto guardado exitosamente");
        cuentaRepository.save(cuenta);
        return "redirect:/contacto/lista";

    }



}
