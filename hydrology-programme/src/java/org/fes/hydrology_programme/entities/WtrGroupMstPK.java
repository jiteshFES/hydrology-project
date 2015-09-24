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
import javax.validation.constraints.Size;

/**
 *
 * @author jitesh
 */
@Embeddable
public class WtrGroupMstPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private short userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "GROUP_NAME")
    private String groupName;

    public WtrGroupMstPK() {
    }

    public WtrGroupMstPK(short userId, String groupName) {
        this.userId = userId;
        this.groupName = groupName;
    }

    public short getUserId() {
        return userId;
    }

    public void setUserId(short userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (groupName != null ? groupName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WtrGroupMstPK)) {
            return false;
        }
        WtrGroupMstPK other = (WtrGroupMstPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if ((this.groupName == null && other.groupName != null) || (this.groupName != null && !this.groupName.equals(other.groupName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.fes.hydrology_programme.entities.WtrGroupMstPK[ userId=" + userId + ", groupName=" + groupName + " ]";
    }
    
}
