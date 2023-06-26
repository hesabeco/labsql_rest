package link.softbond.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


@Entity
@NamedQuery(name="Problema.findAll", query="SELECT p FROM Problema p")
public class Problema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Lob
	private String descripcion;

	private String docente;

	private Integer estado;

	private String nombre;

	private String nombrebase;

	//bi-directional many-to-one association to Consulta
	@OneToMany(mappedBy="problema")
	@JsonIgnore
	private List<Consulta> consultas;

	//bi-directional many-to-one association to Examen
	@OneToMany(mappedBy="problemaBean")
	@JsonIgnore
	private List<Examen> examens;

	//bi-directional many-to-one association to Tabla
	@OneToMany(mappedBy="problema")
	@JsonIgnore
	private List<Tabla> tablas;

	public Problema() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDocente() {
		return this.docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombrebase() {
		return this.nombrebase;
	}

	public void setNombrebase(String nombrebase) {
		this.nombrebase = nombrebase;
	}

	public List<Consulta> getConsultas() {
		return this.consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Consulta addConsulta(Consulta consulta) {
		getConsultas().add(consulta);
		consulta.setProblema(this);

		return consulta;
	}

	public Consulta removeConsulta(Consulta consulta) {
		getConsultas().remove(consulta);
		consulta.setProblema(null);

		return consulta;
	}

	public List<Examen> getExamens() {
		return this.examens;
	}

	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}

	public Examen addExamen(Examen examen) {
		getExamens().add(examen);
		examen.setProblemaBean(this);

		return examen;
	}

	public Examen removeExamen(Examen examen) {
		getExamens().remove(examen);
		examen.setProblemaBean(null);

		return examen;
	}

	public List<Tabla> getTablas() {
		return this.tablas;
	}

	public void setTablas(List<Tabla> tablas) {
		this.tablas = tablas;
	}

	public Tabla addTabla(Tabla tabla) {
		getTablas().add(tabla);
		tabla.setProblema(this);

		return tabla;
	}

	public Tabla removeTabla(Tabla tabla) {
		getTablas().remove(tabla);
		tabla.setProblema(null);

		return tabla;
	}
}