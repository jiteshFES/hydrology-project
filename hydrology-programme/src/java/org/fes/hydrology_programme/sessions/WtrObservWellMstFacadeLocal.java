/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrObservWellMst;

/**
 *
 * @author jitesh
 */
@Local
public interface WtrObservWellMstFacadeLocal {

    void create(WtrObservWellMst wtrObservWellMst);

    void edit(WtrObservWellMst wtrObservWellMst);

    void remove(WtrObservWellMst wtrObservWellMst);

    WtrObservWellMst find(Object id);

    List<WtrObservWellMst> findAll();

    List<WtrObservWellMst> findRange(int[] range);

    int count();
    
    public List<WtrObservWellMst> getObwellList(Integer p_pfa);
    
    public List<String> getfarmerList(Integer p_wshed);
    
    public List<WtrObservWellMst> getwellsrvynoList(Integer p_wshed, String p_farmer);
    
}
