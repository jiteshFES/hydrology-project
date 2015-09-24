/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrStreamGauge;

/**
 *
 * @author alkesh
 */
@Local
public interface WtrStreamGaugeFacadeLocal {

    void create(WtrStreamGauge wtrStreamGauge);

    void edit(WtrStreamGauge wtrStreamGauge);

    void remove(WtrStreamGauge wtrStreamGauge);

    WtrStreamGauge find(Object id);

    List<WtrStreamGauge> findAll();

    List<WtrStreamGauge> findRange(int[] range);

    int count();
    
    public List<WtrStreamGauge> getStreamList(Integer p_pfa);
    
    public List<WtrStreamGauge> findAll(Integer p_watershed);
    
}
