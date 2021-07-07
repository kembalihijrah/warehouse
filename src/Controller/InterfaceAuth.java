/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import App.Network.NetworkPool;

/**
 *
 * @author Fajar-PC
 */
public interface InterfaceAuth {
    public void CreateAuth(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn);
    public void ReadAuth(NetworkPool val);
    public void UpdateAuth(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn, String field, String value);
    public void DeleteAuth(NetworkPool val, String field, String value);
}
