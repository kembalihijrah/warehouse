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
public class StackyMen {
    private String[] StackyMen = new String[200];
    public StackyMen() {}
    public StackyMen(String[] val) {
        this.StackyMen = val;
    }
    public void Reset() {
        this.StackyMen = new String[]{};
    }
    public void setStackyMen(String[] val) { this.StackyMen = val; }
    public String[] getStackyMen() { return this.StackyMen; }
}
