/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jitesh
 */
@Entity
@Table(name = "WTR_STREAM_DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrStreamData.findAll", query = "SELECT w FROM WtrStreamData w"),
    @NamedQuery(name = "WtrStreamData.findByStrSrno", query = "SELECT w FROM WtrStreamData w WHERE w.wtrStreamDataPK.strSrno = :strSrno"),
    @NamedQuery(name = "WtrStreamData.findByStrWshedNo", query = "SELECT w FROM WtrStreamData w WHERE w.wtrStreamDataPK.strWshedNo = :strWshedNo"),
    @NamedQuery(name = "WtrStreamData.findByStrDate", query = "SELECT w FROM WtrStreamData w WHERE w.wtrStreamDataPK.strDate = :strDate"),
    @NamedQuery(name = "WtrStreamData.findByStrInCm", query = "SELECT w FROM WtrStreamData w WHERE w.strInCm = :strInCm"),
    @NamedQuery(name = "WtrStreamData.findByCreateby", query = "SELECT w FROM WtrStreamData w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrStreamData.findByCreatedt", query = "SELECT w FROM WtrStreamData w WHERE w.createdt = :createdt")})
public class WtrStreamData implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WtrStreamDataPK wtrStreamDataPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "STR_IN_CM")
    private BigDecimal strInCm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEBY")
    private int createby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @JoinColumns({
        @JoinColumn(name = "STR_WSHED_NO", referencedColumnName = "STR_WSHED_NO", insertable = false, updatable = false),
        @JoinColumn(name = "STR_SRNO", referencedColumnName = "STR_SRNO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private WtrStreamGauge wtrStreamGauge;

    public WtrStreamData() {
    }

    public WtrStreamData(WtrStreamDataPK wtrStreamDataPK) {
        this.wtrStreamDataPK = wtrStreamDataPK;
    }

    public WtrStreamData(WtrStreamDataPK wtrStreamDataPK, int createby, Date createdt) {
        this.wtrStreamDataPK = wtrStreamDataPK;
        this.createby = createby;
        this.createdt = createdt;
    }

    public WtrStreamData(int strSrno, int strWshedNo, Date strDate) {
        this.wtrStreamDataPK = new WtrStreamDataPK(strSrno, strWshedNo, strDate);
    }

    public WtrStreamDataPK getWtrStreamDataPK() {
        return wtrStreamDataPK;
    }

    public void setWtrStreamDataPK(WtrStreamDataPK wtrStreamDataPK) {
        this.wtrStreamDataPK = wtrStreamDataPK;
    }

    public BigDecimal getStrInCm() {
        return strInCm;
    }

    public void setStrInCm(BigDecimal strInCm) {
        this.strInCm = strInCm;
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

    public WtrStreamGauge getWtrStreamGauge() {
        return wtrStreamGauge;
    }

    public void setWtrStreamGauge(WtrStreamGauge wtrStreamGauge) {
        this.wtrStreamGauge = wtrStreamGauge;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wtrStreamDataPK != null ? wtrStreamDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrStreamData)) {
            return false;
        }
        WtrStreamData other = (WtrStreamData) object;
        if ((this.wtrStreamDataPK == null && other.wtrStreamDataPK != null) || (this.wtrStreamDataPK != null && !this.wtrStreamDataPK.equals(other.wtrStreamDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrStreamData[ wtrStreamDataPK=" + wtrStreamDataPK + " ]";
    }
    
}
