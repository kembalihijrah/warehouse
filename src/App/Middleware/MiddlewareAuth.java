/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Middleware;

/**
 *
 * @author Fajar-PC
 */
public class MiddlewareAuth {
    private String username, password, authKey;
    public MiddlewareAuth() {}
    public MiddlewareAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void setUsername(String val) { this.username = val; }
    public String getUsername() { return this.username; }
    public void setPassword(String val) { this.password = val; }
    public String getPassword() { return this.password; }
    public void setAuthKey(String val) { this.authKey = val; }
    public String getAuthKey() { return this.authKey; }
}
