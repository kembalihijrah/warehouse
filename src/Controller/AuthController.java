/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import App.Network.NetworkPool;
import Model.Auth;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Fajar-PC
 */
public class AuthController  implements InterfaceAuth, InterfaceController {
    private String op, query = "";
    private NetworkPool np = new NetworkPool();
    private Statement stm;
    
    public void dummyStm() {
        try { stm = getNetworkPool().getConnMan().logOn().createStatement(); } catch(Exception e) {}
        getNetworkPool().getConnMan().logOff();
    }
    
    public AuthController() {}
    public AuthController(String op, String query) {
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
    public void CreateAuth(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("C");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsAuth());
        npLocal.getQueryer().setTable("auth");
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
    public void ReadAuth(NetworkPool val) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("R");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsAuth());
        npLocal.getQueryer().setTable("auth");

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
    public void UpdateAuth(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn, String field, String value) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("U");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsAuth());
        npLocal.getQueryer().setTable("auth");
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
    public void DeleteAuth(NetworkPool val, String field, String value) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("D");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsAuth());
        npLocal.getQueryer().setTable("auth");
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
            Auth auth = new Auth();
            stm = getNetworkPool().getConnMan().logOn().createStatement();
            ResultSet rs = stm.executeQuery("select id_auth, username_auth, password_auth from auth;");
            while (rs.next()) {
                System.out.println("Boilerplate() Inner");
                auth.setIdAuth(rs.getString("id_auth"));
                auth.setUsernameAuth(rs.getString("username_auth"));
                auth.setPasswordAuth(rs.getString("password_auth"));
                System.out.println("id_auth: "+auth.getIdAuth()+"\nusername_auth: "+auth.getUsernameAuth()+"\npassword_auth: "+auth.getPasswordAuth());
                if (auth.getIdAuth() == "") {
                    break;
                }
                slices[i] = auth.getIdAuth();
                slices[i+1] = auth.getUsernameAuth();
                slices[i+2] = auth.getPasswordAuth();
                i += 3;
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
            Auth auth = new Auth();
            stm = getNetworkPool().getConnMan().logOn().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("Boilerplate() Inner");
                auth.setIdAuth(rs.getString("id_auth"));
                auth.setUsernameAuth(rs.getString("username_auth"));
                auth.setPasswordAuth(rs.getString("password_auth"));
                System.out.println("id_auth: "+auth.getIdAuth()+"\nusername_auth: "+auth.getUsernameAuth()+"\npassword_auth: "+auth.getPasswordAuth());
                if (auth.getIdAuth() == "") {
                    break;
                }
                slices[i] = auth.getIdAuth();
                slices[i+1] = auth.getUsernameAuth();
                slices[i+2] = auth.getPasswordAuth();
                i += 3;
            }
        } catch(Exception e) { System.out.println(e); }
        getNetworkPool().getConnMan().logOff();
        return slices;
    }
    
    public Object[][] pluralListFilter() {
        String[] data = filter();
        Object[][] objs = new Object[data.length/3][data.length/3];
        int log = 2;
        for (int i = 0; i < data.length/3; i+=3) { // 0=0 4=1 8=2 12=3
            if (i == 0) {
                objs[i] = new Object[]{data[i], data[i+1], data[i+2]};
            }
            if ((i % 3 == 0) && (i != 0)) {
                objs[i-log] = new Object[]{data[i], data[i+1], data[i+2]};
                objs[i] = null;
                log += 2;
            }
        }
        return objs;
    }
    
    
    public Object[][] pluralList() {
        String[] data = boilerplate();
        Object[][] objs = new Object[data.length/3][data.length/3];
        int log = 2;
        for (int i = 0; i < data.length/3; i+=3) { // 0=0 4=1 8=2 12=3
            if (i == 0) {
                objs[i] = new Object[]{data[i], data[i+1], data[i+2]};
            }
            if ((i % 3 == 0) && (i != 0)) {
                objs[i-log] = new Object[]{data[i], data[i+1], data[i+2]};
                objs[i] = null;
                log += 2;
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
                Statement stm = getNetworkPool().getConnMan().logOn().createStatement();
                stm.executeUpdate(getQuery());
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
            } catch (Exception e) {}
            getNetworkPool().getConnMan().logOff();
        }
    }
    
    public void logConnManConnStm() { System.out.println("AuthController\nConnMan: "+getNetworkPool().getConnMan()+"\nConn: "+getNetworkPool().getConnMan().logOn()+"\nStm: "+stm); getNetworkPool().getConnMan().logOff(); }
    public void logOpQuery() { System.out.println("AuthController\nOp: "+op+"\nQuery: "+query); dummyStm(); }
    public void setOp(String val) { this.op = val; }
    public String getOp() { return this.op; }
    public void setQuery(String val) { this.query = val; }
    public String getQuery() { return this.query; }
    public void setNetworkPool(NetworkPool val) { this.np = val; }
    public NetworkPool getNetworkPool() { return this.np; }
    public void setStm(Statement val) { this.stm = val; }
    public Statement getStm() { return this.stm; }
}
