package link.softbond.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "problema")
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "docente", length = 50)
    private String docente;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "nombrebase", length = 50, columnDefinition = "VARCHAR(50) COMMENT 'Almacena el nombre en la base de datos de MySQL'")
    private String nombreBase;
}