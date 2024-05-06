package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Obras {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int IdObra;


	@Column
    private String artista;


	@Column
    private String titulo;
	
	@Column
    private String tecnica;
	
	
	@Column
    private String estadoConservacion;
	
	@Column
    private int agnoCreacion;
	
	
	@Column
    private Double precioVenta;
	
	@Column
    private Double valoracion;
	
	@Column
    private String ubucacionActual;

	public int getIdObra() {
		return IdObra;
	}

	public void setIdObra(int iD_obra) {
		this.IdObra = iD_obra;
	}



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}


	public String getEstadoConservacion() {
		return estadoConservacion;
	}

	public void setEstadoConservacion(String estadoConservacion) {
		this.estadoConservacion = estadoConservacion;
	}

	public int getAgnoCreacion() {
		return agnoCreacion;
	}

	public void setAgnoCreacion(int agnoCreacion) {
		this.agnoCreacion = agnoCreacion;
	}




	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Double getValoracion() {
		return valoracion;
	}

	public void setValoracion(Double valoracion) {
		this.valoracion = valoracion;
	}

	public String getUbicacionActual() {
		return ubucacionActual;
	}

	public void setUbicacionActual(String ubicacionActual) {
		this.ubucacionActual = ubicacionActual;
	}

	
	
	
	
}
