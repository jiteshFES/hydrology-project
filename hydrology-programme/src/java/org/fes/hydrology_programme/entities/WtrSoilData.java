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
@Table(name = "WTR_SOIL_DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrSoilData.findAll", query = "SELECT w FROM WtrSoilData w"),
    @NamedQuery(name = "WtrSoilData.findBySoilSrno", query = "SELECT w FROM WtrSoilData w WHERE w.soilSrno = :soilSrno"),
    @NamedQuery(name = "WtrSoilData.findBySoilFarmer", query = "SELECT w FROM WtrSoilData w WHERE w.soilFarmer = :soilFarmer"),
    @NamedQuery(name = "WtrSoilData.findBySoilDate", query = "SELECT w FROM WtrSoilData w WHERE w.soilDate = :soilDate"),
    @NamedQuery(name = "WtrSoilData.findBySoilPercentage", query = "SELECT w FROM WtrSoilData w WHERE w.soilPercentage = :soilPercentage"),
    @NamedQuery(name = "WtrSoilData.findByCreateby", query = "SELECT w FROM WtrSoilData w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrSoilData.findByCreatedt", query = "SELECT w FROM WtrSoilData w WHERE w.createdt = :createdt"),
    @NamedQuery(name = "WtrSoilData.findBySoilSurveyNo", query = "SELECT w FROM WtrSoilData w WHERE w.soilSurveyNo = :soilSurveyNo")})
public class WtrSoilData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOIL_SRNO")
    private Integer soilSrno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SOIL_FARMER")
    private String soilFarmer;
    @Column(name = "SOIL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date soilDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SOIL_PERCENTAGE")
    private BigDecimal soilPercentage;
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
    @Column(name = "SOIL_SURVEY_NO")
    private String soilSurveyNo;
    @JoinColumn(name = "SOIL_WSHED_NO", referencedColumnName = "WSHED_NO")
    @ManyToOne(optional = false)
    private WtrWshedMst soilWshedNo;
    @JoinColumn(name = "SOIL_PLOT_SRNO", referencedColumnName = "PLOT_SRNO")
    @ManyToOne(optional = false)
    private WtrPlotMst soilPlotSrno;

    public WtrSoilData() {
    }

    public WtrSoilData(Integer soilSrno) {
        this.soilSrno = soilSrno;
    }

    public WtrSoilData(Integer soilSrno, String soilFarmer, int createby, Date createdt) {
        this.soilSrno = soilSrno;
        this.soilFarmer = soilFarmer;
        this.createby = createby;
        this.createdt = createdt;
    }

    public Integer getSoilSrno() {
        return soilSrno;
    }

    public void setSoilSrno(Integer soilSrno) {
        this.soilSrno = soilSrno;
    }

    public String getSoilFarmer() {
        return soilFarmer;
    }

    public void setSoilFarmer(String soilFarmer) {
        this.soilFarmer = soilFarmer;
    }

    public Date getSoilDate() {
        return soilDate;
    }

    public void setSoilDate(Date soilDate) {
        this.soilDate = soilDate;
    }

    public BigDecimal getSoilPercentage() {
        return soilPercentage;
    }

    public void setSoilPercentage(BigDecimal soilPercentage) {
        this.soilPercentage = soilPercentage;
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

    public String getSoilSurveyNo() {
        return soilSurveyNo;
    }

    public void setSoilSurveyNo(String soilSurveyNo) {
        this.soilSurveyNo = soilSurveyNo;
    }

    public WtrWshedMst getSoilWshedNo() {
        return soilWshedNo;
    }

    public void setSoilWshedNo(WtrWshedMst soilWshedNo) {
        this.soilWshedNo = soilWshedNo;
    }

    public WtrPlotMst getSoilPlotSrno() {
        return soilPlotSrno;
    }

    public void setSoilPlotSrno(WtrPlotMst soilPlotSrno) {
        this.soilPlotSrno = soilPlotSrno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (soilSrno != null ? soilSrno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrSoilData)) {
            return false;
        }
        WtrSoilData other = (WtrSoilData) object;
        if ((this.soilSrno == null && other.soilSrno != null) || (this.soilSrno != null && !this.soilSrno.equals(other.soilSrno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrSoilData[ soilSrno=" + soilSrno + " ]";
    }
    
}
