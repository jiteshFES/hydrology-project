/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.jsf.pages.masters;

import java.io.Serializable;
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
import org.fes.hydrology_programme.entities.WtrDistMst;
import org.fes.hydrology_programme.entities.WtrPfaMst;
import org.fes.hydrology_programme.entities.WtrRsoMst;
import org.fes.hydrology_programme.entities.WtrWshedMst;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;
import org.fes.hydrology_programme.sessions.WtrDistMstFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrPfaMstFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrRsoMstFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrWshedMstFacadeLocal;
import org.fes.lib.utilities.LogGenerator;

/**
 *
 * @author alkesh
 */
@ManagedBean
@ViewScoped
public class Watershed implements Serializable {

    @EJB
    private WtrWshedMstFacadeLocal wtrWshedMstFacade;
    @EJB
    private WtrPfaMstFacadeLocal wtrPfaMstFacade;
    @EJB
    private WtrDistMstFacadeLocal wtrDistMstFacade;
    @EJB
    private WtrRsoMstFacadeLocal wtrRsoMstFacade;
    LogGenerator logGenerator = new LogGenerator();
    System_Properties system_Properties = new System_Properties();
    //<editor-fold defaultstate="collapsed" desc="ddl_rso">
    String ddl_rso;
    List<SelectItem> ddl_rso_options;

    public String getDdl_rso() {
        return ddl_rso;
    }

    public void setDdl_rso(String ddl_rso) {
        this.ddl_rso = ddl_rso;
    }

    public List<SelectItem> getDdl_rso_options() {
        return ddl_rso_options;
    }

    public void setDdl_rso_options(List<SelectItem> ddl_rso_options) {
        this.ddl_rso_options = ddl_rso_options;
    }

    public void setDdl_rso() {
        ddl_rso_options = new ArrayList<SelectItem>();
        List<WtrRsoMst> lst_RsoMsts = wtrRsoMstFacade.findAll();
        int n = lst_RsoMsts.size();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                ddl_rso_options.add(new SelectItem(lst_RsoMsts.get(i).getRsoNo().toString(), lst_RsoMsts.get(i).getRsoName()));
            }
            ddl_rso = ddl_rso_options.get(0).getValue().toString();
        } else {
            ddl_rso_options.add(new SelectItem(null, "--- Not Available ---"));
            ddl_rso = null;
        }
    }

    public void ddl_rso_changed(ValueChangeEvent event) {
        ddl_rso = event.getNewValue().toString();
        setDdl_district();
        setDdl_pfa();
        setDdl_wshed();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ddl_district">
    String ddl_district;
    List<SelectItem> ddl_district_options;

    public String getDdl_district() {
        return ddl_district;
    }

    public void setDdl_district(String ddl_district) {
        this.ddl_district = ddl_district;
    }

    public List<SelectItem> getDdl_district_options() {
        return ddl_district_options;
    }

    public void setDdl_district_options(List<SelectItem> ddl_district_options) {
        this.ddl_district_options = ddl_district_options;
    }

    public void setDdl_district() {
        ddl_district_options = new ArrayList<SelectItem>();
        if (ddl_rso != null) {
            List<WtrDistMst> lst_DistMsts = wtrDistMstFacade.getRSOdists(new Integer(ddl_rso));
            int n = lst_DistMsts.size();
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    ddl_district_options.add(new SelectItem(lst_DistMsts.get(i).getDistrictNo().toString(), lst_DistMsts.get(i).getDistrictName()));
                }
                ddl_district = ddl_district_options.get(0).getValue().toString();
                return;
            }
        }
        ddl_district = null;
        ddl_district_options.add(new SelectItem(null, "--- Not Available ---"));
    }

    public void ddl_district_changed(ValueChangeEvent event) {
        ddl_district = event.getNewValue().toString();
        setDdl_pfa();
        setDdl_wshed();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ddl_pfa">
    String ddl_pfa;
    List<SelectItem> ddl_pfa_options;

    public String getDdl_pfa() {
        return ddl_pfa;
    }

    public void setDdl_pfa(String ddl_pfa) {
        this.ddl_pfa = ddl_pfa;
    }

    public List<SelectItem> getDdl_pfa_options() {
        return ddl_pfa_options;
    }

    public void setDdl_pfa_options(List<SelectItem> ddl_pfa_options) {
        this.ddl_pfa_options = ddl_pfa_options;
    }

    public void setDdl_pfa() {

        ddl_pfa_options = new ArrayList<SelectItem>();
        if (ddl_district != null) {
            List<WtrPfaMst> lst_PfaMsts = wtrPfaMstFacade.getDistpfas(new Integer(ddl_district));
            int n = lst_PfaMsts.size();
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    ddl_pfa_options.add(new SelectItem(lst_PfaMsts.get(i).getPfaNo().toString(), lst_PfaMsts.get(i).getPfaName()));
                }
                ddl_pfa = ddl_pfa_options.get(0).getValue().toString();
                return;
            }
        }
        ddl_pfa = null;
        ddl_pfa_options.add(new SelectItem(null, "--- Not Available ---"));
    }

    public void ddl_pfa_changed(ValueChangeEvent event) {
        ddl_pfa = event.getNewValue().toString();
        setDdl_wshed();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ddl_wshed">
    //   String ddl_wshed;
    List<SelectItem> ddl_wshed_options;

    public List<SelectItem> getDdl_wshed_options() {
        return ddl_wshed_options;
    }

    public void setDdl_wshed_options(List<SelectItem> ddl_wshed_options) {
        this.ddl_wshed_options = ddl_wshed_options;
    }

    public void setDdl_wshed() {
        ddl_wshed_options = new ArrayList<SelectItem>();
        if (ddl_pfa != null) {
            List<WtrWshedMst> lst_WshedMsts = wtrWshedMstFacade.getPfawshed(new Integer(ddl_pfa));
            int n = lst_WshedMsts.size();
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    ddl_wshed_options.add(new SelectItem(lst_WshedMsts.get(i).getWshedNo().toString(), lst_WshedMsts.get(i).getWshedName()));
                }
                return;
            }

        }
        ddl_wshed_options.add(new SelectItem(null, "--- Not Available ---"));
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="tbl_wshed_list">
    List<WtrWshedMst> tbl_wshed_list;
    List<WtrWshedMst> tbl_wshed_list_filtered;

    public List<WtrWshedMst> getTbl_wshed_list_filtered() {
        return tbl_wshed_list_filtered;
    }

    public void setTbl_wshed_list_filtered(List<WtrWshedMst> tbl_wshed_list_filtered) {
        this.tbl_wshed_list_filtered = tbl_wshed_list_filtered;
    }

    public List<WtrWshedMst> getTbl_wshed_list() {
        return tbl_wshed_list;
    }

    public void setTbl_wshed_list(List<WtrWshedMst> tbl_wshed_list) {
        this.tbl_wshed_list = tbl_wshed_list;
    }

    public void setTbl_wshed_list() {
        tbl_wshed_list = wtrWshedMstFacade.getWshedList((getGlobalSettings().getEnt_login_user().getPfaRsoNumber() == null ? 0 : getGlobalSettings().getEnt_login_user().getPfaRsoNumber().getPfaNo()));
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Common Entry Dialog Settings">
    //<editor-fold defaultstate="collapsed" desc="txt_common_entry_1">
    String txt_common_entry_1;

    public String getTxt_common_entry_1() {
        return txt_common_entry_1;
    }

    public void setTxt_common_entry_1(String txt_common_entry_1) {
        this.txt_common_entry_1 = txt_common_entry_1;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="hdn_common_entry_no">
    String hdn_common_entry_no;

    public String getHdn_common_entry_no() {
        return hdn_common_entry_no;
    }

    public void setHdn_common_entry_no(String hdn_common_entry_no) {
        this.hdn_common_entry_no = hdn_common_entry_no;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="btn_common_entry_create">

    public void btn_common_entry_create(ActionEvent event) {
        if (hdn_common_entry_no.equals("1")) {
            createRSO();
        } else if (hdn_common_entry_no.equals("2")) {
            createDIST();
        } else if (hdn_common_entry_no.equals("3")) {
            createPFA();
        } else if (hdn_common_entry_no.equals("4")) {
            createWSHED();
        }
        setTbl_wshed_list();
    }
    //</editor-fold>

    public void createRSO() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrRsoMst ent_RsoMst = new WtrRsoMst(new Integer("-1"));
            ent_RsoMst.setRsoName(txt_common_entry_1.toUpperCase().trim());
            ent_RsoMst.setCreateby(getGlobalSettings().getEnt_login_user().getUserId());
            ent_RsoMst.setCreatedt(new Date());
            wtrRsoMstFacade.create(ent_RsoMst);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "RSO Created", "RSO created successfully"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error in creating RSO", "Error occurred during creating new RSO"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "createRSO()", null, e);

        }
        String v_old_value = ddl_rso;
        setDdl_rso();
        ddl_rso = v_old_value != null ? v_old_value : ddl_rso;
    }

    public void createDIST() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrDistMst ent_DistMst = new WtrDistMst(new Integer("-1"));
            ent_DistMst.setDistrictName(txt_common_entry_1.toUpperCase().trim());
            ent_DistMst.setCreateby(new Integer(getGlobalSettings().getEnt_login_user().getUserId().toString()));
            ent_DistMst.setCreatedt(new Date());
            ent_DistMst.setRsoNo(new WtrRsoMst(new Integer(ddl_rso)));
            wtrDistMstFacade.create(ent_DistMst);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "District Created", "District created successfully"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error in creating District", "Error occurred during creating new District"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "createDist()", null, e);

        }
        String v_old_value = ddl_district;
        setDdl_district();
        ddl_district = v_old_value != null ? v_old_value : ddl_district;
    }

    public void createPFA() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrPfaMst ent_PfaMst = new WtrPfaMst(new Integer("-1"));
            ent_PfaMst.setPfaName(txt_common_entry_1.toUpperCase().trim());
            ent_PfaMst.setCreateby(new Integer(getGlobalSettings().getEnt_login_user().getUserId().toString()));
            ent_PfaMst.setCreatedt(new Date());
            ent_PfaMst.setRsoNo(new WtrRsoMst(new Integer(ddl_rso)));
            ent_PfaMst.setDistrictNo(new WtrDistMst(new Integer(ddl_district)));
            wtrPfaMstFacade.create(ent_PfaMst);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "PFA Created", "PFA created successfully"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error in creating PFA", "Error occurred during creating new PFA"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "createPFA()", null, e);

        }
        String v_old_value = ddl_pfa;
        setDdl_pfa();
        ddl_pfa = v_old_value != null ? v_old_value : ddl_pfa;
    }

    public void createWSHED() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrWshedMst ent_WshedMst = new WtrWshedMst(new Integer("-1"));
            ent_WshedMst.setWshedName(txt_common_entry_1.toUpperCase().trim());
            ent_WshedMst.setCreateby(new Integer(getGlobalSettings().getEnt_login_user().getUserId().toString()));
            ent_WshedMst.setCreatedt(new Date());
            ent_WshedMst.setRsoNo(new WtrRsoMst(new Integer(ddl_rso)));
            ent_WshedMst.setDistrictNo(new WtrDistMst(new Integer(ddl_district)));
            ent_WshedMst.setPfaNo(new WtrPfaMst(new Integer(ddl_pfa)));
            wtrWshedMstFacade.create(ent_WshedMst);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Watershed Created", "Watershed created successfully"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error in creating Watershed", "Error occurred during creating new Watershed"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "createWshed()", null, e);

        }

        setDdl_wshed();

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="init()">
    @PostConstruct
    public void init() {
        setDdl_rso();
        setDdl_district();
        setDdl_pfa();
        setDdl_wshed();
        setTbl_wshed_list();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">

    public Watershed() {
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
