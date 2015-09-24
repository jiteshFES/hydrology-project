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
@Table(name = "WTR_PFA_MST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrPfaMst.findAll", query = "SELECT w FROM WtrPfaMst w"),
    @NamedQuery(name = "WtrPfaMst.findByPfaNo", query = "SELECT w FROM WtrPfaMst w WHERE w.pfaNo = :pfaNo"),
    @NamedQuery(name = "WtrPfaMst.findByPfaName", query = "SELECT w FROM WtrPfaMst w WHERE w.pfaName = :pfaName"),
    @NamedQuery(name = "WtrPfaMst.findByCreateby", query = "SELECT w FROM WtrPfaMst w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrPfaMst.findByCreatedt", query = "SELECT w FROM WtrPfaMst w WHERE w.createdt = :createdt")})
public class WtrPfaMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PFA_NO")
    private Integer pfaNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PFA_NAME")
    private String pfaName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEBY")
    private int createby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @JoinColumn(name = "RSO_NO", referencedColumnName = "RSO_NO")
    @ManyToOne(optional = false)
    private WtrRsoMst rsoNo;
    @JoinColumn(name = "DISTRICT_NO", referencedColumnName = "DISTRICT_NO")
    @ManyToOne(optional = false)
    private WtrDistMst districtNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pfaNo")
    private Collection<WtrWshedMst> wtrWshedMstCollection;
    @OneToMany(mappedBy = "pfaRsoNumber")
    private Collection<WtrUserMst> wtrUserMstCollection;

    public WtrPfaMst() {
    }

    public WtrPfaMst(Integer pfaNo) {
        this.pfaNo = pfaNo;
    }

    public WtrPfaMst(Integer pfaNo, String pfaName, int createby, Date createdt) {
        this.pfaNo = pfaNo;
        this.pfaName = pfaName;
        this.createby = createby;
        this.createdt = createdt;
    }

    public Integer getPfaNo() {
        return pfaNo;
    }

    public void setPfaNo(Integer pfaNo) {
        this.pfaNo = pfaNo;
    }

    public String getPfaName() {
        return pfaName;
    }

    public void setPfaName(String pfaName) {
        this.pfaName = pfaName;
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

    public WtrRsoMst getRsoNo() {
        return rsoNo;
    }

    public void setRsoNo(WtrRsoMst rsoNo) {
        this.rsoNo = rsoNo;
    }

    public WtrDistMst getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(WtrDistMst districtNo) {
        this.districtNo = districtNo;
    }

    @XmlTransient
    public Collection<WtrWshedMst> getWtrWshedMstCollection() {
        return wtrWshedMstCollection;
    }

    public void setWtrWshedMstCollection(Collection<WtrWshedMst> wtrWshedMstCollection) {
        this.wtrWshedMstCollection = wtrWshedMstCollection;
    }

    @XmlTransient
    public Collection<WtrUserMst> getWtrUserMstCollection() {
        return wtrUserMstCollection;
    }

    public void setWtrUserMstCollection(Collection<WtrUserMst> wtrUserMstCollection) {
        this.wtrUserMstCollection = wtrUserMstCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pfaNo != null ? pfaNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrPfaMst)) {
            return false;
        }
        WtrPfaMst other = (WtrPfaMst) object;
        if ((this.pfaNo == null && other.pfaNo != null) || (this.pfaNo != null && !this.pfaNo.equals(other.pfaNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrPfaMst[ pfaNo=" + pfaNo + " ]";
    }
    
}
