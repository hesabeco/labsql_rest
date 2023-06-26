package link.softbond.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import link.softbond.entities.Examen;

public interface ExamenRepository extends JpaRepository<Examen,Integer>{
	List<Examen>generarPreguntas(Integer idExamen);
}
