/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Cache;

/**
 *
 * @author Fajar-PC
 */
public class CacheUpdateProfile {
    private String oldUsername, oldPassword = "";
    private String freshUsername, freshPassword = "";
    private boolean changed = false;
    public CacheUpdateProfile() {}
    public CacheUpdateProfile(String val1, String val2, String val3, String val4) {
        super();
        this.oldUsername = val1;
        this.oldPassword = val2;
        this.freshUsername = val3;
        this.freshPassword = val4;
    }
    public void setOldUsername(String val) { this.oldUsername = val; }
    public String getOldUsername() { return this.oldUsername; }
    public void setOldPassword(String val) { this.oldPassword = val; }
    public String getOldPassword() { return this.oldPassword; }
    public void setFreshUsername(String val) { this.freshUsername = val; }
    public String getFreshUsername() { return this.freshUsername; }
    public void setFreshPassword(String val) { this.freshPassword = val; }
    public String getFreshPassword() { return this.freshPassword; }
    public void setChanged(boolean val) { this.changed = val; }
    public boolean getChanged() { return this.changed; }
}
