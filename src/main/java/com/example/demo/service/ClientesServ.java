package com.example.demo.service;

import com.example.demo.exception.ResourceNotFound;
import com.example.demo.model.Clientes;
import com.example.demo.repository.ClientesRep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
              

@AllArgsConstructor
@Service
public class ClientesServ {


	private ClientesRep clientesRep;

	
    public void createCliente(Clientes cliente){
    	clientesRep.save(cliente);

    }
    
    public void updateCliente(Clientes cliente, int id) {
    	Clientes db= clientesRep.findById(id).orElseThrow(ResourceNotFound::new);
    	db.setCorreo(cliente.getCorreo());
    	db.setDireccion(cliente.getDireccion());
    	db.setNombre(cliente.getNombre());
    	db.setNotas(cliente.getNotas());
    	db.setPreferencias(cliente.getPreferencias());
    	db.setTelefono(cliente.getNotas());
    	
    	clientesRep.save(db);
    }
    
    public List<Clientes> listCliente() {
    	return clientesRep.findAll();
    }
    
    public void deleteCliente(int id) {
    	clientesRep.deleteHistorialByIdSocio(id);
    	clientesRep.deleteById(id);
    }
    
    public Clientes getClientesId(int id) {
    	
        return clientesRep.findById(id).orElseThrow(ResourceNotFound::new);
    }

}
