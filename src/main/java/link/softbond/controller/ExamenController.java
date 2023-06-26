package link.softbond.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> branch 'master' of https://github.com/hesabeco/labsql_rest.git
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import link.softbond.entities.Examen;
import link.softbond.entities.Opcion;
import link.softbond.entities.Usuario;
import link.softbond.repositorios.ExamenRepository;
import link.softbond.repositorios.OpcionRepositry;
import link.softbond.repositorios.UsuarioRepository;

@RestController
@RequestMapping("/examenes")
public class ExamenController {
	@Autowired
	ExamenRepository examenRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	OpcionRepositry opcionRepositry;

	@GetMapping
	public List<Examen> getExamenes() {
		List<Examen> examenes = examenRepository.findAll();
		return examenes;
	}

	@GetMapping("/{id}/listar")
	public List<Opcion> listarExamenesUsuario(@PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return opcionRepositry.findByUsuarioBean(usuario);
	}
>>>>>>> branch 'master' of https://github.com/hesabeco/labsql_rest.git
}
