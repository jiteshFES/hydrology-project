/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fes.hydrology_programme.entities.WtrRsoMst;

/**
 *
 * @author jitesh
 */
@Stateless
public class WtrRsoMstFacade extends AbstractFacade<WtrRsoMst> implements WtrRsoMstFacadeLocal {
    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrRsoMstFacade() {
        super(WtrRsoMst.class);
    }
    
}
