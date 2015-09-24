package org.fes.hydrology_programme.jsf;

import java.io.Serializable;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.fes.hydrology_programme.custom_entities.System_Properties;
import org.fes.lib.utilities.DateTimeUtility;
import org.fes.lib.utilities.LogGenerator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@ManagedBean(name = "GlobalResources")
@SessionScoped
public class GlobalResources implements Serializable {

    String systemName = new System_Properties().getSystemName();
    LogGenerator logGenerator = new LogGenerator();
    DateTimeUtility dateTimeUtility = new DateTimeUtility();
    //<editor-fold defaultstate="collapsed" desc="content_type">
    String content_type = "Content-Type";
    
    public String getContent_type() {
        return content_type;
    }
    
    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Resources Settings">
    // <editor-fold defaultstate="collapsed" desc="variable Declarations">
    HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    String project_path = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/";
    String secured_resources_path;
    String rsc_css_fes_layout;
    String rsc_css_fes_layout_skin;
    String rsc_css_ddsmoothmenu;
    String rsc_css_ddsmoothmenu_skin;
    String rsc_css_skin;
    String rsc_css_skin_general_customised;
    String rsc_title_icon;
    String rsc_js_utilities;
    String rsc_js_primefaces_customised;
    String rsc_js_ddsmoothmenu;
    String rsc_js_browser_detect;
    String rsc_js_plg_date_format;
    String rsc_js_plg_scrollable_datatable;
    String rsc_js_plg_scrollable_tree;
    String rsc_js_plg_scroll_resizable;
    String rsc_js_plg_currencyFormatter;
    String rsc_js_plg_input_currencyFormatter;
    String rsc_img_loading;
    String rsc_img_loading_bar;

    public String getSecured_resources_path() {
        return secured_resources_path;
    }

    public void setSecured_resources_path(String secured_resources_path) {
        this.secured_resources_path = secured_resources_path;
    }

    public String getProject_path() {
        return project_path;
    }

    public void setProject_path(String project_path) {
        this.project_path = project_path;
    }

    public String getRsc_css_fes_layout() {
        return rsc_css_fes_layout;
    }

    public void setRsc_css_fes_layout(String rsc_css_fes_layout) {
        this.rsc_css_fes_layout = rsc_css_fes_layout;
    }

    public String getRsc_css_fes_layout_skin() {
        return rsc_css_fes_layout_skin;
    }

    public void setRsc_css_fes_layout_skin(String rsc_css_fes_layout_skin) {
        this.rsc_css_fes_layout_skin = rsc_css_fes_layout_skin;
    }

    public String getRsc_js_plg_input_currencyFormatter() {
        return rsc_js_plg_input_currencyFormatter;
    }

    public void setRsc_js_plg_input_currencyFormatter(String rsc_js_plg_input_currencyFormatter) {
        this.rsc_js_plg_input_currencyFormatter = rsc_js_plg_input_currencyFormatter;
    }

    public String getRsc_css_ddsmoothmenu() {
        return rsc_css_ddsmoothmenu;
    }

    public void setRsc_css_ddsmoothmenu(String rsc_css_ddsmoothmenu) {
        this.rsc_css_ddsmoothmenu = rsc_css_ddsmoothmenu;
    }

    public String getRsc_css_ddsmoothmenu_skin() {
        return rsc_css_ddsmoothmenu_skin;
    }

    public void setRsc_css_ddsmoothmenu_skin(String rsc_css_ddsmoothmenu_skin) {
        this.rsc_css_ddsmoothmenu_skin = rsc_css_ddsmoothmenu_skin;
    }

    public String getRsc_js_ddsmoothmenu() {
        return rsc_js_ddsmoothmenu;
    }

    public void setRsc_js_ddsmoothmenu(String rsc_js_ddsmoothmenu) {
        this.rsc_js_ddsmoothmenu = rsc_js_ddsmoothmenu;
    }

    public String getRsc_js_plg_currencyFormatter() {
        return rsc_js_plg_currencyFormatter;
    }

    public void setRsc_js_plg_currencyFormatter(String rsc_js_plg_currencyFormatter) {
        this.rsc_js_plg_currencyFormatter = rsc_js_plg_currencyFormatter;
    }

    public String getRsc_js_plg_date_format() {
        return rsc_js_plg_date_format;
    }

    public void setRsc_js_plg_date_format(String rsc_js_plg_date_format) {
        this.rsc_js_plg_date_format = rsc_js_plg_date_format;
    }

    public String getRsc_img_loading() {
        return rsc_img_loading;
    }

    public void setRsc_img_loading(String rsc_img_loading) {
        this.rsc_img_loading = rsc_img_loading;
    }

    public String getRsc_img_loading_bar() {
        return rsc_img_loading_bar;
    }

    public void setRsc_img_loading_bar(String rsc_img_loading_bar) {
        this.rsc_img_loading_bar = rsc_img_loading_bar;
    }

    public String getRsc_css_skin() {
        return rsc_css_skin;
    }

    public void setRsc_css_skin(String rsc_css_skin) {
        this.rsc_css_skin = rsc_css_skin;
    }

    public String getRsc_css_skin_general_customised() {
        return rsc_css_skin_general_customised;
    }

    public void setRsc_css_skin_general_customised(String rsc_css_skin_general_customised) {
        this.rsc_css_skin_general_customised = rsc_css_skin_general_customised;
    }

    public String getRsc_title_icon() {
        return rsc_title_icon;
    }

    public void setRsc_title_icon(String rsc_title_icon) {
        this.rsc_title_icon = rsc_title_icon;
    }

    public String getRsc_js_plg_scroll_resizable() {
        return rsc_js_plg_scroll_resizable;
    }

    public void setRsc_js_plg_scroll_resizable(String rsc_js_plg_scroll_resizable) {
        this.rsc_js_plg_scroll_resizable = rsc_js_plg_scroll_resizable;
    }

    public String getRsc_js_plg_scrollable_tree() {
        return rsc_js_plg_scrollable_tree;
    }

    public void setRsc_js_plg_scrollable_tree(String rsc_js_plg_scrollable_tree) {
        this.rsc_js_plg_scrollable_tree = rsc_js_plg_scrollable_tree;
    }

    public String getRsc_js_plg_scrollable_datatable() {
        return rsc_js_plg_scrollable_datatable;
    }

    public void setRsc_js_plg_scrollable_datatable(String rsc_js_plg_scrollable_datatable) {
        this.rsc_js_plg_scrollable_datatable = rsc_js_plg_scrollable_datatable;
    }

    public String getRsc_js_utilities() {
        return rsc_js_utilities;
    }

    public void setRsc_js_utilities(String rsc_js_utilities) {
        this.rsc_js_utilities = rsc_js_utilities;
    }

    public String getRsc_js_primefaces_customised() {
        return rsc_js_primefaces_customised;
    }

    public void setRsc_js_primefaces_customised(String rsc_js_primefaces_customised) {
        this.rsc_js_primefaces_customised = rsc_js_primefaces_customised;
    }

    public String getRsc_js_browser_detect() {
        return rsc_js_browser_detect;
    }

    public void setRsc_js_browser_detect(String rsc_js_browser_detect) {
        this.rsc_js_browser_detect = rsc_js_browser_detect;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setting Resources">
    public void ChangeTheme(String selected_theme) {
        setSelected_theme(selected_theme);
        setResources();
    }

    private void setResources() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("http://database.fes.org.in/web-resources/staff-scheduling/secured-resources.xml");
            doc.getDocumentElement().normalize();
            Element e;
            //user theme and path
            if (getSelected_theme() == null) {
                e = getElement(doc, "default-theme", "default-theme");
                setSecured_resources_path(getTagValue("secure-resources-path", e));
                setThemes_path(getTagValue("theme-path", e));
                setSelected_theme("default");
            }
            setSelected_theme_path(getThemes_path() + getSelected_theme() + "/");
            //title-icon
            e = getElement(doc, "title-icon", "title-icon");
            rsc_title_icon = getTagValue("file-path", e) + "?v=" + getTagValue("version", e);
            //fes-layout
            rsc_css_fes_layout = getJSCSS(doc, "stylesheets", "fes-layout");
            //fes-layout-skin
            rsc_css_fes_layout_skin = getJSCSS(doc, "stylesheets", "fes-layout-skin");
            //ddsmoothmenu
            rsc_css_ddsmoothmenu = getJSCSS(doc, "stylesheets", "ddsmoothmenu");
            //ddsmoothmenu-skin
            rsc_css_ddsmoothmenu_skin = getJSCSS(doc, "stylesheets", "ddsmoothmenu-skin");
            //jquery-skin
            rsc_css_skin = getJSCSS(doc, "stylesheets", "jquery-skin");
            //jquery-skin-general-customised
            rsc_css_skin_general_customised = getJSCSS(doc, "stylesheets", "jquery-skin-general-customised");
            //utilities
            rsc_js_utilities = getJSCSS(doc, "javascripts", "utilities");
            //primefaces-customised
            rsc_js_primefaces_customised = getJSCSS(doc, "javascripts", "primefaces-customised");
            //ddsmoothmenu
            rsc_js_ddsmoothmenu = getJSCSS(doc, "javascripts", "ddsmoothmenu");
            //browser_detect
            rsc_js_browser_detect = getJSCSS(doc, "javascripts", "browser-detect");
            //date.format
            rsc_js_plg_date_format = getJSCSS(doc, "javascripts", "plugin-date-format");
            //plugin-scrollable-tree
            rsc_js_plg_scrollable_tree = getJSCSS(doc, "javascripts", "plugin-scrollable-tree");
            //plugin-scroll-resizable
            rsc_js_plg_scroll_resizable = getJSCSS(doc, "javascripts", "plugin-scroll-resizable");
            //plugin-currency-formatter
            rsc_js_plg_currencyFormatter = getJSCSS(doc, "javascripts", "plugin-currency-formatter");
            //plugin-input-currency-formatter
            rsc_js_plg_input_currencyFormatter = getJSCSS(doc, "javascripts", "plugin-input-currency-formatter");
            //loading-image
            e = getElement(doc, "images", "loading-image");
            rsc_img_loading = getTagValue("file-path", e) + "?v=" + getTagValue("version", e);
            //loading-bar
            e = getElement(doc, "images", "loading-bar");
            rsc_img_loading_bar = getTagValue("file-path", e) + "?v=" + getTagValue("version", e);
        } catch (Exception ex) {
            logGenerator.generateLog(systemName, Level.SEVERE, GlobalResources.class.getName(), "setResources()", null, ex);
        }
    }

    private Element getElement(Document doc, String resourceType, String resourceName) {
        XPathExpression expr;
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        NodeList nodeList;
        Element e = null;
        try {
            expr = xpath.compile("//" + resourceType + "[res-name='" + resourceName + "']/*/text()");
            nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            e = (Element) nodeList.item(0).getParentNode().getParentNode();
        } catch (XPathExpressionException ex) {
            logGenerator.generateLog(systemName, Level.SEVERE, GlobalResources.class.getName(), "getElement", "resourcesName : " + resourceName, ex);
        } catch (Exception ex) {
            logGenerator.generateLog(systemName, Level.SEVERE, GlobalResources.class.getName(), "getElement", "resourcesName : " + resourceName, ex);
        }
        return e;
    }

    private String getTagValue(String sTag, Element eElement) {
        return eElement.getElementsByTagName(sTag).item(0).getChildNodes().item(0).getNodeValue();
    }

    private String getJSCSS(Document doc, String resourceType, String resourceName) {
        Element e = getElement(doc, resourceType, resourceName);
        String v_returning_string;
        if (getTagValue("theme-file", e).equals("0")) {
            v_returning_string = getTagValue("file-path", e) + "?v=" + getTagValue("version", e);
        } else {
            v_returning_string = getSelected_theme_path() + getTagValue("file-path", e) + "?v=" + getTagValue("version", e);
        }
        return v_returning_string;
    }// </editor-fold>
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Theme Setting">
    //FhrdEmpmst ent_login_user = null;
    String user_theme = null;
    String selected_theme = null;
    String themes_path = null;
    String selected_theme_path = null;

//    public void setUserFromGlobalSettings(FhrdEmpmst ent_login_user1) {
//        ent_login_user = ent_login_user1;
//        //user_theme=ent_login_user.getUserTheme();
//        if (user_theme != null) {
//            selected_theme = user_theme;
//        }
//    }
//    public FhrdEmpmst getEnt_login_user() {
//        return ent_login_user;
//    }
//
//    public void setEnt_login_user(FhrdEmpmst ent_login_user) {
//        this.ent_login_user = ent_login_user;
//    }
    public String getUser_theme() {
        return user_theme;
    }

    public void setUser_theme(String user_theme) {
        this.user_theme = user_theme;
    }

    public String getSelected_theme() {
        return selected_theme;
    }

    public void setSelected_theme(String selected_theme) {
        this.selected_theme = selected_theme;
    }

    public String getThemes_path() {
        return themes_path;
    }

    public void setThemes_path(String themes_path) {
        this.themes_path = themes_path;
    }

    public String getSelected_theme_path() {
        return selected_theme_path;
    }

    public void setSelected_theme_path(String selected_theme_path) {
        this.selected_theme_path = selected_theme_path;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="DialogBox Settings">
    public String waitDialog_hide = new String();
    public String waitDialog_show = new String();
    public String GeneralDialog_show = new String();
    public String GeneralDialog_hide = new String();

    public String getWaitDialog_hide() {
        return waitDialog_hide;
    }

    public void setWaitDialog_hide(String waitDialog_hide) {
        this.waitDialog_hide = waitDialog_hide;
    }

    public String getGeneralDialog_hide() {
        return GeneralDialog_hide;
    }

    public void setGeneralDialog_hide(String GeneralDialog_hide) {
        this.GeneralDialog_hide = GeneralDialog_hide;
    }

    public String getGeneralDialog_show() {
        return GeneralDialog_show;
    }

    public void setGeneralDialog_show(String GeneralDialog_show) {
        this.GeneralDialog_show = GeneralDialog_show;
    }

    public String getWaitDialog_show() {
        return waitDialog_show;
    }

    public void setWaitDialog_show(String waitDialog_show) {
        this.waitDialog_show = waitDialog_show;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Default Constructor & Other Beans">
    // <editor-fold defaultstate="collapsed" desc="Default Constructor">

    public GlobalResources() {
        setResources();
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="getGlobalUtilities">

    protected GlobalUtilities getGlobalUtilities() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (GlobalUtilities) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "GlobalUtilities");
    }// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="getGlobalSettings">
//    protected GlobalSettings getGlobalSettings() {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        return (GlobalSettings) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "GlobalSettings");
//    }
    // </editor-fold>
    // </editor-fold>
}
