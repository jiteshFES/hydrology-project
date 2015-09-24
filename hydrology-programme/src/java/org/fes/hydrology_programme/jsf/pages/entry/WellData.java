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
import org.fes.hydrology_programme.entities.WtrObservWellMst;
import org.fes.hydrology_programme.entities.WtrObwellData;
import org.fes.hydrology_programme.entities.WtrWshedMst;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;
import org.fes.hydrology_programme.sessions.WtrObservWellMstFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrObwellDataFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrWshedMstFacadeLocal;
import org.fes.lib.utilities.LogGenerator;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author alkesh
 */
@ManagedBean
@ViewScoped
public class WellData implements Serializable {

    @EJB
    private WtrObservWellMstFacadeLocal wtrObservWellMstFacade;
    @EJB
    private WtrObwellDataFacadeLocal wtrObwellDataFacade;
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
        if (ddl_wshed != null) {
            ddl_farmer_options = new ArrayList<SelectItem>();
            List<String> lst_farmerMsts = wtrObservWellMstFacade.getfarmerList(new Integer(ddl_wshed));
            int n = lst_farmerMsts.size();
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    ddl_farmer_options.add(new SelectItem(lst_farmerMsts.get(i)));
                }
                ddl_farmer = ddl_farmer_options.get(0).getValue().toString();
            } else {
                ddl_farmer_options.add(new SelectItem(null, "--- Not Available ---"));
            }
        }
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
        if (ddl_farmer != null) {
            ddl_srvyno_options = new ArrayList<SelectItem>();
            List<WtrObservWellMst> lst_srvynoMsts = wtrObservWellMstFacade.getwellsrvynoList(new Integer(ddl_wshed), ddl_farmer);
            int n = lst_srvynoMsts.size();
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    ddl_srvyno_options.add(new SelectItem(lst_srvynoMsts.get(i).getObwellLocation(), lst_srvynoMsts.get(i).getObwellLocation()));
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
    //<editor-fold defaultstate="collapsed" desc="tbl_welldata_list">
    List<WtrObwellData> tbl_welldata_list;
    List<WtrObwellData> tbl_welldata_list_filtered;

    public List<WtrObwellData> getTbl_welldata_list_filtered() {
        return tbl_welldata_list_filtered;
    }

    public void setTbl_welldata_list_filtered(List<WtrObwellData> tbl_welldata_list_filtered) {
        this.tbl_welldata_list_filtered = tbl_welldata_list_filtered;
    }

    public List<WtrObwellData> getTbl_welldata_list() {
        return tbl_welldata_list;
    }

    public void setTbl_welldata_list(List<WtrObwellData> tbl_welldata_list) {
        this.tbl_welldata_list = tbl_welldata_list;
    }

    public void setTbl_welldata_list() {
        tbl_welldata_list = wtrObwellDataFacade.getwelldataList((getGlobalSettings().getEnt_login_user().getPfaRsoNumber() == null ? 0 : getGlobalSettings().getEnt_login_user().getPfaRsoNumber().getPfaNo()));
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Well Data Entry">
    //<editor-fold defaultstate="collapsed" desc="Objectst">
    Date cal_colldate;
    Date cal_phrs;
    String txt_swl;
    String txt_pwl;
    String txt_ptime;
    String txt_pdays;

    public Date getCal_phrs() {
        return cal_phrs;
    }

    public void setCal_phrs(Date cal_phrs) {
        this.cal_phrs = cal_phrs;
    }

    public String getTxt_ptime() {
        return txt_ptime;
    }

    public void setTxt_ptime(String txt_ptime) {
        this.txt_ptime = txt_ptime;
    }

    public Date getCal_colldate() {
        return cal_colldate;
    }

    public void setCal_colldate(Date cal_colldate) {
        this.cal_colldate = cal_colldate;
    }

    public String getTxt_pdays() {
        return txt_pdays;
    }

    public void setTxt_pdays(String txt_pdays) {
        this.txt_pdays = txt_pdays;
    }

    public String getTxt_pwl() {
        return txt_pwl;
    }

    public void setTxt_pwl(String txt_pwl) {
        this.txt_pwl = txt_pwl;
    }

    public String getTxt_swl() {
        return txt_swl;
    }

    public void setTxt_swl(String txt_swl) {
        this.txt_swl = txt_swl;
    }

    //</editor-fold>
    public void btn_welldata_create(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrObwellData ent_WtrObwelldata = new WtrObwellData();
            ent_WtrObwelldata.setOdataSrno(-1);
            ent_WtrObwelldata.setOdataDate(cal_colldate);
            ent_WtrObwelldata.setOdataWshedNo(new WtrWshedMst(new Integer(ddl_wshed)));
            ent_WtrObwelldata.setOdataFarmer(ddl_farmer);
            ent_WtrObwelldata.setOdataSurveyNo(ddl_srvyno);
            ent_WtrObwelldata.setOdataSwlMts(new BigDecimal(txt_swl));
            ent_WtrObwelldata.setOdataPwlMts(new BigDecimal(txt_pwl));
            ent_WtrObwelldata.setOdataDrumTime(new Integer(txt_ptime));
            ent_WtrObwelldata.setOdataPumpHrsDay(new BigDecimal(cal_phrs.getHours() + "." + cal_phrs.getMinutes()));
            ent_WtrObwelldata.setOdataPumpDaysMonth(new Short(txt_pdays));
            ent_WtrObwelldata.setCreateby(getGlobalSettings().getUser_id());
            ent_WtrObwelldata.setCreatedt(new Date());
            wtrObwellDataFacade.create(ent_WtrObwelldata);
            setTbl_welldata_list();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Observation Well Data Created", "Observation Well Data Created Successfully"));
        } catch (Exception exception) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error in creating Observation well data"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "WellDataEntry", null, exception);
        }

    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Well Data Edit">
    //<editor-fold defaultstate="collapsed" desc="ent_welldata_edit">
    WtrObwellData ent_welldata_edit;

    public WtrObwellData getEnt_welldata_edit() {
        return ent_welldata_edit;
    }

    public void setEnt_welldata_edit(WtrObwellData ent_welldata_edit) {
        updateMode = true;
        ddl_wshed = ent_welldata_edit.getOdataWshedNo().getWshedNo().toString();
        setDdl_farmer();
        ddl_farmer = ent_welldata_edit.getOdataFarmer();
        setDdl_srvyno();
        ddl_srvyno = ent_welldata_edit.getOdataSurveyNo();
        cal_colldate = ent_welldata_edit.getOdataDate();
        txt_swl = ent_welldata_edit.getOdataSwlMts().toString();
        txt_pwl = ent_welldata_edit.getOdataPwlMts().toString();
        txt_ptime = ent_welldata_edit.getOdataDrumTime().toString();
        cal_phrs = new Date();
        cal_phrs.setHours(new Integer(ent_welldata_edit.getOdataPumpHrsDay().toString().split("\\.")[0]));
        if (ent_welldata_edit.getOdataPumpHrsDay().toString().split("\\.").length > 1) {
            cal_phrs.setMinutes(new Integer(ent_welldata_edit.getOdataPumpHrsDay().toString().split("\\.")[1]));
        } else {
            cal_phrs.setMinutes(0);
        }
        txt_pdays = ent_welldata_edit.getOdataPumpDaysMonth().toString();
        this.ent_welldata_edit = ent_welldata_edit;
    }
    //</editor-fold>

    public void btn_welldata_edit(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrObwellData ent_WtrObwelldata = wtrObwellDataFacade.find(ent_welldata_edit.getOdataSrno());
            ent_WtrObwelldata.setOdataDate(cal_colldate);
            ent_WtrObwelldata.setOdataWshedNo(new WtrWshedMst(new Integer(ddl_wshed)));
            ent_WtrObwelldata.setOdataFarmer(ddl_farmer);
            ent_WtrObwelldata.setOdataSurveyNo(ddl_srvyno);
            ent_WtrObwelldata.setOdataSwlMts(new BigDecimal(txt_swl));
            ent_WtrObwelldata.setOdataPwlMts(new BigDecimal(txt_pwl));
            ent_WtrObwelldata.setOdataDrumTime(new Integer(txt_ptime));
            ent_WtrObwelldata.setOdataPumpHrsDay(new BigDecimal(cal_phrs.getHours() + "." + cal_phrs.getMinutes()));
            ent_WtrObwelldata.setOdataPumpDaysMonth(new Short(txt_pdays));
            ent_WtrObwelldata.setCreateby(getGlobalSettings().getUser_id());
            ent_WtrObwelldata.setCreatedt(new Date());
            wtrObwellDataFacade.edit(ent_WtrObwelldata);
            setTbl_welldata_list();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Observation Well Data Updated", "Observation Well Data Updated Successfully"));
        } catch (Exception exception) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error in creating Observation well data"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "btn_welldata_edit", null, exception);
        }

    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Well Data remove">
    WtrObwellData ent_welldata_remove;

    public WtrObwellData getEnt_welldata_remove() {
        return ent_welldata_remove;
    }

    public void setEnt_welldata_remove(WtrObwellData ent_welldata_remove) {
        wtrObwellDataFacade.remove(ent_welldata_remove);
        setTbl_welldata_list();
        this.ent_welldata_remove = ent_welldata_remove;
    }
    //</editor-fold>

    public void addNewData(ActionEvent event) {
        updateMode = false;
        cal_colldate = null;
        txt_swl = null;
        txt_pwl = null;
        txt_ptime = null;
        cal_phrs = null;
        txt_pdays = null;
    }

    //<editor-fold defaultstate="collapsed" desc="init()">
    @PostConstruct
    public void init() {
        setDdl_wshed();
        setDdl_farmer();
        setDdl_srvyno();
        setTbl_welldata_list();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">

    public WellData() {
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
