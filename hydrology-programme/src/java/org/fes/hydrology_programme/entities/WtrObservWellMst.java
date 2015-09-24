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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jitesh
 */
@Entity
@Table(name = "WTR_OBSERV_WELL_MST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrObservWellMst.findAll", query = "SELECT w FROM WtrObservWellMst w"),
    @NamedQuery(name = "WtrObservWellMst.findByObwellSrno", query = "SELECT w FROM WtrObservWellMst w WHERE w.obwellSrno = :obwellSrno"),
    @NamedQuery(name = "WtrObservWellMst.findByObwellFarmer", query = "SELECT w FROM WtrObservWellMst w WHERE w.obwellFarmer = :obwellFarmer"),
    @NamedQuery(name = "WtrObservWellMst.findByObwellDrillYear", query = "SELECT w FROM WtrObservWellMst w WHERE w.obwellDrillYear = :obwellDrillYear"),
    @NamedQuery(name = "WtrObservWellMst.findByObwellNumber", query = "SELECT w FROM WtrObservWellMst w WHERE w.obwellNumber = :obwellNumber"),
    @NamedQuery(name = "WtrObservWellMst.findByObwellLocation", query = "SELECT w FROM WtrObservWellMst w WHERE w.obwellLocation = :obwellLocation"),
    @NamedQuery(name = "WtrObservWellMst.findByObwellDepth", query = "SELECT w FROM WtrObservWellMst w WHERE w.obwellDepth = :obwellDepth"),
    @NamedQuery(name = "WtrObservWellMst.findByObwellType", query = "SELECT w FROM WtrObservWellMst w WHERE w.obwellType = :obwellType"),
    @NamedQuery(name = "WtrObservWellMst.findByObwellMotorCapacity", query = "SELECT w FROM WtrObservWellMst w WHERE w.obwellMotorCapacity = :obwellMotorCapacity"),
    @NamedQuery(name = "WtrObservWellMst.findByObwellGpsn", query = "SELECT w FROM WtrObservWellMst w WHERE w.obwellGpsn = :obwellGpsn"),
    @NamedQuery(name = "WtrObservWellMst.findByObwellGpse", query = "SELECT w FROM WtrObservWellMst w WHERE w.obwellGpse = :obwellGpse"),
    @NamedQuery(name = "WtrObservWellMst.findByCreateby", query = "SELECT w FROM WtrObservWellMst w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrObservWellMst.findByCreatedt", query = "SELECT w FROM WtrObservWellMst w WHERE w.createdt = :createdt"),
    @NamedQuery(name = "WtrObservWellMst.findByObwellStages", query = "SELECT w FROM WtrObservWellMst w WHERE w.obwellStages = :obwellStages"),
    @NamedQuery(name = "WtrObservWellMst.findByObwellElevation", query = "SELECT w FROM WtrObservWellMst w WHERE w.obwellElevation = :obwellElevation")})
public class WtrObservWellMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OBWELL_SRNO")
    private Integer obwellSrno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "OBWELL_FARMER")
    private String obwellFarmer;
    @Size(max = 4)
    @Column(name = "OBWELL_DRILL_YEAR")
    private String obwellDrillYear;
    @Size(max = 50)
    @Column(name = "OBWELL_NUMBER")
    private String obwellNumber;
    @Size(max = 100)
    @Column(name = "OBWELL_LOCATION")
    private String obwellLocation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OBWELL_DEPTH")
    private BigDecimal obwellDepth;
    @Size(max = 1)
    @Column(name = "OBWELL_TYPE")
    private String obwellType;
    @Size(max = 50)
    @Column(name = "OBWELL_MOTOR_CAPACITY")
    private String obwellMotorCapacity;
    @Size(max = 20)
    @Column(name = "OBWELL_GPSN")
    private String obwellGpsn;
    @Size(max = 20)
    @Column(name = "OBWELL_GPSE")
    private String obwellGpse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEBY")
    private int createby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @Size(max = 50)
    @Column(name = "OBWELL_STAGES")
    private String obwellStages;
    @Column(name = "OBWELL_ELEVATION")
    private BigDecimal obwellElevation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "odataObwellSrno")
    private Collection<WtrObwellData> wtrObwellDataCollection;
    @JoinColumn(name = "OBWELL_WSHED_NO", referencedColumnName = "WSHED_NO")
    @ManyToOne(optional = false)
    private WtrWshedMst obwellWshedNo;

    public WtrObservWellMst() {
    }

    public WtrObservWellMst(Integer obwellSrno) {
        this.obwellSrno = obwellSrno;
    }

    public WtrObservWellMst(Integer obwellSrno, String obwellFarmer, int createby, Date createdt) {
        this.obwellSrno = obwellSrno;
        this.obwellFarmer = obwellFarmer;
        this.createby = createby;
        this.createdt = createdt;
    }

    public Integer getObwellSrno() {
        return obwellSrno;
    }

    public void setObwellSrno(Integer obwellSrno) {
        this.obwellSrno = obwellSrno;
    }

    public String getObwellFarmer() {
        return obwellFarmer;
    }

    public void setObwellFarmer(String obwellFarmer) {
        this.obwellFarmer = obwellFarmer;
    }

    public String getObwellDrillYear() {
        return obwellDrillYear;
    }

    public void setObwellDrillYear(String obwellDrillYear) {
        this.obwellDrillYear = obwellDrillYear;
    }

    public String getObwellNumber() {
        return obwellNumber;
    }

    public void setObwellNumber(String obwellNumber) {
        this.obwellNumber = obwellNumber;
    }

    public String getObwellLocation() {
        return obwellLocation;
    }

    public void setObwellLocation(String obwellLocation) {
        this.obwellLocation = obwellLocation;
    }

    public BigDecimal getObwellDepth() {
        return obwellDepth;
    }

    public void setObwellDepth(BigDecimal obwellDepth) {
        this.obwellDepth = obwellDepth;
    }

    public String getObwellType() {
        return obwellType;
    }

    public void setObwellType(String obwellType) {
        this.obwellType = obwellType;
    }

    public String getObwellMotorCapacity() {
        return obwellMotorCapacity;
    }

    public void setObwellMotorCapacity(String obwellMotorCapacity) {
        this.obwellMotorCapacity = obwellMotorCapacity;
    }

    public String getObwellGpsn() {
        return obwellGpsn;
    }

    public void setObwellGpsn(String obwellGpsn) {
        this.obwellGpsn = obwellGpsn;
    }

    public String getObwellGpse() {
        return obwellGpse;
    }

    public void setObwellGpse(String obwellGpse) {
        this.obwellGpse = obwellGpse;
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

    public String getObwellStages() {
        return obwellStages;
    }

    public void setObwellStages(String obwellStages) {
        this.obwellStages = obwellStages;
    }

    public BigDecimal getObwellElevation() {
        return obwellElevation;
    }

    public void setObwellElevation(BigDecimal obwellElevation) {
        this.obwellElevation = obwellElevation;
    }

    @XmlTransient
    public Collection<WtrObwellData> getWtrObwellDataCollection() {
        return wtrObwellDataCollection;
    }

    public void setWtrObwellDataCollection(Collection<WtrObwellData> wtrObwellDataCollection) {
        this.wtrObwellDataCollection = wtrObwellDataCollection;
    }

    public WtrWshedMst getObwellWshedNo() {
        return obwellWshedNo;
    }

    public void setObwellWshedNo(WtrWshedMst obwellWshedNo) {
        this.obwellWshedNo = obwellWshedNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (obwellSrno != null ? obwellSrno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrObservWellMst)) {
            return false;
        }
        WtrObservWellMst other = (WtrObservWellMst) object;
        if ((this.obwellSrno == null && other.obwellSrno != null) || (this.obwellSrno != null && !this.obwellSrno.equals(other.obwellSrno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrObservWellMst[ obwellSrno=" + obwellSrno + " ]";
    }
    
}
