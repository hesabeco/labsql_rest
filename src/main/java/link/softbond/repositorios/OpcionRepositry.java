package link.softbond.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import link.softbond.entities.Opcion;
import link.softbond.entities.Usuario;

public interface OpcionRepositry extends JpaRepository<Opcion, Integer>{

	List<Opcion> findByUsuarioBean(Optional<Usuario> usuario);
}
