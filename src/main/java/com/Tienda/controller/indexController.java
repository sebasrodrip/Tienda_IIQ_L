package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.Tienda.domain.Cliente;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class indexController {
    
    @Autowired
    private ClienteDao ClienteDao;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("ahora utilizamos MVC");
        
        /*Cliente cliente = new Cliente("Sebastian","Rodriguez Paniagua", "srodriguez60182@ufide.ac.cr","6448-0569");
        Cliente cliente2 = new Cliente("Juan","Lopez Rojas", "lopezrojas@correofalso.com","1111-1111");
        Cliente cliente3 = new Cliente("Rosa","Melinda Alvarez", "alvarezmr@correofalso.com","2222-2222");
        
        var clientes = Arrays.asList(cliente, cliente2, cliente3);
        model.addAttribute("cliente", cliente);
        model.addAttribute("clientes", clientes);*/
        
        var clientes = ClienteDao.findAll();
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
}
