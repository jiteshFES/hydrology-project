/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fes.hydrology_programme.entities.WtrSoilData;

/**
 *
 * @author jitesh
 */
@Stateless
public class WtrSoilDataFacade extends AbstractFacade<WtrSoilData> implements WtrSoilDataFacadeLocal {
    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrSoilDataFacade() {
        super(WtrSoilData.class);
    }
    
    @Override
    public List<WtrSoilData> getSoildataList(Integer p_pfa) {
        return em.createNativeQuery(
                " SELECT *" +
                " FROM   WTR_SOIL_DATA " +
                " WHERE  SOIL_WSHED_NO IN (SELECT WSHED_NO FROM WTR_WSHED_MST " +
                " WHERE  PFA_NO like decode (" +p_pfa+",0,'%',"+p_pfa+"))",
                WtrSoilData.class).getResultList();
    }
    
}
