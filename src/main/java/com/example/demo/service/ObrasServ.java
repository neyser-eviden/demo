package com.example.demo.service;

import com.example.demo.exception.ResourceNotFound;
import com.example.demo.model.Obras;
import com.example.demo.repository.ObrasRep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ObrasServ {


	private ObrasRep obrasRep;
	
    public void createObras(Obras obras){
    	obrasRep.save(obras);

    }
    
    public void updateObras(Obras obras, int id) {
    	Obras db= obrasRep.findById(id).orElseThrow(ResourceNotFound::new);

    	db.setAgnoCreacion(obras.getAgnoCreacion());
    	db.setArtista(obras.getArtista());
    	db.setEstadoConservacion(obras.getEstadoConservacion());
    	db.setPrecioVenta(obras.getPrecioVenta());
    	db.setTecnica(obras.getTecnica());
    	db.setTitulo(obras.getTitulo());
    	db.setUbicacionActual(obras.getUbicacionActual());
    	db.setValoracion(obras.getValoracion());
    	
    	obrasRep.save(db);
    }
    
    public List<Obras> listObras() {
    	return obrasRep.findAll();
    }
    
    public void deleteObras(int id) {
    	obrasRep.deleteHistorialByIdObra(id);
    	obrasRep.deleteById(id);
    }
    
    public Obras getObrasId(int id) {
    	return obrasRep.findById(id).orElseThrow(ResourceNotFound::new);
   }
}
