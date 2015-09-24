/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrDistMst;

/**
 *
 * @author jitesh
 */
@Local
public interface WtrDistMstFacadeLocal {

    void create(WtrDistMst wtrDistMst);

    void edit(WtrDistMst wtrDistMst);

    void remove(WtrDistMst wtrDistMst);

    WtrDistMst find(Object id);

    List<WtrDistMst> findAll();

    List<WtrDistMst> findRange(int[] range);

    int count();
    
    public List<WtrDistMst> getRSOdists(Integer p_rso);
    
}
