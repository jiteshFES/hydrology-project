package org.fes.hydrology_programme.jsf;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.fes.hydrology_programme.custom_entities.System_Properties;

@ManagedBean(name = "Login")
@RequestScoped
public class Login implements Serializable {

    System_Properties system_Properties=new System_Properties();
    String txt = new String();

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    

    public Login() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String v_user_id = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        if (v_user_id != null) {
            HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
            try {
                response.sendRedirect(system_Properties.getSystemUrl());
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }
}