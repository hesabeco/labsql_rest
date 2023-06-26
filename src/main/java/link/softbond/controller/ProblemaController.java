package link.softbond.controller;

import java.util.List;
import link.softbond.entities.Problema;
import link.softbond.repositorios.ProblemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.app.web.entities.Bill;

import link.softbond.entities.Problema;
import link.softbond.repositorios.ProblemaRepository;

=======
>>>>>>> branch 'master' of https://github.com/hesabeco/labsql_rest.git
@RestController
@RequestMapping("/problemas")
public class ProblemaController {
	@Autowired
	ProblemaRepository problemaRepository;
	
	
	@GetMapping("/list")
    public List<Problema> listarProblemas(){
        return problemaRepository.findAll();
    }
	
	@GetMapping("/list/activos")
    public List<Problema> listarProblemasActivos(@RequestParam("estado") Integer estado) {
        return problemaRepository.findByEstado(estado);
    }
	

	@GetMapping("/list/activos")
	public List<Problema> getProblemasActivos() {
		List<Problema> todos= problemaRepository.findAll();	
		List<Problema> problemaEstado = null;
		 for (Problema problema : todos) {
		        if (problema.getEstado()==((byte)1)) {
		            problemaEstado.add(problema);
		        }
		    }
		    return problemaEstado;
		}

	@PostMapping
	public Problema agregarProblema(@RequestBody Problema problema) {
		problemaRepository.save(problema);
		return problema;
	}

}
