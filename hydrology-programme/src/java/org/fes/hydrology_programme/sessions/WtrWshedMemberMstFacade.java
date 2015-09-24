/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fes.hydrology_programme.entities.WtrWshedMemberMst;

/**
 *
 * @author alkesh
 */
@Stateless
public class WtrWshedMemberMstFacade extends AbstractFacade<WtrWshedMemberMst> implements WtrWshedMemberMstFacadeLocal {
    @PersistenceContext(unitName = "hydrology-programmePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WtrWshedMemberMstFacade() {
        super(WtrWshedMemberMst.class);
    }
    
    @Override
    public List<WtrWshedMemberMst> getMemberList(Integer p_pfa) {
        return em.createNativeQuery(
                " SELECT *" +
                " FROM   WTR_WSHED_MEMBER_MST " +
                " WHERE  MEM_WSHED_NO IN (SELECT WSHED_NO FROM WTR_WSHED_MST " +
                " WHERE  PFA_NO like decode (" +p_pfa+",0,'%',"+p_pfa+"))",
                WtrWshedMemberMst.class).getResultList();
    }
    
}
