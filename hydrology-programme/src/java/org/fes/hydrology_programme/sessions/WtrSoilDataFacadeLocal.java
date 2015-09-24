/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrSoilData;

/**
 *
 * @author jitesh
 */
@Local
public interface WtrSoilDataFacadeLocal {

    void create(WtrSoilData wtrSoilData);

    void edit(WtrSoilData wtrSoilData);

    void remove(WtrSoilData wtrSoilData);

    WtrSoilData find(Object id);

    List<WtrSoilData> findAll();

    List<WtrSoilData> findRange(int[] range);

    int count();
    
    public List<WtrSoilData> getSoildataList(Integer p_pfa);
    
}
