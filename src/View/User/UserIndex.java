/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.User;

import App.Network.NetworkPool;
import App.Middleware.MiddlewareAuth;
import App.Cache.CacheUpdateProfile;
import App.UserIndexHelper;
import App.Exception.ExceptionActivity;

import Controller.ArchiveController;
import Controller.ArticleController;
import Controller.AuthController;
import Controller.DocumentController;
import Controller.QueryController;

import Tools.Colorful;
import View.SinglePage;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Fajar-PC
 */
public class UserIndex extends javax.swing.JFrame {

    /**
     * Creates new form UserIndex
     */
    protected NetworkPool np = new NetworkPool();
    private MiddlewareAuth mwAuth = new MiddlewareAuth();
    private boolean Resume = false;
    private final Colorful c = new Colorful();
    private final ArchiveController archController = new ArchiveController();
    private final DocumentController docmController = new DocumentController();
    private final ArticleController artiController = new ArticleController();
    private final QueryController querController = new QueryController();
    private final UserIndexHelper uIH = new UserIndexHelper();
    private final CacheUpdateProfile cUP = new CacheUpdateProfile();
    
    public UserIndex() {
        initComponents();
        SPA();
    }
    
    public void SPA() {
//        setNotifierToHtml();
        
        activeInactiveNav(c.getActiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor());
        panel_submain.setVisible(false);
        ReadToArchiveController();
    }
    
    public void NoteToNotifier(String val) {
        lbl_notifier.setText(val);
    }
    
    public void setNotifierToHtml(String val) {
        NoteToNotifier(val);
    }
    
    public void activeInactiveNav(Color archive, Color doc, Color article, Color details, Color settings) {
        nav_archive.setForeground(archive);
        nav_document.setForeground(doc);
        nav_article.setForeground(article);
        nav_settings.setForeground(settings);
        nav_details.setForeground(details);
    }
    
    public void activeInactiveNavBackground(Color archive, Color doc, Color article, Color details, Color settings) {
        nav_archive.setBackground(archive);
        nav_document.setBackground(doc);
        nav_article.setBackground(article);
        nav_settings.setBackground(settings);
        nav_details.setBackground(details);
    }
    
    public void showLblSeparator(boolean val) {
        lbl_separator_one.setVisible(val);
        lbl_separator_two.setVisible(val);
        lbl_separator_three.setVisible(val);
    }
    
    public void showLblSection(boolean val) {
        lbl_section_child_one.setVisible(val);
        lbl_section_child_two.setVisible(val);
        lbl_section_child_three.setVisible(val);
    }
    
    public void showEditable(boolean val) {
        txt_editable_one.setVisible(false);
        txt_editable_two.setVisible(val);
        txt_editable_three.setVisible(val);
    }
    
    public void setLblSection(String val1, String val2, String val3) {
        lbl_section_child_one.setText(val1);
        lbl_section_child_two.setText(val2);
        lbl_section_child_three.setText(val3);
    }
    
    public void showTxtSection(boolean val) {
        txt_section_child_one.setVisible(val);
        txt_section_child_two.setVisible(val);
        txt_section_child_three.setVisible(val);
    }
    
    public void setTxtSection(String val1, String val2, String val3) {
        txt_section_child_one.setText(val1);
        txt_section_child_two.setText(val2);
        txt_section_child_three.setText(val3);
    }

    public void setNetworkPool(NetworkPool val) { this.np = val; }
    public NetworkPool getNetworkPool() { return this.np; }
    
    public void setMiddlewareAuth(MiddlewareAuth val) { this.mwAuth = val; }
    public MiddlewareAuth getMiddlewareAuth() { return this.mwAuth; }
    
    public void logMiddlewareAuth() {
        JOptionPane.showMessageDialog(null, "Auth-Key: "+getMiddlewareAuth().getAuthKey()+"Username: "+getMiddlewareAuth().getUsername()+"Password: "+getMiddlewareAuth().getPassword());
    }
    
    public void loadData(Object[][] objs, String[] fields) {
        tbl_databases.setModel(new javax.swing.table.DefaultTableModel(
            objs,
            fields
        ));
    }
    
    public void loadBulk(Object[][] objs, String[] fields) {
        tbl_bulk.setModel(new javax.swing.table.DefaultTableModel(
            objs,
            fields
        ));
    }
    
    // Archive
    public void ReadToArchiveController() {
        archController.ReadArchive(getNetworkPool());
        loadData(archController.pluralList(), getNetworkPool().getQueryer().getFields());
    }
    
    // Document
    public void ReadToDocumentController() {
        docmController.ReadDocument(getNetworkPool());
        loadData(docmController.pluralList(), getNetworkPool().getQueryer().getFields());
    }
    
    // Article
    public void ReadToArticleController() {
        artiController.ReadArticle(getNetworkPool());
        loadData(artiController.pluralList(), getNetworkPool().getQueryer().getFields());
    }
    
    public void FilterToArchiveController() {
        String searchText = txt_search.getText();
        
        String query = "select * from archive"+" where "+"id_archive='"+searchText+"';";
        
        archController.setOp("R");
        archController.setNetworkPool(getNetworkPool());
        archController.setQuery(query);
//        JOptionPane.showMessageDialog(null, "Query "+query);
//        JOptionPane.showMessageDialog(null, "Searching!");
        loadData(archController.pluralListFilter(), getNetworkPool().getQueryer().getFields());
    }
    
    public void FilterToDocumentController() {
        String searchText = txt_search.getText();
        
        String query = "select * from document"+" where "+"id_document='"+searchText+"';";

        docmController.setOp("R");
        docmController.setNetworkPool(getNetworkPool());
        docmController.setQuery(query);
//        docmController.Read();
//        JOptionPane.showMessageDialog(null, "Query "+query);
//        JOptionPane.showMessageDialog(null, "Searching!");
        loadData(docmController.pluralListFilter(), getNetworkPool().getQueryer().getFields());
    }
    
    public void FilterToArticleController() {
        String searchText = txt_search.getText();
        
        String query = "select * from article"+" where "+"id_article='"+searchText+"';";
        artiController.setOp("R");
        artiController.setNetworkPool(getNetworkPool());
        artiController.setQuery(query);
//        artiController.Read();
//        JOptionPane.showMessageDialog(null, "Query "+query);
//        JOptionPane.showMessageDialog(null, "Searching!");
        loadData(artiController.pluralListFilter(), getNetworkPool().getQueryer().getFields());
    }
    
    public void NavSettings(java.awt.event.MouseEvent evt) {
        lbl_result.setVisible(false);
        panel_tbl_bulk.setVisible(false);
        activeInactiveNavBackground(c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getActiveBackgroundColor());
        showEditable(false);
        txt_search.setText("Search here...");
        btn_edit_or_bookmark.setText("Edit Profile");
        showLblSeparator(false);
        lbl_header.setText("<html><h2>Configure with your <strong>mind!<strong><h2></html>");
        txt_section_profile.setText("<html>"
                + "<h3>Setting Profile<h3>"
                + "</html>");
        lbl_notifier.setIcon(null);
        setNotifierToHtml("<html><h1>Settings</h1></html>");
        activeInactiveNav(c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getActiveColor());
        showLblSection(true);
        setLblSection("ID-Auth: ", "Username: ", "Password: ");
        showTxtSection(true);
        if (cUP.getChanged()) {
            setTxtSection(getMiddlewareAuth().getAuthKey(), cUP.getFreshUsername(), cUP.getFreshPassword());
        } else {
            setTxtSection(getMiddlewareAuth().getAuthKey(), getMiddlewareAuth().getUsername(), getMiddlewareAuth().getPassword());
        }
        panel_main.setVisible(false);
        panel_submain.setVisible(true);
    }
    
    public void NavArchive(java.awt.event.MouseEvent evt) {
        activeInactiveNavBackground(c.getActiveBackgroundColor(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        txt_search.setText("Search here...");
        lbl_database.setText("Archive");
        panel_main.setVisible(true);
        panel_submain.setVisible(false);
        lbl_notifier.setIcon(null);
        setNotifierToHtml("<html><h1>Archive</h1></html>");
        activeInactiveNav(c.getActiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor());
        ReadToArchiveController();
    }
    
    public void NavDocument(java.awt.event.MouseEvent evt) {
        activeInactiveNavBackground(c.getBlueCommon(), c.getActiveBackgroundColor(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        txt_search.setText("Search here...");
        lbl_database.setText("Document");
        panel_main.setVisible(true);
        panel_submain.setVisible(false);
        lbl_notifier.setIcon(null);
        setNotifierToHtml("<html><h1>Document</h1></html>");
        activeInactiveNav(c.getInactiveColor(), c.getActiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor());
        ReadToDocumentController();
    }
    
    public void NavArticle(java.awt.event.MouseEvent evt) {
        activeInactiveNavBackground(c.getBlueCommon(), c.getBlueCommon(), c.getActiveBackgroundColor(), c.getBlueCommon(), c.getBlueCommon());
        nav_article.setBackground(c.getActiveBackgroundColor());
        txt_search.setText("Search here...");
        lbl_database.setText("Article");
        panel_main.setVisible(true);
        panel_submain.setVisible(false);
        lbl_notifier.setIcon(null);
        setNotifierToHtml("<html><h1>Article</h1></html>");
        activeInactiveNav(c.getInactiveColor(), c.getInactiveColor(), c.getActiveColor(), c.getInactiveColor(), c.getInactiveColor());
        ReadToArticleController();
    }
    
    public void NavDetails(java.awt.event.MouseEvent evt) {
        lbl_result.setVisible(false);
        panel_tbl_bulk.setVisible(false);
        txt_section_profile.setVisible(false);
        activeInactiveNavBackground(c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getActiveBackgroundColor(), c.getBlueCommon());
        showEditable(false);
        txt_search.setText("Search here...");
        showLblSection(false);
        showLblSeparator(false);
        showTxtSection(false);
        btn_edit_or_bookmark.setText("Check Bookmark");
        lbl_header.setText("<html><h2>Check your bookmark <strong>details!</strong></h2></html>");
        txt_section_profile.setText(uIH.combine());
        lbl_notifier.setIcon(null);
        setNotifierToHtml("<html><h1>Details</h1></html>");
        activeInactiveNav(c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getActiveColor(), c.getInactiveColor());
        showTxtSection(false);
        panel_main.setVisible(false);
        panel_submain.setVisible(true);
    }
    
    public void TableTouched(java.awt.event.MouseEvent evt) {
        String val = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 0).toString();
        System.out.println(lbl_database.getText());
        try {
        if (evt.getButton() == 1) {
            System.out.println("Clicked!");
            if (tbl_databases.isEditing()) {
                TableCellEditor edt = tbl_databases.getCellEditor();
                if (edt != null) {
                    // Try and stop the cell editing process
                    if (!edt.stopCellEditing()) {
                        // Cancel the editing if can't be stopped...
                        // You could handle an error state here instead...
                        edt.cancelCellEditing();
                    }
                }
            
            }
            if (val == null) {
                txt_id.setText("");
            } else {
                txt_id.setText(val);
                if ("Archive".equals(lbl_database.getText())) { uIH.setArchive(val); }
                if ("Document".equals(lbl_database.getText())) { uIH.setDocument(val); }
                if ("Article".equals(lbl_database.getText())) { uIH.setArticle(val); }
            }
        } 
//        System.out.println("getSoruce: "+evt.getSource());
        } catch (Exception e) { try {
            throw new ExceptionActivity("Selected no value! ("+e.getMessage()+")");
            } catch (ExceptionActivity ex) {
                Logger.getLogger(UserIndex.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void BookmarkTouched(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Bookmarked!");
        if (lbl_database.getText() == "Archive") {
            JOptionPane.showMessageDialog(null, "Prefered (OK)!");
            txt_section_profile.setText(uIH.combine());
            Resume = true;
        }
        
        if (lbl_database.getText() == "Document") {
            JOptionPane.showMessageDialog(null, "Prefered Archive First!");
            if (Resume) { txt_section_profile.setText(uIH.combine()); Resume = false; }
        }
        
        if (lbl_database.getText() == "Article") {
            JOptionPane.showMessageDialog(null, "Prefered Document First!");
            if (Resume) { txt_section_profile.setText(uIH.combine()); Resume = false; uIH.reset(); }
        }
    }
    
    public void SearchTouched(java.awt.event.MouseEvent evt) {
//        String val = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 0).toString();
//        JOptionPane.showMessageDialog(null, "Search: "+txt_search.getText());
//        System.out.println("Row count: "+tbl_databases.getRowHeight());
        if (lbl_database.getText() == "Archive") {
            FilterToArchiveController();
        }
        
        if (lbl_database.getText() == "Document") {
            FilterToDocumentController();
        }
        
        if (lbl_database.getText() == "Article") {
            FilterToArticleController();
        }
    }
    
    public void ReadAllTouched(java.awt.event.MouseEvent evt) {
        if (lbl_database.getText() == "Archive") {
            ReadToArchiveController();
        }
        
        if (lbl_database.getText() == "Document") {
            ReadToDocumentController();
        }
        
        if (lbl_database.getText() == "Article") {
            ReadToArticleController();
        }
    }
    
    public void BtnMiracleApplyTouched() {
        if (btn_edit_or_bookmark.getText() == "Apply") {
            showEditable(false);
            btn_edit_or_bookmark.setText("Edit Profile");
            cUP.setOldUsername(mwAuth.getUsername());
            cUP.setOldPassword(mwAuth.getPassword());
            String uspass = txt_section_child_one.getText()+"_"+txt_editable_two.getText()+"_"+txt_editable_three.getText();
            NetworkPool npLocal = getNetworkPool();
            AuthController auth = new AuthController();
            npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsAuth());
            npLocal.getQueryer().setOp("U");
            npLocal.getQueryer().setValues(uspass.split("_"));
            npLocal.getQueryer().setTable("auth");
            npLocal.getQueryer().setField("id_auth");
            npLocal.getQueryer().setValue(txt_section_child_one.getText());
            npLocal.getQueryer().Query();
            auth.setOp(npLocal.getQueryer().getOp());
            auth.setNetworkPool(getNetworkPool());
            auth.setQuery(npLocal.getQueryer().getQuery());
            auth.Update();
            cUP.setFreshUsername(txt_editable_two.getText());
            cUP.setFreshPassword(txt_editable_three.getText());
            cUP.setChanged(true);
            JOptionPane.showMessageDialog(null, "Apply update success!");
            showTxtSection(true);
        }
    }
    
    public void BtnMiracleEditProfileTouched() {
        if (btn_edit_or_bookmark.getText() == "Edit Profile") {
            showTxtSection(false);
            showEditable(true);
            btn_edit_or_bookmark.setText("Apply");
        }
    }
    
    public void BtnMiracleCheckBookmark() {
        if (btn_edit_or_bookmark.getText() == "Check Bookmark") {
            uIH.setSplitThrees(uIH.combine().split("_"));
            if (uIH.getSplitThrees().length == 1) {
//               JOptionPane.showMessageDialog(null, "Split bookmark: "+uIH.getSplitThrees()[0]); 
            } if (uIH.getSplitThrees().length == 2) {
//               JOptionPane.showMessageDialog(null, "Split bookmark: "+uIH.getSplitThrees()[0]+" "+uIH.getSplitThrees()[1]);
            } if (uIH.getSplitThrees().length == 3) {
//               JOptionPane.showMessageDialog(null, "Split bookmark: "+uIH.getSplitThrees()[0]+" "+uIH.getSplitThrees()[1]+" "+uIH.getSplitThrees()[2]);
            } 
//            JOptionPane.showMessageDialog(null, "Split bookmark: "+uIH.getSplitThrees()[0]+" "+uIH.getSplitThrees()[1]+" "+uIH.getSplitThrees()[2]);
            if (uIH.getSplitThrees().length > 0) {
                if (uIH.getSplitThrees()[0].length() > 4) {
                    String query = "select * from archive"+" where "+"id_archive='"+uIH.getSplitThrees()[0]+"';";

                    archController.setOp("R");
                    archController.setNetworkPool(getNetworkPool());
                    archController.setQuery(query);
                    loadBulk(archController.pluralListFilter(), getNetworkPool().getStorageDB().getFieldsArchive());
//                    JOptionPane.showMessageDialog(null, "Bulk[len-1]: "+archController.pluralListFilter()[0][getNetworkPool().getStorageDB().getFieldsArchive().length-1]);
                    txt_section_profile.setText("reset");
                    uIH.commitToAbstract(archController.pluralListFilter()[0][getNetworkPool().getStorageDB().getFieldsArchive().length-1].toString(), null);
                    lbl_result.setText(uIH.getBulkArchive());
                    saveQuery();
                    uIH.reset();
                    panel_tbl_bulk.setVisible(false);
                    bulkArchive(archController.pluralListFilter()[0][getNetworkPool().getStorageDB().getFieldsArchive().length-1].toString());
                } else
                if (uIH.getSplitThrees()[1].length() > 4) {
                    String query = "select * from document"+" where "+"id_document='"+uIH.getSplitThrees()[1]+"';";

                    docmController.setOp("R");
                    docmController.setNetworkPool(getNetworkPool());
                    docmController.setQuery(query);
                    loadBulk(docmController.pluralListFilter(), getNetworkPool().getStorageDB().getFieldsDocument());
//                    JOptionPane.showMessageDialog(null, "Bulk[len-1]: "+docmController.pluralListFilter()[0][getNetworkPool().getStorageDB().getFieldsDocument().length-1]);
                    txt_section_profile.setText("reset");
                    uIH.commitToAbstract(null, docmController.pluralListFilter()[0][getNetworkPool().getStorageDB().getFieldsDocument().length-1].toString());
                    lbl_result.setText(uIH.getBulkDocument());
                    saveQuery();
                    uIH.reset();
                    panel_tbl_bulk.setVisible(false);
                    bulkDocument(docmController.pluralListFilter()[0][getNetworkPool().getStorageDB().getFieldsDocument().length-1].toString());
                } else
                if (uIH.getSplitThrees()[2].length() > 4) {
                    String combine = "";
                    String query = "select * from article"+" where "+"id_article='"+uIH.getSplitThrees()[2]+"';";
                    artiController.setOp("R");
                    artiController.setNetworkPool(getNetworkPool());
                    artiController.setQuery(query);
                    loadBulk(artiController.pluralListFilter(), getNetworkPool().getStorageDB().getFieldsArticle());
//                    JOptionPane.showMessageDialog(null, "Bulk[len-1]: "+artiController.pluralListFilter()[0][getNetworkPool().getStorageDB().getFieldsArticle().length-1]);
                    String res = artiController.pluralListFilter()[0][0].toString()+" "+artiController.pluralListFilter()[0][1].toString()+" "+artiController.pluralListFilter()[0][2]+" "+artiController.pluralListFilter()[0][3];
//                    JOptionPane.showMessageDialog(null, "Result: "+res);
                    txt_section_profile.setText("eset");
                    lbl_result.setText("Article is not bulk..!"+res);
                    for (int j = 0; j < artiController.pluralListFilter()[0][3].toString().split("_").length; j++) {
                        combine += artiController.pluralListFilter()[0][3].toString().split("_")[j]+" ";
                    }
                    lbl_result.setText("<html><h3>ID Article : "+artiController.pluralListFilter()[0][0].toString()+"</h3>"+"<p>Name Article : "+artiController.pluralListFilter()[0][1].toString()+"</p>"+"<p>Date Article : "+artiController.pluralListFilter()[0][2]+"</p>"+"<p>Content Article : "+combine+"</p>"+"</h3></html>");
                    saveQuery();
                    uIH.reset();
                    panel_tbl_bulk.setVisible(false);
                }
            }
            txt_section_profile.setVisible(false);
            lbl_result.setVisible(true);
        }
    }
    
    public void BtnMiracleTouched(java.awt.event.MouseEvent evt) {
        BtnMiracleApplyTouched();
        BtnMiracleEditProfileTouched();
        BtnMiracleCheckBookmark();
    }
    
    public void bulkArchive(String val) {
        String[] split = val.split("_");
        String forHtml = "<html><br>From Archive (bulk_archive == parsed to DB document)<br>";
        for (int i = 0; i < split.length; i++) {
            String combine = "";
            String query = "select * from document"+" where "+"id_document='"+split[i]+"';";

            docmController.setOp("R");
            docmController.setNetworkPool(getNetworkPool());
            docmController.setQuery(query);
            loadBulk(docmController.pluralListFilter(), getNetworkPool().getStorageDB().getFieldsDocument());
//            JOptionPane.showMessageDialog(null, "Inner Bulk[len-1]: "+val);
//            JOptionPane.showMessageDialog(null, "Inner id_document: "+split[i]);
            txt_section_profile.setText("reset");
            uIH.commitToAbstract(val, null);
            lbl_result.setText(uIH.getBulkArchive());
//            JOptionPane.showMessageDialog(null, "testdoc object[]: "+docmController.pluralListFilter()[0][0]);
//            forHtml += "<html><br>From Archive<br>";
            for (int j = 0; j < docmController.pluralListFilter()[0][4].toString().split("_").length; j++) {
                combine += docmController.pluralListFilter()[0][4].toString().split("_")[j]+" ";
            }
            forHtml += "<h3>ID Document : "+docmController.pluralListFilter()[0][0].toString()+"</h3></p>Name Document : "+docmController.pluralListFilter()[0][1]+"</p>"+"<p>Date Document : "+docmController.pluralListFilter()[0][2].toString()+"</p>"+"<p>Theme Document : "+docmController.pluralListFilter()[0][3]+"</p>"+"<p>Bulk Document : "+combine+"</p>";
            uIH.reset();
            panel_tbl_bulk.setVisible(false);
//            JOptionPane.showMessageDialog(null, "forHtml bulkdocument: "+forHtml);
        }
        forHtml += "</html>";
        lbl_result.setText(forHtml);
    }
    
    public void bulkDocument(String val) {
        String[] split = val.split("_");
        String forHtml = "<html><br>From Document (bulk_document == parsed to DB article)<br>";
        
        for (int i = 0; i < split.length; i++) {
            String combine = "";
            String query = "select * from article"+" where "+"id_article='"+split[i]+"';";

            artiController.setOp("R");
            artiController.setNetworkPool(getNetworkPool());
            artiController.setQuery(query);
            loadBulk(artiController.pluralListFilter(), getNetworkPool().getStorageDB().getFieldsArticle());
//            JOptionPane.showMessageDialog(null, "Inner Bulk[len-1]: "+val);
//            JOptionPane.showMessageDialog(null, "Inner id_article: "+split[i]);
            txt_section_profile.setText("reset");
            uIH.commitToAbstract(null, val);
            lbl_result.setText(uIH.getBulkDocument());
//            JOptionPane.showMessageDialog(null, "testart object[]: "+artiController.pluralListFilter()[0][0]);
//            forHtml += "<html><br>From Document<br>";
            
            for (int j = 0; j < artiController.pluralListFilter()[0][3].toString().split("_").length; j++) {
                combine += artiController.pluralListFilter()[0][3].toString().split("_")[j]+" ";
            }
            forHtml += "<h3>ID Article : "+artiController.pluralListFilter()[0][0].toString()+"</h3></p>Name Article : "+artiController.pluralListFilter()[0][1]+"</p>"+"<p>Date Article : "+artiController.pluralListFilter()[0][2].toString()+"</p>"+"<p>Content Article : "+combine+"</p>";
            uIH.reset();
            panel_tbl_bulk.setVisible(false);
//            JOptionPane.showMessageDialog(null, "forHtml bulkarticle: "+forHtml);
        }
        forHtml += "</html>";
        lbl_result.setText(forHtml);
    }
    
    public void saveQuery() {
        if (cUP.getChanged()) {
                NetworkPool npLocal = getNetworkPool();
//                setTxtSection(getMiddlewareAuth().getAuthKey(), cUP.getFreshUsername(), cUP.getFreshPassword());
                npLocal.getQueryer().setOp("U");
                npLocal.getQueryer().setTable("query");
                npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsQuery());
                npLocal.getQueryer().setField("id_query");
                npLocal.getQueryer().setValue(getMiddlewareAuth().getAuthKey());
                npLocal.getQueryer().setValues(new String[]{getMiddlewareAuth().getAuthKey(), uIH.combine()});
                npLocal.getQueryer().Query();
                querController.setOp(npLocal.getQueryer().getOp());
                querController.setQuery(npLocal.getQueryer().getQuery());
                querController.setNetworkPool(npLocal);
                querController.Update();
            } else {
//                setTxtSection(getMiddlewareAuth().getAuthKey(), getMiddlewareAuth().getUsername(), getMiddlewareAuth().getPassword());
                NetworkPool npLocal = getNetworkPool();
                npLocal.getQueryer().setOp("U");
                npLocal.getQueryer().setTable("query");
                npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsQuery());
                npLocal.getQueryer().setField("id_query");
                npLocal.getQueryer().setValue(getMiddlewareAuth().getAuthKey());
                npLocal.getQueryer().setValues(new String[]{getMiddlewareAuth().getAuthKey(), uIH.combine()});
                npLocal.getQueryer().Query();
                querController.setOp(npLocal.getQueryer().getOp());
                querController.setQuery(npLocal.getQueryer().getQuery());
                querController.setNetworkPool(npLocal);
                querController.Update();
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        nav_archive = new javax.swing.JLabel();
        nav_document = new javax.swing.JLabel();
        nav_article = new javax.swing.JLabel();
        lbl_logout = new javax.swing.JLabel();
        nav_details = new javax.swing.JLabel();
        nav_settings = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_notifier = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panel_main = new javax.swing.JPanel();
        lbl_database = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_databases = new javax.swing.JTable();
        btn_bookmark = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        lbl_id = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        lbl_search = new javax.swing.JLabel();
        btn_readAll = new javax.swing.JButton();
        panel_submain = new javax.swing.JPanel();
        lbl_header = new javax.swing.JLabel();
        txt_section_profile = new javax.swing.JLabel();
        txt_section_child_one = new javax.swing.JLabel();
        txt_section_child_two = new javax.swing.JLabel();
        txt_section_child_three = new javax.swing.JLabel();
        lbl_section_child_one = new javax.swing.JLabel();
        lbl_section_child_two = new javax.swing.JLabel();
        lbl_section_child_three = new javax.swing.JLabel();
        btn_edit_or_bookmark = new javax.swing.JButton();
        lbl_separator_two = new javax.swing.JLabel();
        lbl_separator_one = new javax.swing.JLabel();
        lbl_separator_three = new javax.swing.JLabel();
        txt_editable_one = new javax.swing.JTextField();
        txt_editable_two = new javax.swing.JTextField();
        txt_editable_three = new javax.swing.JTextField();
        lbl_result = new javax.swing.JLabel();
        panel_tbl_bulk = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bulk = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        lbl_title.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_warehouse_32px.png"))); // NOI18N
        lbl_title.setText("Warehouse of Book");

        nav_archive.setBackground(new java.awt.Color(70, 163, 255));
        nav_archive.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_archive.setForeground(new java.awt.Color(255, 255, 255));
        nav_archive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_archive_32px.png"))); // NOI18N
        nav_archive.setText("Archive");
        nav_archive.setOpaque(true);
        nav_archive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_archiveMouseClicked(evt);
            }
        });

        nav_document.setBackground(new java.awt.Color(0, 153, 255));
        nav_document.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_document.setForeground(new java.awt.Color(255, 255, 255));
        nav_document.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_document_32px.png"))); // NOI18N
        nav_document.setText("Document");
        nav_document.setOpaque(true);
        nav_document.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_documentMouseClicked(evt);
            }
        });

        nav_article.setBackground(new java.awt.Color(0, 153, 255));
        nav_article.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_article.setForeground(new java.awt.Color(255, 255, 255));
        nav_article.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_matt_paper_32px.png"))); // NOI18N
        nav_article.setText("Article");
        nav_article.setOpaque(true);
        nav_article.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_articleMouseClicked(evt);
            }
        });

        lbl_logout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_shutdown_32px.png"))); // NOI18N
        lbl_logout.setText("Logout");
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });

        nav_details.setBackground(new java.awt.Color(0, 153, 255));
        nav_details.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_details.setForeground(new java.awt.Color(255, 255, 255));
        nav_details.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_details_32px.png"))); // NOI18N
        nav_details.setText("Details");
        nav_details.setOpaque(true);
        nav_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_detailsMouseClicked(evt);
            }
        });

        nav_settings.setBackground(new java.awt.Color(0, 153, 255));
        nav_settings.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_settings.setForeground(new java.awt.Color(255, 255, 255));
        nav_settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_settings_32px.png"))); // NOI18N
        nav_settings.setText("Settings");
        nav_settings.setOpaque(true);
        nav_settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_settingsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nav_settings, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_archive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_document, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_article, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(nav_details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title)
                .addGap(38, 38, 38)
                .addComponent(nav_settings)
                .addGap(18, 18, 18)
                .addComponent(nav_archive)
                .addGap(18, 18, 18)
                .addComponent(nav_document)
                .addGap(18, 18, 18)
                .addComponent(nav_article)
                .addGap(18, 18, 18)
                .addComponent(nav_details)
                .addGap(34, 34, 34)
                .addComponent(lbl_logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        lbl_notifier.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_notifier.setForeground(new java.awt.Color(255, 255, 255));
        lbl_notifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_salute_32px.png"))); // NOI18N
        lbl_notifier.setText("Welcome");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(lbl_notifier, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_notifier)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));

        panel_main.setBackground(new java.awt.Color(0, 153, 255));

        lbl_database.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_database.setForeground(new java.awt.Color(255, 255, 255));
        lbl_database.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_price_tag_32px.png"))); // NOI18N
        lbl_database.setText("Archive");

        tbl_databases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_databases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_databasesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_databases);

        btn_bookmark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_bookmark_32px.png"))); // NOI18N
        btn_bookmark.setText("Bookmark");
        btn_bookmark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_bookmarkMouseClicked(evt);
            }
        });

        txt_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        lbl_id.setText("ID");

        txt_search.setText("Search here...");
        txt_search.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.orange, java.awt.Color.orange));

        lbl_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_search_24px.png"))); // NOI18N
        lbl_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_searchMouseClicked(evt);
            }
        });

        btn_readAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_read_32px.png"))); // NOI18N
        btn_readAll.setText("Read All");
        btn_readAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_readAllMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_mainLayout = new javax.swing.GroupLayout(panel_main);
        panel_main.setLayout(panel_mainLayout);
        panel_mainLayout.setHorizontalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_mainLayout.createSequentialGroup()
                        .addComponent(lbl_database)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_mainLayout.createSequentialGroup()
                        .addComponent(lbl_id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_bookmark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_readAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_mainLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_mainLayout.setVerticalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_database)
                    .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_search)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_bookmark, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_readAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_submain.setBackground(new java.awt.Color(30, 153, 255));

        lbl_header.setForeground(new java.awt.Color(255, 255, 255));
        lbl_header.setText("Header");

        txt_section_profile.setForeground(new java.awt.Color(255, 255, 255));
        txt_section_profile.setText("Section");
        txt_section_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_section_profileMouseClicked(evt);
            }
        });

        txt_section_child_one.setForeground(new java.awt.Color(255, 255, 255));
        txt_section_child_one.setText("txt_section_child_one");

        txt_section_child_two.setForeground(new java.awt.Color(255, 255, 255));
        txt_section_child_two.setText("txt_section_child_one");

        txt_section_child_three.setForeground(new java.awt.Color(255, 255, 255));
        txt_section_child_three.setText("txt_section_child_one");

        lbl_section_child_one.setForeground(new java.awt.Color(255, 255, 255));
        lbl_section_child_one.setText("lbl_section_child_one");

        lbl_section_child_two.setForeground(new java.awt.Color(255, 255, 255));
        lbl_section_child_two.setText("lbl_section_child_two");

        lbl_section_child_three.setForeground(new java.awt.Color(255, 255, 255));
        lbl_section_child_three.setText("lbl_section_child_three");

        btn_edit_or_bookmark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_edit_16px.png"))); // NOI18N
        btn_edit_or_bookmark.setText("Edit Profile");
        btn_edit_or_bookmark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edit_or_bookmarkMouseClicked(evt);
            }
        });

        lbl_separator_two.setForeground(new java.awt.Color(255, 255, 255));
        lbl_separator_two.setText("lbl_separator_two");

        lbl_separator_one.setForeground(new java.awt.Color(255, 255, 255));
        lbl_separator_one.setText("lbl_separator_one");

        lbl_separator_three.setForeground(new java.awt.Color(255, 255, 255));
        lbl_separator_three.setText("lbl_separator_three");

        txt_editable_two.setText("your-new-username");
        txt_editable_two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_editable_twoActionPerformed(evt);
            }
        });

        txt_editable_three.setText("your-new-password");

        lbl_result.setForeground(new java.awt.Color(255, 255, 255));
        lbl_result.setText("lbl_result");

        tbl_bulk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_bulk);

        javax.swing.GroupLayout panel_tbl_bulkLayout = new javax.swing.GroupLayout(panel_tbl_bulk);
        panel_tbl_bulk.setLayout(panel_tbl_bulkLayout);
        panel_tbl_bulkLayout.setHorizontalGroup(
            panel_tbl_bulkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panel_tbl_bulkLayout.setVerticalGroup(
            panel_tbl_bulkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tbl_bulkLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_submainLayout = new javax.swing.GroupLayout(panel_submain);
        panel_submain.setLayout(panel_submainLayout);
        panel_submainLayout.setHorizontalGroup(
            panel_submainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_submainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_submainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_submainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_header)
                        .addGroup(panel_submainLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(panel_submainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_submainLayout.createSequentialGroup()
                                    .addComponent(lbl_section_child_one)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbl_separator_one))
                                .addGroup(panel_submainLayout.createSequentialGroup()
                                    .addComponent(lbl_section_child_three)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbl_separator_three))
                                .addGroup(panel_submainLayout.createSequentialGroup()
                                    .addComponent(lbl_section_child_two)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbl_separator_two)))
                            .addGap(31, 31, 31)
                            .addGroup(panel_submainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_section_child_one)
                                .addComponent(txt_section_child_two)
                                .addComponent(txt_section_child_three))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel_submainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_editable_one)
                                .addComponent(txt_editable_two, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addComponent(txt_editable_three)))
                        .addComponent(btn_edit_or_bookmark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txt_section_profile)
                    .addGroup(panel_submainLayout.createSequentialGroup()
                        .addComponent(panel_tbl_bulk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_result)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_submainLayout.setVerticalGroup(
            panel_submainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_submainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_section_profile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_submainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_section_child_one)
                    .addComponent(lbl_section_child_one)
                    .addComponent(lbl_separator_one)
                    .addComponent(txt_editable_one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_submainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_section_child_two)
                    .addComponent(lbl_section_child_two)
                    .addComponent(lbl_separator_two)
                    .addComponent(txt_editable_two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_submainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_section_child_three)
                    .addComponent(lbl_section_child_three)
                    .addComponent(lbl_separator_three)
                    .addComponent(txt_editable_three, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit_or_bookmark, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_submainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_result)
                    .addComponent(panel_tbl_bulk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_submain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_submain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        // TODO add your handling code here:
        if (cUP.getChanged()) {
                JOptionPane.showMessageDialog(null, "Logout and query saved! (has been updated the profile)");
            } else {
                JOptionPane.showMessageDialog(null, "Logout and query saved! (has not been updated the profile)");
            }
        new SinglePage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void nav_archiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_archiveMouseClicked
        // TODO add your handling code here:
        NavArchive(evt);
    }//GEN-LAST:event_nav_archiveMouseClicked

    private void nav_documentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_documentMouseClicked
        // TODO add your handling code here:
        NavDocument(evt);
    }//GEN-LAST:event_nav_documentMouseClicked

    private void nav_articleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_articleMouseClicked
        // TODO add your handling code here:
        NavArticle(evt);
    }//GEN-LAST:event_nav_articleMouseClicked

    private void nav_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_detailsMouseClicked
        // TODO add your handling code here:
        NavDetails(evt);
    }//GEN-LAST:event_nav_detailsMouseClicked

    private void nav_settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_settingsMouseClicked
        // TODO add your handling code here:
        NavSettings(evt);
    }//GEN-LAST:event_nav_settingsMouseClicked

    private void tbl_databasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_databasesMouseClicked
        // TODO add your handling code here:
        TableTouched(evt);
    }//GEN-LAST:event_tbl_databasesMouseClicked

    private void txt_section_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_section_profileMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_section_profileMouseClicked

    private void btn_bookmarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bookmarkMouseClicked
        // TODO add your handling code here:
        BookmarkTouched(evt);
    }//GEN-LAST:event_btn_bookmarkMouseClicked

    private void lbl_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_searchMouseClicked
        // TODO add your handling code here:
        SearchTouched(evt);
    }//GEN-LAST:event_lbl_searchMouseClicked

    private void btn_readAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_readAllMouseClicked
        // TODO add your handling code here:
        ReadAllTouched(evt);
    }//GEN-LAST:event_btn_readAllMouseClicked

    private void txt_editable_twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_editable_twoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_editable_twoActionPerformed

    private void btn_edit_or_bookmarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_or_bookmarkMouseClicked
        // TODO add your handling code here:
//        if (uIH.combine() == "__") { JOptionPane.showMessageDialog(null, "Try bookmark again..."); }
        BtnMiracleTouched(evt);
    }//GEN-LAST:event_btn_edit_or_bookmarkMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserIndex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bookmark;
    private javax.swing.JButton btn_edit_or_bookmark;
    private javax.swing.JButton btn_readAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_database;
    private javax.swing.JLabel lbl_header;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_notifier;
    private javax.swing.JLabel lbl_result;
    private javax.swing.JLabel lbl_search;
    private javax.swing.JLabel lbl_section_child_one;
    private javax.swing.JLabel lbl_section_child_three;
    private javax.swing.JLabel lbl_section_child_two;
    private javax.swing.JLabel lbl_separator_one;
    private javax.swing.JLabel lbl_separator_three;
    private javax.swing.JLabel lbl_separator_two;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel nav_archive;
    private javax.swing.JLabel nav_article;
    private javax.swing.JLabel nav_details;
    private javax.swing.JLabel nav_document;
    private javax.swing.JLabel nav_settings;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_submain;
    private javax.swing.JPanel panel_tbl_bulk;
    private javax.swing.JTable tbl_bulk;
    private javax.swing.JTable tbl_databases;
    private javax.swing.JTextField txt_editable_one;
    private javax.swing.JTextField txt_editable_three;
    private javax.swing.JTextField txt_editable_two;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_search;
    private javax.swing.JLabel txt_section_child_one;
    private javax.swing.JLabel txt_section_child_three;
    private javax.swing.JLabel txt_section_child_two;
    private javax.swing.JLabel txt_section_profile;
    // End of variables declaration//GEN-END:variables
}
