package link.softbond.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the finalsql database table.
 * 
 */
@Entity
@NamedQuery(name="Finalsql.findAll", query="SELECT f FROM Finalsql f")
public class Finalsql implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp fecha;

	@Lob
	private String resultado;

	@Lob
	private String ssql;

	private String usuario;

	//bi-directional many-to-one association to Consulta
	@ManyToOne
	@JoinColumn(name="idconsulta")
	private Consulta consulta;

	public Finalsql() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
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

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Consulta getConsulta() {
		return this.consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}