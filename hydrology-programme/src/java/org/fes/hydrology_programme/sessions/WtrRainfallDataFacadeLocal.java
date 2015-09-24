/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.sessions;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import org.fes.hydrology_programme.entities.WtrRainfallData;

/**
 *
 * @author jitesh
 */
@Local
public interface WtrRainfallDataFacadeLocal {

    void create(WtrRainfallData wtrRainfallData);

    void edit(WtrRainfallData wtrRainfallData);

    void remove(WtrRainfallData wtrRainfallData);

    WtrRainfallData find(Object id);

    List<WtrRainfallData> findAll();

    List<WtrRainfallData> findRange(int[] range);

    int count();

    public List<WtrRainfallData> findAllByInterval(Integer p_wshedSrno, Date p_start_date, Date p_end_date, boolean p_unitMandatory);

    public List<WtrRainfallData> findAll(Integer p_wshedSrno, Date p_date);
}
