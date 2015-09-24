/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fes.hydrology_programme.entities.WtrObservWellMst;


/**
 *
 * @author jitesh
 */
@Stateless
public class WtrObservWellMstFacade extends AbstractFacade<WtrObservWellMst> implements WtrObservWellMstFacadeLocal {
    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrObservWellMstFacade() {
        super(WtrObservWellMst.class);
    }
    
    @Override
    public List<WtrObservWellMst> getObwellList(Integer p_pfa) {
        return em.createNativeQuery(
                " SELECT *" +
                " FROM   WTR_OBSERV_WELL_MST " +
                " WHERE  OBWELL_WSHED_NO IN (SELECT WSHED_NO FROM WTR_WSHED_MST " +
                " WHERE  PFA_NO like decode (" +p_pfa+",0,'%',"+p_pfa+"))",
                WtrObservWellMst.class).getResultList();
    }
    
    @Override
    public List<String> getfarmerList(Integer p_wshed) {       
        return em.createNativeQuery(
                " SELECT DISTINCT OBWELL_FARMER" +
                " FROM   WTR_OBSERV_WELL_MST " +
                " WHERE  OBWELL_WSHED_NO = " +p_wshed).getResultList();
    }
    
    @Override
    public List<WtrObservWellMst> getwellsrvynoList(Integer p_wshed, String p_farmer) {
        return em.createNativeQuery(
                " SELECT OBWELL_SRNO, OBWELL_LOCATION " +
                " FROM   WTR_OBSERV_WELL_MST " +
                " WHERE  OBWELL_WSHED_NO = " +p_wshed +
                " AND    UPPER(OBWELL_FARMER) = UPPER('"+p_farmer+"')",
                WtrObservWellMst.class).getResultList();
    }
    
}
