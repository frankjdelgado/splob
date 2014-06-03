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
@Table(name = "t_usuario", catalog = "ati_proyecto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUsuario.findAll", query = "SELECT t FROM TUsuario t"),
    @NamedQuery(name = "TUsuario.findById", query = "SELECT t FROM TUsuario t WHERE t.id = :id"),
    @NamedQuery(name = "TUsuario.findByAlias", query = "SELECT t FROM TUsuario t WHERE t.alias = :alias"),
    @NamedQuery(name = "TUsuario.findByPassword", query = "SELECT t FROM TUsuario t WHERE t.password = :password"),
    @NamedQuery(name = "TUsuario.findByEmail", query = "SELECT t FROM TUsuario t WHERE t.email = :email")})
public class TUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 64)
    @Column(name = "alias", length = 64)
    private String alias;
    @Size(max = 64)
    @Column(name = "password", length = 64)
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email", length = 255)
    private String email;
    @OneToMany(mappedBy = "usuario")
    private Collection<TUsuarioEquipo> tUsuarioEquipoCollection;
    @OneToMany(mappedBy = "usuario")
    private Collection<TPost> tPostCollection;

    public TUsuario() {
    }

    public TUsuario(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<TUsuarioEquipo> getTUsuarioEquipoCollection() {
        return tUsuarioEquipoCollection;
    }

    public void setTUsuarioEquipoCollection(Collection<TUsuarioEquipo> tUsuarioEquipoCollection) {
        this.tUsuarioEquipoCollection = tUsuarioEquipoCollection;
    }

    @XmlTransient
    public Collection<TPost> getTPostCollection() {
        return tPostCollection;
    }

    public void setTPostCollection(Collection<TPost> tPostCollection) {
        this.tPostCollection = tPostCollection;
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
        if (!(object instanceof TUsuario)) {
            return false;
        }
        TUsuario other = (TUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TUsuario[ id=" + id + ", alias="+ alias + ", email="+ email + " ]";
    }
    
}
