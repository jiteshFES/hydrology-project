/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fes.hydrology_programme.entities.WtrRainguageMst;
import org.fes.hydrology_programme.entities.WtrWshedMst;

/**
 *
 * @author jitesh
 */
@Stateless
public class WtrRainguageMstFacade extends AbstractFacade<WtrRainguageMst> implements WtrRainguageMstFacadeLocal {
    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrRainguageMstFacade() {
        super(WtrRainguageMst.class);
    }
    
    @Override
    public List<WtrRainguageMst> getRgaugeList(Integer p_pfa) {
        return em.createNativeQuery(
                " SELECT *" +
                " FROM   WTR_RAINGUAGE_MST " +
                " WHERE  RG_WSHED_NO IN (SELECT WSHED_NO FROM WTR_WSHED_MST " +
                " WHERE  PFA_NO like decode (" +p_pfa+",0,'%',"+p_pfa+"))",
                WtrRainguageMst.class).getResultList();
    }
}
