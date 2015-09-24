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
import org.fes.hydrology_programme.entities.WtrWshedMemberMst;
import org.fes.hydrology_programme.entities.WtrWshedMst;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;
import org.fes.hydrology_programme.sessions.WtrWshedMemberMstFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrWshedMstFacadeLocal;
import org.fes.lib.utilities.LogGenerator;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author alkesh
 */
@ManagedBean
@ViewScoped
public class Wmembers implements Serializable {
    @EJB
    private WtrWshedMemberMstFacadeLocal wtrWshedMemberMstFacade;
    
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
    
    //<editor-fold defaultstate="collapsed" desc="tbl_wmember_list">
    List<WtrWshedMemberMst> tbl_wmember_list;
    List<WtrWshedMemberMst> tbl_wmember_list_filtered;

    public List<WtrWshedMemberMst> getTbl_wmember_list_filtered() {
        return tbl_wmember_list_filtered;
    }

    public void setTbl_wmember_list_filtered(List<WtrWshedMemberMst> tbl_wmember_list_filtered) {
        this.tbl_wmember_list_filtered = tbl_wmember_list_filtered;
    }

    public List<WtrWshedMemberMst> getTbl_wmember_list() {
        return tbl_wmember_list;
    }

    public void setTbl_wmember_list(List<WtrWshedMemberMst> tbl_wmember_list) {
        this.tbl_wmember_list = tbl_wmember_list;
    }

    public void setTbl_wmember_list() {
        tbl_wmember_list = wtrWshedMemberMstFacade.getMemberList((getGlobalSettings().getEnt_login_user().getPfaRsoNumber() == null?0:getGlobalSettings().getEnt_login_user().getPfaRsoNumber().getPfaNo()));
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Member Entry">
    //<editor-fold defaultstate="collapsed" desc="Objectst">
    
    String txt_mname;
    String ddl_mtype;

    public String getDdl_mtype() {
        return ddl_mtype;
    }

    public void setDdl_mtype(String ddl_mtype) {
        this.ddl_mtype = ddl_mtype;
    }

    public String getTxt_mname() {
        return txt_mname;
    }

    public void setTxt_mname(String txt_mname) {
        this.txt_mname = txt_mname;
    }

    //</editor-fold>
    
    public void btn_member_create(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrWshedMemberMst ent_WtrMember = new WtrWshedMemberMst();
            
            ent_WtrMember.setMemberSrno(-1);
            ent_WtrMember.setMemWshedNo(new WtrWshedMst(new Integer(ddl_wshed)));
            ent_WtrMember.setMemName(txt_mname);
            ent_WtrMember.setMemType(ddl_mtype);
            ent_WtrMember.setCreateby(getGlobalSettings().getUser_id());
            ent_WtrMember.setCreatedt(new Date());
            wtrWshedMemberMstFacade.create(ent_WtrMember);
            setTbl_wmember_list();
            
            ddl_wshed=null;
            txt_mname=null;
            ddl_mtype=null;
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Member Created", "Member Created Successfully"));
        } catch (Exception exception) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error in creating Member"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "MemberEntry", null, exception);
        }

    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="WshedMemEdit">
    public void WshedMemEdit(RowEditEvent event) {
        WtrWshedMemberMst ent_WtrWshedMem = (WtrWshedMemberMst) event.getObject();
        wtrWshedMemberMstFacade.edit(ent_WtrWshedMem);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="member_remove">
    WtrWshedMemberMst ent_member_remove;

    public WtrWshedMemberMst getEnt_member_remove() {
        return ent_member_remove;
    }

    public void setEnt_member_remove(WtrWshedMemberMst ent_member_remove) {
        wtrWshedMemberMstFacade.remove(ent_member_remove);
        setTbl_wmember_list();
        this.ent_member_remove = ent_member_remove;
    }
    //</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="init()">
    @PostConstruct
    public void init() {
        setDdl_wshed();
        setTbl_wmember_list();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">

    public Wmembers() {
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
