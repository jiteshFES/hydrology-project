/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrObwellData;

/**
 *
 * @author jitesh
 */
@Local
public interface WtrObwellDataFacadeLocal {

    void create(WtrObwellData wtrObwellData);

    void edit(WtrObwellData wtrObwellData);

    void remove(WtrObwellData wtrObwellData);

    WtrObwellData find(Object id);

    List<WtrObwellData> findAll();

    List<WtrObwellData> findRange(int[] range);

    int count();
    
    public List<WtrObwellData> getwelldataList(Integer p_pfa);
    
    public List<WtrObwellData> getwshedwellList(Integer p_wshed);
    
}
