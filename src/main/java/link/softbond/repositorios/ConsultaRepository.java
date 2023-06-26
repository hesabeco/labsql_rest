package link.softbond.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import link.softbond.entities.Consulta;
import link.softbond.entities.Problema;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{
List<Consulta> findByProblema(Optional<Problema> problema);
}
