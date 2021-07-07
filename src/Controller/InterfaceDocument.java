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
public interface InterfaceDocument {
    public void CreateDocument(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn);
    public void ReadDocument(NetworkPool val);
    public void UpdateDocument(NetworkPool val, String valuesRaw, String valuesCombined, String modeBtn, String field, String value);
    public void DeleteDocument(NetworkPool val, String field, String value);
}
