package org.fes.hydrology_programme.jsf;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.fes.hydrology_programme.custom_entities.System_Properties;
import org.fes.hydrology_programme.custom_sessions.ejb_utilitiesLocal;
import org.fes.hydrology_programme.entities.WtrUserMst;
import org.fes.hydrology_programme.sessions.WtrUserMstFacadeLocal;
import org.fes.lib.utilities.DateTimeUtility;
import org.fes.lib.utilities.LogGenerator;

/**
 *
 * @author Krishna
 */
@ManagedBean(name = "GlobalSettings")
@SessionScoped
public class GlobalSettings implements Serializable {

    @EJB
    private ejb_utilitiesLocal ejb_utilities;
    @EJB
    private WtrUserMstFacadeLocal WtrUserMstFacade;
    LogGenerator logGenerator = new LogGenerator();
    DateTimeUtility dateTimeUtility = new DateTimeUtility();
    // <editor-fold defaultstate="collapsed" desc="SystemName">
    String SystemName = new System_Properties().getSystemName();
    // </editor-fold>    
    //<editor-fold defaultstate="collapsed" desc="ent_login_user">
    WtrUserMst ent_login_user = null;

    public WtrUserMst getEnt_login_user() {
        if (ent_login_user == null) {
            if (FacesContext.getCurrentInstance().getExternalContext().getRemoteUser() != null) {
                ent_login_user = WtrUserMstFacade.findByUserName(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
            }
        }
        return ent_login_user;
    }

    public void setEnt_login_user(WtrUserMst ent_login_user) {
        this.ent_login_user = ent_login_user;
    }
    //</editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="Gives Id of the user who is logged in">
    private Integer getUserId() {
        return new Integer(getEnt_login_user().getUserId().toString());
    }
    // </editor-fold>            
    // <editor-fold defaultstate="collapsed" desc="Global working+name+posting+orgou">
    Integer user_id = null;
    String user_name = null;

    public String getUser_name() {
        if (user_name == null) {
            user_name = getEnt_login_user().getUserName();
        }
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getUser_id() {
        user_id = getUserId();
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    // </editor-fold>      
    // <editor-fold defaultstate="collapsed" desc="Default Constructor & Other Bean">
// <editor-fold defaultstate="collapsed" desc="Default Constructor">
    public GlobalSettings() {
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
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Un Used Commented Portion">
//    public void gettempWorkingou() {
//        Thread t = Thread.currentThread();
//        while (getWorking_ou() == 0) {
//            try {
//
//                Thread.sleep(1500);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(GlobalSettings.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
////
//    // <editor-fold defaultstate="collapsed" desc="Org Number List For Organisation">
//    public List<Integer> org_unit_number_list = null;
//    
//    public List<Integer> getOrg_unit_number_list(String p_calling_class, String p_calling_method) {
//        if (org_unit_number_list == null) {
//            try {
//                List<Integer> lst_SystOrgUnitMst_OumUnitSrno = new ArrayList<Integer>();
//                    Connection cn = getGlobalUtilities().getjdbcFES_PROJECT_Oracle().getConnection();
//                    try {
//                        Statement stmt = cn.createStatement();
//                        try {
//                            ResultSet rs = stmt.executeQuery("select COLUMN_VALUE \"LST_ORG_UNIT\" from table(ou_pack.GET_SUB_OU(" + getOrg_ou(GlobalSettings.class.getName(), "getOrg_Unit_Number_List_Local()") + ",'b','y'))");
//                            try {
//                                while (rs.next()) {
//                                    //SystOrgUnitMst ent_SystOrgUnitMst=new SystOrgUnitMst(Integer.parseInt(rs.getString("LST_ORG")));
//                                    lst_SystOrgUnitMst_OumUnitSrno.add(Integer.parseInt(rs.getString("LST_ORG_UNIT")));
//                                }
//                            } finally {
//                                rs.close();
//                            }
//                        } finally {
//                            stmt.close();
//                        }
//                    } finally {
//                        if (!cn.isClosed()) {
//                            cn.close();
//                        }
//                    }
//                        org_unit_number_list = lst_SystOrgUnitMst_OumUnitSrNo;
//            } catch (SQLException ex) {
//                Logger.getLogger(GlobalSettings.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return org_unit_number_list;
//    }
//    
//    public void setOrg_unit_number_list(List<Integer> org_unit_number_list) {
//        this.org_unit_number_list = org_unit_number_list;
//    }
//    
//    
//    // </editor-fold>
////    }// </editor-fold>
}
