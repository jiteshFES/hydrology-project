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
import org.fes.hydrology_programme.entities.WtrPfaMst;
import org.fes.hydrology_programme.entities.WtrUserMst;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;
import org.fes.hydrology_programme.sessions.WtrPfaMstFacade;
import org.fes.hydrology_programme.sessions.WtrPfaMstFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrUserMstFacade;
import org.fes.hydrology_programme.sessions.WtrUserMstFacadeLocal;
import org.fes.lib.utilities.LogGenerator;

/**
 *
 * @author alkesh
 */
@ManagedBean
@ViewScoped
public class Usermst implements Serializable {
    @EJB
    private WtrPfaMstFacadeLocal wtrPfaMstFacade;
    @EJB
    private WtrUserMstFacadeLocal wtrUserMstFacade;
    
    
   
    LogGenerator logGenerator = new LogGenerator();
    System_Properties system_Properties = new System_Properties();
    
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
        ddl_pfa = null;
        ddl_pfa_options = new ArrayList<SelectItem>();
        List<WtrPfaMst> lst_PfaMsts = wtrPfaMstFacade.getPfaList((getGlobalSettings().getEnt_login_user().getPfaRsoNumber() == null?0:getGlobalSettings().getEnt_login_user().getPfaRsoNumber().getPfaNo()));
            int n = lst_PfaMsts.size();
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    ddl_pfa_options.add(new SelectItem(lst_PfaMsts.get(i).getPfaNo().toString(), lst_PfaMsts.get(i).getPfaName()));
                }
                ddl_pfa = ddl_pfa_options.get(0).getValue().toString();
            } else {
                ddl_pfa_options.add(new SelectItem(null, "--- Not Available ---"));
            }
        
    }

    public void ddl_pfa_changed(ValueChangeEvent event) {
          setDdl_pfa();
    }
    //</editor-fold> 
    
    //<editor-fold defaultstate="collapsed" desc="tbl_usermst_list">
    List<WtrUserMst> tbl_usermst_list;
    List<WtrUserMst> tbl_usermst_list_filtered;

    public List<WtrUserMst> getTbl_usermst_list_filtered() {
        return tbl_usermst_list_filtered;
    }

    public void setTbl_usermst_list_filtered(List<WtrUserMst> tbl_usermst_list_filtered) {
        this.tbl_usermst_list_filtered = tbl_usermst_list_filtered;
    }

    public List<WtrUserMst> getTbl_usermst_list() {
        return tbl_usermst_list;
    }

    public void setTbl_usermst_list(List<WtrUserMst> tbl_usermst_list) {
        this.tbl_usermst_list = tbl_usermst_list;
    }

    public void setTbl_usermst_list() {
        tbl_usermst_list = wtrUserMstFacade.getUserList(getGlobalSettings().getEnt_login_user().getUserType(),getGlobalSettings().getUser_id());
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="User Entry">
    //<editor-fold defaultstate="collapsed" desc="Objectst">
    
    String txt_uname;
    String ddl_utype;
    String txt_upassword;
    String txt_confirm_upassword;

    public String getDdl_utype() {
        return ddl_utype;
    }

    public void setDdl_utype(String ddl_utype) {
        this.ddl_utype = ddl_utype;
    }

    public String getTxt_uname() {
        return txt_uname;
    }

    public void setTxt_uname(String txt_uname) {
        this.txt_uname = txt_uname;
    }

    public String getTxt_upassword() {
        return txt_upassword;
    }

    public void setTxt_upassword(String txt_upassword) {
        this.txt_upassword = txt_upassword;
    }

    public String getTxt_confirm_upassword() {
        return txt_confirm_upassword;
    }

    public void setTxt_confirm_upassword(String txt_confirm_upassword) {
        this.txt_confirm_upassword = txt_confirm_upassword;
    }

   

    //</editor-fold>
    
    public void btn_user_create(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WtrUserMst ent_WtrUsers = new WtrUserMst();
            
            ent_WtrUsers.setUserId(new Short("-1"));
            ent_WtrUsers.setUserType(ddl_utype.trim().toUpperCase());
            ent_WtrUsers.setUserName(txt_uname.trim().toUpperCase());
            ent_WtrUsers.setPfaRsoNumber(new WtrPfaMst(Integer.valueOf(ddl_pfa)));
            ent_WtrUsers.setUserPassword(txt_upassword);
            ent_WtrUsers.setCreateby(getGlobalSettings().getUser_id());
            ent_WtrUsers.setCreatedt(new Date());
            wtrUserMstFacade.create(ent_WtrUsers);
            setTbl_usermst_list();
            
            ddl_utype=null;
            txt_uname=null;
            txt_upassword=null;
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User Created", "User Created Successfully"));
        } catch (Exception exception) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error in creating User"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "UserEntry", null, exception);
        }

    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Change Password">
    String txt_new_password;
    String txt_confirm_password;
    WtrUserMst ent_UserMst;
    
    public WtrUserMst getEnt_UserMst() {
        return ent_UserMst;
    }
    
    public void setEnt_UserMst(WtrUserMst ent_UserMst) {
        txt_new_password=null;
        txt_confirm_password=null;
        this.ent_UserMst = ent_UserMst;
    }
    
    public String getTxt_confirm_password() {
        return txt_confirm_password;
    }
    
    public void setTxt_confirm_password(String txt_confirm_password) {
        this.txt_confirm_password = txt_confirm_password;
    }
    
    public String getTxt_new_password() {
        return txt_new_password;
    }
    
    public void setTxt_new_password(String txt_new_password) {
        this.txt_new_password = txt_new_password;
    }
    
    public void changePassword(ActionEvent event){
        FacesContext context=FacesContext.getCurrentInstance();
        try {
            ent_UserMst = wtrUserMstFacade.find(ent_UserMst.getUserId());            
            ent_UserMst.setUserPassword(txt_new_password);
            wtrUserMstFacade.edit(ent_UserMst);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Password changed successfully"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error updating password"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, this.getClass().getName(), "changePassword", null, e);
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="init()">
    @PostConstruct
    public void init() {
        ddl_utype="R";
        setDdl_pfa();
        setTbl_usermst_list();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">

    public Usermst() {
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
