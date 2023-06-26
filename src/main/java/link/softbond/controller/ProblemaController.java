package link.softbond.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import link.softbond.entities.Problema;
import link.softbond.repositorios.ProblemaRepository;

@RestController
@RequestMapping("/problemas")
public class ProblemaController {
	@Autowired
	ProblemaRepository problemaRepository;
	@GetMapping("/{id}")
	public List<Problema> getProblemabyEstado(@PathVariable Integer estado) {
		List<Problema> todos= problemaRepository.findAll();
		List<Problema> problemaEstado = null;
		 for (Problema problema : todos) {
		        if (problema.getEstado().equals(estado)) {
		            problemaEstado.add(problema);
		        }
		    }
		    return problemaEstado;
		}
}
