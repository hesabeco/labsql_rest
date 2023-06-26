
package link.softbond.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import link.softbond.entities.Problema;
import link.softbond.entities.Tabla;

public interface TablaRepository extends JpaRepository<Tabla, Integer> {

	List<Tabla> findByProblema(Optional<Problema> problema);
	
}

