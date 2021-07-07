/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Exception;

/**
 *
 * @author Fajar-PC
 */
public class ExceptionActivity extends Throwable {
    private String exception;
    public ExceptionActivity() {}
    public ExceptionActivity(String val) { this.exception = val; }
    public void setException(String val) { this.exception = val; }
    public String getException() { return this.exception; }
    @Override
    public String toString() {
        return getException();
    }
}
