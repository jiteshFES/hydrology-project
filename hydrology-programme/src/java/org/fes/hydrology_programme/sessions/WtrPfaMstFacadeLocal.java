/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrPfaMst;

/**
 *
 * @author jitesh
 */
@Local
public interface WtrPfaMstFacadeLocal {

    void create(WtrPfaMst wtrPfaMst);

    void edit(WtrPfaMst wtrPfaMst);

    void remove(WtrPfaMst wtrPfaMst);

    WtrPfaMst find(Object id);

    List<WtrPfaMst> findAll();

    List<WtrPfaMst> findRange(int[] range);

    int count();
    
    public List<WtrPfaMst> getDistpfas(Integer p_dist);
    
    public List<WtrPfaMst> getPfaList(Integer p_pfa);
}
