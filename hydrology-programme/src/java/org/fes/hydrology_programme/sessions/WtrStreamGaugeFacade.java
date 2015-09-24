/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fes.hydrology_programme.entities.WtrStreamGauge;

/**
 *
 * @author alkesh
 */
@Stateless
public class WtrStreamGaugeFacade extends AbstractFacade<WtrStreamGauge> implements WtrStreamGaugeFacadeLocal {

    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrStreamGaugeFacade() {
        super(WtrStreamGauge.class);
    }

    @Override
    public List<WtrStreamGauge> findAll(Integer p_watershed) {
        return em.createNativeQuery(
                " SELECT *"
                + " FROM   WTR_STREAM_GAUGE "
                + " WHERE  STR_WSHED_NO =" + p_watershed
                + " ORDER BY STR_NAME",
                WtrStreamGauge.class).getResultList();
    }

    @Override
    public List<WtrStreamGauge> getStreamList(Integer p_pfa) {
        return em.createNativeQuery(
                " SELECT *"
                + " FROM   WTR_STREAM_GAUGE "
                + " WHERE  STR_WSHED_NO IN (SELECT WSHED_NO FROM WTR_WSHED_MST "
                + " WHERE  PFA_NO like decode (" + p_pfa + ",0,'%'," + p_pfa + "))"
                + " ORDER BY STR_NAME",
                WtrStreamGauge.class).getResultList();
    }
}
