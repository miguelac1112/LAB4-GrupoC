package com.example.lab4_gtics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class InicioController {

    @GetMapping("/inicio")
    public String inicio(){
        return "Inicio";
    }
}
