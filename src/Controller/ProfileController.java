/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import App.Network.NetworkPool;
import Model.Profile;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Fajar-PC
 */
public class ProfileController implements InterfaceProfile, InterfaceController {
    private String op, query = "";
    private NetworkPool np = new NetworkPool();
    private Statement stm;
    
    public void dummyStm() {
        try { stm = getNetworkPool().getConnMan().logOn().createStatement(); } catch(Exception e) {}
        getNetworkPool().getConnMan().logOff();
    }
    
    public ProfileController() {}
    public ProfileController(String op, String query) {
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
    public void CreateProfile(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("C");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsProfile());
        npLocal.getQueryer().setTable("profile");
//        mute.setOp("C");
//        mute.setFields(getNetworkPool().getStorageDB().getFieldsProfile());
//        mute.setTable("profile");

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
    public void ReadProfile(NetworkPool val) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("R");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsProfile());
        npLocal.getQueryer().setTable("profile");
        
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
    public void UpdateProfile(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn, String field, String value) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("U");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsProfile());
        npLocal.getQueryer().setTable("profile");

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
    public void DeleteProfile(NetworkPool val, String field, String value) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("D");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsProfile());
        npLocal.getQueryer().setTable("profile");
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
            Profile prof = new Profile();
            stm = getNetworkPool().getConnMan().logOn().createStatement();
            ResultSet rs = stm.executeQuery("select id_profile, name_profile, date_profile, status_profile, borrow_profile, motto_profile from profile;");
            while (rs.next()) {
                System.out.println("Boilerplate() Inner");
                prof.setIdProfile(rs.getString("id_profile"));
                prof.setNameProfile(rs.getString("name_profile"));
                prof.setDateProfile(rs.getDate("date_profile"));
                prof.setStatusProfile(rs.getString("status_profile"));
                prof.setBorrowProfile(rs.getString("borrow_profile"));
                prof.setMottoProfile(rs.getString("motto_profile"));
                System.out.println("id_profile: "+prof.getIdProfile()+"\nname_profile: "+prof.getNameProfile()+"\ndate_profile: "+prof.getDateProfile()+"\nstatus_profile: "+prof.getStatusProfile()+"\nborrow_profile: "+prof.getBorrowProfile()+"\nmotto_profile: "+prof.getMottoProfile());
                if (prof.getIdProfile() == "") {
                    break;
                }
                slices[i] = prof.getIdProfile();
                slices[i+1] = prof.getNameProfile();
                slices[i+2] = prof.getDateProfile().toString();
                slices[i+3] = prof.getStatusProfile();
                slices[i+4] = prof.getBorrowProfile();
                slices[i+5] = prof.getMottoProfile();
                i += 6;
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
            Profile prof = new Profile();
            stm = getNetworkPool().getConnMan().logOn().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("Boilerplate() Inner");
                prof.setIdProfile(rs.getString("id_profile"));
                prof.setNameProfile(rs.getString("name_profile"));
                prof.setDateProfile(rs.getDate("date_profile"));
                prof.setStatusProfile(rs.getString("status_profile"));
                prof.setBorrowProfile(rs.getString("borrow_profile"));
                prof.setMottoProfile(rs.getString("motto_profile"));
                System.out.println("id_profile: "+prof.getIdProfile()+"\nname_profile: "+prof.getNameProfile()+"\ndate_profile: "+prof.getDateProfile()+"\nstatus_profile: "+prof.getStatusProfile()+"\nborrow_profile: "+prof.getBorrowProfile()+"\nmotto_profile: "+prof.getMottoProfile());
                if (prof.getIdProfile() == "") {
                    break;
                }
                slices[i] = prof.getIdProfile();
                slices[i+1] = prof.getNameProfile();
                slices[i+2] = prof.getDateProfile().toString();
                slices[i+3] = prof.getStatusProfile();
                slices[i+4] = prof.getBorrowProfile();
                slices[i+5] = prof.getMottoProfile();
                i += 6;
            }
        } catch(Exception e) { System.out.println(e); }
        getNetworkPool().getConnMan().logOff();
        return slices;
    }
    
    public Object[][] pluralListFilter() {
        String[] data = filter();
        Object[][] objs = new Object[data.length/6][data.length/6];
        int log = 5;
        for (int i = 0; i < data.length/6; i+=6) { // 0=0 4=1 8=2 12=3
            if (i == 0) {
                objs[i] = new Object[]{data[i], data[i+1], data[i+2], data[i+3], data[i+4], data[i+5]};
            }
            if ((i % 6 == 0) && (i != 0)) {
                objs[i-log] = new Object[]{data[i], data[i+1], data[i+2], data[i+3], data[i+4], data[i+5]};
                objs[i] = null;
                log += 5;
            }
        }
        return objs;
    }
    
    public Object[][] pluralList() {
        String[] data = boilerplate();
        verification();
        Object[][] objs = new Object[data.length/6][data.length/6];
        int log = 5;
        for (int i = 0; i < data.length/6; i+=6) { // 0=0 4=1 8=2 12=3
            if (i == 0) {
                objs[i] = new Object[]{data[i], data[i+1], data[i+2], data[i+3], data[i+4], data[i+5]};
            }
            if ((i % 6 == 0) && (i != 0)) {
                objs[i-log] = new Object[]{data[i], data[i+1], data[i+2], data[i+3], data[i+4], data[i+5]};
                objs[i] = null;
                log += 5;
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
                logOpQuery();
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
    public void Read() {}

    /**
     *
     */
    @Override
    public void Update() {
        if (getOp() == "U") {
            try {
                System.out.println("From Controller");
                logOpQuery();
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
                logOpQuery();
                Statement stm = getNetworkPool().getConnMan().logOn().createStatement();
                stm.executeUpdate(getQuery());
                getNetworkPool().getConnMan().logOn().commit();
            } catch (Exception e) {}
            getNetworkPool().getConnMan().logOff();
        }
    }
    
    public void logConnManConnStm() { System.out.println("Profile Controller\nConnMan: "+getNetworkPool().getConnMan()+"\nConn: "+getNetworkPool().getConnMan().logOn()+"\nStm: "+stm); getNetworkPool().getConnMan().logOff(); }
    public void logOpQuery() { System.out.println("Profile Controller\nOp: "+op+"\nQuery: "+query); dummyStm(); }
    public void setOp(String val) { this.op = val; }
    public String getOp() { return this.op; }
    public void setQuery(String val) { this.query = val; }
    public String getQuery() { return this.query; }
    public void setNetworkPool(NetworkPool val) { this.np = val; }
    public NetworkPool getNetworkPool() { return this.np; }
    public void setStm(Statement val) { this.stm = val; }
    public Statement getStm() { return this.stm; }
}
