/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marvin
 */
@Entity
@Table(name = "v_post_hashtag", catalog = "ati_proyecto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VPostHashtag.findAll", query = "SELECT v FROM VPostHashtag v"),
    @NamedQuery(name = "VPostHashtag.findById", query = "SELECT v FROM VPostHashtag v WHERE v.id = :id"),
    @NamedQuery(name = "VPostHashtag.findByPostId", query = "SELECT v FROM VPostHashtag v WHERE v.postId = :postId"),
    @NamedQuery(name = "VPostHashtag.findByTitulo", query = "SELECT v FROM VPostHashtag v WHERE v.titulo = :titulo"),
    @NamedQuery(name = "VPostHashtag.findByContenido", query = "SELECT v FROM VPostHashtag v WHERE v.contenido = :contenido"),
    @NamedQuery(name = "VPostHashtag.findByTipo", query = "SELECT v FROM VPostHashtag v WHERE v.tipo = :tipo"),
    @NamedQuery(name = "VPostHashtag.findByFechaCreacion", query = "SELECT v FROM VPostHashtag v WHERE v.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "VPostHashtag.findByFechaInicio", query = "SELECT v FROM VPostHashtag v WHERE v.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "VPostHashtag.findByFechaFin", query = "SELECT v FROM VPostHashtag v WHERE v.fechaFin = :fechaFin"),
    @NamedQuery(name = "VPostHashtag.findByUsuario", query = "SELECT v FROM VPostHashtag v WHERE v.usuario = :usuario"),
    @NamedQuery(name = "VPostHashtag.findByHashId", query = "SELECT v FROM VPostHashtag v WHERE v.hashId = :hashId"),
    @NamedQuery(name = "VPostHashtag.findByHashtag", query = "SELECT v FROM VPostHashtag v WHERE v.hashtag = :hashtag")})
public class VPostHashtag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    @javax.persistence.Id
    private long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_id", nullable = false)
    private long postId;
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
    @Column(name = "usuario")
    private BigInteger usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hash_id", nullable = false)
    private long hashId;
    @Size(max = 255)
    @Column(name = "hashtag", length = 255)
    private String hashtag;

    public VPostHashtag() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
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

    public BigInteger getUsuario() {
        return usuario;
    }

    public void setUsuario(BigInteger usuario) {
        this.usuario = usuario;
    }

    public long getHashId() {
        return hashId;
    }

    public void setHashId(long hashId) {
        this.hashId = hashId;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }
    
}
