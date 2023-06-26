package link.softbond.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import link.softbond.entities.Tabla;
import link.softbond.repositorios.TablaRepository;

@RestController
@RequestMapping("/tabla")
public class TablaController {
	
	@Autowired
	TablaRepository tablaRepository;
	@DeleteMapping("/{id}")
	public String deleteBillbyId(@PathVariable Integer id) {
		Optional<Tabla> tabla = tablaRepository.findById(id);
		if (!tabla.isPresent()) {
			return "La tabla con el id " + id + " no existe";
		}
		// Bill getBill = bill.get();
		tablaRepository.deleteById(id);
		return "Se ha eliminado exitosamente la tabla con el id: " + id;
	}
}
