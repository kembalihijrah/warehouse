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
@Table(name = "document")
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d"),
    @NamedQuery(name = "Document.findByIdDocument", query = "SELECT d FROM Document d WHERE d.idDocument = :idDocument"),
    @NamedQuery(name = "Document.findByNameDocument", query = "SELECT d FROM Document d WHERE d.nameDocument = :nameDocument"),
    @NamedQuery(name = "Document.findByDateDocument", query = "SELECT d FROM Document d WHERE d.dateDocument = :dateDocument"),
    @NamedQuery(name = "Document.findByThemeDocument", query = "SELECT d FROM Document d WHERE d.themeDocument = :themeDocument")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_document")
    private String idDocument;
    @Column(name = "name_document")
    private String nameDocument;
    @Column(name = "date_document")
    @Temporal(TemporalType.DATE)
    private Date dateDocument;
    @Column(name = "theme_document")
    private String themeDocument;
    @Lob
    @Column(name = "bulk_document")
    private String bulkDocument;

    public Document() {
    }

    public Document(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getNameDocument() {
        return nameDocument;
    }

    public void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    public Date getDateDocument() {
        return dateDocument;
    }

    public void setDateDocument(Date dateDocument) {
        this.dateDocument = dateDocument;
    }

    public String getThemeDocument() {
        return themeDocument;
    }

    public void setThemeDocument(String themeDocument) {
        this.themeDocument = themeDocument;
    }

    public String getBulkDocument() {
        return bulkDocument;
    }

    public void setBulkDocument(String bulkDocument) {
        this.bulkDocument = bulkDocument;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocument != null ? idDocument.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.idDocument == null && other.idDocument != null) || (this.idDocument != null && !this.idDocument.equals(other.idDocument))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Document[ idDocument=" + idDocument + " ]";
    }
    
}
