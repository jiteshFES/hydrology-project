/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fes.hydrology_programme.entities.WtrWshedMst;

/**
 *
 * @author jitesh
 */
@Stateless
public class WtrWshedMstFacade extends AbstractFacade<WtrWshedMst> implements WtrWshedMstFacadeLocal {

    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrWshedMstFacade() {
        super(WtrWshedMst.class);
    }

    @Override
    public List<WtrWshedMst> getPfawshed(Integer p_pfa) {
        return em.createNativeQuery(
                " SELECT *"
                + " FROM   WTR_WSHED_MST "
                + " WHERE  PFA_NO = " + p_pfa
                + " ORDER BY WSHED_NAME", WtrWshedMst.class).getResultList();
    }

    @Override
    public List<WtrWshedMst> getWshedList(Integer p_pfa) {
        return em.createNativeQuery(
                " SELECT *"
                + " FROM   WTR_WSHED_MST "
                + " WHERE  PFA_NO like decode (" + p_pfa + ",0,'%'," + p_pfa + ")"
                + " ORDER BY WSHED_NAME",
                WtrWshedMst.class).getResultList();
    }
}
