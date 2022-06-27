package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.Tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class indexController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("ahora utilizamos MVC");
        
        /*Cliente cliente = new Cliente("Sebastian","Rodriguez Paniagua", "srodriguez60182@ufide.ac.cr","6448-0569");
        Cliente cliente2 = new Cliente("Juan","Lopez Rojas", "lopezrojas@correofalso.com","1111-1111");
        Cliente cliente3 = new Cliente("Rosa","Melinda Alvarez", "alvarezmr@correofalso.com","2222-2222");
        
        var clientes = Arrays.asList(cliente, cliente2, cliente3);
        model.addAttribute("cliente", cliente);
        model.addAttribute("clientes", clientes);*/
        
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente",cliente);
        return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }
    
}
