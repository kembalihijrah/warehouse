/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

/**
 *
 * @author Fajar-PC
 */
public abstract class UserIndexHelperAbstract {
    private String bulkFromArchive;
    private String bulkFromDocument;
    public UserIndexHelperAbstract() {}
    public UserIndexHelperAbstract(String val1, String val2) {
        this.bulkFromArchive = val1;
        this.bulkFromDocument = val2;
    }
    protected void setBulkFromArchive(String val) { this.bulkFromArchive = val; }
    protected String getBulkFromArchive() { return this.bulkFromArchive; }
    protected void setBulkFromDocument(String val) { this.bulkFromDocument = val; }
    protected String getBulkFromDocument() { return this.bulkFromDocument; }
}
