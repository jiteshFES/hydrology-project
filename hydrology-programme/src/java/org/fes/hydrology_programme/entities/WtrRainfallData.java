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
@Table(name = "WTR_RAINFALL_DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrRainfallData.findAll", query = "SELECT w FROM WtrRainfallData w"),
    @NamedQuery(name = "WtrRainfallData.findByRfallSrno", query = "SELECT w FROM WtrRainfallData w WHERE w.rfallSrno = :rfallSrno"),
    @NamedQuery(name = "WtrRainfallData.findByRfallDate", query = "SELECT w FROM WtrRainfallData w WHERE w.rfallDate = :rfallDate"),
    @NamedQuery(name = "WtrRainfallData.findByRfallInMm", query = "SELECT w FROM WtrRainfallData w WHERE w.rfallInMm = :rfallInMm"),
    @NamedQuery(name = "WtrRainfallData.findByRfallInInch", query = "SELECT w FROM WtrRainfallData w WHERE w.rfallInInch = :rfallInInch"),
    @NamedQuery(name = "WtrRainfallData.findByRfallInCm", query = "SELECT w FROM WtrRainfallData w WHERE w.rfallInCm = :rfallInCm"),
    @NamedQuery(name = "WtrRainfallData.findByCreateby", query = "SELECT w FROM WtrRainfallData w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrRainfallData.findByCreatedt", query = "SELECT w FROM WtrRainfallData w WHERE w.createdt = :createdt")})
public class WtrRainfallData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RFALL_SRNO")
    private Integer rfallSrno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RFALL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rfallDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RFALL_IN_MM")
    private BigDecimal rfallInMm;
    @Column(name = "RFALL_IN_INCH")
    private BigDecimal rfallInInch;
    @Column(name = "RFALL_IN_CM")
    private BigDecimal rfallInCm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEBY")
    private int createby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @JoinColumn(name = "RFALL_WSHED_NO", referencedColumnName = "WSHED_NO")
    @ManyToOne(optional = false)
    private WtrWshedMst rfallWshedNo;

    public WtrRainfallData() {
    }

    public WtrRainfallData(Integer rfallSrno) {
        this.rfallSrno = rfallSrno;
    }

    public WtrRainfallData(Integer rfallSrno, Date rfallDate, int createby, Date createdt) {
        this.rfallSrno = rfallSrno;
        this.rfallDate = rfallDate;
        this.createby = createby;
        this.createdt = createdt;
    }

    public Integer getRfallSrno() {
        return rfallSrno;
    }

    public void setRfallSrno(Integer rfallSrno) {
        this.rfallSrno = rfallSrno;
    }

    public Date getRfallDate() {
        return rfallDate;
    }

    public void setRfallDate(Date rfallDate) {
        this.rfallDate = rfallDate;
    }

    public BigDecimal getRfallInMm() {
        return rfallInMm;
    }

    public void setRfallInMm(BigDecimal rfallInMm) {
        this.rfallInMm = rfallInMm;
    }

    public BigDecimal getRfallInInch() {
        return rfallInInch;
    }

    public void setRfallInInch(BigDecimal rfallInInch) {
        this.rfallInInch = rfallInInch;
    }

    public BigDecimal getRfallInCm() {
        return rfallInCm;
    }

    public void setRfallInCm(BigDecimal rfallInCm) {
        this.rfallInCm = rfallInCm;
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

    public WtrWshedMst getRfallWshedNo() {
        return rfallWshedNo;
    }

    public void setRfallWshedNo(WtrWshedMst rfallWshedNo) {
        this.rfallWshedNo = rfallWshedNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rfallSrno != null ? rfallSrno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrRainfallData)) {
            return false;
        }
        WtrRainfallData other = (WtrRainfallData) object;
        if ((this.rfallSrno == null && other.rfallSrno != null) || (this.rfallSrno != null && !this.rfallSrno.equals(other.rfallSrno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrRainfallData[ rfallSrno=" + rfallSrno + " ]";
    }
    
}
