/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import App.Network.NetworkPool;
import Model.Archive;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Fajar-PC
 */
public class ArchiveController implements InterfaceArchive, InterfaceController {
    private String op, query = "";
    private NetworkPool np = new NetworkPool();
    private Statement stm;

    public void dummyStm() {
        try { stm = np.getConnMan().logOn().createStatement(); } catch(Exception e) {}
        getNetworkPool().getConnMan().logOff();
    }
    public ArchiveController() {}
    public ArchiveController(String op, String query) {
        this.op = op;
        this.query = query;
    }
    
    /**
     *
     * @param val
     * @param valuesRaw
     * @param valuesCombined
     * @param modeBtn
     */
    @Override
    public void CreateArchive(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("C");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsArchive());
        npLocal.getQueryer().setTable("archive");
        if (valuesRaw.split("\\s+").length < npLocal.getQueryer().getFields().length) {
            JOptionPane.showMessageDialog(null, "Not enough!");
        }
        if (modeBtn == "Mode Developer") {
            npLocal.getQueryer().setValues(valuesCombined.split("\\s+"));
        } else {
            npLocal.getQueryer().setValues(valuesRaw.split("\\s+"));
        }
        npLocal.getQueryer().Query();

        setOp(npLocal.getQueryer().getOp());
        setQuery(npLocal.getQueryer().getQuery());
        logOpQuery();
        logConnManConnStm();
        
//        setNetworkPool(npLocal);
        try {
            setStm(npLocal.getConnMan().logOn().createStatement());
            Create();
        } catch(Exception e) {}
        npLocal.getConnMan().logOff();
        if (modeBtn == "Mode Developer") {
            JOptionPane.showMessageDialog(null, "Change to Mode Developer!");
        } else {
            JOptionPane.showMessageDialog(null, "Success created!");
        }
    }
    
    /**
     *
     * @param val
     */
    @Override
    public void ReadArchive(NetworkPool val) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("R");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsArchive());
        npLocal.getQueryer().setTable("archive");

        npLocal.getQueryer().Query();

        setOp(npLocal.getQueryer().getOp());
        setQuery(npLocal.getQueryer().getQuery());
        logOpQuery();
        logConnManConnStm();
        
//        setNetworkPool(npLocal);
        try {
            setStm(npLocal.getConnMan().logOn().createStatement());
        } catch(Exception e) {}
        npLocal.getConnMan().logOff();
    }
    
    /**
     *
     * @param val
     * @param valuesRaw
     * @param valuesCombined
     * @param modeBtn
     * @param field
     * @param value
     */
    @Override
    public void UpdateArchive(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn, String field, String value) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("U");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsArchive());
        npLocal.getQueryer().setTable("archive");

        if (field == "") {
            JOptionPane.showMessageDialog(null, "Empty field!");
        }
        if (value == "") {
            JOptionPane.showMessageDialog(null, "Empty value!");
        }
        npLocal.getQueryer().setField(field);
        npLocal.getQueryer().setValue(value);

        if (valuesRaw.split("\\s+").length < npLocal.getQueryer().getFields().length) {
            JOptionPane.showMessageDialog(null, "Not enough!");
        }
        if (modeBtn == "Mode Developer") {
            npLocal.getQueryer().setValues(valuesCombined.split("\\s+"));
        } else {
            npLocal.getQueryer().setValues(valuesRaw.split("\\s+"));
        }
        npLocal.getQueryer().Query();
        setOp(npLocal.getQueryer().getOp());
        setQuery(npLocal.getQueryer().getQuery());
        logOpQuery();
        logConnManConnStm();
        
//        setNetworkPool(npLocal);
        try {
            setStm(npLocal.getConnMan().logOn().createStatement());
            Update();
        } catch(Exception e) {}
        npLocal.getConnMan().logOff();
        if (modeBtn == "Mode Developer") {
            JOptionPane.showMessageDialog(null, "Change to Mode Developer!");
        } else {
            JOptionPane.showMessageDialog(null, "Success updated!");
        }
    }
    
    /**
     *
     * @param val
     * @param field
     * @param value
     */
    @Override
    public void DeleteArchive(NetworkPool val, String field, String value) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("D");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsArchive());
        npLocal.getQueryer().setTable("archive");
        if (field == "") {
            JOptionPane.showMessageDialog(null, "Empty field!");
        }
        if (value == "") {
            JOptionPane.showMessageDialog(null, "Empty value!");
        }
        npLocal.getQueryer().setField(field);
        npLocal.getQueryer().setValue(value);
        npLocal.getQueryer().Query();

        setOp(npLocal.getQueryer().getOp());
        setQuery(npLocal.getQueryer().getQuery());
        logOpQuery();
        logConnManConnStm();
        
//        setNetworkPool(npLocal);
        try {
            setStm(npLocal.getConnMan().logOn().createStatement());
            Delete();
        } catch(Exception e) {}
        npLocal.getConnMan().logOff();
        JOptionPane.showMessageDialog(null, "Success deleted!");
    }
    
    public String[] boilerplate() {
        String[] slices = new String[200];
        int i = 0;
        try {
            System.out.println("Boilerplate()");
            Archive arch = new Archive();
            stm = getNetworkPool().getConnMan().logOn().createStatement();
            ResultSet rs = stm.executeQuery("select id_archive, name_archive, date_archive, theme_archive, bulk_archive from archive;");
            while (rs.next()) {
                System.out.println("Boilerplate() Inner");
                arch.setIdArchive(rs.getString("id_archive"));
                arch.setNameArchive(rs.getString("name_archive"));
                arch.setDateArchive(rs.getDate("date_archive"));
                arch.setThemeArchive(rs.getString("theme_archive"));
                arch.setBulkArchive(rs.getString("bulk_archive"));
                System.out.println("id_archive: "+arch.getIdArchive()+"\nname_archive: "+arch.getNameArchive()+"\ndate_archive: "+arch.getDateArchive().toString()+"\ntheme_archive: "+arch.getThemeArchive()+"\nbulk_archive: "+arch.getBulkArchive());
                if (arch.getIdArchive() == "") {
                    break;
                }
                slices[i] = arch.getIdArchive();
                slices[i+1] = arch.getNameArchive();
                slices[i+2] = arch.getDateArchive().toString();
                slices[i+3] = arch.getThemeArchive();
                slices[i+4] = arch.getBulkArchive();
                i += 5;
            }
        } catch(Exception e) { System.out.println(e); }
        getNetworkPool().getConnMan().logOff();
        return slices;
    }
    
    public void verification() {
        System.out.println("boilerplate fill:");
//        System.out.println("length slices: "+boilerplate().length);
//        String id = null;
//        String us = null, pw = null;
        for (int i = 0; i < boilerplate().length-1; i+=3) {
            System.out.println(boilerplate()[i]);
        }
    }
    
    public String[] filter() {
        String[] slices = new String[200];
        int i = 0;
        try {
            System.out.println("Boilerplate()");
            Archive arch = new Archive();
            stm = getNetworkPool().getConnMan().logOn().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("Boilerplate() Inner");
                arch.setIdArchive(rs.getString("id_archive"));
                arch.setNameArchive(rs.getString("name_archive"));
                arch.setDateArchive(rs.getDate("date_archive"));
                arch.setThemeArchive(rs.getString("theme_archive"));
                arch.setBulkArchive(rs.getString("bulk_archive"));
                System.out.println("id_archive: "+arch.getIdArchive()+"\nname_archive: "+arch.getNameArchive()+"\ndate_archive: "+arch.getDateArchive().toString()+"\ntheme_archive: "+arch.getThemeArchive()+"\nbulk_archive: "+arch.getBulkArchive());
                if (arch.getIdArchive() == "") {
                    break;
                }
                slices[i] = arch.getIdArchive();
                slices[i+1] = arch.getNameArchive();
                slices[i+2] = arch.getDateArchive().toString();
                slices[i+3] = arch.getThemeArchive();
                slices[i+4] = arch.getBulkArchive();
                i += 5;
            }
        } catch(Exception e) { System.out.println(e); }
        getNetworkPool().getConnMan().logOff();
        return slices;
    }
    
    public Object[][] pluralListFilter() {
        String[] data = filter();
        Object[][] objs = new Object[data.length/5][data.length/5];
        int log = 4;
        for (int i = 0; i < data.length/5; i+=5) { // 0=0 4=1 8=2 12=3
            if (i == 0) {
                objs[i] = new Object[]{data[i], data[i+1], data[i+2], data[i+3], data[i+4]};
            }
            if ((i % 5 == 0) && (i != 0)) {
                objs[i-log] = new Object[]{data[i], data[i+1], data[i+2], data[i+3], data[i+4]};
                objs[i] = null;
                log += 4;
            }
        }
        return objs;
    }
    
    
    public Object[][] pluralList() {
        verification();
        String[] data = boilerplate();
        Object[][] objs = new Object[data.length/5][data.length/5];
        int log = 4;
        for (int i = 0; i < data.length/5; i+=5) { // 0=0 4=1 8=2 12=3
            if (i == 0) {
                objs[i] = new Object[]{data[i], data[i+1], data[i+2], data[i+3], data[i+4]};
            }
            if ((i % 5 == 0) && (i != 0)) {
                objs[i-log] = new Object[]{data[i], data[i+1], data[i+2], data[i+3], data[i+4]};
                objs[i] = null;
                log += 4;
            }
        }
        return objs;
    }
    
    /**
     *
     */
    @Override
    public void Create() {
        if (getOp() == "C") {
            try {
                System.out.println("From Controller");
                Statement stm = getNetworkPool().getConnMan().logOn().createStatement();
                stm.executeUpdate(getQuery());
                getNetworkPool().getConnMan().logOn().commit();
            } catch (Exception e) {}
            getNetworkPool().getConnMan().logOff();
        }
    }

    /**
     *
     */
    @Override
    public void Read() {
    
    }

    /**
     *
     */
    @Override
    public void Update() {
        if (getOp() == "U") {
            try {
                System.out.println("From Controller");
                Statement stm = getNetworkPool().getConnMan().logOn().createStatement();
                stm.executeUpdate(getQuery());
                getNetworkPool().getConnMan().logOn().commit();
            } catch (Exception e) {}
            getNetworkPool().getConnMan().logOff();
        }
    }

    /**
     *
     */
    @Override
    public void Delete() {
        if (getOp() == "D") {
            try {
                System.out.println("From Controller");
                Statement stm = getNetworkPool().getConnMan().logOn().createStatement();
                stm.executeUpdate(getQuery());
                getNetworkPool().getConnMan().logOn().commit();
            } catch (Exception e) {}
            getNetworkPool().getConnMan().logOff();
        }
    }
    
    public void logConnManConnStm() { System.out.println("Archive Controller\nConnMan: "+getNetworkPool().getConnMan()+"\nConn: "+getNetworkPool().getConnMan().logOn()+"\nStm: "+stm); getNetworkPool().getConnMan().logOff(); }
    public void logOpQuery() { System.out.println("Archive Controller\nOp: "+op+"\nQuery: "+query); dummyStm(); }
    public void setOp(String val) { this.op = val; }
    public String getOp() { return this.op; }
    public void setQuery(String val) { this.query = val; }
    public String getQuery() { return this.query; }
    public void setNetworkPool(NetworkPool val) { this.np = val; }
    public NetworkPool getNetworkPool() { return this.np; }
    public void setStm(Statement val) { this.stm = val; }
    public Statement getStm() { return this.stm; }
}
