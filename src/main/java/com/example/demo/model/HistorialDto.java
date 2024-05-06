package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialDto {

private int idHistorial;


    private int idCliente;
	    
	    private int idObra;
	    
	    private Double Precio;
	
	    private Double Comision;
	}
