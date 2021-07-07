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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Fajar-PC
 */
@Entity
@Table(name = "archive")
@NamedQueries({
    @NamedQuery(name = "Archive.findAll", query = "SELECT a FROM Archive a"),
    @NamedQuery(name = "Archive.findByIdArchive", query = "SELECT a FROM Archive a WHERE a.idArchive = :idArchive"),
    @NamedQuery(name = "Archive.findByNameArchive", query = "SELECT a FROM Archive a WHERE a.nameArchive = :nameArchive"),
    @NamedQuery(name = "Archive.findByDateArchive", query = "SELECT a FROM Archive a WHERE a.dateArchive = :dateArchive"),
    @NamedQuery(name = "Archive.findByThemeArchive", query = "SELECT a FROM Archive a WHERE a.themeArchive = :themeArchive")})
public class Archive implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_archive")
    private String idArchive;
    @Column(name = "name_archive")
    private String nameArchive;
    @Column(name = "date_archive")
    @Temporal(TemporalType.DATE)
    private Date dateArchive;
    @Column(name = "theme_archive")
    private String themeArchive;
    @Lob
    @Column(name = "bulk_archive")
    private String bulkArchive;

    public Archive() {
    }

    public Archive(String idArchive) {
        this.idArchive = idArchive;
    }

    public String getIdArchive() {
        return idArchive;
    }

    public void setIdArchive(String idArchive) {
        this.idArchive = idArchive;
    }

    public String getNameArchive() {
        return nameArchive;
    }

    public void setNameArchive(String nameArchive) {
        this.nameArchive = nameArchive;
    }

    public Date getDateArchive() {
        return dateArchive;
    }

    public void setDateArchive(Date dateArchive) {
        this.dateArchive = dateArchive;
    }

    public String getThemeArchive() {
        return themeArchive;
    }

    public void setThemeArchive(String themeArchive) {
        this.themeArchive = themeArchive;
    }

    public String getBulkArchive() {
        return bulkArchive;
    }

    public void setBulkArchive(String bulkArchive) {
        this.bulkArchive = bulkArchive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArchive != null ? idArchive.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archive)) {
            return false;
        }
        Archive other = (Archive) object;
        if ((this.idArchive == null && other.idArchive != null) || (this.idArchive != null && !this.idArchive.equals(other.idArchive))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Archive[ idArchive=" + idArchive + " ]";
    }
    
}
