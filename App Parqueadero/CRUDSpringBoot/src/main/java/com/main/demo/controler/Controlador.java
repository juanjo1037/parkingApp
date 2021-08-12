package com.main.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.demo.InterfaceService.IVehiculoService;
import com.main.demo.modelo.Vehiculo;

@Controller
@RequestMapping("/listar")
public class Controlador {
	@Autowired
	private IVehiculoService service;
	
	@GetMapping("/")
	public String listar(Model model) {
		List <Vehiculo> vehiculos = service.listar();
		model.addAttribute("vehiculos", vehiculos);
		return "index";
		
	}
	
}
