package com.Tienda.controller;

import com.Tienda.dao.ArticuloDao;
import com.Tienda.domain.Articulo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.Tienda.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class ArticuloController {
    
    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/articulo/listado")
    public String inicio(Model model) {       
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        return "/articulo/listado";
    }
    
    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo){
        return "/articulo/modificar";
    }
    
    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo){
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model){
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo",articulo);
        return "/articulo/modificar";
    }
    
    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo){
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }
    
}
