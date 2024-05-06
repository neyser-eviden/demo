package com.example.demo.service;


import com.example.demo.exception.ResourceNotFound;
import com.example.demo.model.Historial;
import com.example.demo.repository.HistorialRep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HistorialServ {

	private HistorialRep historialRep;
	
	
	public void createHistorial(Historial historial) {
        historialRep.save(historial);
    }

    
    public void updateHistorial(Historial historial, int id) {
    	Historial db= historialRep.findById(id).orElseThrow(ResourceNotFound::new);
    	db.setComision(historial.getComision());
    	db.setIdCliente(historial.getIdCliente());
    	db.setIdObra(historial.getIdObra());
    	db.setPrecio(historial.getPrecio());
    	
    	historialRep.save(db);
    }
    
    public List<Historial> listHistorial() {
    	return historialRep.findAll();
    }
    
    public void deleteHistorial(int id) {
    	historialRep.deleteById(id);
    }
    
    public Historial getHistorialId(int id) {
    	return historialRep.findById(id).orElseThrow(ResourceNotFound::new);
   }
}
