package link.softbond.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the examen database table.
 * 
 */
@Entity
@NamedQuery(name="Examen.findAll", query="SELECT e FROM Examen e")
public class Examen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer cantidad;

	private String descripcion;

	private Timestamp fechafin;

	private Timestamp fechainicio;

	@ManyToOne
	@JoinColumn(name="problema_id")
	private Problema problemaBean;

	public Examen() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}

	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Problema getProblemaBean() {
		return this.problemaBean;
	}

	public void setProblemaBean(Problema problemaBean) {
		this.problemaBean = problemaBean;
	}

}