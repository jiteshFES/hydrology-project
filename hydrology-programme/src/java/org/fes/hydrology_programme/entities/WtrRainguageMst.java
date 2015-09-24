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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jitesh
 */
@Entity
@Table(name = "WTR_RAINGUAGE_MST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrRainguageMst.findAll", query = "SELECT w FROM WtrRainguageMst w"),
    @NamedQuery(name = "WtrRainguageMst.findByRgSrno", query = "SELECT w FROM WtrRainguageMst w WHERE w.rgSrno = :rgSrno"),
    @NamedQuery(name = "WtrRainguageMst.findByRgGuageType", query = "SELECT w FROM WtrRainguageMst w WHERE w.rgGuageType = :rgGuageType"),
    @NamedQuery(name = "WtrRainguageMst.findByRgGuageLocation", query = "SELECT w FROM WtrRainguageMst w WHERE w.rgGuageLocation = :rgGuageLocation"),
    @NamedQuery(name = "WtrRainguageMst.findByRgGpsN", query = "SELECT w FROM WtrRainguageMst w WHERE w.rgGpsN = :rgGpsN"),
    @NamedQuery(name = "WtrRainguageMst.findByRgGpsE", query = "SELECT w FROM WtrRainguageMst w WHERE w.rgGpsE = :rgGpsE"),
    @NamedQuery(name = "WtrRainguageMst.findByCreateby", query = "SELECT w FROM WtrRainguageMst w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrRainguageMst.findByCreatedt", query = "SELECT w FROM WtrRainguageMst w WHERE w.createdt = :createdt"),
    @NamedQuery(name = "WtrRainguageMst.findByRgInstallDate", query = "SELECT w FROM WtrRainguageMst w WHERE w.rgInstallDate = :rgInstallDate"),
    @NamedQuery(name = "WtrRainguageMst.findByRgElevation", query = "SELECT w FROM WtrRainguageMst w WHERE w.rgElevation = :rgElevation")})
public class WtrRainguageMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RG_SRNO")
    private Integer rgSrno;
    @Size(max = 1)
    @Column(name = "RG_GUAGE_TYPE")
    private String rgGuageType;
    @Size(max = 100)
    @Column(name = "RG_GUAGE_LOCATION")
    private String rgGuageLocation;
    @Size(max = 20)
    @Column(name = "RG_GPS_N")
    private String rgGpsN;
    @Size(max = 20)
    @Column(name = "RG_GPS_E")
    private String rgGpsE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEBY")
    private int createby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @Column(name = "RG_INSTALL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rgInstallDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RG_ELEVATION")
    private BigDecimal rgElevation;
    @JoinColumn(name = "RG_WSHED_NO", referencedColumnName = "WSHED_NO")
    @ManyToOne(optional = false)
    private WtrWshedMst rgWshedNo;

    public WtrRainguageMst() {
    }

    public WtrRainguageMst(Integer rgSrno) {
        this.rgSrno = rgSrno;
    }

    public WtrRainguageMst(Integer rgSrno, int createby, Date createdt) {
        this.rgSrno = rgSrno;
        this.createby = createby;
        this.createdt = createdt;
    }

    public Integer getRgSrno() {
        return rgSrno;
    }

    public void setRgSrno(Integer rgSrno) {
        this.rgSrno = rgSrno;
    }

    public String getRgGuageType() {
        return rgGuageType;
    }

    public void setRgGuageType(String rgGuageType) {
        this.rgGuageType = rgGuageType;
    }

    public String getRgGuageLocation() {
        return rgGuageLocation;
    }

    public void setRgGuageLocation(String rgGuageLocation) {
        this.rgGuageLocation = rgGuageLocation;
    }

    public String getRgGpsN() {
        return rgGpsN;
    }

    public void setRgGpsN(String rgGpsN) {
        this.rgGpsN = rgGpsN;
    }

    public String getRgGpsE() {
        return rgGpsE;
    }

    public void setRgGpsE(String rgGpsE) {
        this.rgGpsE = rgGpsE;
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

    public Date getRgInstallDate() {
        return rgInstallDate;
    }

    public void setRgInstallDate(Date rgInstallDate) {
        this.rgInstallDate = rgInstallDate;
    }

    public BigDecimal getRgElevation() {
        return rgElevation;
    }

    public void setRgElevation(BigDecimal rgElevation) {
        this.rgElevation = rgElevation;
    }

    public WtrWshedMst getRgWshedNo() {
        return rgWshedNo;
    }

    public void setRgWshedNo(WtrWshedMst rgWshedNo) {
        this.rgWshedNo = rgWshedNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rgSrno != null ? rgSrno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrRainguageMst)) {
            return false;
        }
        WtrRainguageMst other = (WtrRainguageMst) object;
        if ((this.rgSrno == null && other.rgSrno != null) || (this.rgSrno != null && !this.rgSrno.equals(other.rgSrno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrRainguageMst[ rgSrno=" + rgSrno + " ]";
    }
    
}
