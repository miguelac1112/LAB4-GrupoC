package com.example.lab4_gtics.controller;

import com.example.lab4_gtics.entity.Cuenta;
import com.example.lab4_gtics.repository.CuentaRepository;
import com.example.lab4_gtics.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
        return "redirect:/contacto/list";

    }
    @GetMapping("/borrar")
    public String borrarContacto(@RequestParam("id") Integer id, RedirectAttributes attr){
        Optional<Cuenta> oCuenta = cuentaRepository.findById(id);
        if(oCuenta.isPresent()) {
            attr.addFlashAttribute("msg3", "Contacto borrado exitosamente");
            cuentaRepository.delete(oCuenta.get());
        }
        return "redirect:/contacto/list";




}
