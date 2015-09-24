/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.jsf.pages.entry;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.fes.hydrology_programme.custom_entities.System_Properties;
import org.fes.hydrology_programme.entities.WtrPlotMst;
import org.fes.hydrology_programme.entities.WtrSoilData;
import org.fes.hydrology_programme.entities.WtrWshedMst;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;
import org.fes.hydrology_programme.sessions.*;
import org.fes.lib.utilities.LogGenerator;

/**
 *
 * @author alkesh
 */
@ManagedBean
@ViewScoped
public class SoilData implements Serializable {
    @EJB
    private WtrPlotMstFacadeLocal wtrPlotMstFacade;
    @EJB
    private WtrSoilDataFacadeLocal wtrSoilDataFacade;
    @EJB
    private WtrWshedMstFacadeLocal wtrWshedMstFacade;
    LogGenerator logGenerator = new LogGenerator();
    System_Properties system_Properties = new System_Properties();
    //<editor-fold defaultstate="collapsed" desc="updateMode">
    boolean updateMode;

    public boolean isUpdateMode() {
        return updateMode;
    }

    public void setUpdateMode(boolean updateMode) {
        this.updateMode = updateMode;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ddl_wshed">
    String ddl_wshed;
    List<SelectItem> ddl_wshed_options;

    public String getDdl_wshed() {
        return ddl_wshed;
    }

    public void setDdl_wshed(String ddl_wshed) {
        this.ddl_wshed = ddl_wshed;
    }

    public List<SelectItem> getDdl_wshed_options() {
        return ddl_wshed_options;
    }

    public void setDdl_wshed_options(List<SelectItem> ddl_wshed_options) {
        this.ddl_wshed_options = ddl_wshed_options;
    }

    public void setDdl_wshed() {
        ddl_wshed = null;
        ddl_wshed_options = new ArrayList<SelectItem>();
        List<WtrWshedMst> lst_WshedMsts = wtrWshedMstFacade.getWshedList((getGlobalSettings().getEnt_login_user().getPfaRsoNumber() == null ? 0 : getGlobalSettings().getEnt_login_user().getPfaRsoNumber().getPfaNo()));
        int n = lst_WshedMsts.size();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                ddl_wshed_options.add(new SelectItem(lst_WshedMsts.get(i).getWshedNo().toString(), lst_WshedMsts.get(i).getWshedName()));
            }
            ddl_wshed = ddl_wshed_options.get(0).getValue().toString();
        } else {
            ddl_wshed_options.add(new SelectItem(null, "--- Not Available ---"));
        }

    }

    public void ddl_wshed_changed(ValueChangeEvent event) {
        ddl_wshed = event.getNewValue().toString();
        setDdl_farmer();
        setDdl_srvyno();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ddl_farmer">
    String ddl_farmer;
    List<SelectItem> ddl_farmer_options;

    public String getDdl_farmer() {
        return ddl_farmer;
    }

    public void setDdl_farmer(String ddl_farmer) {
        this.ddl_farmer = ddl_farmer;
    }

    public List<SelectItem> getDdl_farmer_options() {
        return ddl_farmer_options;
    }

    public void setDdl_farmer_options(List<SelectItem> ddl_farmer_options) {
        this.ddl_farmer_options = ddl_farmer_options;
    }

    public void setDdl_farmer() {
        ddl_farmer = null;
        if(ddl_wshed!=null){
        ddl_farmer_options = new ArrayList<SelectItem>();
        List<String> lst_farmerMsts = wtrPlotMstFacade.getFarmerList(new Integer(ddl_wshed));
        int n = lst_farmerMsts.size();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                ddl_farmer_options.add(new SelectItem(lst_farmerMsts.get(i).toUpperCase()));
            }
            ddl_farmer = ddl_farmer_options.get(0).getValue().toString();
        } else {
            ddl_farmer_options.add(new SelectItem(null, "--- Not Available ---"));
        }}

    }

    public void ddl_farmer_changed(ValueChangeEvent event) {
        ddl_farmer = event.getNewValue().toString();
        setDdl_srvyno();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ddl_srvyno">
    String ddl_srvyno;
    List<SelectItem> ddl_srvyno_options;

    public String getDdl_srvyno() {
        return ddl_srvyno;
    }

    public void setDdl_srvyno(String ddl_srvyno) {
        this.ddl_srvyno = ddl_srvyno;
    }

    public List<SelectItem> getDdl_srvyno_options() {
        return ddl_srvyno_options;
    }

    public void setDdl_srvyno_options(List<SelectItem> ddl_srvyno_options) {
        this.ddl_srvyno_options = ddl_srvyno_options;
    }

    public void setDdl_srvyno() {
        ddl_srvyno = null;
        if(ddl_farmer!=null){
        ddl_srvyno_options = new ArrayList<SelectItem>();
        List<WtrPlotMst> lst_srvynoMsts = wtrPlotMstFacade.getPlotsrvyList(new Integer(ddl_wshed), ddl_farmer);
        int n = lst_srvynoMsts.size();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                ddl_srvyno_options.add(new SelectItem(lst_srvynoMsts.get(i).getPlotSurveyNo(),lst_srvynoMsts.get(i).getPlotSurveyNo()));
            }
            ddl_srvyno = ddl_srvyno_options.get(0).getValue().toString();
        } else {
            ddl_srvyno_options.add(new SelectItem(null, "--- Not Available ---"));
        }
        }
    }

    public void ddl_srvyno_changed(ValueChangeEvent event) {
        setDdl_srvyno();
    }
    //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="tbl_soildata_list">
    List<WtrSoilData> tbl_soildata_list;
    List<WtrSoilData> tbl_soildata_list_filtered;

    public List<WtrSoilData> getTbl_soildata_list_filtered() {
        return tbl_soildata_list_filtered;
    }

    public void setTbl_soildata_list_filtered(List<WtrSoilData> tbl_soildata_list_filtered) {
        this.tbl_soildata_list_filtered = tbl_soildata_list_filtered;
    }

    public List<WtrSoilData> getTbl_soildata_list() {
        return tbl_soildata_list;
    }

    public void setTbl_soildata_list(List<WtrSoilData> tbl_soildata_list) {
        this.tbl_soildata_list = tbl_soildata_list;
    }

    public void setTbl_soildata_list() {
        tbl_soildata_list = wtrSoilDataFacade.getSoildataList((getGlobalSettings().getEnt_login_user().getPfaRsoNumber() == null ? 0 : getGlobalSettings().getEnt_login_user().getPfaRsoNumber().getPfaNo()));
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="soil Data Entry">
    //<editor-fold defaultstate="collapsed" desc="Objectst">
    Date cal_colldate;
    String txt_percentage;

    public Date getCal_colldate() {
        return cal_colldate;
    }

    public void setCal_colldate(Date cal_colldate) {
        this.cal_colldate = cal_colldate;
    }

    public String getTxt_percentage() {
        return txt_percentage;
    }

    public void setTxt_percentage(String txt_percentage) {
        this.txt_percentage = txt_percentage;
    }
    
   

    //</editor-fold>
    public void btn_soildata_create(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrSoilData ent_WtrSoildata = new WtrSoilData();
            ent_WtrSoildata.setSoilSrno(-1);
            ent_WtrSoildata.setSoilDate(cal_colldate);
            ent_WtrSoildata.setSoilWshedNo(new WtrWshedMst(new Integer(ddl_wshed)));
            ent_WtrSoildata.setSoilFarmer(ddl_farmer);
            ent_WtrSoildata.setSoilSurveyNo(ddl_srvyno);
            ent_WtrSoildata.setSoilPercentage(new BigDecimal(txt_percentage));
            ent_WtrSoildata.setCreateby(getGlobalSettings().getUser_id());
            ent_WtrSoildata.setCreatedt(new Date());
            wtrSoilDataFacade.create(ent_WtrSoildata);
            setTbl_soildata_list();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Soil Moisture Data Created", "Soil Moisture Data Created Successfully"));
        } catch (Exception exception) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error in creating Soil Moisture data"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "soilDataEntry", null, exception);
        }

    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="soil Data Edit">
    //<editor-fold defaultstate="collapsed" desc="ent_soildata_edit">
    WtrSoilData ent_soildata_edit;

    public WtrSoilData getEnt_soildata_edit() {
        return ent_soildata_edit;
    }

    public void setEnt_soildata_edit(WtrSoilData ent_soildata_edit) {
        updateMode = true;
        ddl_wshed = ent_soildata_edit.getSoilWshedNo().getWshedNo().toString();
        ddl_farmer = ent_soildata_edit.getSoilFarmer();
        setDdl_srvyno();
        ddl_srvyno = ent_soildata_edit.getSoilSurveyNo();
        cal_colldate = ent_soildata_edit.getSoilDate();
        txt_percentage = ent_soildata_edit.getSoilPercentage().toString();
        this.ent_soildata_edit = ent_soildata_edit;
    }
    //</editor-fold>
//    public void soildataEdit(RowEditEvent event) {
//        System.out.println("Into Edit");
//        WtrObsoilData ent_soildata = (WtrObsoilData) event.getObject();
//        wtrObsoilDataFacade.edit(ent_soildata);
//        
//        setTbl_soildata_list();
//    }

    public void btn_soildata_edit(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrSoilData ent_WtrSoildata = wtrSoilDataFacade.find(ent_soildata_edit.getSoilSrno());
            ent_WtrSoildata.setSoilDate(cal_colldate);
            ent_WtrSoildata.setSoilWshedNo(new WtrWshedMst(new Integer(ddl_wshed)));
            ent_WtrSoildata.setSoilFarmer(ddl_farmer);
            ent_WtrSoildata.setSoilSurveyNo(ddl_srvyno);
            ent_WtrSoildata.setSoilPercentage(new BigDecimal(txt_percentage));
            ent_WtrSoildata.setCreateby(getGlobalSettings().getUser_id());
            ent_WtrSoildata.setCreatedt(new Date());
            wtrSoilDataFacade.edit(ent_WtrSoildata);
            setTbl_soildata_list();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Soil Moisture Data Created", "Soil Moisture Data Updated Successfully"));
        } catch (Exception exception) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error in creating Soil Moisture data"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "soilDataEntry", null, exception);
        }

    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="soil Data remove">
    WtrSoilData ent_soildata_remove;

    public WtrSoilData getEnt_soildata_remove() {
        return ent_soildata_remove;
    }

    public void setEnt_soildata_remove(WtrSoilData ent_soildata_remove) {
        wtrSoilDataFacade.remove(ent_soildata_remove);
        setTbl_soildata_list();
        this.ent_soildata_remove = ent_soildata_remove;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="addNewData">
    public void addNewData(ActionEvent event) {
        updateMode = false;
        cal_colldate = null;
        txt_percentage = null;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="init()">
    @PostConstruct
    public void init() {
        setDdl_wshed();
        setDdl_farmer();
        setDdl_srvyno();
        setTbl_soildata_list();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">

    public SoilData() {
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
