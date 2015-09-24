/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fes.hydrology_programme.entities.WtrObwellData;

/**
 *
 * @author jitesh
 */
@Stateless
public class WtrObwellDataFacade extends AbstractFacade<WtrObwellData> implements WtrObwellDataFacadeLocal {
    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrObwellDataFacade() {
        super(WtrObwellData.class);
    }
    
    @Override
    public List<WtrObwellData> getwelldataList(Integer p_pfa) {
        return em.createNativeQuery(
                " SELECT *" +
                " FROM   WTR_OBWELL_DATA " +
                " WHERE  ODATA_WSHED_NO IN (SELECT WSHED_NO FROM WTR_WSHED_MST " +
                " WHERE  PFA_NO like decode (" +p_pfa+",0,'%',"+p_pfa+"))",
                WtrObwellData.class).getResultList();
    }
    
    @Override
    public List<WtrObwellData> getwshedwellList(Integer p_wshed) {
        return em.createNativeQuery(
                " SELECT *" +
                " FROM   WTR_OBWELL_DATA " +
                " WHERE  ODATA_WSHED_NO =" +p_wshed,
                WtrObwellData.class).getResultList();
    }
}
