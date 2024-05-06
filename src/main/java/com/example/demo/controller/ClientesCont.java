package com.example.demo.controller;

import com.example.demo.model.Clientes;
import com.example.demo.service.ClientesServ;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class ClientesCont {
	
	@Autowired
	private ClientesServ clientesServ;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createCliente(@Validated @RequestBody Clientes cliente){
    	clientesServ.createCliente(cliente);
    }
    @PutMapping("/{id}")
    @ResponseBody
    public void updateCliente(@Validated @RequestBody Clientes cliente,@PathVariable int id){
    	clientesServ.updateCliente(cliente,id);

    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Clientes getClientesId(@PathVariable int id) {
        return clientesServ.getClientesId(id);
    }

    
    @GetMapping
    @ResponseBody
    public List<Clientes> listCliente() {
    	return clientesServ.listCliente();
    }
     
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteCliente(@PathVariable int id) {
   
    	clientesServ.deleteCliente(id);
    }

}
