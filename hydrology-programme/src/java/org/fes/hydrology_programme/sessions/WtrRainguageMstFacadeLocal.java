/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrRainguageMst;

/**
 *
 * @author jitesh
 */
@Local
public interface WtrRainguageMstFacadeLocal {

    void create(WtrRainguageMst wtrRainguageMst);

    void edit(WtrRainguageMst wtrRainguageMst);

    void remove(WtrRainguageMst wtrRainguageMst);

    WtrRainguageMst find(Object id);

    List<WtrRainguageMst> findAll();

    List<WtrRainguageMst> findRange(int[] range);

    int count();
    
    public List<WtrRainguageMst> getRgaugeList(Integer p_pfa);
    
}
