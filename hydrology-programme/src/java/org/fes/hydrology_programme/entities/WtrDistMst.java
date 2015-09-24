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
@Table(name = "WTR_DIST_MST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrDistMst.findAll", query = "SELECT w FROM WtrDistMst w"),
    @NamedQuery(name = "WtrDistMst.findByDistrictNo", query = "SELECT w FROM WtrDistMst w WHERE w.districtNo = :districtNo"),
    @NamedQuery(name = "WtrDistMst.findByDistrictName", query = "SELECT w FROM WtrDistMst w WHERE w.districtName = :districtName"),
    @NamedQuery(name = "WtrDistMst.findByCreateby", query = "SELECT w FROM WtrDistMst w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrDistMst.findByCreatedt", query = "SELECT w FROM WtrDistMst w WHERE w.createdt = :createdt")})
public class WtrDistMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISTRICT_NO")
    private Integer districtNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DISTRICT_NAME")
    private String districtName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEBY")
    private int createby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtNo")
    private Collection<WtrPfaMst> wtrPfaMstCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtNo")
    private Collection<WtrWshedMst> wtrWshedMstCollection;
    @JoinColumn(name = "RSO_NO", referencedColumnName = "RSO_NO")
    @ManyToOne(optional = false)
    private WtrRsoMst rsoNo;

    public WtrDistMst() {
    }

    public WtrDistMst(Integer districtNo) {
        this.districtNo = districtNo;
    }

    public WtrDistMst(Integer districtNo, String districtName, int createby, Date createdt) {
        this.districtNo = districtNo;
        this.districtName = districtName;
        this.createby = createby;
        this.createdt = createdt;
    }

    public Integer getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(Integer districtNo) {
        this.districtNo = districtNo;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
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

    public WtrRsoMst getRsoNo() {
        return rsoNo;
    }

    public void setRsoNo(WtrRsoMst rsoNo) {
        this.rsoNo = rsoNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtNo != null ? districtNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrDistMst)) {
            return false;
        }
        WtrDistMst other = (WtrDistMst) object;
        if ((this.districtNo == null && other.districtNo != null) || (this.districtNo != null && !this.districtNo.equals(other.districtNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrDistMst[ districtNo=" + districtNo + " ]";
    }
    
}
