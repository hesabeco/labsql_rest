package link.softbond.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import link.softbond.entities.Problema;
import link.softbond.entities.Tabla;
import link.softbond.repositorios.ProblemaRepository;
import link.softbond.repositorios.TablaRepository;

@RestController
@RequestMapping("/problemas")
public class ProblemaController {

	@Autowired
	ProblemaRepository problemaRepository;

	@Autowired
	TablaRepository tablaRepository;

	@GetMapping("/list")
	public List<Problema> listarProblemas() {
		return problemaRepository.findAll();
	}

	@GetMapping("/{id}")
	public List<Problema> getProblemabyEstado(@PathVariable Integer estado) {
		List<Problema> todos = problemaRepository.findAll();
		List<Problema> problemaEstado = null;
		for (Problema problema : todos) {
			if (problema.getEstado() == (byte) 1) {
				problemaEstado.add(problema);
			}
		}
		return problemaEstado;
	}

	@GetMapping("/{id_problema}/tablas/{id_tabla}/datos")
	public ResponseEntity<Tabla> listarDatosTablas(@PathVariable("{id}") Integer id_problema,
			@PathVariable("{id_tabla}") Integer id_tabla) {
		Optional<Problema> problema = problemaRepository.findById(id_problema);
		if (problema != null) {
			List<Tabla> tablasProblema = tablaRepository.findByProblema(problema);
			for (Tabla tabla : tablasProblema) {
	            if (tabla.getId()==(id_tabla)) {
	                return new ResponseEntity<>(tabla, HttpStatus.OK);
	            }else {
	            	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	            }
	        }
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return null;
	}
}
