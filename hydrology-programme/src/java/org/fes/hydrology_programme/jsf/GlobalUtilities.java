package org.fes.hydrology_programme.jsf;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;
import org.fes.lib.utilities.DateTimeUtility;
import org.fes.lib.utilities.LogGenerator;
import org.fes.hydrology_programme.custom_entities.System_Properties;

/**
 *
 * @author jitesh
 */
@ManagedBean(name = "GlobalUtilities")
@SessionScoped
public class GlobalUtilities implements Serializable {

    @Resource(name = "jdbc/FES_PROJECT_Oracle")
    private DataSource jdbcFES_PROJECT_Oracle;
    String systemName = new System_Properties().getSystemName();
    LogGenerator logGenerator = new LogGenerator();
    DateTimeUtility dateTimeUtility = new DateTimeUtility();
    System_Properties system_Properties = new System_Properties();
    // <editor-fold defaultstate="collapsed" desc="india_standard_time">
    String india_standard_time = system_Properties.getIndia_standard_time();

    public String getIndia_standard_time() {
        return india_standard_time;
    }

    public void setIndia_standard_time(String india_standard_time) {
        this.india_standard_time = india_standard_time;
    }// </editor-fold>
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

    public String getRupee_symbol_margin_right() {
        return rupee_symbol_margin_right;
    }

    public void setRupee_symbol_margin_right(String rupee_symbol_margin_right) {
        this.rupee_symbol_margin_right = rupee_symbol_margin_right;
    }

    public String getRupee_symbol_margin_left() {
        return rupee_symbol_margin_left;
    }

    public void setRupee_symbol_margin_left(String rupee_symbol_margin_left) {
        this.rupee_symbol_margin_left = rupee_symbol_margin_left;
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="DateFormat">
    String DateFormat = dateTimeUtility.getDateFormat();

    public String getDateFormat() {
        return DateFormat;
    }

    public void setDateFormat(String DateFormat) {
        this.DateFormat = DateFormat;
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Financial Year Settings">
    boolean CurrentFinancialyear = true;
    Integer selected_fin_year = null;
    Integer selected_fin_start_year = null;
    Integer selected_fin_end_year = null;
    Date selected_fin_start_date = null;
    Date selected_fin_end_date = null;
    Integer current_fin_year = null;
    Integer current_fin_start_year = null;
    Integer current_fin_end_year = null;
    Date current_fin_start_date = null;
    Date current_fin_end_date = null;
    Date current_quarter_start_date = null;
    Date current_quarter_end_date = null;
    Date date_min_entry_start_date = null;
    Date date_min_entry_end_date = null;
    String string_min_entry_start_date = null;
    String string_min_entry_end_date = null;
    Date today = null;

    public Date getToday() {
        return new Date();
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Integer getCurrent_fin_year() {
        if (current_fin_year == null) {
            current_fin_year = dateTimeUtility.finYearFromDate(new Date());
        }
        return current_fin_year;
    }

    public void setCurrent_fin_year(Integer current_fin_year) {
        this.current_fin_year = current_fin_year;
    }

    public Integer getSelected_fin_year() {
        if (selected_fin_year == null) {
            selected_fin_year = getCurrent_fin_year();
        }
        return selected_fin_year;
    }

    public void setSelected_fin_year(Integer selected_fin_year) {
        this.selected_fin_year = selected_fin_year;
    }

    public Integer getCurrent_fin_start_year() {
        if (current_fin_start_year == null) {
            current_fin_start_year = Integer.valueOf(getCurrent_fin_year().toString().substring(0, 4));
        }
        return current_fin_start_year;
    }

    public void setCurrent_fin_start_year(Integer current_fin_start_year) {
        this.current_fin_start_year = current_fin_start_year;
    }

    public Integer getCurrent_fin_end_year() {
        if (current_fin_end_year == null) {
            current_fin_end_year = Integer.valueOf(getCurrent_fin_year().toString().substring(4, 8));
        }
        return current_fin_end_year;
    }

    public void setCurrent_fin_end_year(Integer current_fin_end_year) {
        this.current_fin_end_year = current_fin_end_year;
    }

    public Integer getSelected_fin_start_year() {
        if (selected_fin_start_year == null) {
            selected_fin_start_year = Integer.valueOf(getSelected_fin_year().toString().substring(0, 4));
        }
        return selected_fin_start_year;
    }

    public void setSelected_fin_start_year(Integer selected_fin_start_year) {
        this.selected_fin_start_year = selected_fin_start_year;
    }

    public Integer getSelected_fin_end_year() {
        if (selected_fin_end_year == null) {
            selected_fin_end_year = Integer.valueOf(getSelected_fin_year().toString().substring(4, 8));
        }
        return selected_fin_end_year;
    }

    public void setSelected_fin_end_year(Integer selected_fin_end_year) {
        this.selected_fin_end_year = selected_fin_end_year;
    }

    public Date getCurrent_fin_start_date() {
        if (current_fin_start_date == null) {
            current_fin_start_date = new Date(getCurrent_fin_start_year() - 1900, 3, 1);
        }
        return current_fin_start_date;
    }

    public void setCurrent_fin_start_date(Date current_fin_start_date) {
        this.current_fin_start_date = current_fin_start_date;
    }

    public Date getCurrent_fin_end_date() {
        if (current_fin_end_date == null) {
            current_fin_end_date = new Date(getCurrent_fin_end_year() - 1900, 2, 31);
        }
        return current_fin_end_date;
    }

    public void setCurrent_fin_end_date(Date current_fin_end_date) {
        this.current_fin_end_date = current_fin_end_date;
    }

    public Date getSelected_fin_start_date() {
        if (selected_fin_start_date == null) {
            selected_fin_start_date = new Date(getSelected_fin_start_year() - 1900, 3, 1);
        }
        return selected_fin_start_date;
    }

    public void setSelected_fin_start_date(Date selected_fin_start_date) {
        this.selected_fin_start_date = selected_fin_start_date;
    }

    public Date getSelected_fin_end_date() {
        if (selected_fin_end_date == null) {
            selected_fin_end_date = new Date(getSelected_fin_end_year() - 1900, 2, 31);
        }
        return selected_fin_end_date;
    }

    public void setSelected_fin_end_date(Date selected_fin_end_date) {
        this.selected_fin_end_date = selected_fin_end_date;
    }

    public boolean isCurrentFinancialyear() {
        return CurrentFinancialyear;
    }

    public void setCurrentFinancialyear(boolean CurrentFinancialyear) {
        this.CurrentFinancialyear = CurrentFinancialyear;
    }

    public void ResetFinancialYear(Integer p_fin_year) {
//getFIS_GlobalSettings().setSelected_fin_year(Integer.valueOf(ddl_financial_year.getValue().toString()));
        setSelected_fin_year(p_fin_year);
        selected_fin_start_year = Integer.valueOf(getSelected_fin_year().toString().substring(0, 4));
        selected_fin_end_year = Integer.valueOf(getSelected_fin_year().toString().substring(4, 8));
        selected_fin_start_date = new Date(getSelected_fin_start_year() - 1900, 3, 1);
        selected_fin_end_date = new Date(getSelected_fin_end_year() - 1900, 2, 31);
        if (getCurrent_fin_year().equals(getSelected_fin_year())) {
            CurrentFinancialyear = true;
        } else {
            CurrentFinancialyear = false;
        }
    }

    public Date getCurrent_quarter_start_date() {
        if (current_quarter_start_date == null) {
            Date v_temp_date = new Date();
            current_quarter_start_date = new Date(v_temp_date.getYear(), (v_temp_date.getMonth() / 3) * 3, 1);
        }

        return current_quarter_start_date;
    }

    public void setCurrent_quarter_start_date(Date current_quarter_start_date) {
        this.current_quarter_start_date = current_quarter_start_date;
    }

    public Date getCurrent_quarter_end_date() {
        if (current_quarter_end_date == null) {
            Date v_temp_date = new Date();
            Calendar calendar = Calendar.getInstance();
            int quater_end_month = (v_temp_date.getMonth() / 3) * 3 + 2;
            calendar.set(v_temp_date.getYear(), quater_end_month, v_temp_date.getDate());
            int quater_end_Day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            current_quarter_end_date = new Date(v_temp_date.getYear(), quater_end_month, quater_end_Day);
        }
        return current_quarter_end_date;
    }

    public void setCurrent_quarter_end_date(Date current_quarter_end_date) {
        this.current_quarter_end_date = current_quarter_end_date;
    }

    public Date getDate_min_entry_start_date() {
        if (date_min_entry_start_date == null) {
            date_min_entry_start_date = getCurrent_fin_start_date();
        }
        return date_min_entry_start_date;
    }

    public void setDate_min_entry_start_date(Date date_min_entry_start_date) {
        this.date_min_entry_start_date = date_min_entry_start_date;
    }

    public Date getDate_min_entry_end_date() {
        if (date_min_entry_end_date == null) {
            date_min_entry_end_date = getCurrent_fin_end_date();
        }
        return date_min_entry_end_date;
    }

    public void setDate_min_entry_end_date(Date date_min_entry_end_date) {
        this.date_min_entry_end_date = date_min_entry_end_date;
    }

    public String getString_min_entry_start_date() {
        if (string_min_entry_start_date == null) {
            string_min_entry_start_date = dateTimeUtility.ChangeDateFormat(getDate_min_entry_start_date(), dateTimeUtility.getDateFormat());
        }
        return string_min_entry_start_date;
    }

    public void setString_min_entry_start_date(String string_min_entry_start_date) {
        this.string_min_entry_start_date = string_min_entry_start_date;
    }

    public String getString_min_entry_end_date() {
        if (string_min_entry_end_date == null) {
            string_min_entry_end_date = dateTimeUtility.ChangeDateFormat(getDate_min_entry_end_date(), dateTimeUtility.getDateFormat());
        }
        return string_min_entry_end_date;
    }

    public void setString_min_entry_end_date(String string_min_entry_end_date) {
        this.string_min_entry_end_date = string_min_entry_end_date;
    }
    // </editor-fold>
    //<editor-fold defaultstate="collapsed" desc="GeneralDialog">
    String out_GeneralDialog_detail = new String();
    String out_GeneralDialog_header = new String();

    public String getOut_GeneralDialog_detail() {
        return out_GeneralDialog_detail;
    }

    public void setOut_GeneralDialog_detail(String out_GeneralDialog_detail) {
        this.out_GeneralDialog_detail = out_GeneralDialog_detail;
    }

    public String getOut_GeneralDialog_header() {
        return out_GeneralDialog_header;
    }

    public void setOut_GeneralDialog_header(String out_GeneralDialog_header) {
        this.out_GeneralDialog_header = out_GeneralDialog_header;
    }

    public void SetGeneralDialog(String p_header, String p_detail) {
        out_GeneralDialog_header = p_header;
        out_GeneralDialog_detail = p_detail;
    }
    //</editor-fold>    
    //<editor-fold defaultstate="collapsed" desc="temp_max_date">
    String temp_max_date = "30-Jun-2012";

    public String getTemp_max_date() {
        return temp_max_date;
    }

    public void setTemp_max_date(String temp_max_date) {
        this.temp_max_date = temp_max_date;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="getMonthName">

    public String getMonthName(int p_month) {
        String v_returning_value;
        switch (p_month) {
            case 1:
                v_returning_value = "JAN";
                break;
            case 2:
                v_returning_value = "FEB";
                break;
            case 3:
                v_returning_value = "MAR";
                break;
            case 4:
                v_returning_value = "APR";
                break;
            case 5:
                v_returning_value = "MAY";
                break;
            case 6:
                v_returning_value = "JUN";
                break;
            case 7:
                v_returning_value = "JUL";
                break;
            case 8:
                v_returning_value = "AUG";
                break;
            case 9:
                v_returning_value = "SEP";
                break;
            case 10:
                v_returning_value = "OCT";
                break;
            case 11:
                v_returning_value = "NOV";
                break;
            case 12:
                v_returning_value = "DEC";
                break;
            default:
                v_returning_value = null;
        }
        return v_returning_value;
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="getjdbcFES_PROJECT_Oracle()">

    public DataSource getjdbcFES_PROJECT_Oracle() {
        return jdbcFES_PROJECT_Oracle;
    }// </editor-fold>    
    // <editor-fold defaultstate="collapsed" desc="Default Constructor and other beans">
// <editor-fold defaultstate="collapsed" desc="getGlobalSettings">

//    protected GlobalSettings getGlobalSettings() {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        return (GlobalSettings) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "GlobalSettings");
//    }// </editor-fold>

    public GlobalUtilities() {
    }
    // </editor-fold>    
}
