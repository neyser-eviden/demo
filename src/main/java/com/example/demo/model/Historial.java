package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Historial {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idHistorial;
	

	@ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes idCliente;
    
	@ManyToOne
    @JoinColumn(name = "idObra")
    private Obras idObra;
    
      

    
    @Column
    private Double precio;
    
    @Column
    private Double comision;


}
