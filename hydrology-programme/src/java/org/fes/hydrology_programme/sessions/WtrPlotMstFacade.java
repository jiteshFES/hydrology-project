/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fes.hydrology_programme.entities.WtrPlotMst;

/**
 *
 * @author jitesh
 */
@Stateless
public class WtrPlotMstFacade extends AbstractFacade<WtrPlotMst> implements WtrPlotMstFacadeLocal {
    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrPlotMstFacade() {
        super(WtrPlotMst.class);
    }
    
    @Override
    public List<WtrPlotMst> getPlotList(Integer p_pfa) {
        return em.createNativeQuery(
                " SELECT *" +
                " FROM   WTR_PLOT_MST " +
                " WHERE  PLOT_WSHED_NO IN (SELECT WSHED_NO FROM WTR_WSHED_MST " +
                " WHERE  PFA_NO like decode (" +p_pfa+",0,'%',"+p_pfa+"))",
                WtrPlotMst.class).getResultList();
    }
    
    @Override
    public List<String> getFarmerList(Integer p_wshed) {
        return em.createNativeQuery(
                " SELECT PLOT_FARMER" +
                " FROM   WTR_PLOT_MST " +
                " WHERE  PLOT_WSHED_NO = "+ p_wshed).getResultList();
    }
    
   
    @Override
    public List<WtrPlotMst> getPlotsrvyList(Integer p_wshed,String p_farmer) {
        return em.createNativeQuery(
                " SELECT *" +
                " FROM   WTR_PLOT_MST " +
                " WHERE  PLOT_WSHED_NO = " + p_wshed +
                " AND    UPPER(PLOT_FARMER) = UPPER('"+ p_farmer+"')",
                WtrPlotMst.class).getResultList();
    }
    
}
