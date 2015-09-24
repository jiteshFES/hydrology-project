/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fes.hydrology_programme.entities.WtrRainfallData;
import org.fes.lib.utilities.DateTimeUtility;

/**
 *
 * @author jitesh
 */
@Stateless
public class WtrRainfallDataFacade extends AbstractFacade<WtrRainfallData> implements WtrRainfallDataFacadeLocal {

    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;
    DateTimeUtility dateTimeUtility = new DateTimeUtility();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<WtrRainfallData> findAllByInterval(Integer p_wshedSrno, Date p_start_date, Date p_end_date, boolean p_unitMandatory) {
        String v_start_date = dateTimeUtility.ChangeDateFormat(p_start_date, null);
        String v_end_date = dateTimeUtility.ChangeDateFormat(p_end_date, null);
        String v_query = "SELECT * FROM WTR_RAINFALL_DATA "
                + " WHERE RFALL_DATE BETWEEN '" + v_start_date + "' AND '" + v_end_date + "'";
        if (p_wshedSrno != null) {
            v_query += " AND RFALL_WSHED_NO = " + p_wshedSrno;
        }
        if (p_unitMandatory) {
            v_query += " AND RFALL_IN_MM IS NOT NULL";
        }
        return em.createNativeQuery(v_query, WtrRainfallData.class).getResultList();
    }

    @Override
    public List<WtrRainfallData> findAll(Integer p_wshedSrno, Date p_date) {
        String v_date = dateTimeUtility.ChangeDateFormat(p_date, null);
        String v_query = "SELECT * FROM WTR_RAINFALL_DATA "
                + " WHERE RFALL_DATE = '" + v_date + "'";
        if (p_wshedSrno != null) {
            v_query += " AND RFALL_WSHED_NO = " + p_wshedSrno;
        }
        return em.createNativeQuery(v_query, WtrRainfallData.class).getResultList();
    }

    public WtrRainfallDataFacade() {
        super(WtrRainfallData.class);
    }
}
