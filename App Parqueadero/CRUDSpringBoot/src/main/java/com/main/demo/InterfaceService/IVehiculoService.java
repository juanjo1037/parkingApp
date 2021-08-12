package com.main.demo.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.main.demo.modelo.Vehiculo;

public interface IVehiculoService {
	public List<Vehiculo>listar();
	public Optional<Vehiculo>listarPlaca(String placa);
	public int Save(Vehiculo v);
	public void delete(String placa);
}
