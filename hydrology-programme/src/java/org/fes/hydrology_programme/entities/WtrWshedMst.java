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
@Table(name = "WTR_WSHED_MST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrWshedMst.findAll", query = "SELECT w FROM WtrWshedMst w"),
    @NamedQuery(name = "WtrWshedMst.findByWshedNo", query = "SELECT w FROM WtrWshedMst w WHERE w.wshedNo = :wshedNo"),
    @NamedQuery(name = "WtrWshedMst.findByWshedName", query = "SELECT w FROM WtrWshedMst w WHERE w.wshedName = :wshedName"),
    @NamedQuery(name = "WtrWshedMst.findByCreateby", query = "SELECT w FROM WtrWshedMst w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrWshedMst.findByCreatedt", query = "SELECT w FROM WtrWshedMst w WHERE w.createdt = :createdt")})
public class WtrWshedMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "WSHED_NO")
    private Integer wshedNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "WSHED_NAME")
    private String wshedName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEBY")
    private int createby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plotWshedNo")
    private Collection<WtrPlotMst> wtrPlotMstCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rfallWshedNo")
    private Collection<WtrRainfallData> wtrRainfallDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wtrWshedMst")
    private Collection<WtrStreamGauge> wtrStreamGaugeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "odataWshedNo")
    private Collection<WtrObwellData> wtrObwellDataCollection;
    @JoinColumn(name = "RSO_NO", referencedColumnName = "RSO_NO")
    @ManyToOne(optional = false)
    private WtrRsoMst rsoNo;
    @JoinColumn(name = "PFA_NO", referencedColumnName = "PFA_NO")
    @ManyToOne(optional = false)
    private WtrPfaMst pfaNo;
    @JoinColumn(name = "DISTRICT_NO", referencedColumnName = "DISTRICT_NO")
    @ManyToOne(optional = false)
    private WtrDistMst districtNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memWshedNo")
    private Collection<WtrWshedMemberMst> wtrWshedMemberMstCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obwellWshedNo")
    private Collection<WtrObservWellMst> wtrObservWellMstCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soilWshedNo")
    private Collection<WtrSoilData> wtrSoilDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rgWshedNo")
    private Collection<WtrRainguageMst> wtrRainguageMstCollection;

    public WtrWshedMst() {
    }

    public WtrWshedMst(Integer wshedNo) {
        this.wshedNo = wshedNo;
    }

    public WtrWshedMst(Integer wshedNo, String wshedName, int createby, Date createdt) {
        this.wshedNo = wshedNo;
        this.wshedName = wshedName;
        this.createby = createby;
        this.createdt = createdt;
    }

    public Integer getWshedNo() {
        return wshedNo;
    }

    public void setWshedNo(Integer wshedNo) {
        this.wshedNo = wshedNo;
    }

    public String getWshedName() {
        return wshedName;
    }

    public void setWshedName(String wshedName) {
        this.wshedName = wshedName;
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
    public Collection<WtrPlotMst> getWtrPlotMstCollection() {
        return wtrPlotMstCollection;
    }

    public void setWtrPlotMstCollection(Collection<WtrPlotMst> wtrPlotMstCollection) {
        this.wtrPlotMstCollection = wtrPlotMstCollection;
    }

    @XmlTransient
    public Collection<WtrRainfallData> getWtrRainfallDataCollection() {
        return wtrRainfallDataCollection;
    }

    public void setWtrRainfallDataCollection(Collection<WtrRainfallData> wtrRainfallDataCollection) {
        this.wtrRainfallDataCollection = wtrRainfallDataCollection;
    }

    @XmlTransient
    public Collection<WtrStreamGauge> getWtrStreamGaugeCollection() {
        return wtrStreamGaugeCollection;
    }

    public void setWtrStreamGaugeCollection(Collection<WtrStreamGauge> wtrStreamGaugeCollection) {
        this.wtrStreamGaugeCollection = wtrStreamGaugeCollection;
    }

    @XmlTransient
    public Collection<WtrObwellData> getWtrObwellDataCollection() {
        return wtrObwellDataCollection;
    }

    public void setWtrObwellDataCollection(Collection<WtrObwellData> wtrObwellDataCollection) {
        this.wtrObwellDataCollection = wtrObwellDataCollection;
    }

    public WtrRsoMst getRsoNo() {
        return rsoNo;
    }

    public void setRsoNo(WtrRsoMst rsoNo) {
        this.rsoNo = rsoNo;
    }

    public WtrPfaMst getPfaNo() {
        return pfaNo;
    }

    public void setPfaNo(WtrPfaMst pfaNo) {
        this.pfaNo = pfaNo;
    }

    public WtrDistMst getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(WtrDistMst districtNo) {
        this.districtNo = districtNo;
    }

    @XmlTransient
    public Collection<WtrWshedMemberMst> getWtrWshedMemberMstCollection() {
        return wtrWshedMemberMstCollection;
    }

    public void setWtrWshedMemberMstCollection(Collection<WtrWshedMemberMst> wtrWshedMemberMstCollection) {
        this.wtrWshedMemberMstCollection = wtrWshedMemberMstCollection;
    }

    @XmlTransient
    public Collection<WtrObservWellMst> getWtrObservWellMstCollection() {
        return wtrObservWellMstCollection;
    }

    public void setWtrObservWellMstCollection(Collection<WtrObservWellMst> wtrObservWellMstCollection) {
        this.wtrObservWellMstCollection = wtrObservWellMstCollection;
    }

    @XmlTransient
    public Collection<WtrSoilData> getWtrSoilDataCollection() {
        return wtrSoilDataCollection;
    }

    public void setWtrSoilDataCollection(Collection<WtrSoilData> wtrSoilDataCollection) {
        this.wtrSoilDataCollection = wtrSoilDataCollection;
    }

    @XmlTransient
    public Collection<WtrRainguageMst> getWtrRainguageMstCollection() {
        return wtrRainguageMstCollection;
    }

    public void setWtrRainguageMstCollection(Collection<WtrRainguageMst> wtrRainguageMstCollection) {
        this.wtrRainguageMstCollection = wtrRainguageMstCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wshedNo != null ? wshedNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrWshedMst)) {
            return false;
        }
        WtrWshedMst other = (WtrWshedMst) object;
        if ((this.wshedNo == null && other.wshedNo != null) || (this.wshedNo != null && !this.wshedNo.equals(other.wshedNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrWshedMst[ wshedNo=" + wshedNo + " ]";
    }
    
}
