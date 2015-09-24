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
import org.fes.hydrology_programme.entities.WtrRainguageMst;
import org.fes.hydrology_programme.entities.WtrWshedMst;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;
import org.fes.hydrology_programme.sessions.WtrRainguageMstFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrWshedMstFacadeLocal;
import org.fes.lib.utilities.LogGenerator;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author alkesh
 */
@ManagedBean
@ViewScoped
public class Raingauge implements Serializable {
    @EJB
    private WtrRainguageMstFacadeLocal wtrRainguageMstFacade;
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
    
    //<editor-fold defaultstate="collapsed" desc="tbl_rgauge_list">
    List<WtrRainguageMst> tbl_rgauge_list;
    List<WtrRainguageMst> tbl_rgauge_list_filtered;

    public List<WtrRainguageMst> getTbl_rgauge_list_filtered() {
        return tbl_rgauge_list_filtered;
    }

    public void setTbl_rgauge_list_filtered(List<WtrRainguageMst> tbl_rgauge_list_filtered) {
        this.tbl_rgauge_list_filtered = tbl_rgauge_list_filtered;
    }

    public List<WtrRainguageMst> getTbl_rgauge_list() {
        return tbl_rgauge_list;
    }

    public void setTbl_rgauge_list(List<WtrRainguageMst> tbl_rgauge_list) {
        this.tbl_rgauge_list = tbl_rgauge_list;
    }

    public void setTbl_rgauge_list() {
        tbl_rgauge_list = wtrRainguageMstFacade.getRgaugeList((getGlobalSettings().getEnt_login_user().getPfaRsoNumber() == null?0:getGlobalSettings().getEnt_login_user().getPfaRsoNumber().getPfaNo()));
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Rain Gauge Entry">
    //<editor-fold defaultstate="collapsed" desc="Objectst">
    
    String ddl_gtype;
    String txt_glocation;
    String txt_gpsn;
    String txt_gpse;
    String txt_gelevation;
    Date   cal_installdt;

    public Date getCal_installdt() {
        return cal_installdt;
    }

    public void setCal_installdt(Date cal_installdt) {
        this.cal_installdt = cal_installdt;
    }

    public String getTxt_gelevation() {
        return txt_gelevation;
    }

    public void setTxt_gelevation(String txt_gelevation) {
        this.txt_gelevation = txt_gelevation;
    }

    public String getDdl_gtype() {
        return ddl_gtype;
    }

    public void setDdl_gtype(String ddl_gtype) {
        this.ddl_gtype = ddl_gtype;
    }

    public String getTxt_glocation() {
        return txt_glocation;
    }

    public void setTxt_glocation(String txt_glocation) {
        this.txt_glocation = txt_glocation;
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

    

    //</editor-fold>
    public void btn_rgauge_create(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrRainguageMst ent_WtrRgaugeMst = new WtrRainguageMst();
            
            ent_WtrRgaugeMst.setRgSrno(-1);
            ent_WtrRgaugeMst.setRgWshedNo(new WtrWshedMst(new Integer(ddl_wshed)));
            ent_WtrRgaugeMst.setRgGuageType(ddl_gtype);
            ent_WtrRgaugeMst.setRgInstallDate(cal_installdt);
            ent_WtrRgaugeMst.setRgGuageLocation(txt_glocation.toUpperCase());
            ent_WtrRgaugeMst.setRgGpsN(txt_gpsn);
            ent_WtrRgaugeMst.setRgGpsE(txt_gpse);
            ent_WtrRgaugeMst.setCreateby(getGlobalSettings().getUser_id());
            ent_WtrRgaugeMst.setCreatedt(new Date());
            ent_WtrRgaugeMst.setRgElevation(new BigDecimal(txt_gelevation));
            wtrRainguageMstFacade.create(ent_WtrRgaugeMst);
            setTbl_rgauge_list();
            
            ddl_wshed=null;
            ddl_gtype=null;
            cal_installdt=null;
            txt_glocation=null;
            txt_gpsn=null;
            txt_gpse=null;
            txt_gelevation=null;
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Rain Gauge Detail Created", "Rain Gauge Created Successfully"));
        } catch (Exception exception) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error in creating Rain Gauge detail"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "RainGaugeEntry", null, exception);
        }

    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="rgaugeEdit">
    public void rgaugeEdit(RowEditEvent event) {
        WtrRainguageMst ent_RGauge = (WtrRainguageMst) event.getObject();
        wtrRainguageMstFacade.edit(ent_RGauge);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="rgauge_remove">
    WtrRainguageMst ent_rgauge_remove;

    public WtrRainguageMst getEnt_rgauge_remove() {
        return ent_rgauge_remove;
    }

    public void setEnt_rgauge_remove(WtrRainguageMst ent_rgauge_remove) {
        wtrRainguageMstFacade.remove(ent_rgauge_remove);
        setTbl_rgauge_list();
        this.ent_rgauge_remove = ent_rgauge_remove;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="init()">
    @PostConstruct
    public void init() {
        setDdl_wshed();
        setTbl_rgauge_list();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">

    public Raingauge() {
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
