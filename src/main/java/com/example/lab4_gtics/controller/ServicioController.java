package com.example.lab4_gtics.controller;
import com.example.lab4_gtics.repository.OpcionServicioRepository;
import com.example.lab4_gtics.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/servicios")
public class ServicioController {
    @Autowired
    OpcionServicioRepository opcionServicioRepository;
    @Autowired
    ServicioRepository servicioRepository;

    @GetMapping(value = "")
    public String index(Model model){
        int idMascota= 1;
        model.addAttribute("servicios",servicioRepository.ServicioXMascota(idMascota));
        return "servicios/list";
    }
}
