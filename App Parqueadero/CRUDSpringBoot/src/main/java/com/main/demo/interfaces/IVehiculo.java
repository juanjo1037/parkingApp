package com.main.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.demo.modelo.Vehiculo;
@Repository
public interface IVehiculo extends CrudRepository<Vehiculo, String> {

}
