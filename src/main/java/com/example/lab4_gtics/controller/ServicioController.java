package com.example.lab4_gtics.controller;
import com.example.lab4_gtics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/servicios")
public class ServicioController {
    @Autowired
    OpcionServicioRepository opcionServicioRepository;
    @Autowired
    ServicioRepository servicioRepository;
    @Autowired
    ResponsableRepository responsableRepository;
    @Autowired
    MascotaRepository mascotaRepository;
    @Autowired
    OpcionRepository opcionRepository;

    @GetMapping(value = "")
    public String index(Model model){
        int idMascota= 1;
        model.addAttribute("servicios",servicioRepository.ServicioXMascota(idMascota));
        model.addAttribute("idMascota",idMascota);
        return "servicios/list";
    }

    @GetMapping(value = "/nuevo")
    public String nuevo(@RequestParam(value = "idMascota") Integer mascota,
                        @RequestParam(value = "idCuenta") Integer cuenta,
                        Model model){
        model.addAttribute("responsables", responsableRepository.findAll());
        model.addAttribute("mascota", mascotaRepository.findById(mascota).get());
        model.addAttribute("idCuenta", cuenta);
        model.addAttribute("opciones", opcionRepository.findAll());
       return "servicios/newFrm";
    }
}
