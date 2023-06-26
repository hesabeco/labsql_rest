package link.softbond.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import link.softbond.entities.Consulta;
import link.softbond.repositorios.ConsultaRepository;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	
	@Autowired
	ConsultaRepository consultaRepository;

	@PostMapping
	public ResponseEntity<Consulta> crearConsulta(@RequestBody Consulta consulta){
		return new ResponseEntity<>(consultaRepository.save(consulta),HttpStatus.OK);
	}
	
}
