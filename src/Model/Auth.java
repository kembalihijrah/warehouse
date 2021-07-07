/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Fajar-PC
 */
@Entity
@Table(name = "auth")
@NamedQueries({
    @NamedQuery(name = "Auth.findAll", query = "SELECT a FROM Auth a"),
    @NamedQuery(name = "Auth.findByIdAuth", query = "SELECT a FROM Auth a WHERE a.idAuth = :idAuth"),
    @NamedQuery(name = "Auth.findByUsernameAuth", query = "SELECT a FROM Auth a WHERE a.usernameAuth = :usernameAuth"),
    @NamedQuery(name = "Auth.findByPasswordAuth", query = "SELECT a FROM Auth a WHERE a.passwordAuth = :passwordAuth")})
public class Auth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_auth")
    private String idAuth;
    @Column(name = "username_auth")
    private String usernameAuth;
    @Column(name = "password_auth")
    private String passwordAuth;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "auth")
    private Profile profile;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "auth")
    private Query query;

    public Auth() {
    }

    public Auth(String idAuth) {
        this.idAuth = idAuth;
    }

    public String getIdAuth() {
        return idAuth;
    }

    public void setIdAuth(String idAuth) {
        this.idAuth = idAuth;
    }

    public String getUsernameAuth() {
        return usernameAuth;
    }

    public void setUsernameAuth(String usernameAuth) {
        this.usernameAuth = usernameAuth;
    }

    public String getPasswordAuth() {
        return passwordAuth;
    }

    public void setPasswordAuth(String passwordAuth) {
        this.passwordAuth = passwordAuth;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuth != null ? idAuth.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auth)) {
            return false;
        }
        Auth other = (Auth) object;
        if ((this.idAuth == null && other.idAuth != null) || (this.idAuth != null && !this.idAuth.equals(other.idAuth))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Auth[ idAuth=" + idAuth + " ]";
    }
    
}
