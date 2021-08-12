package com.main.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String placa;
	private String tipo;
	private String idServicio;

	public Vehiculo(String placa, String tipo, String idServicio) {
		super();
		this.placa = placa;
		this.tipo = tipo;
		this.idServicio = idServicio;
	}

	public String getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Vehiculo(String placa, String tipo) {
		super();
		this.placa = placa;
		this.tipo = tipo;
	}
	
	
}	