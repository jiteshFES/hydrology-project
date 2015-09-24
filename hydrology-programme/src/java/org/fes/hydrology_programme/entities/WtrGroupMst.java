/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jitesh
 */
@Entity
@Table(name = "WTR_GROUP_MST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrGroupMst.findAll", query = "SELECT w FROM WtrGroupMst w"),
    @NamedQuery(name = "WtrGroupMst.findByUserId", query = "SELECT w FROM WtrGroupMst w WHERE w.wtrGroupMstPK.userId = :userId"),
    @NamedQuery(name = "WtrGroupMst.findByGroupName", query = "SELECT w FROM WtrGroupMst w WHERE w.wtrGroupMstPK.groupName = :groupName"),
    @NamedQuery(name = "WtrGroupMst.findByUserName", query = "SELECT w FROM WtrGroupMst w WHERE w.userName = :userName"),
    @NamedQuery(name = "WtrGroupMst.findByCreateby", query = "SELECT w FROM WtrGroupMst w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrGroupMst.findByCreatedt", query = "SELECT w FROM WtrGroupMst w WHERE w.createdt = :createdt")})
public class WtrGroupMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WtrGroupMstPK wtrGroupMstPK;
    @Size(max = 20)
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "CREATEBY")
    private Integer createby;
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private WtrUserMst wtrUserMst;

    public WtrGroupMst() {
    }

    public WtrGroupMst(WtrGroupMstPK wtrGroupMstPK) {
        this.wtrGroupMstPK = wtrGroupMstPK;
    }

    public WtrGroupMst(short userId, String groupName) {
        this.wtrGroupMstPK = new WtrGroupMstPK(userId, groupName);
    }

    public WtrGroupMstPK getWtrGroupMstPK() {
        return wtrGroupMstPK;
    }

    public void setWtrGroupMstPK(WtrGroupMstPK wtrGroupMstPK) {
        this.wtrGroupMstPK = wtrGroupMstPK;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Date getCreatedt() {
        return createdt;
    }

    public void setCreatedt(Date createdt) {
        this.createdt = createdt;
    }

    public WtrUserMst getWtrUserMst() {
        return wtrUserMst;
    }

    public void setWtrUserMst(WtrUserMst wtrUserMst) {
        this.wtrUserMst = wtrUserMst;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wtrGroupMstPK != null ? wtrGroupMstPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrGroupMst)) {
            return false;
        }
        WtrGroupMst other = (WtrGroupMst) object;
        if ((this.wtrGroupMstPK == null && other.wtrGroupMstPK != null) || (this.wtrGroupMstPK != null && !this.wtrGroupMstPK.equals(other.wtrGroupMstPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrGroupMst[ wtrGroupMstPK=" + wtrGroupMstPK + " ]";
    }
    
}
