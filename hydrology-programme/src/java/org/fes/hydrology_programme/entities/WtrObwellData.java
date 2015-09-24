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
@Table(name = "WTR_OBWELL_DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrObwellData.findAll", query = "SELECT w FROM WtrObwellData w"),
    @NamedQuery(name = "WtrObwellData.findByOdataSrno", query = "SELECT w FROM WtrObwellData w WHERE w.odataSrno = :odataSrno"),
    @NamedQuery(name = "WtrObwellData.findByOdataFarmer", query = "SELECT w FROM WtrObwellData w WHERE w.odataFarmer = :odataFarmer"),
    @NamedQuery(name = "WtrObwellData.findByOdataDate", query = "SELECT w FROM WtrObwellData w WHERE w.odataDate = :odataDate"),
    @NamedQuery(name = "WtrObwellData.findByOdataSurveyNo", query = "SELECT w FROM WtrObwellData w WHERE w.odataSurveyNo = :odataSurveyNo"),
    @NamedQuery(name = "WtrObwellData.findByOdataPumpHrsDay", query = "SELECT w FROM WtrObwellData w WHERE w.odataPumpHrsDay = :odataPumpHrsDay"),
    @NamedQuery(name = "WtrObwellData.findByOdataDrumTime", query = "SELECT w FROM WtrObwellData w WHERE w.odataDrumTime = :odataDrumTime"),
    @NamedQuery(name = "WtrObwellData.findByOdataSwlMts", query = "SELECT w FROM WtrObwellData w WHERE w.odataSwlMts = :odataSwlMts"),
    @NamedQuery(name = "WtrObwellData.findByOdataPwlMts", query = "SELECT w FROM WtrObwellData w WHERE w.odataPwlMts = :odataPwlMts"),
    @NamedQuery(name = "WtrObwellData.findByOdataPumpDaysMonth", query = "SELECT w FROM WtrObwellData w WHERE w.odataPumpDaysMonth = :odataPumpDaysMonth"),
    @NamedQuery(name = "WtrObwellData.findByCreateby", query = "SELECT w FROM WtrObwellData w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrObwellData.findByCreatedt", query = "SELECT w FROM WtrObwellData w WHERE w.createdt = :createdt")})
public class WtrObwellData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ODATA_SRNO")
    private Integer odataSrno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ODATA_FARMER")
    private String odataFarmer;
    @Column(name = "ODATA_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date odataDate;
    @Size(max = 50)
    @Column(name = "ODATA_SURVEY_NO")
    private String odataSurveyNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ODATA_PUMP_HRS_DAY")
    private BigDecimal odataPumpHrsDay;
    @Column(name = "ODATA_DRUM_TIME")
    private Integer odataDrumTime;
    @Column(name = "ODATA_SWL_MTS")
    private BigDecimal odataSwlMts;
    @Column(name = "ODATA_PWL_MTS")
    private BigDecimal odataPwlMts;
    @Column(name = "ODATA_PUMP_DAYS_MONTH")
    private Short odataPumpDaysMonth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEBY")
    private int createby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @JoinColumn(name = "ODATA_WSHED_NO", referencedColumnName = "WSHED_NO")
    @ManyToOne(optional = false)
    private WtrWshedMst odataWshedNo;
    @JoinColumn(name = "ODATA_OBWELL_SRNO", referencedColumnName = "OBWELL_SRNO")
    @ManyToOne(optional = false)
    private WtrObservWellMst odataObwellSrno;

    public WtrObwellData() {
    }

    public WtrObwellData(Integer odataSrno) {
        this.odataSrno = odataSrno;
    }

    public WtrObwellData(Integer odataSrno, String odataFarmer, int createby, Date createdt) {
        this.odataSrno = odataSrno;
        this.odataFarmer = odataFarmer;
        this.createby = createby;
        this.createdt = createdt;
    }

    public Integer getOdataSrno() {
        return odataSrno;
    }

    public void setOdataSrno(Integer odataSrno) {
        this.odataSrno = odataSrno;
    }

    public String getOdataFarmer() {
        return odataFarmer;
    }

    public void setOdataFarmer(String odataFarmer) {
        this.odataFarmer = odataFarmer;
    }

    public Date getOdataDate() {
        return odataDate;
    }

    public void setOdataDate(Date odataDate) {
        this.odataDate = odataDate;
    }

    public String getOdataSurveyNo() {
        return odataSurveyNo;
    }

    public void setOdataSurveyNo(String odataSurveyNo) {
        this.odataSurveyNo = odataSurveyNo;
    }

    public BigDecimal getOdataPumpHrsDay() {
        return odataPumpHrsDay;
    }

    public void setOdataPumpHrsDay(BigDecimal odataPumpHrsDay) {
        this.odataPumpHrsDay = odataPumpHrsDay;
    }

    public Integer getOdataDrumTime() {
        return odataDrumTime;
    }

    public void setOdataDrumTime(Integer odataDrumTime) {
        this.odataDrumTime = odataDrumTime;
    }

    public BigDecimal getOdataSwlMts() {
        return odataSwlMts;
    }

    public void setOdataSwlMts(BigDecimal odataSwlMts) {
        this.odataSwlMts = odataSwlMts;
    }

    public BigDecimal getOdataPwlMts() {
        return odataPwlMts;
    }

    public void setOdataPwlMts(BigDecimal odataPwlMts) {
        this.odataPwlMts = odataPwlMts;
    }

    public Short getOdataPumpDaysMonth() {
        return odataPumpDaysMonth;
    }

    public void setOdataPumpDaysMonth(Short odataPumpDaysMonth) {
        this.odataPumpDaysMonth = odataPumpDaysMonth;
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

    public WtrWshedMst getOdataWshedNo() {
        return odataWshedNo;
    }

    public void setOdataWshedNo(WtrWshedMst odataWshedNo) {
        this.odataWshedNo = odataWshedNo;
    }

    public WtrObservWellMst getOdataObwellSrno() {
        return odataObwellSrno;
    }

    public void setOdataObwellSrno(WtrObservWellMst odataObwellSrno) {
        this.odataObwellSrno = odataObwellSrno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odataSrno != null ? odataSrno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrObwellData)) {
            return false;
        }
        WtrObwellData other = (WtrObwellData) object;
        if ((this.odataSrno == null && other.odataSrno != null) || (this.odataSrno != null && !this.odataSrno.equals(other.odataSrno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrObwellData[ odataSrno=" + odataSrno + " ]";
    }
    
}
