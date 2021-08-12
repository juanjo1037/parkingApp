package com.main.demo.modelo;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private LocalDateTime horaIngreso;
	private LocalDateTime horaSalida;
	private float precio;
	private String placaVehiculo;
	
	
	public Servicio(String id, LocalDateTime horaIngreso, LocalDateTime horaSalida, float precio,
			String placaVehiculo) {
		super();
		this.id = id;
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;
		this.precio = precio;
		this.placaVehiculo = placaVehiculo;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Servicio(LocalDateTime horaIngreso, LocalDateTime horaSalida, float precio) {
		super();
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;
		this.precio = precio;
	}
	
	public LocalDateTime getHoraIngreso() {
		return horaIngreso;
	}
	public void setHoraIngreso(LocalDateTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	 
	
}
