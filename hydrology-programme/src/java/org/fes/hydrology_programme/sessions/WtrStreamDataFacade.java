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
import org.fes.hydrology_programme.entities.WtrStreamData;
import org.fes.lib.utilities.DateTimeUtility;

/**
 *
 * @author jitesh
 */
@Stateless
public class WtrStreamDataFacade extends AbstractFacade<WtrStreamData> implements WtrStreamDataFacadeLocal {

    DateTimeUtility dateTimeUtility = new DateTimeUtility();
    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrStreamDataFacade() {
        super(WtrStreamData.class);
    }

    @Override
    public List<WtrStreamData> findAllByInterval(Integer p_wshedSrno,Integer p_strSrno, Date p_start_date, Date p_end_date, boolean p_unitMandatory) {
        String v_start_date = dateTimeUtility.ChangeDateFormat(p_start_date, null);
        String v_end_date = dateTimeUtility.ChangeDateFormat(p_end_date, null);
        String v_query = "SELECT * FROM WTR_STREAM_DATA "
                + " WHERE STR_DATE BETWEEN '" + v_start_date + "' AND '" + v_end_date + "'";
        if (p_wshedSrno != null) {
            v_query += " AND STR_WSHED_NO = " + p_wshedSrno;
        }
        if(p_strSrno!=null){
            v_query += " AND STR_SRNO = " + p_strSrno;
        }
        if (p_unitMandatory) {
            v_query += " AND STR_IN_CM IS NOT NULL";
        }
        return em.createNativeQuery(v_query, WtrStreamData.class).getResultList();
    }

    @Override
    public List<WtrStreamData> findAll(Integer p_wshedSrno, Date p_date) {
        String v_date = dateTimeUtility.ChangeDateFormat(p_date, null);
        String v_query = "SELECT * FROM WTR_STREAM_DATA "
                + " WHERE STR_DATE = '" + v_date + "'";
        if (p_wshedSrno != null) {
            v_query += " AND STR_WSHED_NO = " + p_wshedSrno;
        }
        return em.createNativeQuery(v_query, WtrStreamData.class).getResultList();
    }
}
