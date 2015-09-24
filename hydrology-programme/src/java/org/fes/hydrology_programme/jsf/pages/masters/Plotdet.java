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
import org.fes.hydrology_programme.entities.WtrPlotMst;
import org.fes.hydrology_programme.entities.WtrWshedMst;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;
import org.fes.hydrology_programme.sessions.WtrPlotMstFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrWshedMstFacadeLocal;
import org.fes.lib.utilities.LogGenerator;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author alkesh
 */
@ManagedBean
@ViewScoped
public class Plotdet implements Serializable {
    @EJB
    private WtrPlotMstFacadeLocal wtrPlotMstFacade;
    
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
    
    //<editor-fold defaultstate="collapsed" desc="tbl_plot_list">
    List<WtrPlotMst> tbl_plot_list;
    List<WtrPlotMst> tbl_plot_list_filtered;

    public List<WtrPlotMst> getTbl_plot_list_filtered() {
        return tbl_plot_list_filtered;
    }

    public void setTbl_plot_list_filtered(List<WtrPlotMst> tbl_plot_list_filtered) {
        this.tbl_plot_list_filtered = tbl_plot_list_filtered;
    }

    public List<WtrPlotMst> getTbl_plot_list() {
        return tbl_plot_list;
    }

    public void setTbl_plot_list(List<WtrPlotMst> tbl_plot_list) {
        this.tbl_plot_list = tbl_plot_list;
    }

    public void setTbl_plot_list() {
        tbl_plot_list = wtrPlotMstFacade.getPlotList((getGlobalSettings().getEnt_login_user().getPfaRsoNumber() == null?0:getGlobalSettings().getEnt_login_user().getPfaRsoNumber().getPfaNo()));
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Plotdet Entry">
    //<editor-fold defaultstate="collapsed" desc="Objectst">
    
    String txt_pfarmer;
    String ddl_stype;
    String ddl_ploc;
    String txt_gpsn;
    String txt_gpse;
    String txt_pelevate;
    String txt_surveyno;

    public String getDdl_stype() {
        return ddl_stype;
    }

    public void setDdl_stype(String ddl_stype) {
        this.ddl_stype = ddl_stype;
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

    public String getTxt_pelevate() {
        return txt_pelevate;
    }

    public void setTxt_pelevate(String txt_pelevate) {
        this.txt_pelevate = txt_pelevate;
    }

    public String getTxt_pfarmer() {
        return txt_pfarmer;
    }

    public void setTxt_pfarmer(String txt_pfarmer) {
        this.txt_pfarmer = txt_pfarmer;
    }

    public String getTxt_surveyno() {
        return txt_surveyno;
    }

    public void setTxt_surveyno(String txt_surveyno) {
        this.txt_surveyno = txt_surveyno;
    }

    public String getDdl_ploc() {
        return ddl_ploc;
    }

    public void setDdl_ploc(String ddl_ploc) {
        this.ddl_ploc = ddl_ploc;
    }


    //</editor-fold>
    
    public void btn_plot_create(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrPlotMst ent_WtrPlotMst = new WtrPlotMst();
            
            ent_WtrPlotMst.setPlotSrno(-1);
            ent_WtrPlotMst.setPlotWshedNo(new WtrWshedMst(new Integer(ddl_wshed)));
            ent_WtrPlotMst.setPlotSoiltype(ddl_stype.trim().toUpperCase());
            ent_WtrPlotMst.setPlotFarmer(txt_pfarmer.trim().toUpperCase());
            ent_WtrPlotMst.setPlotSurveyNo(txt_surveyno);
            ent_WtrPlotMst.setPlotLocation(ddl_ploc.toUpperCase());
            ent_WtrPlotMst.setPlotGpsn(txt_gpsn);
            ent_WtrPlotMst.setPlotGpse(txt_gpse);
            ent_WtrPlotMst.setCreateby(getGlobalSettings().getUser_id());
            ent_WtrPlotMst.setCreatedt(new Date());
            ent_WtrPlotMst.setPlotElevation(new BigDecimal(txt_pelevate));
            wtrPlotMstFacade.create(ent_WtrPlotMst);
            setTbl_plot_list();
            ddl_stype=null;
            txt_pfarmer=null;
            txt_surveyno=null;
            ddl_ploc=null;
            txt_gpsn=null;
            txt_gpse=null;
            txt_pelevate=null;
            
            
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Plot Detail Created", "Plot Details Created Successfully"));
        } catch (Exception exception) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error in creating Plot detail"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "PlotEntry", null, exception);
        }

    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="plotEdit">
    public void plotEdit(RowEditEvent event) {
        WtrPlotMst ent_WtrPlot = (WtrPlotMst) event.getObject();
        wtrPlotMstFacade.edit(ent_WtrPlot);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="plot_remove">
    WtrPlotMst ent_plot_remove;

    public WtrPlotMst getEnt_plot_remove() {
        return ent_plot_remove;
    }

    public void setEnt_plot_remove(WtrPlotMst ent_plot_remove) {
        wtrPlotMstFacade.remove(ent_plot_remove);
        setTbl_plot_list();
        this.ent_plot_remove = ent_plot_remove;
    }
    //</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="init()">
    @PostConstruct
    public void init() {
        setDdl_wshed();
        setTbl_plot_list();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">

    public Plotdet() {
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
