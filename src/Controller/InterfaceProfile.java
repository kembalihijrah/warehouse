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
public interface InterfaceProfile {
    public void CreateProfile(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn);
    public void ReadProfile(NetworkPool val);
    public void UpdateProfile(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn, String field, String value);
    public void DeleteProfile(NetworkPool val, String field, String value);
}
