/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.custom_entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author jitesh
 */
public class EntryData {
    Date entry_date;
    BigDecimal entry_unit;

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public BigDecimal getEntry_unit() {
        return entry_unit;
    }

    public void setEntry_unit(BigDecimal entry_unit) {
        this.entry_unit = entry_unit;
    }

  

    public EntryData(Date entry_date) {
        this.entry_date = entry_date;
    }

    public EntryData() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EntryData other = (EntryData) obj;
        if (this.entry_date != other.entry_date && (this.entry_date == null || !this.entry_date.equals(other.entry_date))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.entry_date != null ? this.entry_date.hashCode() : 0);
        return hash;
    }
    
}
