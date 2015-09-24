/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrRsoMst;

/**
 *
 * @author jitesh
 */
@Local
public interface WtrRsoMstFacadeLocal {

    void create(WtrRsoMst wtrRsoMst);

    void edit(WtrRsoMst wtrRsoMst);

    void remove(WtrRsoMst wtrRsoMst);

    WtrRsoMst find(Object id);

    List<WtrRsoMst> findAll();

    List<WtrRsoMst> findRange(int[] range);

    int count();
    
}
