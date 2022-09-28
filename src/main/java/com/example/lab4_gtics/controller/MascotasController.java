package com.example.lab4_gtics.controller;


import com.example.lab4_gtics.entity.*;
import com.example.lab4_gtics.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/mascota"})
public class MascotasController {

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    RazaEspecieRepository razaEspecieRepository;

    @Autowired
    ServicioRepository servicioRepository;

    @Autowired
    OpcionServicioRepository opcionServicioRepository;

    @Autowired
    CuentaRepository cuentaRepository;


    @GetMapping(value = {"/lista",""})
    public String listaMascotas(Model model){
        List<ListaMascotasDto> listado=mascotaRepository.obtenerListaMascotas();


        model.addAttribute("listaMascotas",listado);

        return "listamascotas";

    }

    @PostMapping(value={"/search"})
    public String buscarMascota(@RequestParam("searchField") String searchField,Model model){

        List<ListaMascotasDto> busqueda=mascotaRepository.buscaMascotas(searchField);

        model.addAttribute("listaMascotas",busqueda);

        return "listamascotas";
    }


    @GetMapping(value={"/editar"})
    public String editarMascota(@RequestParam("id") int id, Model model){

        Optional<Mascota> optmascota=mascotaRepository.findById(id);

        if(optmascota.isPresent()){
            Mascota mascota=optmascota.get();
            List<RazaEspecie> razas=razaEspecieRepository.findAll();
            model.addAttribute("razas",razas);

            model.addAttribute("mascota",mascota);
//            System.out.println("*/*/**/*/*/*/**/*/*/*/**/*/*/*/**/*/");
//            System.out.println(mascota.getCuentaIdcuenta().getId());
//            System.out.println("*/*/**/*/*/*/**/*/*/*/**/*/*/*/**/*/");
        }
        return "editarMascota";
    }

    @PostMapping(value = {"/save"})
    public String save(Mascota mascota,RedirectAttributes attr){
        mascotaRepository.save(mascota);
        attr.addFlashAttribute("msg","Datos de mascota guardados correctamente");
        return "redirect:/mascota/lista";

    }

    @GetMapping(value={"/vermas"})
    public String vermas(@RequestParam("id") int id,Model model){


        Optional<Mascota> optmascota=mascotaRepository.findById(id);
        List<Servicio> servicio=servicioRepository.ServicioXMascota(id);
        List<OpcionServicio> opcionServicio=opcionServicioRepository.OpcionxMascota(id);

        if(optmascota.isPresent()) {
            Mascota mascota = optmascota.get();

            model.addAttribute("mascota",mascota);
            model.addAttribute("servicio",servicio);
            model.addAttribute("opcionServicio",opcionServicio);
        }


        return "servicioxmascota";
    }

    @GetMapping(value = {"/new"})
    public String nuevaMascota(Model model) {

        return "listaMascotas";
    }

    @GetMapping(value = {"/newDuenho"})
    public String nuevoDuenhover(Model model) {

        return "mascota/newFrmDuenho";
    }

    @PostMapping(value = {"/saveDuenho"})
    public String nuevoDuenho(Model model, Cuenta cuenta, @RequestParam("password1") String password1){
        if(Objects.equals(cuenta.getPassword(), password1)){
            cuentaRepository.save(cuenta);
            return "redirect:/mascota/new";
        }else{
            return "mascota/newFrmDuenho";
        }
    }



    @PostMapping(value={"/delete"})
    public String borrarMascota(@RequestParam("id") int id , RedirectAttributes attr){

        Optional<Mascota> optMascota= mascotaRepository.findById(id);

        if(optMascota.isPresent()){
            mascotaRepository.deleteById(id);
            attr.addFlashAttribute("msg","Mascota borrada :)");
        }
        return "redirect:/mascota/lista";

    }
/*
    @GetMapping(value={"/listadelete"})
    public String borrar(@RequestParam("id") int id , RedirectAttributes attr, Model model){

        Optional<Mascota> optMascota= mascotaRepository.findById(id);

        if(optMascota.isPresent()){
            //mascotaRepository.listaBorrar(id);
            List<ListaMascotasDto> listado=mascotaRepository.listaBorrar(id);
            attr.addFlashAttribute("msg","Mascota borrada :)");
            model.addAttribute("listaMascotas",listado);
        }
        return "redirect:/mascota/listadelete";

    }*/

}
