/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrWshedMemberMst;

/**
 *
 * @author alkesh
 */
@Local
public interface WtrWshedMemberMstFacadeLocal {

    void create(WtrWshedMemberMst wtrWshedMemberMst);

    void edit(WtrWshedMemberMst wtrWshedMemberMst);

    void remove(WtrWshedMemberMst wtrWshedMemberMst);

    WtrWshedMemberMst find(Object id);

    List<WtrWshedMemberMst> findAll();

    List<WtrWshedMemberMst> findRange(int[] range);

    int count();
    
    public List<WtrWshedMemberMst> getMemberList(Integer p_pfa);
    
}
