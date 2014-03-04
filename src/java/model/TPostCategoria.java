/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marvin
 */
@Entity
@Table(name = "t_post_categoria", catalog = "ati_proyecto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPostCategoria.findAll", query = "SELECT t FROM TPostCategoria t"),
    @NamedQuery(name = "TPostCategoria.findById", query = "SELECT t FROM TPostCategoria t WHERE t.id = :id")})
public class TPostCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @JoinColumn(name = "post", referencedColumnName = "id")
    @ManyToOne
    private TPost post;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne
    private TCategoria categoria;

    public TPostCategoria() {
    }

    public TPostCategoria(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TPost getPost() {
        return post;
    }

    public void setPost(TPost post) {
        this.post = post;
    }

    public TCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(TCategoria categoria) {
        this.categoria = categoria;
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
        if (!(object instanceof TPostCategoria)) {
            return false;
        }
        TPostCategoria other = (TPostCategoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TPostCategoria[ id=" + id + " ]";
    }
    
}
