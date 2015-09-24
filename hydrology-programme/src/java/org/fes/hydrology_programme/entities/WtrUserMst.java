/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.entities;

import java.io.Serializable;
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
@Table(name = "WTR_USER_MST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WtrUserMst.findAll", query = "SELECT w FROM WtrUserMst w"),
    @NamedQuery(name = "WtrUserMst.findByUserId", query = "SELECT w FROM WtrUserMst w WHERE w.userId = :userId"),
    @NamedQuery(name = "WtrUserMst.findByUserName", query = "SELECT w FROM WtrUserMst w WHERE w.userName = :userName"),
    @NamedQuery(name = "WtrUserMst.findByUserType", query = "SELECT w FROM WtrUserMst w WHERE w.userType = :userType"),
    @NamedQuery(name = "WtrUserMst.findByUserPassword", query = "SELECT w FROM WtrUserMst w WHERE w.userPassword = :userPassword"),
    @NamedQuery(name = "WtrUserMst.findByCreateby", query = "SELECT w FROM WtrUserMst w WHERE w.createby = :createby"),
    @NamedQuery(name = "WtrUserMst.findByCreatedt", query = "SELECT w FROM WtrUserMst w WHERE w.createdt = :createdt")})
public class WtrUserMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private Short userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "USER_TYPE")
    private String userType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEBY")
    private int createby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATEDT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdt;
    @JoinColumn(name = "PFA_RSO_NUMBER", referencedColumnName = "PFA_NO")
    @ManyToOne
    private WtrPfaMst pfaRsoNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wtrUserMst")
    private Collection<WtrGroupMst> wtrGroupMstCollection;

    public WtrUserMst() {
    }

    public WtrUserMst(Short userId) {
        this.userId = userId;
    }

    public WtrUserMst(Short userId, String userName, String userType, String userPassword, int createby, Date createdt) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.userPassword = userPassword;
        this.createby = createby;
        this.createdt = createdt;
    }

    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public WtrPfaMst getPfaRsoNumber() {
        return pfaRsoNumber;
    }

    public void setPfaRsoNumber(WtrPfaMst pfaRsoNumber) {
        this.pfaRsoNumber = pfaRsoNumber;
    }

    @XmlTransient
    public Collection<WtrGroupMst> getWtrGroupMstCollection() {
        return wtrGroupMstCollection;
    }

    public void setWtrGroupMstCollection(Collection<WtrGroupMst> wtrGroupMstCollection) {
        this.wtrGroupMstCollection = wtrGroupMstCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrUserMst)) {
            return false;
        }
        WtrUserMst other = (WtrUserMst) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrUserMst[ userId=" + userId + " ]";
    }
    
}
