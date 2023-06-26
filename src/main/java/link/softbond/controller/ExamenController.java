package link.softbond.controller;

import java.util.List;
import link.softbond.entities.Examen;
import link.softbond.repositorios.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examen")
public class ExamenController {

	@Autowired
	ExamenRepository examenRepository;

	@GetMapping
	public List<Examen> listarExamenes() {
		return examenRepository.findAll();
	}

}