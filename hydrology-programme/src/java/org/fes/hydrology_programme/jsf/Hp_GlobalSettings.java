package org.fes.hydrology_programme.jsf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.fes.hydrology_programme.custom_entities.System_Properties;

import org.fes.lib.utilities.DateTimeUtility;
import org.fes.lib.utilities.LogGenerator;

@ManagedBean(name = "Hp_GlobalSettings")
@SessionScoped
public class Hp_GlobalSettings implements Serializable {

   
    String systemName = new System_Properties().getSystemName();
    LogGenerator logGenerator = new LogGenerator();
    DateTimeUtility dateTimeUtility = new DateTimeUtility();
    // <editor-fold defaultstate="collapsed" desc="Breadcrumb Settings">
    String brHp_system = "";
    String brHp = getGlobalResources().getProject_path();
    String brHp_mst = "#";
    String brHp_entry= "#";
    String brHp_settings="#";

    public String getBrHp() {
        return brHp;
    }

    public void setBrHp(String brHp) {
        this.brHp = brHp;
    }

    public String getBrHp_entry() {
        return brHp_entry;
    }

    public void setBrHp_entry(String brHp_entry) {
        this.brHp_entry = brHp_entry;
    }

    public String getBrHp_mst() {
        return brHp_mst;
    }

    public void setBrHp_mst(String brHp_mst) {
        this.brHp_mst = brHp_mst;
    }

    public String getBrHp_system() {
        return brHp_system;
    }

    public void setBrHp_system(String brHp_system) {
        this.brHp_system = brHp_system;
    }

    public String getBrHp_settings() {
        return brHp_settings;
    }

    public void setBrHp_settings(String brHp_settings) {
        this.brHp_settings = brHp_settings;
    }
    
// </editor-fold>
    //<editor-fold defaultstate="collapsed" desc="PostConstruct">

    @PostConstruct
    public void init() {
        
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">
    // <editor-fold defaultstate="collapsed" desc="Default Constructor">

    public Hp_GlobalSettings() {
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="getGlobalUtilities">
    @ManagedProperty(value = "#{GlobalUtilities}")
    GlobalUtilities globalUtilities;

    public GlobalUtilities getGlobalUtilities() {
        return globalUtilities;
    }

    public void setGlobalUtilities(GlobalUtilities globalUtilities) {
        this.globalUtilities = globalUtilities;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="getGlobalResources">

    public GlobalResources getGlobalResources() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (GlobalResources) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "GlobalResources");
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="getGlobalSettings">

    protected GlobalSettings getGlobalSettings() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (GlobalSettings) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "GlobalSettings");
    }
    // </editor-fold>
// </editor-fold> 
}
