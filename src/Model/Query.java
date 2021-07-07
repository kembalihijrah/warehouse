/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Fajar-PC
 */
@Entity
@Table(name = "query")
@NamedQueries({
    @NamedQuery(name = "Query.findAll", query = "SELECT q FROM Query q"),
    @NamedQuery(name = "Query.findByIdQuery", query = "SELECT q FROM Query q WHERE q.idQuery = :idQuery"),
    @NamedQuery(name = "Query.findByNameQuery", query = "SELECT q FROM Query q WHERE q.nameQuery = :nameQuery")})
public class Query implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_query")
    private String idQuery;
    @Column(name = "name_query")
    private String nameQuery;
    @JoinColumn(name = "id_query", referencedColumnName = "id_auth", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Auth auth;

    public Query() {
    }

    public Query(String idQuery) {
        this.idQuery = idQuery;
    }

    public String getIdQuery() {
        return idQuery;
    }

    public void setIdQuery(String idQuery) {
        this.idQuery = idQuery;
    }

    public String getNameQuery() {
        return nameQuery;
    }

    public void setNameQuery(String nameQuery) {
        this.nameQuery = nameQuery;
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
        hash += (idQuery != null ? idQuery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Query)) {
            return false;
        }
        Query other = (Query) object;
        if ((this.idQuery == null && other.idQuery != null) || (this.idQuery != null && !this.idQuery.equals(other.idQuery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Query[ idQuery=" + idQuery + " ]";
    }
    
}
