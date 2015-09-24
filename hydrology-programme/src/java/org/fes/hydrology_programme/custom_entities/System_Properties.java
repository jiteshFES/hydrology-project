package org.fes.hydrology_programme.custom_entities;

import java.io.Serializable;

public class System_Properties implements Serializable {
    //<editor-fold defaultstate="collapsed" desc="rupee_symbol">

    String rupee_symbol = "<span class=\"WebRupee\">Rs.</span>";
    String rupee_symbol_margin = "<span class=\"WebRupee-Margin\">Rs.</span>";
    String rupee_symbol_margin_right = "<span class=\"WebRupee-Margin-Right\">Rs.</span>";
    String rupee_symbol_margin_left = "<span class=\"WebRupee-Margin-Left\">Rs.</span>";

    public String getRupee_symbol() {
        return rupee_symbol;
    }

    public void setRupee_symbol(String rupee_symbol) {
        this.rupee_symbol = rupee_symbol;
    }

    public String getRupee_symbol_margin() {
        return rupee_symbol_margin;
    }

    public void setRupee_symbol_margin(String rupee_symbol_margin) {
        this.rupee_symbol_margin = rupee_symbol_margin;
    }

    public String getRupee_symbol_margin_left() {
        return rupee_symbol_margin_left;
    }

    public void setRupee_symbol_margin_left(String rupee_symbol_margin_left) {
        this.rupee_symbol_margin_left = rupee_symbol_margin_left;
    }

    public String getRupee_symbol_margin_right() {
        return rupee_symbol_margin_right;
    }

    public void setRupee_symbol_margin_right(String rupee_symbol_margin_right) {
        this.rupee_symbol_margin_right = rupee_symbol_margin_right;
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SystemName">
    String SystemName = "hydrology-programme";
    String SystemUrl = "hydrology-programme";

    public String getSystemUrl() {
        return SystemUrl;
    }

    public void setSystemUrl(String SystemUrl) {
        this.SystemUrl = SystemUrl;
    }

    public String getSystemName() {
        return SystemName;
    }

    public void setSystemName(String SystemName) {
        this.SystemName = SystemName;
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="india_standard_time">
    String india_standard_time = "GMT+5:30";

    public String getIndia_standard_time() {
        return india_standard_time;
    }

    public void setIndia_standard_time(String india_standard_time) {
        this.india_standard_time = india_standard_time;
    }// </editor-fold>
    //<editor-fold defaultstate="collapsed" desc="system error msg"> 
    String system_error_msg_detail = "Some unexpected error occured";
    String system_error_msg_header = "System error";

    public String getSystem_error_msg_detail() {
        return system_error_msg_detail;
    }

    public void setSystem_error_msg_detail(String system_error_msg_detail) {
        this.system_error_msg_detail = system_error_msg_detail;
    }

    public String getSystem_error_msg_header() {
        return system_error_msg_header;
    }

    public void setSystem_error_msg_header(String system_error_msg_header) {
        this.system_error_msg_header = system_error_msg_header;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="system_start_year">
    Integer system_start_year=2012;
    
    public Integer getSystem_start_year() {
        return system_start_year;
    }
    
    public void setSystem_start_year(Integer system_start_year) {
        this.system_start_year = system_start_year;
    }
    //</editor-fold>

    public System_Properties() {
    }
}
