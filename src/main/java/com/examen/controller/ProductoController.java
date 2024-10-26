package com.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.examen.model.Producto;
import com.examen.repository.IProductoRepository;

@Controller
public class ProductoController {
	
    @Autowired
    private IProductoRepository productoRepository;

    @GetMapping("/")
    public String index(Model model) {
    	List<Producto> productos = productoRepository.findAll();
    	
        model.addAttribute("productos", productos);
        return "index";  
    }

    @GetMapping("/producto/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        return "registro";  
    }

    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto) {
        productoRepository.save(producto);
        return "redirect:/";  
    }
}
