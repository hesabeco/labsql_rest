package link.softbond.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the consulta database table.
 * 
 */
@Entity
@NamedQuery(name="Consulta.findAll", query="SELECT c FROM Consulta c")
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	private int estado;

	@Lob
	private String explicacion;

	@Lob
	private String explicsolucion;

	private int numpracticas;

	@Lob
	private String solucion;

	@Lob
	private String solucionalternativa;

	//bi-directional many-to-one association to Problema
	@ManyToOne
	@JoinColumn(name="idproblema")
	private Problema problema;

	//bi-directional many-to-one association to Finalsql
	@OneToMany(mappedBy="consulta")
	private List<Finalsql> finalsqls;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="consultaBean")
	private List<Opcion> opcions;

	//bi-directional many-to-one association to Practica
	@OneToMany(mappedBy="consulta")
	private List<Practica> practicas;

	public Consulta() {
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

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getExplicacion() {
		return this.explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	public String getExplicsolucion() {
		return this.explicsolucion;
	}

	public void setExplicsolucion(String explicsolucion) {
		this.explicsolucion = explicsolucion;
	}

	public int getNumpracticas() {
		return this.numpracticas;
	}

	public void setNumpracticas(int numpracticas) {
		this.numpracticas = numpracticas;
	}

	public String getSolucion() {
		return this.solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	public String getSolucionalternativa() {
		return this.solucionalternativa;
	}

	public void setSolucionalternativa(String solucionalternativa) {
		this.solucionalternativa = solucionalternativa;
	}

	public Problema getProblema() {
		return this.problema;
	}

	public void setProblema(Problema problema) {
		this.problema = problema;
	}

	public List<Finalsql> getFinalsqls() {
		return this.finalsqls;
	}

	public void setFinalsqls(List<Finalsql> finalsqls) {
		this.finalsqls = finalsqls;
	}

	public Finalsql addFinalsql(Finalsql finalsql) {
		getFinalsqls().add(finalsql);
		finalsql.setConsulta(this);

		return finalsql;
	}

	public Finalsql removeFinalsql(Finalsql finalsql) {
		getFinalsqls().remove(finalsql);
		finalsql.setConsulta(null);

		return finalsql;
	}

	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public Opcion addOpcion(Opcion opcion) {
		getOpcions().add(opcion);
		opcion.setConsultaBean(this);

		return opcion;
	}

	public Opcion removeOpcion(Opcion opcion) {
		getOpcions().remove(opcion);
		opcion.setConsultaBean(null);

		return opcion;
	}

	public List<Practica> getPracticas() {
		return this.practicas;
	}

	public void setPracticas(List<Practica> practicas) {
		this.practicas = practicas;
	}

	public Practica addPractica(Practica practica) {
		getPracticas().add(practica);
		practica.setConsulta(this);

		return practica;
	}

	public Practica removePractica(Practica practica) {
		getPracticas().remove(practica);
		practica.setConsulta(null);

		return practica;
	}

}