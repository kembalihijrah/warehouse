/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Tools.Queryer;

/**
 *
 * @author Fajar-PC
 */
public class AdminIndexHelper {
    private Queryer mute = new Queryer();
    private String op, query, table = "";
    private String[] fields = new String[]{};
    private String valuesCombined = "";
    public AdminIndexHelper() {}
    public void setValuesCombined(String val) { this.valuesCombined = val; }
    public String getValuesCombined() { return this.valuesCombined; }
    public void setOp(String val) { this.op = val; }
    public String getOp() { return this.op; }
    public void setQuery(String val) { this.query = val; }
    public String getQuery() { return this.query; }
    public void setTable(String val) { this.table = val; }
    public String getTable() { return this.table; }
    public void setFields(String[] val) { this.fields = val; }
    public String[] getFields() { return this.fields; }
    public void Query() { mute.Query(); this.query = mute.getQuery(); }
}
