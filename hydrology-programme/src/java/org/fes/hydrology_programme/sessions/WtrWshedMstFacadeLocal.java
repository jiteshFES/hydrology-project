/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrWshedMst;

/**
 *
 * @author jitesh
 */
@Local
public interface WtrWshedMstFacadeLocal {

    void create(WtrWshedMst wtrWshedMst);

    void edit(WtrWshedMst wtrWshedMst);

    void remove(WtrWshedMst wtrWshedMst);

    WtrWshedMst find(Object id);

    List<WtrWshedMst> findAll();

    List<WtrWshedMst> findRange(int[] range);

    int count();
    
    public List<WtrWshedMst> getPfawshed(Integer p_pfa);
    
    public List<WtrWshedMst> getWshedList(Integer p_pfa);
}
