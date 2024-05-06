package com.example.demo.controller;

import com.example.demo.model.Clientes;
import com.example.demo.model.Historial;
import com.example.demo.model.HistorialDto;
import com.example.demo.model.Obras;
import com.example.demo.repository.ClientesRep;
import com.example.demo.repository.ObrasRep;
import com.example.demo.service.HistorialServ;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class HistorialCont {

	@Autowired
	private HistorialServ historialServ;
	@Autowired
	private ClientesRep clientesRep;
	@Autowired
	private ObrasRep obrasRep;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createHistorial(@Validated @RequestBody HistorialDto historial){
    	
    	Clientes cliente = clientesRep.findById(historial.getIdCliente()).get();
    	System.out.println(cliente);
    	
    	Obras obras = obrasRep.findById(historial.getIdObra()).get();
    	System.out.println(obras);
    	
    	Historial historialEntity = new Historial(historial.getIdHistorial(),
    			cliente,obras,historial.getPrecio(),historial.getComision()
    			);
    	historialServ.createHistorial(historialEntity);
    }
    @PutMapping("/{id}")
    @ResponseBody
    public void updateHistorial(@Validated @RequestBody Historial historial,@PathVariable int id){
    	historialServ.updateHistorial(historial,id);

    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Historial getHistorialId(@PathVariable int id) {
    	return historialServ.getHistorialId(id);
    }
    
    @GetMapping
    @ResponseBody
    public List<Historial> listHistorial() {
    	return historialServ.listHistorial();
    }
     
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteHistorial(@PathVariable int id) {
    	historialServ.deleteHistorial(id);
    }
}
