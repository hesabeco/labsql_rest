package link.softbond.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import link.softbond.entities.Examen;
import link.softbond.entities.Problema;

public interface ExamenRepository extends JpaRepository<Examen,Integer>{

	List<Examen> findByProblemaBean(Optional<Problema> problema);

	List<Examen>generarPreguntas(Integer idExamen);
}
