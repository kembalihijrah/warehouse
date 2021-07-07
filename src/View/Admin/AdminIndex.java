/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Admin;

import App.Network.NetworkPool;
import App.AdminIndexHelper;
import App.Middleware.MiddlewareAuth;
import App.Exception.ExceptionActivity;
//import App.Cache.CacheUpdateProfile;

import Controller.*;

import Tools.Colorful;
import View.SinglePage;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
// Create Archive
//getNetworkPool().getQueryer().setOp("C");
//        getNetworkPool().getQueryer().setFields(getNetworkPool().getStorageDB().getFieldsArchive());
//        getNetworkPool().getQueryer().setTable("archive");
////        mute.setOp("C");
////        mute.setFields(getNetworkPool().getStorageDB().getFieldsArchive());
////        mute.setTable("archive");
//        if (txt_values.getText().split("\\s+").length < getNetworkPool().getQueryer().getFields().length) {
//            JOptionPane.showMessageDialog(null, "Not enough!");
//        }
//        if (btn_mode.getText() == "Mode Developer") {
////            mute.setValues(values.split("\\s+"));
//            getNetworkPool().getQueryer().setValues(values.split("\\s+"));
//        } else {
////            mute.setValues(txt_values.getText().split("\\s+"));
//            getNetworkPool().getQueryer().setValues(txt_values.getText().split("\\s+"));
//        }
////        mute.Query();
//        getNetworkPool().getQueryer().Query();
////        txtarea_query.setText(mute.getQuery());
//        txtarea_query.setText(getNetworkPool().getQueryer().getQuery());
////        archController.setOp(mute.getOp());
////        archController.setQuery(mute.getQuery());
//        archController.setOp(getNetworkPool().getQueryer().getOp());
//        archController.setQuery(getNetworkPool().getQueryer().getQuery());
//        archController.logOpQuery();
//        archController.logConnManConnStm();
//        
//        archController.setNetworkPool(getNetworkPool());
//        try {
//            archController.setStm(getNetworkPool().getConnMan().logOn().createStatement());
//            archController.Create();
//        } catch(Exception e) {}
//        getNetworkPool().getConnMan().logOff();
//        if (btn_mode.getText() == "Mode Developer") {
//            JOptionPane.showMessageDialog(null, "Change to Mode Developer!");
//        } else {
//            JOptionPane.showMessageDialog(null, "Success created!");
//        }

//Read Archive
//getNetworkPool().getQueryer().setOp("R");
//        getNetworkPool().getQueryer().setFields(getNetworkPool().getStorageDB().getFieldsArchive());
//        getNetworkPool().getQueryer().setTable("archive");
//
//        getNetworkPool().getQueryer().Query();
//
//        archController.setOp(getNetworkPool().getQueryer().getOp());
//        archController.setQuery(getNetworkPool().getQueryer().getQuery());
//        archController.logOpQuery();
//        archController.logConnManConnStm();
//        
//        archController.setNetworkPool(getNetworkPool());
//        try {
//            archController.setStm(getNetworkPool().getConnMan().logOn().createStatement());
//        } catch(Exception e) {}
//        getNetworkPool().getConnMan().logOff();
//        loadData(archController.pluralList(), getNetworkPool().getQueryer().getFields());

//Update Archive
//getNetworkPool().getQueryer().setOp("U");
//        getNetworkPool().getQueryer().setFields(getNetworkPool().getStorageDB().getFieldsArchive());
//        getNetworkPool().getQueryer().setTable("archive");
//
//        if (txt_field.getText() == "") {
//            JOptionPane.showMessageDialog(null, "Empty field!");
//        }
//        if (txt_value.getText() == "") {
//            JOptionPane.showMessageDialog(null, "Empty value!");
//        }
//        getNetworkPool().getQueryer().setField(txt_field.getText());
//        getNetworkPool().getQueryer().setValue(txt_value.getText());
//
//        if (txt_values.getText().split("\\s+").length < getNetworkPool().getQueryer().getFields().length) {
//            JOptionPane.showMessageDialog(null, "Not enough!");
//        }
//        if (btn_mode.getText() == "Mode Developer") {
//            getNetworkPool().getQueryer().setValues(values.split("\\s+"));
//        } else {
//            getNetworkPool().getQueryer().setValues(txt_values.getText().split("\\s+"));
//        }
//        getNetworkPool().getQueryer().Query();
//        txtarea_query.setText(getNetworkPool().getQueryer().getQuery());
//        archController.setOp(getNetworkPool().getQueryer().getOp());
//        archController.setQuery(getNetworkPool().getQueryer().getQuery());
//        archController.logOpQuery();
//        archController.logConnManConnStm();
//        
//        archController.setNetworkPool(getNetworkPool());
//        try {
//            archController.setStm(getNetworkPool().getConnMan().logOn().createStatement());
//            archController.Update();
//        } catch(Exception e) {}
//        getNetworkPool().getConnMan().logOff();
//        if (btn_mode.getText() == "Mode Developer") {
//            JOptionPane.showMessageDialog(null, "Change to Mode Developer!");
//        }
//        JOptionPane.showMessageDialog(null, "Success updated!");

//Delete Archive
//getNetworkPool().getQueryer().setOp("D");
//        getNetworkPool().getQueryer().setFields(getNetworkPool().getStorageDB().getFieldsArchive());
//        getNetworkPool().getQueryer().setTable("archive");
//        if (txt_field.getText() == "") {
//            JOptionPane.showMessageDialog(null, "Empty field!");
//        }
//        if (txt_value.getText() == "") {
//            JOptionPane.showMessageDialog(null, "Empty value!");
//        }
//        getNetworkPool().getQueryer().setField(txt_field.getText());
//        getNetworkPool().getQueryer().setValue(txt_value.getText());
//        getNetworkPool().getQueryer().Query();
//        txtarea_query.setText(getNetworkPool().getQueryer().getQuery());
//
//        archController.setOp(getNetworkPool().getQueryer().getOp());
//        archController.setQuery(getNetworkPool().getQueryer().getQuery());
//        archController.logOpQuery();
//        archController.logConnManConnStm();
//        
//        archController.setNetworkPool(getNetworkPool());
//        try {
//            archController.setStm(getNetworkPool().getConnMan().logOn().createStatement());
//            archController.Delete();
//        } catch(Exception e) {}
//        getNetworkPool().getConnMan().logOff();
//        JOptionPane.showMessageDialog(null, "Success deleted!");

/**
 *
 * @author Fajar-PC
 */
public class AdminIndex extends javax.swing.JFrame {

    /**
     * Creates new form AdminIndex
     */
    protected NetworkPool np = new NetworkPool();
    private Colorful c = new Colorful();
    private ProfileController profController = new ProfileController();
    private AuthController authController = new AuthController();
    private QueryController querController = new QueryController();
    private ArchiveController archController = new ArchiveController();
    private DocumentController docmController = new DocumentController();
    private ArticleController artiController = new ArticleController();
    private MiddlewareAuth mwAuth = new MiddlewareAuth();
    private AdminIndexHelper aIH = new AdminIndexHelper();
//    private CacheUpdateProfile cUH = new CacheUpdateProfile();
    
    public AdminIndex() {
        initComponents();
        SPA();
        try {
            getNetworkPool().getConnMan().logOn().setAutoCommit(true);
        } catch (Exception e) {}
        getNetworkPool().getConnMan().logOff();
    }
    
    public void loadData(Object[][] objs, String[] fields) {
        tbl_databases.setModel(new javax.swing.table.DefaultTableModel(
            objs,
            fields
        ));
    }
    
    public void setMiddlewareAuth(MiddlewareAuth val) { this.mwAuth = val; }
    public MiddlewareAuth getMiddlewareAuth() { return this.mwAuth; }
    
    public void logMiddlewareAuth() {
        JOptionPane.showMessageDialog(null, "Auth-Key: "+getMiddlewareAuth().getAuthKey()+"Username: "+getMiddlewareAuth().getUsername()+"Password: "+getMiddlewareAuth().getPassword());
    }
    
    public void setNetworkPool(NetworkPool val) { this.np = val; }
    public NetworkPool getNetworkPool() { return this.np; }

    public void CreateToProfileController() {
        profController.CreateProfile(getNetworkPool(), txt_values.getText(), aIH.getValuesCombined(), btn_mode.getText());
    }
    public void CreateToAuthController() {
        authController.CreateAuth(getNetworkPool(), txt_values.getText(), aIH.getValuesCombined(), btn_mode.getText());
    }
    public void CreateToQueryController() {
        querController.CreateQuery(getNetworkPool(), txt_values.getText(), aIH.getValuesCombined(), btn_mode.getText());
    }
    public void CreateToArchiveController() {
        archController.CreateArchive(getNetworkPool(), txt_values.getText(), aIH.getValuesCombined(), btn_mode.getText());
    }
    public void CreateToDocumentController() {
        docmController.CreateDocument(getNetworkPool(), txt_values.getText(), aIH.getValuesCombined(), btn_mode.getText());
    }
    public void CreateToArticleController() {
        artiController.CreateArticle(getNetworkPool(), txt_values.getText(), aIH.getValuesCombined(), btn_mode.getText());
    }
    
    public void DeleteToProfileController() {
        profController.DeleteProfile(getNetworkPool(), txt_field.getText(), txt_value.getText());
    }
    public void DeleteToAuthController() {
        authController.DeleteAuth(getNetworkPool(), txt_field.getText(), txt_value.getText());
    }
    public void DeleteToQueryController() {
        querController.DeleteQuery(getNetworkPool(), txt_field.getText(), txt_value.getText());
    }
    public void DeleteToArchiveController() {
        archController.DeleteArchive(getNetworkPool(), txt_field.getText(), txt_value.getText());
    }
    public void DeleteToDocumentController() {
        docmController.DeleteDocument(getNetworkPool(), txt_field.getText(), txt_value.getText());
    }
    public void DeleteToArticleController() {
        artiController.DeleteArticle(getNetworkPool(), txt_field.getText(), txt_value.getText());
    }
    
    public void UpdateToProfileController() {
        profController.UpdateProfile(getNetworkPool(), txt_values.getText(), aIH.getValuesCombined(), btn_mode.getText(), txt_field.getText(), txt_value.getText());
    }
    public void UpdateToAuthController() {
        authController.UpdateAuth(getNetworkPool(), txt_values.getText(), aIH.getValuesCombined(), btn_mode.getText(), txt_field.getText(), txt_value.getText());
    }
    public void UpdateToQueryController() {
        querController.UpdateQuery(getNetworkPool(), txt_values.getText(), aIH.getValuesCombined(), btn_mode.getText(), txt_field.getText(), txt_value.getText());
    }
    public void UpdateToArchiveController() {
        archController.UpdateArchive(getNetworkPool(), txt_values.getText(), aIH.getValuesCombined(), btn_mode.getText(), txt_field.getText(), txt_value.getText());
    }
    public void UpdateToDocumentController() {
        docmController.UpdateDocument(getNetworkPool(), txt_values.getText(), aIH.getValuesCombined(), btn_mode.getText(), txt_field.getText(), txt_value.getText());
    }
    public void UpdateToArticleController() {
        artiController.UpdateArticle(getNetworkPool(), txt_values.getText(), aIH.getValuesCombined(), btn_mode.getText(), txt_field.getText(), txt_value.getText());
    }
    
    // Profile
    public void ReadToProfileController() {
        profController.ReadProfile(getNetworkPool());
        loadData(profController.pluralList(), getNetworkPool().getQueryer().getFields());
    }
    // Auth
    public void ReadToAuthController() {
        authController.ReadAuth(getNetworkPool());
        loadData(authController.pluralList(), getNetworkPool().getQueryer().getFields());
    }
    // Query
    public void ReadToQueryController() {
        querController.ReadQuery(getNetworkPool());
        loadData(querController.pluralList(), getNetworkPool().getQueryer().getFields());
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
    
    public void NoteToNotifier(String val) {
        lbl_notifier.setText(val);
    }
    
    public void setNotifierHtml(String val) {
        NoteToNotifier(val);
    }
    
    public void SPA() {
        panel_additional.setVisible(false);
        fieldValueMode(false, false, false, false, false, false);
        setNotifierHtml("<html><h1>Welcome, admin!</h1></html>");
        HidePanelTodo();
        ReadToProfileController();
        lbl_notifier.setText(lbl_notifier.getText()+", "+getMiddlewareAuth().getUsername());
    }
    
    public void HidePanelTodo() {
        panel_todo.setVisible(false);
    }
    
    public void ShowPanelTodoCreate() {
        fieldValueMode(false, false, false, false, false, false);
        fieldValueModeAllSet("", "", "", "", "", "");
        btn_mode.setText("Mode User");
        btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
        lbl_todo.setText("Todo Feature Create");
        lbl_fields.setVisible(true);
        lbl_values.setVisible(true);
        txt_fields.setVisible(true);
        txt_fields.setText("Fields automatically added in background!");
        lbl_which_field.setVisible(false);
        lbl_which_value.setVisible(false);
        txt_field.setVisible(false);
        txt_value.setVisible(false);
        txt_values.setVisible(true);
        panel_todo.setVisible(true);
    }
    
    public void ShowPanelTodoRead() {
//        JOptionPane.showMessageDialog(null, "Already read the table... (Internal Unimplemented)");
//        JOptionPane.showMessageDialog(null, "Read table (refresh table)");
        fieldValueMode(false, false, false, false, false, false);
        fieldValueModeAllSet("", "", "", "", "", "");
        btn_mode.setText("Mode User");
        btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
        lbl_todo.setText("Todo Feature Read");
        lbl_fields.setVisible(false);
        lbl_values.setVisible(false);
        txt_fields.setVisible(false);
        txt_fields.setText("Fields automatically added in background!");
        txt_values.setVisible(false);
        lbl_which_field.setVisible(true);
        txt_field.setVisible(true);
        lbl_which_value.setVisible(true);
        txt_value.setVisible(true);
        panel_todo.setVisible(true);
//        if (lbl_name.getText() == "Profile") {
//            ReadToProfileController();
//        }
//        if (lbl_name.getText() == "Auth") {
//            ReadToAuthController();
//        }
//        if (lbl_name.getText() == "Query") {
//            ReadToQueryController();
//        }
//        if (lbl_name.getText() == "Archive") {
//            ReadToArchiveController();
//        }
//        if (lbl_name.getText() == "Document") {
//            ReadToDocumentController();
//        }
//        if (lbl_name.getText() == "Article") {
//            ReadToArticleController();
//        }
    }
    
    public void ShowPanelTodoUpdate() {
        fieldValueMode(false, false, false, false, false, false);
        fieldValueModeAllSet("", "", "", "", "", "");
        btn_mode.setText("Mode User");
        btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
        lbl_todo.setText("Todo Feature Update");
        lbl_fields.setVisible(true);
        lbl_values.setVisible(true);
        txt_fields.setVisible(true);
        txt_fields.setText("Fields automatically added in background!");
        txt_values.setVisible(true);
        lbl_which_field.setVisible(true);
        lbl_which_value.setVisible(true);
        txt_field.setVisible(true);
        txt_value.setVisible(true);
        panel_todo.setVisible(true);
    }
    
    public void ShowPanelTodoDelete() {
        fieldValueMode(false, false, false, false, false, false);
        lbl_todo.setText("Todo Feature Delete");
        lbl_fields.setVisible(false);
        lbl_values.setVisible(false);
        txt_fields.setVisible(false);
        txt_values.setVisible(false);
        lbl_which_field.setVisible(true);
        lbl_which_value.setVisible(true);
        txt_field.setVisible(true);
        txt_value.setVisible(true);
        panel_todo.setVisible(true);
    }
    
    public void setLabelName(String val) {
        lbl_name.setText(val);
    }
    
    public void activeInactiveNav(Color prof, Color auth, Color query, Color archive, Color doc, Color article, Color settings, Color dashboard) {
        nav_profile.setForeground(prof); 
        nav_auth.setForeground(auth);
        nav_query.setForeground(query);
        nav_archive.setForeground(archive);
        nav_document.setForeground(doc);
        nav_article.setForeground(article);
        nav_settings.setForeground(settings);
        nav_dashboard.setForeground(dashboard);
    }
    
    public void activeInactiveNavBackground(Color prof, Color auth, Color query, Color archive, Color doc, Color article, Color settings, Color dashboard) {
        nav_profile.setBackground(prof); 
        nav_auth.setBackground(auth);
        nav_query.setBackground(query);
        nav_archive.setBackground(archive);
        nav_document.setBackground(doc);
        nav_article.setBackground(article);
        nav_settings.setBackground(settings);
        nav_dashboard.setBackground(dashboard);
    }
    
    public void fieldValueMode(boolean fval1, boolean fval2, boolean fval3, boolean fval4, boolean fval5, boolean fval6) {
        lbl_field_1.setVisible(fval1);
        txt_field_1.setVisible(fval1);
        
        lbl_field_2.setVisible(fval2);
        txt_field_2.setVisible(fval2);
        
        lbl_field_3.setVisible(fval3);
        txt_field_3.setVisible(fval3);
        
        lbl_field_4.setVisible(fval4);
        txt_field_4.setVisible(fval4);
        
        lbl_field_5.setVisible(fval5);
        txt_field_5.setVisible(fval5);
        
        lbl_field_6.setVisible(fval6);
        txt_field_6.setVisible(fval6);
    }
    
    public void fieldValueModeAllSet(String fval1, String fval2, String fval3, String fval4, String fval5, String fval6) {
        lbl_field_1.setText(fval1);
        lbl_field_2.setText(fval2);
        lbl_field_3.setText(fval3);
        lbl_field_4.setText(fval4);
        lbl_field_5.setText(fval5);
        lbl_field_6.setText(fval6);
    }
    
    public void fieldValueModeAllSetValue(String fval1, String fval2, String fval3, String fval4, String fval5, String fval6) {
        txt_field_1.setText(fval1);
        txt_field_2.setText(fval2);
        txt_field_3.setText(fval3);
        txt_field_4.setText(fval4);
        txt_field_5.setText(fval5);
        txt_field_6.setText(fval6);
    }
    
    public void NavSettings(java.awt.event.MouseEvent evt) {
//        JOptionPane.showMessageDialog(null, "Not implemented.");
        activeInactiveNavBackground(c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getActiveBackgroundColor(), c.getBlueCommon());
        nav_settings.setBackground(c.getActiveBackgroundColor());
        activeInactiveNav(c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getActiveColor(), c.getInactiveColor());
        panel_main.setVisible(false);
        panel_additional.setVisible(true);
        lbl_additional.setText("<html><h2>Settings</h3></html>");
        lbl_header.setText("<html><h3>Configure with your mind...</h3></html>");
        lbl_section_one.setText("<html><p>ID-Auth :</p></html>");
        lbl_section_two.setText("<html><p>Username :</p></html>");
        lbl_section_three.setText("<html><p>Password :</p></html>");
        lbl_separator_one.setVisible(false);
        lbl_separator_two.setVisible(false);
        lbl_separator_three.setVisible(false);
        txt_section_one.setText(mwAuth.getAuthKey());
        txt_section_two.setText(mwAuth.getUsername());
        txt_section_three.setText(mwAuth.getPassword());
//        panel_additional.setVisible(true);
    }
    
    public void NavDashboard(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Not implemented.");
        activeInactiveNavBackground(c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getActiveBackgroundColor());
        activeInactiveNav(c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getActiveColor());
        panel_main.setVisible(false);
        panel_additional.setVisible(false);
//        panel_additional.setVisible(true);
    }
    
    public void NavProfile(java.awt.event.MouseEvent evt) {
        activeInactiveNavBackground(c.getActiveBackgroundColor(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        nav_profile.setBackground(c.getActiveBackgroundColor());
        panel_main.setVisible(true);
        panel_additional.setVisible(false);
        fieldValueModeAllSet("", "", "", "", "", "");
        fieldValueMode(false, false, false, false, false, false);
        btn_mode.setText("Mode User");
        txt_values.setText("");
        btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
        panel_todo.setVisible(false);
        ReadToProfileController();
        activeInactiveNav(c.getActiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor());
        setLabelName("Profile");
    }
    
    public void NavAuth(java.awt.event.MouseEvent evt) {
        activeInactiveNavBackground(c.getBlueCommon(), c.getActiveBackgroundColor(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        panel_main.setVisible(true);
        panel_additional.setVisible(false);
        fieldValueModeAllSet("", "", "", "", "", "");
        fieldValueMode(false, false, false, false, false, false);
        btn_mode.setText("Mode User");
        txt_values.setText("");
        btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
        panel_todo.setVisible(false);
        ReadToAuthController();
        activeInactiveNav(c.getInactiveColor(), c.getActiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor());
        setLabelName("Auth");
    }
    
    public void NavQuery(java.awt.event.MouseEvent evt) {
        activeInactiveNavBackground(c.getBlueCommon(), c.getBlueCommon(), c.getActiveBackgroundColor(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        nav_query.setBackground(c.getActiveBackgroundColor());
        panel_main.setVisible(true);
        panel_additional.setVisible(false);
        fieldValueModeAllSet("", "", "", "", "", "");
        fieldValueMode(false, false, false, false, false, false);
        btn_mode.setText("Mode User");
        txt_values.setText("");
        btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
        panel_todo.setVisible(false);
        ReadToQueryController();
        activeInactiveNav(c.getInactiveColor(), c.getInactiveColor(), c.getActiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor());
        setLabelName("Query");
    }
    
    public void NavArchive(java.awt.event.MouseEvent evt) {
        activeInactiveNavBackground(c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getActiveBackgroundColor(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        nav_archive.setBackground(c.getActiveBackgroundColor());
        panel_main.setVisible(true);
        panel_additional.setVisible(false);
        fieldValueModeAllSet("", "", "", "", "", "");
        fieldValueMode(false, false, false, false, false, false);
        btn_mode.setText("Mode User");
        txt_values.setText("");
        btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
        panel_todo.setVisible(false);
        ReadToArchiveController();
        activeInactiveNav(c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getActiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor());
        setLabelName("Archive");
    }
    
    public void NavDocument(java.awt.event.MouseEvent evt) {
        activeInactiveNavBackground(c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getActiveBackgroundColor(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon());
        nav_document.setBackground(c.getActiveBackgroundColor());
        panel_main.setVisible(true);
        panel_additional.setVisible(false);
        fieldValueModeAllSet("", "", "", "", "", "");
        fieldValueMode(false, false, false, false, false, false);
        btn_mode.setText("Mode User");
        txt_values.setText("");
        btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
        panel_todo.setVisible(false);
        ReadToDocumentController();
        activeInactiveNav(c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getActiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor());
        setLabelName("Document");
    }
    
    public void NavArticle(java.awt.event.MouseEvent evt) {
        activeInactiveNavBackground(c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getBlueCommon(), c.getActiveBackgroundColor(), c.getBlueCommon(), c.getBlueCommon());
        nav_article.setBackground(c.getActiveBackgroundColor());
        panel_main.setVisible(true);
        panel_additional.setVisible(false);
        fieldValueModeAllSet("", "", "", "", "", "");
        fieldValueMode(false, false, false, false, false, false);
        btn_mode.setText("Mode User");
        txt_values.setText("");
        btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
        panel_todo.setVisible(false);
        ReadToArticleController();
        activeInactiveNav(c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getInactiveColor(), c.getActiveColor(), c.getInactiveColor(), c.getInactiveColor());
        setLabelName("Article");
    }
    
    public void FilterToProfileController() {
        String query = "select * from profile"+" where "+txt_field.getText()+"='"+txt_value.getText()+"';";

        profController.setOp("R");
        profController.setNetworkPool(getNetworkPool());
        profController.setQuery(query);
//        docmController.Read();
//        JOptionPane.showMessageDialog(null, "Query "+query);
//        JOptionPane.showMessageDialog(null, "Searching!");
        loadData(profController.pluralListFilter(), getNetworkPool().getQueryer().getFields());
    }
    
    public void FilterToAuthController() {
        String query = "select * from auth"+" where "+txt_field.getText()+"='"+txt_value.getText()+"';";
        authController.setOp("R");
        authController.setNetworkPool(getNetworkPool());
        authController.setQuery(query);
//        artiController.Read();
//        JOptionPane.showMessageDialog(null, "Query "+query);
//        JOptionPane.showMessageDialog(null, "Searching!");
        loadData(authController.pluralListFilter(), getNetworkPool().getQueryer().getFields());
    }
    
    public void FilterToQueryController() {
        String query = "select * from query"+" where "+txt_field.getText()+"='"+txt_value.getText()+"';";
        
        querController.setOp("R");
        querController.setNetworkPool(getNetworkPool());
        querController.setQuery(query);
//        JOptionPane.showMessageDialog(null, "Query "+query);
//        JOptionPane.showMessageDialog(null, "Searching!");
        loadData(querController.pluralListFilter(), getNetworkPool().getQueryer().getFields());
    }
    
    public void FilterToArchiveController() {
        String query = "select * from archive"+" where "+txt_field.getText()+"='"+txt_value.getText()+"';";
        
        archController.setOp("R");
        archController.setNetworkPool(getNetworkPool());
        archController.setQuery(query);
//        JOptionPane.showMessageDialog(null, "Query "+query);
//        JOptionPane.showMessageDialog(null, "Searching!");
        loadData(archController.pluralListFilter(), getNetworkPool().getQueryer().getFields());
    }
    
    public void FilterToDocumentController() {
        String query = "select * from document"+" where "+txt_field.getText()+"='"+txt_value.getText()+"';";

        docmController.setOp("R");
        docmController.setNetworkPool(getNetworkPool());
        docmController.setQuery(query);
//        docmController.Read();
//        JOptionPane.showMessageDialog(null, "Query "+query);
//        JOptionPane.showMessageDialog(null, "Searching!");
        loadData(docmController.pluralListFilter(), getNetworkPool().getQueryer().getFields());
    }
    
    public void FilterToArticleController() {
        String query = "select * from article"+" where "+txt_field.getText()+"='"+txt_value.getText()+"';";
        artiController.setOp("R");
        artiController.setNetworkPool(getNetworkPool());
        artiController.setQuery(query);
//        artiController.Read();
//        JOptionPane.showMessageDialog(null, "Query "+query);
//        JOptionPane.showMessageDialog(null, "Searching!");
        loadData(artiController.pluralListFilter(), getNetworkPool().getQueryer().getFields());
    }
    
    public void ExecuteTouched(java.awt.event.MouseEvent evt) {
        if (lbl_todo.getText() == "Todo Feature Create") {
                if (lbl_name.getText() == "Profile") {
                    CreateToProfileController();
                }
                if (lbl_name.getText() == "Auth") {
                    CreateToAuthController();
                }
                if (lbl_name.getText() == "Query") {
                    CreateToQueryController();
                }
                if (lbl_name.getText() == "Archive") {
                    CreateToArchiveController();
                }
                if (lbl_name.getText() == "Document") {
                    CreateToDocumentController();
                }
                if (lbl_name.getText() == "Article") {
                    CreateToArticleController();
                }
        } else if (lbl_todo.getText() == "Todo Feature Update") {
                if (lbl_name.getText() == "Profile") {
                    UpdateToProfileController();
                }
                if (lbl_name.getText() == "Auth") {
                    UpdateToAuthController();
                }
                if (lbl_name.getText() == "Query") {
                    UpdateToQueryController();
                }
                if (lbl_name.getText() == "Archive") {
                    UpdateToArchiveController();
                }
                if (lbl_name.getText() == "Document") {
                    UpdateToDocumentController();
                }
                if (lbl_name.getText() == "Article") {
                    UpdateToArticleController();
                }
        } else if (lbl_todo.getText() == "Todo Feature Delete") {
                if (lbl_name.getText() == "Profile") {
                    DeleteToProfileController();
                }
                if (lbl_name.getText() == "Auth") {
                    DeleteToAuthController();
                }
                if (lbl_name.getText() == "Query") {
                    DeleteToQueryController();
                }
                if (lbl_name.getText() == "Archive") {
                    DeleteToArchiveController();
                }
                if (lbl_name.getText() == "Document") {
                    DeleteToDocumentController();
                }
                if (lbl_name.getText() == "Article") {
                    DeleteToArticleController();
                }
        } else if (lbl_todo.getText() == "Todo Feature Read") {
                boolean fieldValNotNil = ((txt_field.getText().length() > 0) && (txt_value.getText().length() > 0));
                if (lbl_name.getText() == "Profile") {
                    if (fieldValNotNil) {
                        JOptionPane.showMessageDialog(null, "Success read with filter!");
                        FilterToProfileController();
                    } 
                    if (!fieldValNotNil) {
                        JOptionPane.showMessageDialog(null, "Success read!");
                        ReadToProfileController();
                    }
                }
                if (lbl_name.getText() == "Auth") {
                    if (fieldValNotNil) {
                        JOptionPane.showMessageDialog(null, "Success read with filter!");
                        FilterToAuthController();
                    } 
                    if (!fieldValNotNil) {
                        JOptionPane.showMessageDialog(null, "Success read!");
                        ReadToAuthController();
                    }
                }
                if (lbl_name.getText() == "Query") {
                    if (fieldValNotNil) {
                        JOptionPane.showMessageDialog(null, "Success read with filter!");
                        FilterToQueryController();
                    }
                    if (!fieldValNotNil) {
                        JOptionPane.showMessageDialog(null, "Success read!");
                        ReadToQueryController();
                    }
                }
                if (lbl_name.getText() == "Archive") {
                    if (fieldValNotNil) {
                        JOptionPane.showMessageDialog(null, "Success read with filter!");
                        FilterToArchiveController();
                    } 
                    if (!fieldValNotNil) {
                        JOptionPane.showMessageDialog(null, "Success read!");
                        ReadToArchiveController();
                    }
                }
                if (lbl_name.getText() == "Document") {
                    if (fieldValNotNil) {
                        JOptionPane.showMessageDialog(null, "Success read with filter!");
                        FilterToDocumentController();
                    } 
                    if (!fieldValNotNil) {
                        JOptionPane.showMessageDialog(null, "Success read!");
                        ReadToDocumentController();
                    }
                }
                if (lbl_name.getText() == "Article") {
                    if (fieldValNotNil) {
                        JOptionPane.showMessageDialog(null, "Success read with filter!");
                        FilterToArticleController();
                    } 
                    if (!fieldValNotNil) {
                        JOptionPane.showMessageDialog(null, "Success read!");
                        ReadToArticleController();
                    }
                }
        }
    }
    
    public void TableTouched(java.awt.event.MouseEvent evt) {
        System.out.println(lbl_name.getText());
        try {
        if (evt.getButton() == 1) {
            System.out.println("Clicked!");
            System.out.println(tbl_databases.getColumnCount());
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
            if (false) {
                JOptionPane.showMessageDialog(null, "Null!");
            } else {
//                txt_id.setText(val);
                if (nav_archive.getText().equals(lbl_name.getText())) {
                    String col1 = tbl_databases.getColumnName(0);
                    
                    String val1 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 0).toString();
                    String val2 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 1).toString();
                    String val3 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 2).toString();
                    String val4 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 3).toString();
                    String val5 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 4).toString();
                    txt_field.setText(col1);
                    txt_value.setText(val1);
                    txt_field_1.setText(val1);
                    txt_field_2.setText(val2);
                    txt_field_3.setText(val3);
                    txt_field_4.setText(val4);
                    txt_field_5.setText(val5);
//                    txt_field_6.setText(val6);
                    aIH.setValuesCombined(val1+" "+val2+" "+val3+" "+val4+" "+val5);
//                    valuesCombined = val1+" "+val2+" "+val3+" "+val4+" "+val5;
                    txt_values.setText(aIH.getValuesCombined());
                }
                if (nav_document.getText().equals(lbl_name.getText())) {
                    String col1 = tbl_databases.getColumnName(0);

                    String val1 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 0).toString();
                    String val2 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 1).toString();
                    String val3 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 2).toString();
                    String val4 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 3).toString();
                    String val5 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 4).toString();
                    txt_field.setText(col1);
                    txt_value.setText(val1);
                    txt_field_1.setText(val1);
                    txt_field_2.setText(val2);
                    txt_field_3.setText(val3);
                    txt_field_4.setText(val4);
                    txt_field_5.setText(val5);
//                    txt_field_6.setText(val6);
                    aIH.setValuesCombined(val1+" "+val2+" "+val3+" "+val4+" "+val5);
//                    valuesCombined = val1+" "+val2+" "+val3+" "+val4+" "+val5;
                    txt_values.setText(aIH.getValuesCombined());
                }
                if (nav_article.getText().equals(lbl_name.getText())) {
                    String col1 = tbl_databases.getColumnName(0);

                    String val1 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 0).toString();
                    String val2 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 1).toString();
                    String val3 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 2).toString();
                    String val4 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 3).toString();
                    txt_field.setText(col1);
                    txt_value.setText(val1);
                    txt_field_1.setText(val1);
                    txt_field_2.setText(val2);
                    txt_field_3.setText(val3);
                    txt_field_4.setText(val4);
//                    txt_field_5.setText(val5);
//                    txt_field_6.setText(val6);
//                    valuesCombined = val1+" "+val2+" "+val3+" "+val4;
                    aIH.setValuesCombined(val1+" "+val2+" "+val3+" "+val4);
                    txt_values.setText(aIH.getValuesCombined());
                }
                if (nav_profile.getText().equals(lbl_name.getText())) {
                    String col1 = tbl_databases.getColumnName(0);

                    String val1 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 0).toString();
                    String val2 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 1).toString();
                    String val3 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 2).toString();
                    String val4 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 3).toString();
                    String val5 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 4).toString();
                    String val6 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 5).toString();
                    txt_field.setText(col1);
                    txt_value.setText(val1);
                    txt_field_1.setText(val1);
                    txt_field_2.setText(val2);
                    txt_field_3.setText(val3);
                    txt_field_4.setText(val4);
                    txt_field_5.setText(val5);
                    txt_field_6.setText(val6);
//                    valuesCombined = val1+" "+val2+" "+val3+" "+val4+" "+val5+" "+val6;
                    aIH.setValuesCombined(val1+" "+val2+" "+val3+" "+val4+" "+val5+" "+val6);
                    
                    txt_values.setText(aIH.getValuesCombined());
                }
                if (nav_auth.getText().equals(lbl_name.getText())) {
                    String col1 = tbl_databases.getColumnName(0);
                    
                    String val1 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 0).toString();
                    String val2 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 1).toString();
                    String val3 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 2).toString();
                    txt_field.setText(col1);
                    txt_value.setText(val1);
                    txt_field_1.setText(val1);
                    txt_field_2.setText(val2);
                    txt_field_3.setText(val3);
//                    txt_field_4.setText(val4);
//                    txt_field_5.setText(val5);
//                    txt_field_6.setText(val6);
//                    valuesCombined = val1+" "+val2+" "+val3;
                    aIH.setValuesCombined(val1+" "+val2+" "+val3);
                    txt_values.setText(aIH.getValuesCombined());
                }
                if (nav_query.getText().equals(lbl_name.getText())) {
                    String col1 = tbl_databases.getColumnName(0);
                    
                    String val1 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 0).toString();
                    String val2 = tbl_databases.getValueAt(tbl_databases.getSelectedRow(), 1).toString();
                    txt_field.setText(col1);
                    txt_value.setText(val1);
                    txt_field_1.setText(val1);
                    txt_field_2.setText(val2);
//                    txt_field_3.setText(val3);
//                    txt_field_4.setText(val4);
//                    txt_field_5.setText(val5);
//                    txt_field_6.setText(val6);
//                    valuesCombined = val1+" "+val2;
                    aIH.setValuesCombined(val1+" "+val2);
                    txt_values.setText(aIH.getValuesCombined());
                }
            }
        }
        } catch (Exception e) { try {
            throw new ExceptionActivity("Selected no value! ("+e.getMessage()+")");
            } catch (ExceptionActivity ex) {
                Logger.getLogger(AdminIndex.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void HintTouched(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "field1, field2, field3, field4, field5, fieldN", "Rules of Field(s)", 1);
        JOptionPane.showMessageDialog(null, "value1, value2, value3, value4, value5, value6", "Rules of Value(s)", 1);
        JOptionPane.showMessageDialog(null, "field1", "Rules of Field", 1);
        JOptionPane.showMessageDialog(null, "value1", "Rules of Value", 1);
    }
    
    public void ModeTouched(java.awt.event.MouseEvent evt) {
        if ((lbl_todo.getText() == "Todo Feature Delete") || (lbl_todo.getText() == "Todo Feature Read")) {
            JOptionPane.showMessageDialog(null, "Not implemented!");
        } else {
        if (lbl_name.getText() == "Profile") {
            if (btn_mode.getText() == "Mode User") {
                String[] fieldsProfile = getNetworkPool().getStorageDB().getFieldsProfile();
                lbl_values.setVisible(false);
                txt_values.setVisible(false);
                fieldValueMode(true, true, true, true, true, true);
                fieldValueModeAllSet(fieldsProfile[0], fieldsProfile[1], fieldsProfile[2], fieldsProfile[3], fieldsProfile[4], fieldsProfile[5]);
                btn_mode.setText("Mode Developer");
                btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_developer_32px.png")));
            } else if (btn_mode.getText() == "Mode Developer") {
                lbl_values.setVisible(true);
                txt_values.setVisible(true);
                fieldValueMode(!true, !true, !true, !true, !true, !true);
                btn_mode.setText("Mode User");
                btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
            }
        }
        if (lbl_name.getText() == "Auth") {
            if (btn_mode.getText() == "Mode User") {
                String[] fieldsAuth = getNetworkPool().getStorageDB().getFieldsAuth();
                lbl_values.setVisible(false);
                txt_values.setVisible(false);
                fieldValueMode(true, true, true, false, false, false);
                fieldValueModeAllSet(fieldsAuth[0], fieldsAuth[1], fieldsAuth[2], "", "", "");
                btn_mode.setText("Mode Developer");
                btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_developer_32px.png")));
            } else if (btn_mode.getText() == "Mode Developer") {
                lbl_values.setVisible(true);
                txt_values.setVisible(true);
                fieldValueMode(!true, !true, !true, !true, !true, !true);
                btn_mode.setText("Mode User");
                btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
            }
        }
        if (lbl_name.getText() == "Query") {
            if (btn_mode.getText() == "Mode User") {
                String[] fieldsQuery = getNetworkPool().getStorageDB().getFieldsQuery();
                lbl_values.setVisible(false);
                txt_values.setVisible(false);
                fieldValueMode(true, true, false, false, false, false);
                fieldValueModeAllSet(fieldsQuery[0], fieldsQuery[1], "", "", "", "");
                btn_mode.setText("Mode Developer");
                btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_developer_32px.png")));
            } else if (btn_mode.getText() == "Mode Developer") {
                lbl_values.setVisible(true);
                txt_values.setVisible(true);
                fieldValueMode(!true, !true, !true, !true, !true, !true);
                btn_mode.setText("Mode User");
                btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
            }
        }
        if (lbl_name.getText() == "Archive") {
            if (btn_mode.getText() == "Mode User") {
                String[] fieldsArchive = getNetworkPool().getStorageDB().getFieldsArchive();
                lbl_values.setVisible(false);
                txt_values.setVisible(false);
                fieldValueMode(true, true, true, true, true, false);
                fieldValueModeAllSet(fieldsArchive[0], fieldsArchive[1], fieldsArchive[2], fieldsArchive[3], fieldsArchive[4], "");
                btn_mode.setText("Mode Developer");
                btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_developer_32px.png")));
            } else if (btn_mode.getText() == "Mode Developer") {
                lbl_values.setVisible(true);
                txt_values.setVisible(true);
                fieldValueMode(!true, !true, !true, !true, !true, !true);
                btn_mode.setText("Mode User");
                btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
            }
        }
        if (lbl_name.getText() == "Document") {
            if (btn_mode.getText() == "Mode User") {
                String[] fieldsDocument = getNetworkPool().getStorageDB().getFieldsDocument();
                lbl_values.setVisible(false);
                txt_values.setVisible(false);
                fieldValueMode(true, true, true, true, true, false);
                fieldValueModeAllSet(fieldsDocument[0], fieldsDocument[1], fieldsDocument[2], fieldsDocument[3], fieldsDocument[4], "");
                btn_mode.setText("Mode Developer");
                btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_developer_32px.png")));
            } else if (btn_mode.getText() == "Mode Developer") {
                lbl_values.setVisible(true);
                txt_values.setVisible(true);
                fieldValueMode(!true, !true, !true, !true, !true, !true);
                btn_mode.setText("Mode User");
                btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
            }
        }
        if (lbl_name.getText() == "Article") {
            if (btn_mode.getText() == "Mode User") {
                String[] fieldsArticle = getNetworkPool().getStorageDB().getFieldsArticle();
                lbl_values.setVisible(false);
                txt_values.setVisible(false);
                fieldValueMode(true, true, true, true, false, false);
                fieldValueModeAllSet(fieldsArticle[0], fieldsArticle[1], fieldsArticle[2], fieldsArticle[3], "", "");
                btn_mode.setText("Mode Developer");
                btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_developer_32px.png")));
            } else if (btn_mode.getText() == "Mode Developer") {
                lbl_values.setVisible(true);
                txt_values.setVisible(true);
                fieldValueMode(!true, !true, !true, !true, !true, !true);
                btn_mode.setText("Mode User");
                btn_mode.setIcon(new ImageIcon(this.getClass().getResource("/Storage/icon/icons8_user_32px.png")));
            }
        }
        }
    }
    
    public void ExportTouched(java.awt.event.MouseEvent evt) {
        DefaultTableModel model = (DefaultTableModel)tbl_databases.getModel();
 
        JFileChooser chooser = new JFileChooser();
        int state = chooser.showSaveDialog(null);
        File file = chooser.getSelectedFile();
        if (file != null && state == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                PrintWriter fileWriter = new PrintWriter(bufferedWriter);
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        Object o = model.getValueAt(i, j);
                        String s = (o == null ? "" : String.format("\"%s\"", o.toString()));
                        System.out.print(s);
                        bufferedWriter.write(s);
 
                        if(j < model.getColumnCount() - 1 ){
                            bufferedWriter.write(",");
                        } else {
                            bufferedWriter.write("\r\n");
                        }
                    }
                }
 
                fileWriter.close();
                JOptionPane.showMessageDialog(null, "Success");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failure");
            }
        }

        
        System.out.println("Writed");
//        file.
    }
    
    public void RefreshTouched(java.awt.event.MouseEvent evt) {
        fieldValueModeAllSetValue("", "", "", "", "", "");
        txt_field.setText("");
        txt_value.setText("");
        txt_values.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        panel_nav = new javax.swing.JPanel();
        nav_profile = new javax.swing.JLabel();
        nav_auth = new javax.swing.JLabel();
        nav_query = new javax.swing.JLabel();
        nav_archive = new javax.swing.JLabel();
        nav_document = new javax.swing.JLabel();
        nav_article = new javax.swing.JLabel();
        nav_db = new javax.swing.JLabel();
        lbl_logout = new javax.swing.JLabel();
        nav_dashboard = new javax.swing.JLabel();
        nav_settings = new javax.swing.JLabel();
        panel_notifier = new javax.swing.JPanel();
        lbl_notifier = new javax.swing.JLabel();
        panel_content = new javax.swing.JPanel();
        panel_main = new javax.swing.JPanel();
        lbl_name = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_databases = new javax.swing.JTable();
        panel_todo = new javax.swing.JPanel();
        lbl_todo = new javax.swing.JLabel();
        lbl_fields = new javax.swing.JLabel();
        txt_fields = new javax.swing.JTextField();
        lbl_values = new javax.swing.JLabel();
        txt_values = new javax.swing.JTextField();
        lbl_hint = new javax.swing.JLabel();
        lbl_which_field = new javax.swing.JLabel();
        lbl_which_value = new javax.swing.JLabel();
        txt_field = new javax.swing.JTextField();
        txt_value = new javax.swing.JTextField();
        btn_execute = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_query = new javax.swing.JTextArea();
        lbl_query = new javax.swing.JLabel();
        btn_hide = new javax.swing.JButton();
        btn_mode = new javax.swing.JButton();
        lbl_mode = new javax.swing.JLabel();
        lbl_field_1 = new javax.swing.JLabel();
        txt_field_1 = new javax.swing.JTextField();
        lbl_field_2 = new javax.swing.JLabel();
        txt_field_2 = new javax.swing.JTextField();
        txt_field_3 = new javax.swing.JTextField();
        lbl_field_3 = new javax.swing.JLabel();
        txt_field_4 = new javax.swing.JTextField();
        lbl_field_4 = new javax.swing.JLabel();
        lbl_field_5 = new javax.swing.JLabel();
        txt_field_5 = new javax.swing.JTextField();
        lbl_field_6 = new javax.swing.JLabel();
        txt_field_6 = new javax.swing.JTextField();
        btn_refresh = new javax.swing.JButton();
        lbl_feature = new javax.swing.JLabel();
        btn_create = new javax.swing.JButton();
        btn_read = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_export = new javax.swing.JButton();
        panel_additional = new javax.swing.JPanel();
        lbl_additional = new javax.swing.JLabel();
        lbl_header = new javax.swing.JLabel();
        lbl_section_one = new javax.swing.JLabel();
        lbl_section_two = new javax.swing.JLabel();
        lbl_section_three = new javax.swing.JLabel();
        lbl_separator_one = new javax.swing.JLabel();
        lbl_separator_two = new javax.swing.JLabel();
        lbl_separator_three = new javax.swing.JLabel();
        txt_section_one = new javax.swing.JLabel();
        txt_section_two = new javax.swing.JLabel();
        txt_section_three = new javax.swing.JLabel();
        btn_edit = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_nav.setBackground(new java.awt.Color(0, 153, 255));

        nav_profile.setBackground(new java.awt.Color(70, 163, 255));
        nav_profile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_profile.setForeground(new java.awt.Color(255, 255, 255));
        nav_profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_profile_32px.png"))); // NOI18N
        nav_profile.setText("Profile");
        nav_profile.setOpaque(true);
        nav_profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_profileMouseClicked(evt);
            }
        });

        nav_auth.setBackground(new java.awt.Color(0, 153, 255));
        nav_auth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_auth.setForeground(new java.awt.Color(255, 255, 255));
        nav_auth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_authentication_32px.png"))); // NOI18N
        nav_auth.setText("Auth");
        nav_auth.setOpaque(true);
        nav_auth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_authMouseClicked(evt);
            }
        });

        nav_query.setBackground(new java.awt.Color(0, 153, 255));
        nav_query.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_query.setForeground(new java.awt.Color(255, 255, 255));
        nav_query.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_query_32px.png"))); // NOI18N
        nav_query.setText("Query");
        nav_query.setOpaque(true);
        nav_query.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_queryMouseClicked(evt);
            }
        });

        nav_archive.setBackground(new java.awt.Color(0, 153, 255));
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
        nav_document.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nav_documentKeyPressed(evt);
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

        nav_db.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nav_db.setForeground(new java.awt.Color(255, 255, 255));
        nav_db.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_database_32px.png"))); // NOI18N
        nav_db.setText("Databases");

        lbl_logout.setBackground(new java.awt.Color(0, 0, 0));
        lbl_logout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_shutdown_32px.png"))); // NOI18N
        lbl_logout.setText("Logout");
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });

        nav_dashboard.setBackground(new java.awt.Color(0, 153, 255));
        nav_dashboard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nav_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        nav_dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_dashboard_32px.png"))); // NOI18N
        nav_dashboard.setText("Dashboard");
        nav_dashboard.setOpaque(true);
        nav_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nav_dashboardMouseClicked(evt);
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

        javax.swing.GroupLayout panel_navLayout = new javax.swing.GroupLayout(panel_nav);
        panel_nav.setLayout(panel_navLayout);
        panel_navLayout.setHorizontalGroup(
            panel_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_navLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nav_db, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(nav_settings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_auth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_query, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_archive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_document, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_article, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nav_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panel_navLayout.setVerticalGroup(
            panel_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_navLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nav_db)
                .addGap(24, 24, 24)
                .addComponent(nav_settings)
                .addGap(26, 26, 26)
                .addComponent(nav_profile)
                .addGap(26, 26, 26)
                .addComponent(nav_auth)
                .addGap(26, 26, 26)
                .addComponent(nav_query)
                .addGap(26, 26, 26)
                .addComponent(nav_archive)
                .addGap(26, 26, 26)
                .addComponent(nav_document)
                .addGap(26, 26, 26)
                .addComponent(nav_article)
                .addGap(26, 26, 26)
                .addComponent(nav_dashboard)
                .addGap(26, 26, 26)
                .addComponent(lbl_logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_notifier.setBackground(new java.awt.Color(0, 153, 255));

        lbl_notifier.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_notifier.setForeground(new java.awt.Color(255, 255, 255));
        lbl_notifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_salute_32px.png"))); // NOI18N
        lbl_notifier.setText("Welcome");

        javax.swing.GroupLayout panel_notifierLayout = new javax.swing.GroupLayout(panel_notifier);
        panel_notifier.setLayout(panel_notifierLayout);
        panel_notifierLayout.setHorizontalGroup(
            panel_notifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_notifierLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(lbl_notifier)
                .addContainerGap(852, Short.MAX_VALUE))
        );
        panel_notifierLayout.setVerticalGroup(
            panel_notifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_notifierLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_notifier)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panel_content.setBackground(new java.awt.Color(0, 153, 255));

        panel_main.setBackground(new java.awt.Color(30, 153, 255));

        lbl_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_price_tag_32px.png"))); // NOI18N
        lbl_name.setText("Profile");
        lbl_name.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        panel_todo.setBackground(new java.awt.Color(0, 173, 255));

        lbl_todo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_todo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_todo.setText("Todo Feature");

        lbl_fields.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_fields.setForeground(new java.awt.Color(255, 255, 255));
        lbl_fields.setText("Fields");

        txt_fields.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_fields.setText("Fields");

        lbl_values.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_values.setForeground(new java.awt.Color(255, 255, 255));
        lbl_values.setText("Values");

        txt_values.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_values.setText("Values");

        lbl_hint.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_hint_32px.png"))); // NOI18N
        lbl_hint.setText("Hint Todo Feature?");
        lbl_hint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hintMouseClicked(evt);
            }
        });

        lbl_which_field.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_which_field.setForeground(new java.awt.Color(255, 255, 255));
        lbl_which_field.setText("Which Field");

        lbl_which_value.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_which_value.setForeground(new java.awt.Color(255, 255, 255));
        lbl_which_value.setText("Which Value");

        txt_field.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_field.setText("Field");

        txt_value.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_value.setText("Value");

        btn_execute.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_execute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_exe_32px.png"))); // NOI18N
        btn_execute.setText("Execute");
        btn_execute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_executeMouseClicked(evt);
            }
        });
        btn_execute.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_executeKeyPressed(evt);
            }
        });

        txtarea_query.setColumns(20);
        txtarea_query.setRows(5);
        jScrollPane2.setViewportView(txtarea_query);

        lbl_query.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_query.setForeground(new java.awt.Color(255, 255, 255));
        lbl_query.setText("Query Executed");

        btn_hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_hide_32px.png"))); // NOI18N
        btn_hide.setText("Hide");
        btn_hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hideMouseClicked(evt);
            }
        });

        btn_mode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_user_32px.png"))); // NOI18N
        btn_mode.setText("Mode User");
        btn_mode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_modeMouseClicked(evt);
            }
        });

        lbl_mode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_mode.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mode.setText("Change Mode");

        lbl_field_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_field_1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_field_1.setText("Value 1");

        txt_field_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_field_1.setText("value field 1");

        lbl_field_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_field_2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_field_2.setText("Value 2");

        txt_field_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_field_2.setText("value field 2");

        txt_field_3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_field_3.setText("value field 3");

        lbl_field_3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_field_3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_field_3.setText("Value 3");

        txt_field_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_field_4.setText("value field 4");

        lbl_field_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_field_4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_field_4.setText("Value 4");

        lbl_field_5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_field_5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_field_5.setText("Value 5");

        txt_field_5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_field_5.setText("value field 5");

        lbl_field_6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_field_6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_field_6.setText("Value 6");

        txt_field_6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_field_6.setText("value field 6");

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_refresh_24px.png"))); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.setPreferredSize(new java.awt.Dimension(89, 41));
        btn_refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_todoLayout = new javax.swing.GroupLayout(panel_todo);
        panel_todo.setLayout(panel_todoLayout);
        panel_todoLayout.setHorizontalGroup(
            panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_todoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_execute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_todoLayout.createSequentialGroup()
                        .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_fields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_values, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbl_which_field)
                            .addComponent(lbl_which_value))
                        .addGap(18, 18, 18)
                        .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_fields)
                            .addComponent(txt_values)
                            .addComponent(txt_field)
                            .addComponent(txt_value)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_todoLayout.createSequentialGroup()
                        .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_field_2)
                            .addComponent(lbl_field_1)
                            .addComponent(lbl_field_3)
                            .addComponent(lbl_field_6)
                            .addComponent(lbl_field_4)
                            .addComponent(lbl_field_5))
                        .addGap(139, 139, 139)
                        .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_field_4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_field_5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_field_6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_field_2)
                            .addComponent(txt_field_3)
                            .addComponent(txt_field_1)))
                    .addComponent(jScrollPane2)
                    .addGroup(panel_todoLayout.createSequentialGroup()
                        .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_mode)
                            .addComponent(lbl_mode)
                            .addComponent(lbl_query)
                            .addGroup(panel_todoLayout.createSequentialGroup()
                                .addComponent(lbl_todo)
                                .addGap(7, 7, 7)
                                .addComponent(btn_hide)
                                .addGap(5, 5, 5)
                                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_hint)))
                        .addGap(0, 202, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_todoLayout.setVerticalGroup(
            panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_todoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_todo)
                        .addComponent(btn_hide)
                        .addComponent(lbl_hint)))
                .addGap(26, 26, 26)
                .addComponent(lbl_mode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_mode)
                .addGap(26, 26, 26)
                .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_fields)
                    .addComponent(txt_fields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_values)
                    .addComponent(txt_values, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_field_1)
                    .addComponent(txt_field_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_field_2)
                    .addComponent(txt_field_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_field_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_field_3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_field_4)
                    .addComponent(txt_field_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_field_5)
                    .addComponent(txt_field_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_field_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_field_6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_which_field)
                    .addComponent(txt_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_todoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_which_value)
                    .addComponent(txt_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_execute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_query)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbl_feature.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_feature.setForeground(new java.awt.Color(255, 255, 255));
        lbl_feature.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_features_list_32px.png"))); // NOI18N
        lbl_feature.setText("Features");

        btn_create.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_create.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_create_32px.png"))); // NOI18N
        btn_create.setText("Create");
        btn_create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_createMouseClicked(evt);
            }
        });

        btn_read.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_read.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_read_32px.png"))); // NOI18N
        btn_read.setText("Read");
        btn_read.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_readMouseClicked(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_update_32px.png"))); // NOI18N
        btn_update.setText("Update");
        btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_updateMouseClicked(evt);
            }
        });
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_delete_32px.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });
        btn_delete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_deleteKeyPressed(evt);
            }
        });

        btn_export.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_export_32px.png"))); // NOI18N
        btn_export.setText("Export");
        btn_export.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exportMouseClicked(evt);
            }
        });
        btn_export.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_exportKeyPressed(evt);
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
                        .addComponent(lbl_name)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_mainLayout.createSequentialGroup()
                        .addComponent(btn_create, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_read, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_export, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_todo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_feature))
                .addContainerGap())
        );
        panel_mainLayout.setVerticalGroup(
            panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_name)
                    .addComponent(lbl_feature))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_mainLayout.createSequentialGroup()
                        .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_create)
                            .addComponent(btn_read)
                            .addComponent(btn_update)
                            .addComponent(btn_delete)
                            .addComponent(btn_export))
                        .addGap(11, 11, 11)
                        .addComponent(panel_todo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_additional.setBackground(new java.awt.Color(30, 153, 255));

        lbl_additional.setForeground(new java.awt.Color(255, 255, 255));
        lbl_additional.setText("additonal header");

        lbl_header.setForeground(new java.awt.Color(255, 255, 255));
        lbl_header.setText("Header");

        lbl_section_one.setForeground(new java.awt.Color(255, 255, 255));
        lbl_section_one.setText("lbl_section_one");

        lbl_section_two.setForeground(new java.awt.Color(255, 255, 255));
        lbl_section_two.setText("lbl_section_two");

        lbl_section_three.setForeground(new java.awt.Color(255, 255, 255));
        lbl_section_three.setText("lbl_section_three");

        lbl_separator_one.setForeground(new java.awt.Color(255, 255, 255));
        lbl_separator_one.setText("lbl_separator_one");

        lbl_separator_two.setForeground(new java.awt.Color(255, 255, 255));
        lbl_separator_two.setText("lbl_separator_two");

        lbl_separator_three.setForeground(new java.awt.Color(255, 255, 255));
        lbl_separator_three.setText("lbl_separator_three");

        txt_section_one.setForeground(new java.awt.Color(255, 255, 255));
        txt_section_one.setText("txt_section_one");

        txt_section_two.setForeground(new java.awt.Color(255, 255, 255));
        txt_section_two.setText("txt_section_two");

        txt_section_three.setForeground(new java.awt.Color(255, 255, 255));
        txt_section_three.setText("txt_section_three");

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Storage/icon/icons8_edit_16px.png"))); // NOI18N
        btn_edit.setText("Edit Profile");
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_additionalLayout = new javax.swing.GroupLayout(panel_additional);
        panel_additional.setLayout(panel_additionalLayout);
        panel_additionalLayout.setHorizontalGroup(
            panel_additionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_additionalLayout.createSequentialGroup()
                .addGroup(panel_additionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_additionalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_additionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_additional)
                            .addComponent(lbl_header)))
                    .addGroup(panel_additionalLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(panel_additionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_additionalLayout.createSequentialGroup()
                                .addComponent(lbl_section_two)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_separator_two)
                                .addGap(18, 18, 18)
                                .addComponent(txt_section_two))
                            .addGroup(panel_additionalLayout.createSequentialGroup()
                                .addComponent(lbl_section_one)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_separator_one)
                                .addGap(18, 18, 18)
                                .addComponent(txt_section_one))
                            .addGroup(panel_additionalLayout.createSequentialGroup()
                                .addComponent(lbl_section_three)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_separator_three)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_section_three))))
                    .addGroup(panel_additionalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_additionalLayout.setVerticalGroup(
            panel_additionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_additionalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_additional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_additionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_section_one)
                    .addComponent(lbl_separator_one)
                    .addComponent(txt_section_one))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_additionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_section_two)
                    .addComponent(lbl_separator_two)
                    .addComponent(txt_section_two))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_additionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_section_three)
                    .addComponent(lbl_separator_three)
                    .addComponent(txt_section_three))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_contentLayout = new javax.swing.GroupLayout(panel_content);
        panel_content.setLayout(panel_contentLayout);
        panel_contentLayout.setHorizontalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_additional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_contentLayout.setVerticalGroup(
            panel_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_additional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_notifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_nav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_notifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_createMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_createMouseClicked
        // TODO add your handling code here:
        ShowPanelTodoCreate();
    }//GEN-LAST:event_btn_createMouseClicked

    private void btn_readMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_readMouseClicked
        // TODO add your handling code here:
        ShowPanelTodoRead();
    }//GEN-LAST:event_btn_readMouseClicked

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
        // TODO add your handling code here:
        ShowPanelTodoUpdate();
    }//GEN-LAST:event_btn_updateMouseClicked

    private void btn_deleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_deleteKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_deleteKeyPressed

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        // TODO add your handling code here:
        ShowPanelTodoDelete();
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hideMouseClicked
        // TODO add your handling code here:
        HidePanelTodo();
    }//GEN-LAST:event_btn_hideMouseClicked

    private void nav_authMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_authMouseClicked
        // TODO add your handling code here:
        NavAuth(evt);
    }//GEN-LAST:event_nav_authMouseClicked

    private void nav_queryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_queryMouseClicked
        // TODO add your handling code here:
        NavQuery(evt);
    }//GEN-LAST:event_nav_queryMouseClicked

    private void nav_archiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_archiveMouseClicked
        // TODO add your handling code here:
        NavArchive(evt);
    }//GEN-LAST:event_nav_archiveMouseClicked

    private void nav_documentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nav_documentKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nav_documentKeyPressed

    private void nav_articleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_articleMouseClicked
        // TODO add your handling code here:
        NavArticle(evt);
    }//GEN-LAST:event_nav_articleMouseClicked

    private void nav_documentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_documentMouseClicked
        // TODO add your handling code here:
        NavDocument(evt);
    }//GEN-LAST:event_nav_documentMouseClicked

    private void nav_profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_profileMouseClicked
        // TODO add your handling code here:
        NavProfile(evt);
    }//GEN-LAST:event_nav_profileMouseClicked

    private void btn_executeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_executeKeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btn_executeKeyPressed

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        // TODO add your handling code here:
        new SinglePage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void btn_executeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_executeMouseClicked
        // TODO add your handling code here:
        ExecuteTouched(evt);
    }//GEN-LAST:event_btn_executeMouseClicked

    private void lbl_hintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_hintMouseClicked
        // TODO add your handling code here:
        HintTouched(evt);
    }//GEN-LAST:event_lbl_hintMouseClicked

    private void tbl_databasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_databasesMouseClicked
        // TODO add your handling code here:
        TableTouched(evt);
    }//GEN-LAST:event_tbl_databasesMouseClicked

    private void btn_modeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modeMouseClicked
        // TODO add your handling code here:
        ModeTouched(evt);
    }//GEN-LAST:event_btn_modeMouseClicked

    private void btn_exportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exportMouseClicked
        // TODO add your handling code here:
        ExportTouched(evt);
    }//GEN-LAST:event_btn_exportMouseClicked

    private void btn_exportKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_exportKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_exportKeyPressed

    private void btn_refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshMouseClicked
        // TODO add your handling code here:
        RefreshTouched(evt);
    }//GEN-LAST:event_btn_refreshMouseClicked

    private void nav_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_dashboardMouseClicked
        // TODO add your handling code here:
        NavDashboard(evt);
    }//GEN-LAST:event_nav_dashboardMouseClicked

    private void nav_settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nav_settingsMouseClicked
        // TODO add your handling code here:
        NavSettings(evt);
    }//GEN-LAST:event_nav_settingsMouseClicked

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Not implemented.");
    }//GEN-LAST:event_btn_editMouseClicked

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
            java.util.logging.Logger.getLogger(AdminIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminIndex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_create;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_execute;
    private javax.swing.JButton btn_export;
    private javax.swing.JButton btn_hide;
    private javax.swing.JButton btn_mode;
    private javax.swing.JButton btn_read;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_update;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_additional;
    private javax.swing.JLabel lbl_feature;
    private javax.swing.JLabel lbl_field_1;
    private javax.swing.JLabel lbl_field_2;
    private javax.swing.JLabel lbl_field_3;
    private javax.swing.JLabel lbl_field_4;
    private javax.swing.JLabel lbl_field_5;
    private javax.swing.JLabel lbl_field_6;
    private javax.swing.JLabel lbl_fields;
    private javax.swing.JLabel lbl_header;
    private javax.swing.JLabel lbl_hint;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_mode;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_notifier;
    private javax.swing.JLabel lbl_query;
    private javax.swing.JLabel lbl_section_one;
    private javax.swing.JLabel lbl_section_three;
    private javax.swing.JLabel lbl_section_two;
    private javax.swing.JLabel lbl_separator_one;
    private javax.swing.JLabel lbl_separator_three;
    private javax.swing.JLabel lbl_separator_two;
    private javax.swing.JLabel lbl_todo;
    private javax.swing.JLabel lbl_values;
    private javax.swing.JLabel lbl_which_field;
    private javax.swing.JLabel lbl_which_value;
    private javax.swing.JLabel nav_archive;
    private javax.swing.JLabel nav_article;
    private javax.swing.JLabel nav_auth;
    private javax.swing.JLabel nav_dashboard;
    private javax.swing.JLabel nav_db;
    private javax.swing.JLabel nav_document;
    private javax.swing.JLabel nav_profile;
    private javax.swing.JLabel nav_query;
    private javax.swing.JLabel nav_settings;
    private javax.swing.JPanel panel_additional;
    private javax.swing.JPanel panel_content;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_nav;
    private javax.swing.JPanel panel_notifier;
    private javax.swing.JPanel panel_todo;
    private javax.swing.JTable tbl_databases;
    private javax.swing.JTextField txt_field;
    private javax.swing.JTextField txt_field_1;
    private javax.swing.JTextField txt_field_2;
    private javax.swing.JTextField txt_field_3;
    private javax.swing.JTextField txt_field_4;
    private javax.swing.JTextField txt_field_5;
    private javax.swing.JTextField txt_field_6;
    private javax.swing.JTextField txt_fields;
    private javax.swing.JLabel txt_section_one;
    private javax.swing.JLabel txt_section_three;
    private javax.swing.JLabel txt_section_two;
    private javax.swing.JTextField txt_value;
    private javax.swing.JTextField txt_values;
    private javax.swing.JTextArea txtarea_query;
    // End of variables declaration//GEN-END:variables
}
