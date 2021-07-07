/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Fajar-PC
 */
@Entity
@Table(name = "profile")
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByIdProfile", query = "SELECT p FROM Profile p WHERE p.idProfile = :idProfile"),
    @NamedQuery(name = "Profile.findByNameProfile", query = "SELECT p FROM Profile p WHERE p.nameProfile = :nameProfile"),
    @NamedQuery(name = "Profile.findByDateProfile", query = "SELECT p FROM Profile p WHERE p.dateProfile = :dateProfile"),
    @NamedQuery(name = "Profile.findByStatusProfile", query = "SELECT p FROM Profile p WHERE p.statusProfile = :statusProfile"),
    @NamedQuery(name = "Profile.findByMottoProfile", query = "SELECT p FROM Profile p WHERE p.mottoProfile = :mottoProfile")})
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_profile")
    private String idProfile;
    @Column(name = "name_profile")
    private String nameProfile;
    @Column(name = "date_profile")
    @Temporal(TemporalType.DATE)
    private Date dateProfile;
    @Column(name = "status_profile")
    private String statusProfile;
    @Lob
    @Column(name = "borrow_profile")
    private String borrowProfile;
    @Column(name = "motto_profile")
    private String mottoProfile;
    @JoinColumn(name = "id_profile", referencedColumnName = "id_auth", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Auth auth;

    public Profile() {
    }

    public Profile(String idProfile) {
        this.idProfile = idProfile;
    }

    public String getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(String idProfile) {
        this.idProfile = idProfile;
    }

    public String getNameProfile() {
        return nameProfile;
    }

    public void setNameProfile(String nameProfile) {
        this.nameProfile = nameProfile;
    }

    public Date getDateProfile() {
        return dateProfile;
    }

    public void setDateProfile(Date dateProfile) {
        this.dateProfile = dateProfile;
    }

    public String getStatusProfile() {
        return statusProfile;
    }

    public void setStatusProfile(String statusProfile) {
        this.statusProfile = statusProfile;
    }

    public String getBorrowProfile() {
        return borrowProfile;
    }

    public void setBorrowProfile(String borrowProfile) {
        this.borrowProfile = borrowProfile;
    }

    public String getMottoProfile() {
        return mottoProfile;
    }

    public void setMottoProfile(String mottoProfile) {
        this.mottoProfile = mottoProfile;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfile != null ? idProfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.idProfile == null && other.idProfile != null) || (this.idProfile != null && !this.idProfile.equals(other.idProfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Profile[ idProfile=" + idProfile + " ]";
    }
    
}
