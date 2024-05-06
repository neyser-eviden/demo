package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Clientes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idCliente;

	
		
	@Column
    private String nombre;
	@Column
    private String telefono;
	@Column
    private String correo;
	@Column
    private String direccion;
	@Column
    private String preferencias;
	@Column
    private String notas;


}
