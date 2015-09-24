/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jitesh
 */
@Embeddable
public class WtrStreamGaugePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "STR_SRNO")
    private int strSrno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STR_WSHED_NO")
    private int strWshedNo;

    public WtrStreamGaugePK() {
    }

    public WtrStreamGaugePK(int strSrno, int strWshedNo) {
        this.strSrno = strSrno;
        this.strWshedNo = strWshedNo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) strSrno;
        hash += (int) strWshedNo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrStreamGaugePK)) {
            return false;
        }
        WtrStreamGaugePK other = (WtrStreamGaugePK) object;
        if (this.strSrno != other.strSrno) {
            return false;
        }
        if (this.strWshedNo != other.strWshedNo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrStreamGaugePK[ strSrno=" + strSrno + ", strWshedNo=" + strWshedNo + " ]";
    }
    
}
