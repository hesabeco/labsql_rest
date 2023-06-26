package link.softbond.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import link.softbond.entities.Problema;
import link.softbond.entities.Tabla;

public interface ProblemaRepository extends JpaRepository<Problema, Integer> {
	List<Problema> findByEstado(Integer estado);
	List<Tabla> getTablasPorIdProblema(int idProblema);
}
