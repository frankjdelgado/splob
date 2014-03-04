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
@Table(name = "t_categoria", catalog = "ati_proyecto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCategoria.findAll", query = "SELECT t FROM TCategoria t"),
    @NamedQuery(name = "TCategoria.findById", query = "SELECT t FROM TCategoria t WHERE t.id = :id"),
    @NamedQuery(name = "TCategoria.findByHashtag", query = "SELECT t FROM TCategoria t WHERE t.hashtag = :hashtag")})
public class TCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "hashtag", length = 255)
    private String hashtag;
    @OneToMany(mappedBy = "categoria")
    private Collection<TPostCategoria> tPostCategoriaCollection;

    public TCategoria() {
    }

    public TCategoria(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    @XmlTransient
    public Collection<TPostCategoria> getTPostCategoriaCollection() {
        return tPostCategoriaCollection;
    }

    public void setTPostCategoriaCollection(Collection<TPostCategoria> tPostCategoriaCollection) {
        this.tPostCategoriaCollection = tPostCategoriaCollection;
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
        if (!(object instanceof TCategoria)) {
            return false;
        }
        TCategoria other = (TCategoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TCategoria[ id=" + id + " ]";
    }
    
}
