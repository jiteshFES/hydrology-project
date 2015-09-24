/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.jsf.pages;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.fes.hydrology_programme.jsf.GlobalResources;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;

/**
 *
 * @author Krishna
 */
@ManagedBean
@SessionScoped
public class Template implements Serializable {
    //<editor-fold defaultstate="collapsed" desc="PostConstruct">

    @PostConstruct
    public void init() {

    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Default Constructor & Other Bean">
    // <editor-fold defaultstate="collapsed" desc="Default Constructor">

    public Template() {
        
    }

    
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="getGlobalUtilities">
    protected GlobalUtilities getGlobalUtilities() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (GlobalUtilities) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "GlobalUtilities");
    }// </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="getGlobalResources">

    protected GlobalResources getGlobalResources() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (GlobalResources) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "GlobalResources");
    }// </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="getGlobalSettings">

    protected GlobalSettings getGlobalSettings() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (GlobalSettings) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "GlobalSettings");
    }// </editor-fold>
    // </editor-fold>
    
}
