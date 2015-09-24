/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.jsf.pages.settings;

import java.io.Serializable;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.fes.hydrology_programme.custom_entities.System_Properties;
import org.fes.hydrology_programme.entities.WtrUserMst;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;
import org.fes.hydrology_programme.sessions.WtrUserMstFacadeLocal;
import org.fes.lib.utilities.LogGenerator;

/**
 *
 * @author jitesh
 */
@ManagedBean
@ViewScoped
public class Settings implements Serializable {

    @EJB
    private WtrUserMstFacadeLocal wtrUserMstFacade;
    LogGenerator logGenerator = new LogGenerator();
    System_Properties system_Properties = new System_Properties();
    //<editor-fold defaultstate="collapsed" desc="Change Password">
    //<editor-fold defaultstate="collapsed" desc="Objects Declarations">
    String txt_old_password;
    String txt_new_password;
    String txt_confirm_password;

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

    public String getTxt_old_password() {
        return txt_old_password;
    }

    public void setTxt_old_password(String txt_old_password) {
        this.txt_old_password = txt_old_password;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Saving Methods">

    public void resetPasswordPanel() {
        txt_new_password = "";
        txt_old_password = "";
        txt_confirm_password = "";
    }

    public void changePassword(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (isEntryValid()) {
            try {
                WtrUserMst ent_Empmst = wtrUserMstFacade.find(new Short(getGlobalSettings().getUser_id().toString()));
                ent_Empmst.setUserPassword(txt_new_password);
                //ent_Empmst.set(getGlobalSettings().getUser_id());
                wtrUserMstFacade.edit(ent_Empmst);
                resetPasswordPanel();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Password changed", "Password changed Successfully"));
            } catch (Exception e) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Some unexpected error occurred during changing password"));
                logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, "Error in changing password", "changePassword", null, e);
            }
        }
    }

    public boolean isEntryValid() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {

            String v_old_password = wtrUserMstFacade.find(new Short(getGlobalSettings().getUser_id().toString())).getUserPassword();
            if (!txt_old_password.equals(v_old_password)) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Password does not matched", "Please provide correct old password"));
                return false;
            }
            if (!txt_new_password.equals(txt_confirm_password)) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Password does not matched", "New and confirm password does not matched"));
                return false;
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Some unexpected error occurred during validating password"));
            logGenerator.generateLog(system_Properties.getSystemName(), Level.SEVERE, "Error occurred during validating password", "changePassword", null, e);
            return false;
        }
        return true;
    }
    //</editor-fold>
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="init()">

    @PostConstruct
    public void init() {
    }
    //</editor-fold>

    /**
     * Creates a new instance of Settings
     */
    //<editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">
    public Settings() {
    }
    //<editor-fold defaultstate="collapsed" desc="Global Settings">
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
    //</editor-fold>
}
