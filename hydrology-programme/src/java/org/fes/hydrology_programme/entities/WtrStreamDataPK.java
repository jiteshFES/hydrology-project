/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jitesh
 */
@Embeddable
public class WtrStreamDataPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "STR_SRNO")
    private int strSrno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STR_WSHED_NO")
    private int strWshedNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STR_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date strDate;

    public WtrStreamDataPK() {
    }

    public WtrStreamDataPK(int strSrno, int strWshedNo, Date strDate) {
        this.strSrno = strSrno;
        this.strWshedNo = strWshedNo;
        this.strDate = strDate;
    }

    public int getStrSrno() {
        return strSrno;
    }

    public void setStrSrno(int strSrno) {
        this.strSrno = strSrno;
    }

    public int getStrWshedNo() {
        return strWshedNo;
    }

    public void setStrWshedNo(int strWshedNo) {
        this.strWshedNo = strWshedNo;
    }

    public Date getStrDate() {
        return strDate;
    }

    public void setStrDate(Date strDate) {
        this.strDate = strDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) strSrno;
        hash += (int) strWshedNo;
        hash += (strDate != null ? strDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrStreamDataPK)) {
            return false;
        }
        WtrStreamDataPK other = (WtrStreamDataPK) object;
        if (this.strSrno != other.strSrno) {
            return false;
        }
        if (this.strWshedNo != other.strWshedNo) {
            return false;
        }
        if ((this.strDate == null && other.strDate != null) || (this.strDate != null && !this.strDate.equals(other.strDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrStreamDataPK[ strSrno=" + strSrno + ", strWshedNo=" + strWshedNo + ", strDate=" + strDate + " ]";
    }
    
}
