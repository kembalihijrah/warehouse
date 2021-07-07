/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Fajar-PC
 */
public class ConnectionManager {
    private Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/warehouse"; // myDB --> nama database
    private String username = "root"; // user name DMBS
    private String password = ""; // pswd DMBS
    public ConnectionManager() {}
    public void resetUrl() { this.url = "jdbc:mysql://localhost:3306/"; }
    public void setUrl(String val) { this.url = this.url+val; }
    public String getUrl() { return this.url; }
    public void defaultUrl() { this.url =  "jdbc:mysql://localhost:3306/warehouse"; }
    public Connection logOn(){
    try {
   //    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
       Class.forName(driver).newInstance();
       //Load JDBC Driver
       //Buat object Connection
       con = DriverManager.getConnection( url, username, password );
    } catch(Exception ex){
       ex.printStackTrace();
    } 
    return con; 
    }
    public void logOff(){
       try {
           //Tutup Koneksi
           con.close();
       } catch(Exception ex){
           ex.printStackTrace();
       }
    }
}
