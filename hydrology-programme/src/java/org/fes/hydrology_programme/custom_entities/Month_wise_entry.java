/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.custom_entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jitesh
 */
public class Month_wise_entry implements Serializable {

    Integer rowId;
    List<EntryData> rowData;

    public List<EntryData> getRowData() {
        return rowData;
    }

    public void setRowData(List<EntryData> rowData) {
        this.rowData = rowData;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public Month_wise_entry(Integer rowId) {
        this.rowId = rowId;
    }

    public Month_wise_entry() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Month_wise_entry other = (Month_wise_entry) obj;
        if (this.rowId != other.rowId && (this.rowId == null || !this.rowId.equals(other.rowId))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.rowId != null ? this.rowId.hashCode() : 0);
        return hash;
    }
}
