package link.softbond.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the opcion database table.
 * 
 */
@Entity
@NamedQuery(name="Opcion.findAll", query="SELECT o FROM Opcion o")
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int examen;

	private Timestamp fecha;

	//bi-directional many-to-one association to Consulta
	@ManyToOne
	@JoinColumn(name="consulta")
	private Consulta consultaBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public Opcion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExamen() {
		return this.examen;
	}

	public void setExamen(int examen) {
		this.examen = examen;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Consulta getConsultaBean() {
		return this.consultaBean;
	}

	public void setConsultaBean(Consulta consultaBean) {
		this.consultaBean = consultaBean;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}