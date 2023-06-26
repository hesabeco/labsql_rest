package link.softbond.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tabla database table.
 * 
 */
@Entity
@NamedQuery(name="Tabla.findAll", query="SELECT t FROM Tabla t")
public class Tabla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String descripcion;

	private String nombre;

	@ManyToOne
	@JoinColumn(name="idproblema")
	private Problema problema;

	public Tabla() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Problema getProblema() {
		return this.problema;
	}

	public void setProblema(Problema problema) {
		this.problema = problema;
	}

}