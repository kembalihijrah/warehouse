/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import App.Network.NetworkPool;
import Model.Article;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Fajar-PC
 */
public class ArticleController implements InterfaceArticle, InterfaceController {
    private String op, query = "";
    private NetworkPool np = new NetworkPool();
    private Statement stm;
    
    public void dummyStm() {
        try { stm = np.getConnMan().logOn().createStatement(); } catch(Exception e) {}
        getNetworkPool().getConnMan().logOff();
    }
    
    public ArticleController() {}
    public ArticleController(String op, String query) {
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
    public void CreateArticle(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("C");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsArticle());
        npLocal.getQueryer().setTable("article");
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
    public void ReadArticle(NetworkPool val) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("R");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsArticle());
        npLocal.getQueryer().setTable("article");

        npLocal.getQueryer().Query();

        setOp(npLocal.getQueryer().getOp());
        setQuery(npLocal.getQueryer().getQuery());
        logOpQuery();
        logConnManConnStm();
        
        setNetworkPool(npLocal);
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
    public void UpdateArticle(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn, String field, String value) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("U");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsArticle());
        npLocal.getQueryer().setTable("article");
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
    public void DeleteArticle(NetworkPool val, String field, String value) {
        NetworkPool npLocal = val;
        npLocal.getQueryer().setOp("D");
        npLocal.getQueryer().setFields(npLocal.getStorageDB().getFieldsArticle());
        npLocal.getQueryer().setTable("article");
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
        
        setNetworkPool(npLocal);
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
            Article arti = new Article();
            stm = getNetworkPool().getConnMan().logOn().createStatement();
            ResultSet rs = stm.executeQuery("select id_article, name_article, date_article, content_article from article;");
            while (rs.next()) {
                System.out.println("Boilerplate() Inner");
                arti.setIdArticle(rs.getString("id_article"));
                arti.setNameArticle(rs.getString("name_article"));
                arti.setDateArticle(rs.getDate("date_article"));
                arti.setContentArticle(rs.getString("content_article"));
                System.out.println("id_article: "+arti.getIdArticle()+"\nname_article: "+arti.getNameArticle()+"\ndate_article: "+arti.getDateArticle()+"\ncontent_article: "+arti.getContentArticle());
                if (arti.getIdArticle() == "") {
                    break;
                }
                slices[i] = arti.getIdArticle();
                slices[i+1] = arti.getNameArticle();
                slices[i+2] = arti.getDateArticle().toString();
                slices[i+3] = arti.getContentArticle();
                i += 4;
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
            Article arti = new Article();
            stm = getNetworkPool().getConnMan().logOn().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("Boilerplate() Inner");
                arti.setIdArticle(rs.getString("id_article"));
                arti.setNameArticle(rs.getString("name_article"));
                arti.setDateArticle(rs.getDate("date_article"));
                arti.setContentArticle(rs.getString("content_article"));
                System.out.println("id_article: "+arti.getIdArticle()+"\nname_article: "+arti.getNameArticle()+"\ndate_article: "+arti.getDateArticle()+"\ncontent_article: "+arti.getContentArticle());
                if (arti.getIdArticle() == "") {
                    break;
                }
                slices[i] = arti.getIdArticle();
                slices[i+1] = arti.getNameArticle();
                slices[i+2] = arti.getDateArticle().toString();
                slices[i+3] = arti.getContentArticle();
                i += 4;
            }
        } catch(Exception e) { System.out.println(e); }
        getNetworkPool().getConnMan().logOff();
        return slices;
    }
    
    
    public Object[][] pluralListFilter() {
        String[] data = filter();
        Object[][] objs = new Object[data.length/4][data.length/4];
        int log = 3;
        for (int i = 0; i < data.length/4; i+=4) { // 0=0 4=1 8=2 12=3
            if (i == 0) {
                objs[i] = new Object[]{data[i], data[i+1], data[i+2], data[i+3]};
            }
            if ((i % 4 == 0) && (i != 0)) {
                objs[i-log] = new Object[]{data[i], data[i+1], data[i+2], data[i+3]};
                objs[i] = null;
                log += 3;
            }
        }
        return objs;
    }
    
    public Object[][] pluralList() {
        String[] data = boilerplate();
        Object[][] objs = new Object[data.length/4][data.length/4];
        int log = 3;
        for (int i = 0; i < data.length/4; i+=4) { // 0=0 4=1 8=2 12=3
            if (i == 0) {
                objs[i] = new Object[]{data[i], data[i+1], data[i+2], data[i+3]};
            }
            if ((i % 4 == 0) && (i != 0)) {
                objs[i-log] = new Object[]{data[i], data[i+1], data[i+2], data[i+3]};
                objs[i] = null;
                log += 3;
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
    
    public void logConnManConnStm() { System.out.println("ArticleController\nConnMan: "+getNetworkPool().getConnMan()+"\nConn: "+getNetworkPool().getConnMan().logOn()+"\nStm: "+stm); getNetworkPool().getConnMan().logOff(); }
    public void logOpQuery() { System.out.println("ArticleController\nOp: "+op+"\nQuery: "+query); dummyStm(); }
    public void setOp(String val) { this.op = val; }
    public String getOp() { return this.op; }
    public void setQuery(String val) { this.query = val; }
    public String getQuery() { return this.query; }
    public void setNetworkPool(NetworkPool val) { this.np = val; }
    public NetworkPool getNetworkPool() { return this.np; }
    public void setStm(Statement val) { this.stm = val; }
    public Statement getStm() { return this.stm; }
}
