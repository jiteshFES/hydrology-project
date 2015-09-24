/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrStreamData;

/**
 *
 * @author jitesh
 */
@Local
public interface WtrStreamDataFacadeLocal {

    void create(WtrStreamData wtrStreamData);

    void edit(WtrStreamData wtrStreamData);

    void remove(WtrStreamData wtrStreamData);

    WtrStreamData find(Object id);

    List<WtrStreamData> findAll();

    List<WtrStreamData> findRange(int[] range);

    int count();

    public List<WtrStreamData> findAllByInterval(Integer p_wshedSrno,Integer p_strSrno, Date p_start_date, Date p_end_date, boolean p_unitMandatory);

    public List<WtrStreamData> findAll(Integer p_wshedSrno, Date p_date);
}
