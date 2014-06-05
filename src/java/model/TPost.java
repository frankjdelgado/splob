/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marvin
 */
@Entity
@Table(name = "t_post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPost.findAll", query = "SELECT t FROM TPost t"),
    @NamedQuery(name = "TPost.findById", query = "SELECT t FROM TPost t WHERE t.id = :id"),
    @NamedQuery(name = "TPost.findByImagen", query = "SELECT t FROM TPost t WHERE t.imagen = :imagen"),
    @NamedQuery(name = "TPost.findByContenido", query = "SELECT t FROM TPost t WHERE t.contenido = :contenido"),
    @NamedQuery(name = "TPost.findByTipo", query = "SELECT t FROM TPost t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TPost.findByFechaCreacion", query = "SELECT t FROM TPost t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TPost.findByFechaCalendario", query = "SELECT t FROM TPost t WHERE t.fechaCalendario = :fechaCalendario ORDER BY t.fechaCreacion DESC"),
    @NamedQuery(name = "TPost.findByTipoOrderDesc", query = "SELECT t FROM TPost t WHERE t.tipo = :tipo ORDER BY t.fechaCreacion DESC"),
    @NamedQuery(name = "TPost.findByfindByFechaCalendarioOrderDesc", query = "SELECT t FROM TPost t WHERE t.fechaCalendario = :fechaCalendario ORDER BY t.fechaCreacion DESC"),})
public class TPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 1024)
    @Column(name = "imagen")
    private String imagen;
    @Size(max = 255)
    @Column(name = "contenido")
    private String contenido;
    @Column(name = "tipo")
    private Boolean tipo;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_calendario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCalendario;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne
    private TUsuario usuario;

    public TPost() {
    }

    public TPost(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCalendario() {
        return fechaCalendario;
    }

    public void setFechaCalendario(Date fechaCalendario) {
        this.fechaCalendario = fechaCalendario;
    }

    public TUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TUsuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof TPost)) {
            return false;
        }
        TPost other = (TPost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TPost[ id=" + id + " ]";
    }

}
