package link.softbond.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the practica database table.
 * 
 */
@Entity
@NamedQuery(name="Practica.findAll", query="SELECT p FROM Practica p")
public class Practica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer estado;

	private Timestamp fecha;

	private String ip;

	@Lob
	private String resultado;

	@Lob
	private String ssql;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	//bi-directional many-to-one association to Consulta
	@ManyToOne
	@JoinColumn(name="idconsulta")
	private Consulta consulta;

	public Practica() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getSsql() {
		return this.ssql;
	}

	public void setSsql(String ssql) {
		this.ssql = ssql;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public Consulta getConsulta() {
		return this.consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}