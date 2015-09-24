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

/**
 *
 * @author jitesh
 */
@Stateless
public class WtrDistMstFacade extends AbstractFacade<WtrDistMst> implements WtrDistMstFacadeLocal {
    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrDistMstFacade() {
        super(WtrDistMst.class);
    }
    
    @Override
    public List<WtrDistMst> getRSOdists(Integer p_rso) {
        return em.createNativeQuery(
                " SELECT *" +
                " FROM   WTR_DIST_MST " +
                " WHERE  RSO_NO = " + p_rso,WtrDistMst.class).getResultList();
    }
    
}
