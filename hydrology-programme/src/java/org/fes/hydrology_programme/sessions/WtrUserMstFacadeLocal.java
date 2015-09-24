/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrUserMst;

/**
 *
 * @author jitesh
 */
@Local
public interface WtrUserMstFacadeLocal {

    void create(WtrUserMst wtrUserMst);

    void edit(WtrUserMst wtrUserMst);

    void remove(WtrUserMst wtrUserMst);

    WtrUserMst find(Object id);

    List<WtrUserMst> findAll();

    List<WtrUserMst> findRange(int[] range);

    int count();

    public WtrUserMst findByUserName(String p_userName);
    
    public List<WtrUserMst> getUserList(String p_type, Integer p_userid);
}
