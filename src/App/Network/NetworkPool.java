/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Network;

import Storage.StorageDB;
import Tools.ConnectionManager;
import Tools.Queryer;

/**
 *
 * @author Fajar-PC
 */
public class NetworkPool {
    private ConnectionManager connMan = new ConnectionManager();
    private StorageDB sDB = new StorageDB();
    private Queryer mute = new Queryer();
    public NetworkPool() {}
    public NetworkPool(ConnectionManager val) { this.connMan = val; }
    public void setConnMan(ConnectionManager val) { this.connMan = val; }
    public ConnectionManager getConnMan() { return this.connMan; }
    public void setStorageDB(StorageDB val) { this.sDB = val; }
    public StorageDB getStorageDB() { return this.sDB; }
    public void setQueryer(Queryer val) { this.mute = val; }
    public Queryer getQueryer() { return this.mute; }
}
