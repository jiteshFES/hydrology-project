/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fes.hydrology_programme.entities.WtrDistMst;
import org.fes.hydrology_programme.entities.WtrPfaMst;

/**
 *
 * @author jitesh
 */
@Stateless
public class WtrPfaMstFacade extends AbstractFacade<WtrPfaMst> implements WtrPfaMstFacadeLocal {
    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrPfaMstFacade() {
        super(WtrPfaMst.class);
    }
    
    @Override
    public List<WtrPfaMst> getDistpfas(Integer p_dist) {
        return em.createNativeQuery(
                " SELECT *" +
                " FROM   WTR_PFA_MST " +
                " WHERE  DISTRICT_NO = " + p_dist,WtrPfaMst.class).getResultList();
    }
    
    @Override
    public List<WtrPfaMst> getPfaList(Integer p_pfa) {
        return em.createNativeQuery(
                " SELECT *" +
                " FROM   WTR_PFA_MST " +
                " WHERE  PFA_NO like decode (" +p_pfa+",0,'%',"+p_pfa+")"
                + " ORDER BY PFA_NAME",
                WtrPfaMst.class).getResultList();
    }
}
