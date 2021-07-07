/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author Fajar-PC
 */
public class Queryer {
    private String[] fields;
    private String[] values;
    private String query, op, table, value, field;
    private int id;
    public Queryer() {}
    public Queryer(String op) { this.op = op; }

    private void C() {
        query = "insert into ";
        query += table+" (";
        for (int i = 0; i < fields.length; i++) {
            if (i == fields.length-1) {
                query += getFields()[i]+") ";
                break;
            }
            query += getFields()[i]+", ";
        }
        query += "values (";
        for (int i = 0; i < fields.length; i++) {
            if (i == fields.length-1) {
                query += "'"+getValues()[i]+"'); ";
                break;
            }
            query += "'"+getValues()[i]+"', ";
        }
        
    }
    private void R() {
        query = "select ";
//        query += "* ";
        for (int i = 0; i < fields.length; i++) {
            if (i == fields.length-1) {
                query += getFields()[i]+" ";
                break;
            }
            query += getFields()[i]+", ";
        }
        query += "from "+table+";";
    }
    private void U() {
        query = "update ";
        query += table+" ";
        query += "set ";
        for (int i = 0; i < fields.length; i++) {
            if (i == fields.length-1) {
                query += getFields()[i]+"='";
                query += getValues()[i]+"' ";
                query += "where "+getField()+"='";
                query += getValue()+"';";
                break;
            }
            query += getFields()[i]+"='";
            query += getValues()[i]+"', ";
        }
    }
    private void D() {
        query = "delete from ";
        query += table+" ";
        query += "where "+getField()+"='"+getValue()+"';";
    }
    public void setField(String f) { this.field = f; }
    public String getField() { return this.field; } 
    public void setValue(String v) { this.value = v; }
    public String getValue() { return this.value; }
    public String getQuery() { return this.query; }
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    public void setValues(String[] vals) { this.values = vals; }
    public String[] getValues() { return this.values; }
    public String getTable() { return this.table; }
    public void setTable(String tbl) { this.table = tbl; }
    public String[] getFields() { return this.fields; }
    public void setFields(String[] flds) { this.fields = flds; }
    public void setOp(String op) { this.op = op; }
    public String getOp() { return this.op; }
    public void Query() {
        switch (op) {
            case "C": C(); break;
            case "R": R(); break;
            case "U": U(); break;
            case "D": D(); break;
        }
    }
}
