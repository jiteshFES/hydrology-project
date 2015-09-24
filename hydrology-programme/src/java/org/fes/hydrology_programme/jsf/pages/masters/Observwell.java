/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.jsf.pages.masters;

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
import org.fes.hydrology_programme.entities.WtrWshedMst;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;
import org.fes.hydrology_programme.sessions.WtrObservWellMstFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrWshedMstFacadeLocal;
import org.fes.lib.utilities.LogGenerator;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author alkesh
 */
@ManagedBean
@ViewScoped
public class Observwell implements Serializable {
    @EJB
    private WtrObservWellMstFacadeLocal wtrObservWellMstFacade;
    @EJB
    private WtrWshedMstFacadeLocal wtrWshedMstFacade;
    
   
    LogGenerator logGenerator = new LogGenerator();
    System_Properties system_Properties = new System_Properties();
    

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
            List<WtrWshedMst> lst_WshedMsts = wtrWshedMstFacade.getWshedList((getGlobalSettings().getEnt_login_user().getPfaRsoNumber() == null?0:getGlobalSettings().getEnt_login_user().getPfaRsoNumber().getPfaNo()));
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
          setDdl_wshed();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="tbl_obwell_list">
    List<WtrObservWellMst> tbl_obwell_list;
    List<WtrObservWellMst> tbl_obwell_list_filtered;

    public List<WtrObservWellMst> getTbl_obwell_list_filtered() {
        return tbl_obwell_list_filtered;
    }

    public void setTbl_obwell_list_filtered(List<WtrObservWellMst> tbl_obwell_list_filtered) {
        this.tbl_obwell_list_filtered = tbl_obwell_list_filtered;
    }

    public List<WtrObservWellMst> getTbl_obwell_list() {
        return tbl_obwell_list;
    }

    public void setTbl_obwell_list(List<WtrObservWellMst> tbl_obwell_list) {
        this.tbl_obwell_list = tbl_obwell_list;
    }

    public void setTbl_obwell_list() {
        tbl_obwell_list = wtrObservWellMstFacade.getObwellList((getGlobalSettings().getEnt_login_user().getPfaRsoNumber() == null?0:getGlobalSettings().getEnt_login_user().getPfaRsoNumber().getPfaNo()));
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Observation Well Entry">
    //<editor-fold defaultstate="collapsed" desc="Objectst">
    
    String ddl_wtype;
    String txt_ofarmer;
    String txt_drilyear;
    String txt_wnumber;
    String txt_depth;
    String txt_pumphp;
    String txt_pumpstage;
    String txt_pelevate;
    String txt_wlocation;
    String txt_gpsn;
    String txt_gpse;

    public String getTxt_pelevate() {
        return txt_pelevate;
    }

    public void setTxt_pelevate(String txt_pelevate) {
        this.txt_pelevate = txt_pelevate;
    }

    public String getTxt_pumphp() {
        return txt_pumphp;
    }

    public void setTxt_pumphp(String txt_pumphp) {
        this.txt_pumphp = txt_pumphp;
    }

    public String getTxt_pumpstage() {
        return txt_pumpstage;
    }

    public void setTxt_pumpstage(String txt_pumpstage) {
        this.txt_pumpstage = txt_pumpstage;
    }

    public String getDdl_wtype() {
        return ddl_wtype;
    }

    public void setDdl_wtype(String ddl_wtype) {
        this.ddl_wtype = ddl_wtype;
    }

    
    public String getTxt_drilyear() {
        return txt_drilyear;
    }

    public void setTxt_drilyear(String txt_drilyear) {
        this.txt_drilyear = txt_drilyear;
    }

    public String getTxt_gpse() {
        return txt_gpse;
    }

    public void setTxt_gpse(String txt_gpse) {
        this.txt_gpse = txt_gpse;
    }

    public String getTxt_gpsn() {
        return txt_gpsn;
    }

    public void setTxt_gpsn(String txt_gpsn) {
        this.txt_gpsn = txt_gpsn;
    }

    public String getTxt_depth() {
        return txt_depth;
    }

    public void setTxt_depth(String txt_depth) {
        this.txt_depth = txt_depth;
    }

    public String getTxt_ofarmer() {
        return txt_ofarmer;
    }

    public void setTxt_ofarmer(String txt_ofarmer) {
        this.txt_ofarmer = txt_ofarmer;
    }

    public String getTxt_wlocation() {
        return txt_wlocation;
    }

    public void setTxt_wlocation(String txt_wlocation) {
        this.txt_wlocation = txt_wlocation;
    }

    public String getTxt_wnumber() {
        return txt_wnumber;
    }

    public void setTxt_wnumber(String txt_wnumber) {
        this.txt_wnumber = txt_wnumber;
    }

    

    

    //</editor-fold>
    public void btn_obwell_create(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrObservWellMst ent_WtrObservWellMst = new WtrObservWellMst();
            
            ent_WtrObservWellMst.setObwellSrno(-1);
            ent_WtrObservWellMst.setObwellWshedNo(new WtrWshedMst(new Integer(ddl_wshed)));
            ent_WtrObservWellMst.setObwellFarmer(txt_ofarmer.trim().toUpperCase());
            ent_WtrObservWellMst.setObwellType(ddl_wtype);
            ent_WtrObservWellMst.setObwellDepth(new BigDecimal(txt_depth));
            ent_WtrObservWellMst.setObwellDrillYear(txt_drilyear);
            ent_WtrObservWellMst.setObwellMotorCapacity(txt_pumphp.trim().toUpperCase());
            ent_WtrObservWellMst.setObwellStages(txt_pumpstage.trim().toUpperCase());
            ent_WtrObservWellMst.setObwellElevation(new BigDecimal(txt_pelevate));
            ent_WtrObservWellMst.setObwellNumber(txt_wnumber.trim().toUpperCase());
            ent_WtrObservWellMst.setObwellLocation(txt_wlocation.toUpperCase().trim());
            ent_WtrObservWellMst.setObwellGpsn(txt_gpsn.trim().toUpperCase());
            ent_WtrObservWellMst.setObwellGpse(txt_gpse.trim().toUpperCase());
            ent_WtrObservWellMst.setCreateby(getGlobalSettings().getUser_id());
            ent_WtrObservWellMst.setCreatedt(new Date());
            wtrObservWellMstFacade.create(ent_WtrObservWellMst);
            setTbl_obwell_list();
            
            ddl_wshed=null;
            txt_ofarmer=null;
            ddl_wtype=null;
            txt_depth=null;
            txt_drilyear=null;
            txt_pumphp=null;
            txt_pumpstage=null;
            txt_pelevate=null;
            txt_wnumber=null;
            txt_wlocation=null;
            txt_gpsn=null;
            txt_gpse=null;
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Observation Well Detail Created", "Observation Well Details Created Successfully"));
        } catch (Exception exception) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error in creating Observation well detail"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "ObservWellEntry", null, exception);
        }

    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Observation Well Edit">
    public void obwellEdit(RowEditEvent event) {
        WtrObservWellMst ent_Obwell = (WtrObservWellMst) event.getObject();
        
        wtrObservWellMstFacade.edit(ent_Obwell);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Observation Well remove">
    WtrObservWellMst ent_obwell_remove;

    public WtrObservWellMst getEnt_obwell_remove() {
        return ent_obwell_remove;
    }

    public void setEnt_obwell_remove(WtrObservWellMst ent_obwell_remove) {
        wtrObservWellMstFacade.remove(ent_obwell_remove);
        setTbl_obwell_list();
        this.ent_obwell_remove = ent_obwell_remove;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="init()">
    @PostConstruct
    public void init() {
        setDdl_wshed();
        setTbl_obwell_list();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">

    public Observwell() {
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
