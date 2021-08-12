package com.main.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.demo.InterfaceService.IVehiculoService;
import com.main.demo.interfaces.IVehiculo;
import com.main.demo.modelo.Vehiculo;

@Service
public class VehiculoService implements IVehiculoService{
	@Autowired
	private IVehiculo data;
	@Override
	public List<Vehiculo> listar() {
		
		return (List<Vehiculo>)data.findAll();
	}

	@Override
	public Optional<Vehiculo> listarPlaca(String placa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Save(Vehiculo v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String placa) {
		// TODO Auto-generated method stub
		
	}

}
