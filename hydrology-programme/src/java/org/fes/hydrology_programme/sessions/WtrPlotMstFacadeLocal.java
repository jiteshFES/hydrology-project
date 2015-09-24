/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrPlotMst;

/**
 *
 * @author jitesh
 */
@Local
public interface WtrPlotMstFacadeLocal {

    void create(WtrPlotMst wtrPlotMst);

    void edit(WtrPlotMst wtrPlotMst);

    void remove(WtrPlotMst wtrPlotMst);

    WtrPlotMst find(Object id);

    List<WtrPlotMst> findAll();

    List<WtrPlotMst> findRange(int[] range);

    int count();
    
    public List<WtrPlotMst> getPlotList(Integer p_pfa);
    
    public List<String> getFarmerList(Integer p_wshed);
    
    public List<WtrPlotMst> getPlotsrvyList(Integer p_wshed,String p_farmer);
    
}
