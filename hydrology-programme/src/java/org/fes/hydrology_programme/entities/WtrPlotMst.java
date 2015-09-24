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
@Table(name = "WTR_PLOT_MST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrPlotMst.findAll", query = "SELECT w FROM WtrPlotMst w"),
    @NamedQuery(name = "WtrPlotMst.findByPlotSrno", query = "SELECT w FROM WtrPlotMst w WHERE w.plotSrno = :plotSrno"),
    @NamedQuery(name = "WtrPlotMst.findByPlotFarmer", query = "SELECT w FROM WtrPlotMst w WHERE w.plotFarmer = :plotFarmer"),
    @NamedQuery(name = "WtrPlotMst.findByPlotNo", query = "SELECT w FROM WtrPlotMst w WHERE w.plotNo = :plotNo"),
    @NamedQuery(name = "WtrPlotMst.findByPlotLocation", query = "SELECT w FROM WtrPlotMst w WHERE w.plotLocation = :plotLocation"),
    @NamedQuery(name = "WtrPlotMst.findByPlotSoiltype", query = "SELECT w FROM WtrPlotMst w WHERE w.plotSoiltype = :plotSoiltype"),
    @NamedQuery(name = "WtrPlotMst.findByPlotSurveyNo", query = "SELECT w FROM WtrPlotMst w WHERE w.plotSurveyNo = :plotSurveyNo"),
    @NamedQuery(name = "WtrPlotMst.findByPlotGpsn", query = "SELECT w FROM WtrPlotMst w WHERE w.plotGpsn = :plotGpsn"),
    @NamedQuery(name = "WtrPlotMst.findByPlotGpse", query = "SELECT w FROM WtrPlotMst w WHERE w.plotGpse = :plotGpse"),
    @NamedQuery(name = "WtrPlotMst.findByCreateby", query = "SELECT w FROM WtrPlotMst w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrPlotMst.findByCreatedt", query = "SELECT w FROM WtrPlotMst w WHERE w.createdt = :createdt"),
    @NamedQuery(name = "WtrPlotMst.findByPlotElevation", query = "SELECT w FROM WtrPlotMst w WHERE w.plotElevation = :plotElevation")})
public class WtrPlotMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLOT_SRNO")
    private Integer plotSrno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PLOT_FARMER")
    private String plotFarmer;
    @Size(max = 50)
    @Column(name = "PLOT_NO")
    private String plotNo;
    @Size(max = 20)
    @Column(name = "PLOT_LOCATION")
    private String plotLocation;
    @Size(max = 10)
    @Column(name = "PLOT_SOILTYPE")
    private String plotSoiltype;
    @Size(max = 50)
    @Column(name = "PLOT_SURVEY_NO")
    private String plotSurveyNo;
    @Size(max = 20)
    @Column(name = "PLOT_GPSN")
    private String plotGpsn;
    @Size(max = 20)
    @Column(name = "PLOT_GPSE")
    private String plotGpse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEBY")
    private int createby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PLOT_ELEVATION")
    private BigDecimal plotElevation;
    @JoinColumn(name = "PLOT_WSHED_NO", referencedColumnName = "WSHED_NO")
    @ManyToOne(optional = false)
    private WtrWshedMst plotWshedNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soilPlotSrno")
    private Collection<WtrSoilData> wtrSoilDataCollection;

    public WtrPlotMst() {
    }

    public WtrPlotMst(Integer plotSrno) {
        this.plotSrno = plotSrno;
    }

    public WtrPlotMst(Integer plotSrno, String plotFarmer, int createby, Date createdt) {
        this.plotSrno = plotSrno;
        this.plotFarmer = plotFarmer;
        this.createby = createby;
        this.createdt = createdt;
    }

    public Integer getPlotSrno() {
        return plotSrno;
    }

    public void setPlotSrno(Integer plotSrno) {
        this.plotSrno = plotSrno;
    }

    public String getPlotFarmer() {
        return plotFarmer;
    }

    public void setPlotFarmer(String plotFarmer) {
        this.plotFarmer = plotFarmer;
    }

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    public String getPlotLocation() {
        return plotLocation;
    }

    public void setPlotLocation(String plotLocation) {
        this.plotLocation = plotLocation;
    }

    public String getPlotSoiltype() {
        return plotSoiltype;
    }

    public void setPlotSoiltype(String plotSoiltype) {
        this.plotSoiltype = plotSoiltype;
    }

    public String getPlotSurveyNo() {
        return plotSurveyNo;
    }

    public void setPlotSurveyNo(String plotSurveyNo) {
        this.plotSurveyNo = plotSurveyNo;
    }

    public String getPlotGpsn() {
        return plotGpsn;
    }

    public void setPlotGpsn(String plotGpsn) {
        this.plotGpsn = plotGpsn;
    }

    public String getPlotGpse() {
        return plotGpse;
    }

    public void setPlotGpse(String plotGpse) {
        this.plotGpse = plotGpse;
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

    public BigDecimal getPlotElevation() {
        return plotElevation;
    }

    public void setPlotElevation(BigDecimal plotElevation) {
        this.plotElevation = plotElevation;
    }

    public WtrWshedMst getPlotWshedNo() {
        return plotWshedNo;
    }

    public void setPlotWshedNo(WtrWshedMst plotWshedNo) {
        this.plotWshedNo = plotWshedNo;
    }

    @XmlTransient
    public Collection<WtrSoilData> getWtrSoilDataCollection() {
        return wtrSoilDataCollection;
    }

    public void setWtrSoilDataCollection(Collection<WtrSoilData> wtrSoilDataCollection) {
        this.wtrSoilDataCollection = wtrSoilDataCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plotSrno != null ? plotSrno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrPlotMst)) {
            return false;
        }
        WtrPlotMst other = (WtrPlotMst) object;
        if ((this.plotSrno == null && other.plotSrno != null) || (this.plotSrno != null && !this.plotSrno.equals(other.plotSrno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrPlotMst[ plotSrno=" + plotSrno + " ]";
    }
    
}
