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
import org.fes.hydrology_programme.entities.WtrStreamGauge;
import org.fes.hydrology_programme.entities.WtrStreamGaugePK;
import org.fes.hydrology_programme.entities.WtrWshedMst;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;
import org.fes.hydrology_programme.sessions.WtrStreamGaugeFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrWshedMstFacadeLocal;
import org.fes.lib.utilities.LogGenerator;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author alkesh
 */
@ManagedBean
@ViewScoped
public class Streamgauge implements Serializable {

    @EJB
    private WtrStreamGaugeFacadeLocal wtrStreamGaugeFacade;
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
        setDdl_wshed();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="tbl_streamg_list">
    List<WtrStreamGauge> tbl_streamg_list;
    List<WtrStreamGauge> tbl_streamg_list_filtered;

    public List<WtrStreamGauge> getTbl_streamg_list_filtered() {
        return tbl_streamg_list_filtered;
    }

    public void setTbl_streamg_list_filtered(List<WtrStreamGauge> tbl_streamg_list_filtered) {
        this.tbl_streamg_list_filtered = tbl_streamg_list_filtered;
    }

    public List<WtrStreamGauge> getTbl_streamg_list() {        
        return tbl_streamg_list;
    }

    public void setTbl_streamg_list(List<WtrStreamGauge> tbl_streamg_list) {
        this.tbl_streamg_list = tbl_streamg_list;
    }

    public void setTbl_streamg_list() {
        tbl_streamg_list = wtrStreamGaugeFacade.getStreamList((getGlobalSettings().getEnt_login_user().getPfaRsoNumber() == null ? 0 : getGlobalSettings().getEnt_login_user().getPfaRsoNumber().getPfaNo()));
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Stream Entry">
    //<editor-fold defaultstate="collapsed" desc="Objectst">
    String txt_strname;
    String txt_damheight;
    String txt_damlen;
    String txt_strloc;
    String txt_gpsn;
    String txt_gpse;
    String txt_selevate;
    String txt_fillevel;

    public String getTxt_damheight() {
        return txt_damheight;
    }

    public void setTxt_damheight(String txt_damheight) {
        this.txt_damheight = txt_damheight;
    }

    public String getTxt_damlen() {
        return txt_damlen;
    }

    public void setTxt_damlen(String txt_damlen) {
        this.txt_damlen = txt_damlen;
    }

    public String getTxt_fillevel() {
        return txt_fillevel;
    }

    public void setTxt_fillevel(String txt_fillevel) {
        this.txt_fillevel = txt_fillevel;
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

    public String getTxt_selevate() {
        return txt_selevate;
    }

    public void setTxt_selevate(String txt_selevate) {
        this.txt_selevate = txt_selevate;
    }

    public String getTxt_strloc() {
        return txt_strloc;
    }

    public void setTxt_strloc(String txt_strloc) {
        this.txt_strloc = txt_strloc;
    }

    public String getTxt_strname() {
        return txt_strname;
    }

    public void setTxt_strname(String txt_strname) {
        this.txt_strname = txt_strname;
    }

    //</editor-fold>
    public void btn_stream_create(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrStreamGauge ent_WtrStream = new WtrStreamGauge();

            ent_WtrStream.setWtrStreamGaugePK(new WtrStreamGaugePK(-1, new Integer(ddl_wshed)));
            ent_WtrStream.setStrName(txt_strname.trim().toUpperCase());
            ent_WtrStream.setStrCheckdamHeight(new BigDecimal(txt_damheight));
            ent_WtrStream.setStrFillingLevel(new BigDecimal(txt_fillevel));
            ent_WtrStream.setStrDamLength(new BigDecimal(txt_damlen));
            ent_WtrStream.setStrLocation(txt_strloc.trim().toUpperCase());
            ent_WtrStream.setStrGpsn(txt_gpsn);
            ent_WtrStream.setStrGpse(txt_gpse);
            ent_WtrStream.setStrElevation(new BigDecimal(txt_selevate));
            ent_WtrStream.setCreateby(getGlobalSettings().getUser_id());
            ent_WtrStream.setCreatedt(new Date());
            wtrStreamGaugeFacade.create(ent_WtrStream);
            setTbl_streamg_list();

            txt_strname = null;
            ddl_wshed = null;
            txt_damheight = null;
            txt_fillevel = null;
            txt_damlen = null;
            txt_strloc = null;
            txt_gpsn = null;
            txt_gpse = null;
            txt_selevate = null;

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Stream Gauge Created", "Stream Gauge Created Successfully"));
        } catch (Exception exception) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error in creating Stream Gauge"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "StreamEntry", null, exception);
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="streamEdit">
    public void streamEdit(RowEditEvent event) {
        WtrStreamGauge ent_WtrStreamGauge = (WtrStreamGauge) event.getObject();
        wtrStreamGaugeFacade.edit(ent_WtrStreamGauge);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="stream_remove">
    WtrStreamGauge ent_stream_remove;

    public WtrStreamGauge getEnt_stream_remove() {
        return ent_stream_remove;
    }

    public void setEnt_stream_remove(WtrStreamGauge ent_stream_remove) {
        wtrStreamGaugeFacade.remove(ent_stream_remove);
        setTbl_streamg_list();
        this.ent_stream_remove = ent_stream_remove;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="init()">
    @PostConstruct
    public void init() {
        setDdl_wshed();
        setTbl_streamg_list();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">

    public Streamgauge() {
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
