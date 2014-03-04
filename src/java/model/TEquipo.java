/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
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
 * @author Marvin
 */
@Entity
@Table(name = "t_equipo", catalog = "ati_proyecto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TEquipo.findAll", query = "SELECT t FROM TEquipo t"),
    @NamedQuery(name = "TEquipo.findById", query = "SELECT t FROM TEquipo t WHERE t.id = :id"),
    @NamedQuery(name = "TEquipo.findByNombre", query = "SELECT t FROM TEquipo t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TEquipo.findByPais", query = "SELECT t FROM TEquipo t WHERE t.pais = :pais")})
public class TEquipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "nombre", length = 255)
    private String nombre;
    @Size(max = 200)
    @Column(name = "pais", length = 200)
    private String pais;
    @OneToMany(mappedBy = "equipo")
    private Collection<TUsuarioEquipo> tUsuarioEquipoCollection;

    public TEquipo() {
    }

    public TEquipo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @XmlTransient
    public Collection<TUsuarioEquipo> getTUsuarioEquipoCollection() {
        return tUsuarioEquipoCollection;
    }

    public void setTUsuarioEquipoCollection(Collection<TUsuarioEquipo> tUsuarioEquipoCollection) {
        this.tUsuarioEquipoCollection = tUsuarioEquipoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEquipo)) {
            return false;
        }
        TEquipo other = (TEquipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TEquipo[ id=" + id + " ]";
    }
    
}
