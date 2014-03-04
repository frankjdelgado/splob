/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marvin
 */
@Entity
@Table(name = "t_post", catalog = "ati_proyecto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPost.findAll", query = "SELECT t FROM TPost t"),
    @NamedQuery(name = "TPost.findById", query = "SELECT t FROM TPost t WHERE t.id = :id"),
    @NamedQuery(name = "TPost.findByTitulo", query = "SELECT t FROM TPost t WHERE t.titulo = :titulo"),
    @NamedQuery(name = "TPost.findByContenido", query = "SELECT t FROM TPost t WHERE t.contenido = :contenido"),
    @NamedQuery(name = "TPost.findByTipo", query = "SELECT t FROM TPost t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TPost.findByFechaCreacion", query = "SELECT t FROM TPost t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TPost.findByFechaInicio", query = "SELECT t FROM TPost t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "TPost.findByFechaFin", query = "SELECT t FROM TPost t WHERE t.fechaFin = :fechaFin")})
public class TPost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "titulo", length = 255)
    private String titulo;
    @Size(max = 255)
    @Column(name = "contenido", length = 255)
    private String contenido;
    @Column(name = "tipo")
    private Boolean tipo;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @OneToMany(mappedBy = "post")
    private Collection<TPostCategoria> tPostCategoriaCollection;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public Collection<TPostCategoria> getTPostCategoriaCollection() {
        return tPostCategoriaCollection;
    }

    public void setTPostCategoriaCollection(Collection<TPostCategoria> tPostCategoriaCollection) {
        this.tPostCategoriaCollection = tPostCategoriaCollection;
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
