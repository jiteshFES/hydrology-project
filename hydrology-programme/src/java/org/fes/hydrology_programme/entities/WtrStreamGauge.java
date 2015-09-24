/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jitesh
 */
@Entity
@Table(name = "WTR_STREAM_GAUGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrStreamGauge.findAll", query = "SELECT w FROM WtrStreamGauge w"),
    @NamedQuery(name = "WtrStreamGauge.findByStrSrno", query = "SELECT w FROM WtrStreamGauge w WHERE w.wtrStreamGaugePK.strSrno = :strSrno"),
    @NamedQuery(name = "WtrStreamGauge.findByStrWshedNo", query = "SELECT w FROM WtrStreamGauge w WHERE w.wtrStreamGaugePK.strWshedNo = :strWshedNo"),
    @NamedQuery(name = "WtrStreamGauge.findByStrName", query = "SELECT w FROM WtrStreamGauge w WHERE w.strName = :strName"),
    @NamedQuery(name = "WtrStreamGauge.findByStrCheckdamHeight", query = "SELECT w FROM WtrStreamGauge w WHERE w.strCheckdamHeight = :strCheckdamHeight"),
    @NamedQuery(name = "WtrStreamGauge.findByStrFillingLevel", query = "SELECT w FROM WtrStreamGauge w WHERE w.strFillingLevel = :strFillingLevel"),
    @NamedQuery(name = "WtrStreamGauge.findByStrDamLength", query = "SELECT w FROM WtrStreamGauge w WHERE w.strDamLength = :strDamLength"),
    @NamedQuery(name = "WtrStreamGauge.findByStrLocation", query = "SELECT w FROM WtrStreamGauge w WHERE w.strLocation = :strLocation"),
    @NamedQuery(name = "WtrStreamGauge.findByStrGpsn", query = "SELECT w FROM WtrStreamGauge w WHERE w.strGpsn = :strGpsn"),
    @NamedQuery(name = "WtrStreamGauge.findByStrGpse", query = "SELECT w FROM WtrStreamGauge w WHERE w.strGpse = :strGpse"),
    @NamedQuery(name = "WtrStreamGauge.findByStrElevation", query = "SELECT w FROM WtrStreamGauge w WHERE w.strElevation = :strElevation"),
    @NamedQuery(name = "WtrStreamGauge.findByCreateby", query = "SELECT w FROM WtrStreamGauge w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrStreamGauge.findByCreatedt", query = "SELECT w FROM WtrStreamGauge w WHERE w.createdt = :createdt")})
public class WtrStreamGauge implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WtrStreamGaugePK wtrStreamGaugePK;
    @Size(max = 100)
    @Column(name = "STR_NAME")
    private String strName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "STR_CHECKDAM_HEIGHT")
    private BigDecimal strCheckdamHeight;
    @Column(name = "STR_FILLING_LEVEL")
    private BigDecimal strFillingLevel;
    @Column(name = "STR_DAM_LENGTH")
    private BigDecimal strDamLength;
    @Size(max = 100)
    @Column(name = "STR_LOCATION")
    private String strLocation;
    @Size(max = 20)
    @Column(name = "STR_GPSN")
    private String strGpsn;
    @Size(max = 20)
    @Column(name = "STR_GPSE")
    private String strGpse;
    @Column(name = "STR_ELEVATION")
    private BigDecimal strElevation;
    @Column(name = "CREATEBY")
    private Integer createby;
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @JoinColumn(name = "STR_WSHED_NO", referencedColumnName = "WSHED_NO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WtrWshedMst wtrWshedMst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wtrStreamGauge")
    private Collection<WtrStreamData> wtrStreamDataCollection;

    public WtrStreamGauge() {
    }

    public WtrStreamGauge(WtrStreamGaugePK wtrStreamGaugePK) {
        this.wtrStreamGaugePK = wtrStreamGaugePK;
    }

    public WtrStreamGauge(int strSrno, int strWshedNo) {
        this.wtrStreamGaugePK = new WtrStreamGaugePK(strSrno, strWshedNo);
    }

    public WtrStreamGaugePK getWtrStreamGaugePK() {
        return wtrStreamGaugePK;
    }

    public void setWtrStreamGaugePK(WtrStreamGaugePK wtrStreamGaugePK) {
        this.wtrStreamGaugePK = wtrStreamGaugePK;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public BigDecimal getStrCheckdamHeight() {
        return strCheckdamHeight;
    }

    public void setStrCheckdamHeight(BigDecimal strCheckdamHeight) {
        this.strCheckdamHeight = strCheckdamHeight;
    }

    public BigDecimal getStrFillingLevel() {
        return strFillingLevel;
    }

    public void setStrFillingLevel(BigDecimal strFillingLevel) {
        this.strFillingLevel = strFillingLevel;
    }

    public BigDecimal getStrDamLength() {
        return strDamLength;
    }

    public void setStrDamLength(BigDecimal strDamLength) {
        this.strDamLength = strDamLength;
    }

    public String getStrLocation() {
        return strLocation;
    }

    public void setStrLocation(String strLocation) {
        this.strLocation = strLocation;
    }

    public String getStrGpsn() {
        return strGpsn;
    }

    public void setStrGpsn(String strGpsn) {
        this.strGpsn = strGpsn;
    }

    public String getStrGpse() {
        return strGpse;
    }

    public void setStrGpse(String strGpse) {
        this.strGpse = strGpse;
    }

    public BigDecimal getStrElevation() {
        return strElevation;
    }

    public void setStrElevation(BigDecimal strElevation) {
        this.strElevation = strElevation;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Date getCreatedt() {
        return createdt;
    }

    public void setCreatedt(Date createdt) {
        this.createdt = createdt;
    }

    public WtrWshedMst getWtrWshedMst() {
        return wtrWshedMst;
    }

    public void setWtrWshedMst(WtrWshedMst wtrWshedMst) {
        this.wtrWshedMst = wtrWshedMst;
    }

    @XmlTransient
    public Collection<WtrStreamData> getWtrStreamDataCollection() {
        return wtrStreamDataCollection;
    }

    public void setWtrStreamDataCollection(Collection<WtrStreamData> wtrStreamDataCollection) {
        this.wtrStreamDataCollection = wtrStreamDataCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wtrStreamGaugePK != null ? wtrStreamGaugePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrStreamGauge)) {
            return false;
        }
        WtrStreamGauge other = (WtrStreamGauge) object;
        if ((this.wtrStreamGaugePK == null && other.wtrStreamGaugePK != null) || (this.wtrStreamGaugePK != null && !this.wtrStreamGaugePK.equals(other.wtrStreamGaugePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrStreamGauge[ wtrStreamGaugePK=" + wtrStreamGaugePK + " ]";
    }
    
}
