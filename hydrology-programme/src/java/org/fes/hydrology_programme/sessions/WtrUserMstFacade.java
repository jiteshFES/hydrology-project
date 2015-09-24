/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fes.hydrology_programme.entities.WtrUserMst;

/**
 *
 * @author jitesh
 */
@Stateless
public class WtrUserMstFacade extends AbstractFacade<WtrUserMst> implements WtrUserMstFacadeLocal {
    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrUserMstFacade() {
        super(WtrUserMst.class);
    }
    
    @Override
    public WtrUserMst findByUserName(String p_userName){
        return (WtrUserMst) em.createNativeQuery("SELECT * FROM WTR_USER_MST WHERE USER_NAME = '"+p_userName+"'",WtrUserMst.class).getSingleResult();
    }
    
     @Override
    public List<WtrUserMst> getUserList(String p_type, Integer p_userid) {
        return em.createNativeQuery(
                " SELECT *" +
                " FROM   WTR_USER_MST " +
                " WHERE  USER_ID like decode ('" +p_type+"','R','%',"+p_userid+")",
                WtrUserMst.class).getResultList();
    }
}
