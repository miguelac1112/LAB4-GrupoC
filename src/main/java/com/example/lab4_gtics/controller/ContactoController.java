package com.example.lab4_gtics.controller;

import com.example.lab4_gtics.entity.Cuenta;
import com.example.lab4_gtics.entity.Mascota;
import com.example.lab4_gtics.repository.CuentaRepository;
import com.example.lab4_gtics.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
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
        return "contacto/newFrm";
    }

    @PostMapping("/guardar")
    public String guardarContacto(Cuenta cuenta, RedirectAttributes attr){
        attr.addFlashAttribute("msg1", "Contacto guardado exitosamente");
        CuentaRepository.save(cuenta);
        return "redirect:/contacto/listaduenos";

    }
    @GetMapping("/borrar")
    public String borrarContacto(@RequestParam("id") Integer id, RedirectAttributes attr) {
        Optional<Cuenta> oCuenta = CuentaRepository.findById(id);
        if (oCuenta.isPresent()) {
            attr.addFlashAttribute("msg3", "Contacto borrado exitosamente");
            CuentaRepository.delete(oCuenta.get());
        }
        return "redirect:/contacto/listaduenos";

    }
    @GetMapping("/borrarMascota")
    public String borrarMascota(@RequestParam("id") Integer id,RedirectAttributes attr){
        Optional<Mascota> oMascota = MascotaRepository.buscaMascotas(id);
        if(oMascota.isPresent()) {
            MascotaRepository.delete(oMascota.get());
            attr.addFlashAttribute("msg4", "Mascota borrada exitosamente");
        }
        return "redirect:/contacto/listamascotas";

    }

    @GetMapping("/verMascota")
    public String verMascota(@RequestParam("id") int id, Model model) {

        List<Mascota> ListaMascotasDto> = MascotaRepository.obtenerListaMascotas(id);
        model.addAttribute("mascotas", lista);

        return "contacto/listamascotas";

    }


}
