package org.fes.hydrology_programme.custom_entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Database_Output implements Serializable{
    boolean executed_successfully;
    boolean boolean1;
    boolean boolean2;
    Date date1;
    Date date2;
    String string1;
    String string2;
    Integer integer1;
    Integer integer2;
    Long long1;
    Long long2;
    BigDecimal bigdecimal1;
    BigDecimal bigdecimal2;

    public boolean isBoolean2() {
        return boolean2;
    }

    public void setBoolean2(boolean boolean2) {
        this.boolean2 = boolean2;
    }

    public boolean isExecuted_successfully() {
        return executed_successfully;
    }

    public void setExecuted_successfully(boolean executed_successfully) {
        this.executed_successfully = executed_successfully;
    }

    public boolean isBoolean1() {
        return boolean1;
    }

    public void setBoolean1(boolean boolean1) {
        this.boolean1 = boolean1;
    }

    public BigDecimal getBigdecimal1() {
        return bigdecimal1;
    }

    public void setBigdecimal1(BigDecimal bigdecimal1) {
        this.bigdecimal1 = bigdecimal1;
    }

    public BigDecimal getBigdecimal2() {
        return bigdecimal2;
    }

    public void setBigdecimal2(BigDecimal bigdecimal2) {
        this.bigdecimal2 = bigdecimal2;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Integer getInteger1() {
        return integer1;
    }

    public void setInteger1(Integer integer1) {
        this.integer1 = integer1;
    }

    public Integer getInteger2() {
        return integer2;
    }

    public void setInteger2(Integer integer2) {
        this.integer2 = integer2;
    }

    public Long getLong1() {
        return long1;
    }

    public void setLong1(Long long1) {
        this.long1 = long1;
    }

    public Long getLong2() {
        return long2;
    }

    public void setLong2(Long long2) {
        this.long2 = long2;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public Database_Output(boolean executed_successfully) {
        this.executed_successfully = executed_successfully;
    }

    public Database_Output() {
    }

    

}
