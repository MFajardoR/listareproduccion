/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.M5A.listaReproduccion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marco
 */
@Entity
@Table(name = "listamusicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listamusicas.findAll", query = "SELECT l FROM Listamusicas l"),
    @NamedQuery(name = "Listamusicas.findByIdlistamusicas", query = "SELECT l FROM Listamusicas l WHERE l.idlistamusicas = :idlistamusicas"),
    @NamedQuery(name = "Listamusicas.findByNombre", query = "SELECT l FROM Listamusicas l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Listamusicas.findByDescripcion", query = "SELECT l FROM Listamusicas l WHERE l.descripcion = :descripcion")})
public class Listamusicas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlistamusicas")
    private Long idlistamusicas;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JsonIgnore
    @OneToMany(mappedBy = "idlista")
    private List<Cancion> cancionList;

    public Listamusicas() {
    }

    public Listamusicas(Long idlistamusicas) {
        this.idlistamusicas = idlistamusicas;
    }

    public Long getIdlistamusicas() {
        return idlistamusicas;
    }

    public void setIdlistamusicas(Long idlistamusicas) {
        this.idlistamusicas = idlistamusicas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Cancion> getCancionList() {
        return cancionList;
    }

    public void setCancionList(List<Cancion> cancionList) {
        this.cancionList = cancionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlistamusicas != null ? idlistamusicas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listamusicas)) {
            return false;
        }
        Listamusicas other = (Listamusicas) object;
        if ((this.idlistamusicas == null && other.idlistamusicas != null) || (this.idlistamusicas != null && !this.idlistamusicas.equals(other.idlistamusicas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.M5A.listaReproduccion.model.Listamusicas[ idlistamusicas=" + idlistamusicas + " ]";
    }
    
}
