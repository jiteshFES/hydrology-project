/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.entities;

import java.io.Serializable;
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
@Table(name = "WTR_WSHED_MEMBER_MST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrWshedMemberMst.findAll", query = "SELECT w FROM WtrWshedMemberMst w"),
    @NamedQuery(name = "WtrWshedMemberMst.findByMemberSrno", query = "SELECT w FROM WtrWshedMemberMst w WHERE w.memberSrno = :memberSrno"),
    @NamedQuery(name = "WtrWshedMemberMst.findByMemName", query = "SELECT w FROM WtrWshedMemberMst w WHERE w.memName = :memName"),
    @NamedQuery(name = "WtrWshedMemberMst.findByMemType", query = "SELECT w FROM WtrWshedMemberMst w WHERE w.memType = :memType"),
    @NamedQuery(name = "WtrWshedMemberMst.findByCreateby", query = "SELECT w FROM WtrWshedMemberMst w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrWshedMemberMst.findByCreatedt", query = "SELECT w FROM WtrWshedMemberMst w WHERE w.createdt = :createdt")})
public class WtrWshedMemberMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBER_SRNO")
    private Integer memberSrno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MEM_NAME")
    private String memName;
    @Size(max = 1)
    @Column(name = "MEM_TYPE")
    private String memType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEBY")
    private int createby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @JoinColumn(name = "MEM_WSHED_NO", referencedColumnName = "WSHED_NO")
    @ManyToOne(optional = false)
    private WtrWshedMst memWshedNo;

    public WtrWshedMemberMst() {
    }

    public WtrWshedMemberMst(Integer memberSrno) {
        this.memberSrno = memberSrno;
    }

    public WtrWshedMemberMst(Integer memberSrno, String memName, int createby, Date createdt) {
        this.memberSrno = memberSrno;
        this.memName = memName;
        this.createby = createby;
        this.createdt = createdt;
    }

    public Integer getMemberSrno() {
        return memberSrno;
    }

    public void setMemberSrno(Integer memberSrno) {
        this.memberSrno = memberSrno;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemType() {
        return memType;
    }

    public void setMemType(String memType) {
        this.memType = memType;
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

    public WtrWshedMst getMemWshedNo() {
        return memWshedNo;
    }

    public void setMemWshedNo(WtrWshedMst memWshedNo) {
        this.memWshedNo = memWshedNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberSrno != null ? memberSrno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrWshedMemberMst)) {
            return false;
        }
        WtrWshedMemberMst other = (WtrWshedMemberMst) object;
        if ((this.memberSrno == null && other.memberSrno != null) || (this.memberSrno != null && !this.memberSrno.equals(other.memberSrno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrWshedMemberMst[ memberSrno=" + memberSrno + " ]";
    }
    
}
