/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jitesh
 */
@Entity
@Table(name = "WTR_RSO_MST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrRsoMst.findAll", query = "SELECT w FROM WtrRsoMst w"),
    @NamedQuery(name = "WtrRsoMst.findByRsoNo", query = "SELECT w FROM WtrRsoMst w WHERE w.rsoNo = :rsoNo"),
    @NamedQuery(name = "WtrRsoMst.findByRsoName", query = "SELECT w FROM WtrRsoMst w WHERE w.rsoName = :rsoName"),
    @NamedQuery(name = "WtrRsoMst.findByCreateby", query = "SELECT w FROM WtrRsoMst w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrRsoMst.findByCreatedt", query = "SELECT w FROM WtrRsoMst w WHERE w.createdt = :createdt")})
public class WtrRsoMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RSO_NO")
    private Integer rsoNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RSO_NAME")
    private String rsoName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEBY")
    private int createby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rsoNo")
    private Collection<WtrPfaMst> wtrPfaMstCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rsoNo")
    private Collection<WtrWshedMst> wtrWshedMstCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rsoNo")
    private Collection<WtrDistMst> wtrDistMstCollection;

    public WtrRsoMst() {
    }

    public WtrRsoMst(Integer rsoNo) {
        this.rsoNo = rsoNo;
    }

    public WtrRsoMst(Integer rsoNo, String rsoName, int createby, Date createdt) {
        this.rsoNo = rsoNo;
        this.rsoName = rsoName;
        this.createby = createby;
        this.createdt = createdt;
    }

    public Integer getRsoNo() {
        return rsoNo;
    }

    public void setRsoNo(Integer rsoNo) {
        this.rsoNo = rsoNo;
    }

    public String getRsoName() {
        return rsoName;
    }

    public void setRsoName(String rsoName) {
        this.rsoName = rsoName;
    }

    public int getCreateby() {
        return createby;
    }

    public void setCreateby(int createby) {
        this.createby = createby;
    }

    public Date getCreatedt() {
        return createdt;
    }

    public void setCreatedt(Date createdt) {
        this.createdt = createdt;
    }

    @XmlTransient
    public Collection<WtrPfaMst> getWtrPfaMstCollection() {
        return wtrPfaMstCollection;
    }

    public void setWtrPfaMstCollection(Collection<WtrPfaMst> wtrPfaMstCollection) {
        this.wtrPfaMstCollection = wtrPfaMstCollection;
    }

    @XmlTransient
    public Collection<WtrWshedMst> getWtrWshedMstCollection() {
        return wtrWshedMstCollection;
    }

    public void setWtrWshedMstCollection(Collection<WtrWshedMst> wtrWshedMstCollection) {
        this.wtrWshedMstCollection = wtrWshedMstCollection;
    }

    @XmlTransient
    public Collection<WtrDistMst> getWtrDistMstCollection() {
        return wtrDistMstCollection;
    }

    public void setWtrDistMstCollection(Collection<WtrDistMst> wtrDistMstCollection) {
        this.wtrDistMstCollection = wtrDistMstCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rsoNo != null ? rsoNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrRsoMst)) {
            return false;
        }
        WtrRsoMst other = (WtrRsoMst) object;
        if ((this.rsoNo == null && other.rsoNo != null) || (this.rsoNo != null && !this.rsoNo.equals(other.rsoNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrRsoMst[ rsoNo=" + rsoNo + " ]";
    }
    
}
