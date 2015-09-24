/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.jsf.pages.entry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.fes.hydrology_programme.custom_entities.EntryData;
import org.fes.hydrology_programme.custom_entities.Month_wise_entry;
import org.fes.hydrology_programme.custom_entities.System_Properties;
import org.fes.hydrology_programme.entities.WtrRainfallData;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;
import org.fes.hydrology_programme.sessions.WtrRainfallDataFacadeLocal;
import org.fes.lib.utilities.DateTimeUtility;
import org.fes.lib.utilities.LogGenerator;

/**
 *
 * @author alkesh
 */
@ManagedBean
@ViewScoped
public class Rainfall_data_old implements Serializable {

    @EJB
    private WtrRainfallDataFacadeLocal wtrRainfallDataFacade;
    LogGenerator logGenerator = new LogGenerator();
    System_Properties system_Properties = new System_Properties();
    DateTimeUtility dateTimeUtility = new DateTimeUtility();
    //<editor-fold defaultstate="collapsed" desc="Month & Year Settings">
    String ddl_month;
    String ddl_year;
    List<SelectItem> ddl_year_options;

    public String getDdl_month() {
        return ddl_month;
    }

    public void setDdl_month(String ddl_month) {
        this.ddl_month = ddl_month;
    }

    public String getDdl_year() {
        return ddl_year;
    }

    public void setDdl_year(String ddl_year) {
        this.ddl_year = ddl_year;
    }

    public List<SelectItem> getDdl_year_options() {
        return ddl_year_options;
    }

    public void setDdl_year_options(List<SelectItem> ddl_year_options) {
        this.ddl_year_options = ddl_year_options;
    }

    public void setMonthYear() {
        ddl_year_options = new ArrayList<SelectItem>();
        int currYear = (new Date()).getYear() + 1900;
        for (int i = currYear; i >= 1900; i--) {
            ddl_year_options.add(new SelectItem(i));
        }
        ddl_year = String.valueOf(currYear);
        ddl_month = String.valueOf((new Date()).getMonth() + 1);
    }

    public void ddl_month_changed(ValueChangeEvent event) {
        ddl_month = event.getNewValue().toString();
        setTbl_month_wise_entry();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="wtrRainfallDatas">
    List<WtrRainfallData> wtrRainfallDatas;
    List<Month_wise_entry> tbl_month_wise_entry;
    Integer monthEndDate;

    public List<WtrRainfallData> getWtrRainfallDatas() {
        return wtrRainfallDatas;
    }

    public void setWtrRainfallDatas(List<WtrRainfallData> wtrRainfallDatas) {
        this.wtrRainfallDatas = wtrRainfallDatas;
    }

    public List<Month_wise_entry> getTbl_month_wise_entry() {
        return tbl_month_wise_entry;
    }

    public void setTbl_month_wise_entry(List<Month_wise_entry> tbl_month_wise_entry) {
        this.tbl_month_wise_entry = tbl_month_wise_entry;
    }

    public Integer getMonthEndDate() {
        return monthEndDate;
    }

    public void setMonthEndDate(Integer monthEndDate) {
        this.monthEndDate = monthEndDate;
    }

    public void setTbl_month_wise_entry() {
        Month_wise_entry ent_Month_wise_entry = new Month_wise_entry(1);
        tbl_month_wise_entry = new ArrayList<Month_wise_entry>();
        Date v_start_date = dateTimeUtility.startDateOfMonthFromDate(new Date(new Integer(ddl_year) - 1900, new Integer(ddl_month) - 1, 1));
        Date v_end_date = dateTimeUtility.endDateOfMonthFromDate(new Date(new Integer(ddl_year) - 1900, new Integer(ddl_month) - 1, 1));
        monthEndDate = v_end_date.getDate();
        List<EntryData> lst_to_append = new ArrayList<EntryData>();
        wtrRainfallDatas = wtrRainfallDataFacade.findAllByInterval(null, v_start_date, v_end_date, true);
        while (v_start_date.before(v_end_date)) {
            lst_to_append.add(new EntryData(v_start_date));
            v_start_date = dateTimeUtility.nextDate(v_start_date);
        }
        for (int i = monthEndDate - 1; i < 31; i++) {
            lst_to_append.add(i, new EntryData(new Date(new Integer(ddl_year) - 1900, new Integer(ddl_month) - 1, i + 1)));
        }
        int n = wtrRainfallDatas.size();
        for (int i = 0; i < n; i++) {
            lst_to_append.get(wtrRainfallDatas.get(i).getRfallDate().getDate() - 1).setEntry_unit(wtrRainfallDatas.get(i).getRfallInMm());
        }
        ent_Month_wise_entry.setRowData(lst_to_append);
        tbl_month_wise_entry.add(ent_Month_wise_entry);

//        wtrRainfallDatas = new ArrayList<WtrRainfallData>();
//        Date v_start_date = dateTimeUtility.startDateOfMonthFromDate(new Date(new Integer(ddl_year) - 1900, new Integer(ddl_month), 1));
//        Date v_end_date = dateTimeUtility.endDateOfMonthFromDate(new Date(new Integer(ddl_year) - 1900, new Integer(ddl_month), 1));
//        wtrRainfallDatas = wtrRainfallDataFacade.findAll(v_start_date, v_end_date);
//        List<Month_wise_entry> tbl_rainfall_entry = new ArrayList<Month_wise_entry>();
//        while (v_start_date.before(v_end_date)) {
//            tbl_rainfall_entry.add(new Month_wise_entry(v_start_date));
//            v_start_date = dateTimeUtility.nextDate(v_start_date);
//        }
//        int n = wtrRainfallDatas.size();
//        int index;
//        for (int i = 0; i < n; i++) {
//            WtrRainfallData ent_RainfallData = wtrRainfallDatas.get(i);
//            index = tbl_rainfall_entry.indexOf(new Month_wise_entry(ent_RainfallData.getRfallDate()));
//            Month_wise_entry ent_Month_wise_entry = tbl_rainfall_entry.get(index);
//            ent_Month_wise_entry.setEntry_unit_cm(ent_Month_wise_entry.getEntry_unit_cm());
//            ent_Month_wise_entry.setEntry_unit_mm(ent_Month_wise_entry.getEntry_unit_mm());
//            ent_Month_wise_entry.setEntry_unit_inch(ent_Month_wise_entry.getEntry_unit_inch());
//            tbl_rainfall_entry.set(index, ent_Month_wise_entry);
//        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="init()">

    @PostConstruct
    public void init() {
        setMonthYear();
        setTbl_month_wise_entry();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">

    public Rainfall_data_old() {
    }
    // <editor-fold defaultstate="collapsed" desc="getGlobalSettings">

    protected GlobalSettings getGlobalSettings() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (GlobalSettings) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "GlobalSettings");
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="getGlobalUtilities">

    protected GlobalUtilities getGlobalUtilities() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (GlobalUtilities) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "GlobalUtilities");
    }// </editor-fold>
    //</editor-fold>
}
