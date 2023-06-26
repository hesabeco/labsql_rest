package link.softbond.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import link.softbond.entities.Consulta;
import link.softbond.entities.Problema;
import link.softbond.entities.Tabla;
import link.softbond.repositorios.ConsultaRepository;
import link.softbond.repositorios.ProblemaRepository;
import link.softbond.repositorios.TablaRepository;

import org.springframework.http.HttpHeaders;


@RestController
@RequestMapping("/problemas")
public class ProblemaController {

	@Autowired
	ProblemaRepository problemaRepository;

	@Autowired
	TablaRepository tablaRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@GetMapping("/list")
	public List<Problema> listarProblemas() {
		return problemaRepository.findAll();
	}

	@GetMapping("/list/activos")
    public List<Problema> listarProblemasActivos(@RequestParam("estado") Integer estado) {
        return problemaRepository.findByEstado(estado);
    }
	
	@GetMapping("/list/activos")
	public List<Problema> getProblemasActivos() {
		List<Problema> todos = problemaRepository.findAll();
		List<Problema> problemaEstado = null;

		for (Problema problema : todos) {
			if (problema.getEstado() == ((byte) 1)) {
				problemaEstado.add(problema);
			}
		}
		return problemaEstado;
	}
	
	@GetMapping("/{id_problema}/tablas")
	public List<Tabla> getProblemaTabla(@PathVariable("id_problema") int idProblema){
		    List<Tabla> tablas = problemaRepository.getTablasPorIdProblema(idProblema);
		    return tablas;
	}

	@GetMapping("/{id_problema}/tablas/{id_tabla}/datos")
	public ResponseEntity<List<Object>> listarDatosTablas(@PathVariable("{id}") Integer id_problema,
			@PathVariable("{id_tabla}") Integer id_tabla) {
		Optional<Problema> problema = problemaRepository.findById(id_problema);
		if (problema != null) {
			List<Tabla> tablasProblema = tablaRepository.findByProblema(problema);
			for (Tabla tabla : tablasProblema) {
				if (tabla.getId() == (id_tabla)) {
					List<Object> datosTabla = obtenerDatosTabla(tabla);
					HttpHeaders headers = new HttpHeaders();
					headers.add("Tabla", tabla.getNombre());
					return ResponseEntity.ok().headers(headers).body(datosTabla);
				}
			}
			return ResponseEntity.notFound().build();
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	private List<Object> obtenerDatosTabla(Tabla tabla) {
		List<Object> datosTabla = new ArrayList();
		datosTabla.add(tabla.getId());
		datosTabla.add(tabla.getDescripcion());
		datosTabla.add(tabla.getProblema());
		return datosTabla;
	}
	
	@PostMapping
	public Problema agregarProblema(@RequestBody Problema problema) {
		problemaRepository.save(problema);
		return problema;
	}
	
	@GetMapping("/{id}/consultas")
	public List<Consulta> listarConsultasProblema(@PathVariable Integer id){
		Optional<Problema> problema = problemaRepository.findById(id);
		return consultaRepository.findByProblema(problema);
	}
}
