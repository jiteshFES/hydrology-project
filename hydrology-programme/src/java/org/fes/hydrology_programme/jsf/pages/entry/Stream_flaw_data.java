/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fes.hydrology_programme.jsf.pages.entry;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.fes.hydrology_programme.custom_entities.System_Properties;
import org.fes.hydrology_programme.entities.WtrStreamData;
import org.fes.hydrology_programme.entities.WtrStreamDataPK;
import org.fes.hydrology_programme.entities.WtrStreamGauge;
import org.fes.hydrology_programme.entities.WtrWshedMst;
import org.fes.hydrology_programme.jsf.DefaultScheduleEventCustom;
import org.fes.hydrology_programme.jsf.GlobalSettings;
import org.fes.hydrology_programme.jsf.GlobalUtilities;
import org.fes.hydrology_programme.sessions.WtrStreamDataFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrStreamGaugeFacadeLocal;
import org.fes.hydrology_programme.sessions.WtrWshedMstFacadeLocal;
import org.fes.lib.utilities.DateTimeUtility;
import org.fes.lib.utilities.LogGenerator;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author alkesh
 */
@ManagedBean
@ViewScoped
public class Stream_flaw_data implements Serializable {

    @EJB
    private WtrStreamGaugeFacadeLocal wtrStreamGaugeFacade;
    @EJB
    private WtrWshedMstFacadeLocal wtrWshedMstFacade;
    @EJB
    private WtrStreamDataFacadeLocal wtrStreamDataFacade;
    LogGenerator logGenerator = new LogGenerator();
    System_Properties system_Properties = new System_Properties();
    DateTimeUtility dateTimeUtility = new DateTimeUtility();
    //<editor-fold defaultstate="collapsed" desc="ddl_watershed">
    String ddl_watershed;
    List<SelectItem> ddl_watershed_options;

    public String getDdl_watershed() {
        return ddl_watershed;
    }

    public void setDdl_watershed(String ddl_watershed) {
        this.ddl_watershed = ddl_watershed;
    }

    public List<SelectItem> getDdl_watershed_options() {
        return ddl_watershed_options;
    }

    public void setDdl_watershed_options(List<SelectItem> ddl_watershed_options) {
        this.ddl_watershed_options = ddl_watershed_options;
    }

    public void setDdl_watershed() {
        ddl_watershed_options = new ArrayList<SelectItem>();
        List<WtrWshedMst> lst_WshedMsts = wtrWshedMstFacade.getWshedList((getGlobalSettings().getEnt_login_user().getPfaRsoNumber() == null ? 0 : getGlobalSettings().getEnt_login_user().getPfaRsoNumber().getPfaNo()));
        int n = lst_WshedMsts.size();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                ddl_watershed_options.add(new SelectItem(lst_WshedMsts.get(i).getWshedNo().toString(), lst_WshedMsts.get(i).getWshedName()));
            }
            ddl_watershed = ddl_watershed_options.get(0).getValue().toString();
        } else {
            ddl_watershed_options.add(new SelectItem(null, "--- Not Available ---"));
            ddl_watershed = null;
        }
    }

    public void ddl_watershed_changed(ValueChangeEvent event) {
        ddl_watershed = event.getNewValue().toString();
        setDdl_streamgauge();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ddl_streamgauge">
    String ddl_streamgauge;
    List<SelectItem> ddl_streamgauge_options;

    public String getDdl_streamgauge() {
        return ddl_streamgauge;
    }

    public void setDdl_streamgauge(String ddl_streamgauge) {
        this.ddl_streamgauge = ddl_streamgauge;
    }

    public List<SelectItem> getDdl_streamgauge_options() {
        return ddl_streamgauge_options;
    }

    public void setDdl_streamgauge_options(List<SelectItem> ddl_streamgauge_options) {
        this.ddl_streamgauge_options = ddl_streamgauge_options;
    }

    public void setDdl_streamgauge() {
        ddl_streamgauge_options = new ArrayList<SelectItem>();
        if (ddl_watershed != null) {
            List<WtrStreamGauge> lst_StreamGauges = wtrStreamGaugeFacade.findAll(new Integer(ddl_watershed));
            int n = lst_StreamGauges.size();
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    ddl_streamgauge_options.add(new SelectItem(lst_StreamGauges.get(i).getWtrStreamGaugePK().getStrSrno(), lst_StreamGauges.get(i).getStrName()));
                }
                ddl_streamgauge = ddl_streamgauge_options.get(0).getValue().toString();
            } else {
                ddl_streamgauge_options.add(new SelectItem(null, "--- Not Available ---"));
                ddl_streamgauge = null;
            }
        } else {
            ddl_streamgauge_options.add(new SelectItem(null, "--- Not Available ---"));
            ddl_streamgauge=null;
        }
    }

    public void ddl_streamgauge_changed(ValueChangeEvent event) {
        ddl_streamgauge = event.getNewValue().toString();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="scheduler1_value">
    ScheduleModel scheduler1_value;

    public ScheduleModel getScheduler1_value() {
        return scheduler1_value;
    }

    public void setScheduler1_value(ScheduleModel scheduler1_value) {
        this.scheduler1_value = scheduler1_value;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="scheduleEvent">
    ScheduleEvent scheduleEvent = new DefaultScheduleEventCustom();

    public ScheduleEvent getScheduleEvent() {
        return scheduleEvent;
    }

    public void setScheduleEvent(ScheduleEvent scheduleEvent) {
        this.scheduleEvent = scheduleEvent;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="selectedData">
    WtrStreamData selectedData;

    public WtrStreamData getSelectedData() {
        return selectedData;
    }

    public void setSelectedData(WtrStreamData selectedData) {
        this.selectedData = selectedData;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="EventHandler">
    //<editor-fold defaultstate="collapsed" desc="selectedDate">
    Date selectedDate;

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }
    //</editor-fold>

    public void onEventSelect(SelectEvent selectEvent) {
        scheduleEvent = (ScheduleEvent) selectEvent.getObject();
        selectedDate = scheduleEvent.getStartDate();
        WtrStreamDataPK eventData = (WtrStreamDataPK) scheduleEvent.getData();
        selectedData = wtrStreamDataFacade.find(eventData);
        txt_unit = selectedData.getStrInCm().toString();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        selectedDate = (Date) selectEvent.getObject();
        List<WtrStreamData> lst_temp = wtrStreamDataFacade.findAll(Integer.valueOf(ddl_watershed), selectedDate);
        selectedData = lst_temp.size() > 0 ? lst_temp.get(0) : null;
        txt_unit = selectedData == null ? null : selectedData.getStrInCm().toString();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="txt_unit">
    String txt_unit;

    public String getTxt_unit() {
        return txt_unit;
    }

    public void setTxt_unit(String txt_unit) {
        this.txt_unit = txt_unit;
    }
    //</editor-fold>

    public void btn_update_clicked(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (selectedData == null) {
                WtrStreamData ent_RainfallData = new WtrStreamData();
                ent_RainfallData.setWtrStreamDataPK(new WtrStreamDataPK(new Integer(ddl_streamgauge), new Integer(ddl_watershed), selectedDate));
                ent_RainfallData.setStrInCm((txt_unit.trim().equals("") || txt_unit.trim().equals("0")) ? null : new BigDecimal(txt_unit));
                ent_RainfallData.setCreateby(getGlobalSettings().getUser_id());
                ent_RainfallData.setCreatedt(new Date());
                wtrStreamDataFacade.create(ent_RainfallData);
            } else {
                selectedData.setStrInCm((txt_unit.trim().equals("") || txt_unit.trim().equals("0")) ? null : new BigDecimal(txt_unit));
                wtrStreamDataFacade.edit(selectedData);
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error in updating unit", "Some unexpected error occurred during updating unit"));

        }
    }
    //<editor-fold defaultstate="collapsed" desc="initializeSheduler()">

    public void initializeSheduler() {
        scheduler1_value = new LazyScheduleModel() {

            @Override
            public void loadEvents(Date start, Date end) {
                clear();
                Date v_start_date = dateTimeUtility.startDateOfMonthFromDate(start);
                Date v_end_date = dateTimeUtility.endDateOfMonthFromDate(end);
                List<WtrStreamData> wtrStreamDatas;
                if (ddl_watershed != null && ddl_streamgauge != null) {
                    wtrStreamDatas = wtrStreamDataFacade.findAllByInterval(Integer.valueOf(ddl_watershed), Integer.valueOf(ddl_streamgauge), v_start_date, v_end_date, true);
                    int n = wtrStreamDatas.size();
                    for (int i = 0; i < n; i++) {
                        WtrStreamData ent_Detail = wtrStreamDatas.get(i);
                        Date v_temp_date = ent_Detail.getWtrStreamDataPK().getStrDate();
                        DefaultScheduleEventCustom event = new DefaultScheduleEventCustom(ent_Detail.getStrInCm() + " CM", v_temp_date, v_temp_date, "blue", ent_Detail.getWtrStreamDataPK());
                        addEvent(event);
                    }
                }
            }
        };
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="init()">

    @PostConstruct
    public void init() {
        setDdl_watershed();
        setDdl_streamgauge();
        initializeSheduler();
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">

    public Stream_flaw_data() {
    }
    // <editor-fold defaultstate="collapsed" desc="getGlobalSettings">

    protected GlobalSettings getGlobalSettings() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (GlobalSettings) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "GlobalSettings");
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="getGlobalUtilities">

    protected GlobalUtilities getGlobalUtilities() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (GlobalUtilities) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "GlobalUtilities");
    }// </editor-fold>
    //</editor-fold>
}
