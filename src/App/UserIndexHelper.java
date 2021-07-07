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
public class UserIndexHelper extends UserIndexHelperAbstract {
    private String archive, document, article;
    private String[] splitThrees = new String[]{"", "", ""};
    public UserIndexHelper() {}
    public UserIndexHelper(String arc, String doc, String art) {
        super();
        this.archive = arc;
        this.document = doc;
        this.article = art;
    }
    public void setArchive(String val) { this.archive = val; }
    public String getArchive() { return this.archive; }
    public void setDocument(String val) { this.document = val; }
    public String getDocument() { return this.document; }
    public void setArticle(String val) { this.article = val; }
    public String getArticle() { return this.article; }
    public void setSplitThrees(String[] val) { this.splitThrees = val; }
    public String[] getSplitThrees() { return this.splitThrees; }
    public String combine() { 
        String arch = "";
        String docm = "";
        String arti = "";
        if (getArchive() == null) { arch = null; } else { arch = getArchive(); }
        if (getDocument() == null) { docm = null; } else { docm = getDocument(); }
        if (getArticle() == null) { arti = null; } else { arti = getArticle(); }
        return arch+"_"+docm+"_"+arti; 
    }
    public void reset() {
        setArchive("");
        setDocument("");
        setArticle("");
        setSplitThrees(new String[]{});
    }
    public String getBulkArchive() {
        return super.getBulkFromArchive();
    }
    public String getBulkDocument() {
        return super.getBulkFromDocument();
    }
    public void commitToAbstract(String val1, String val2) {
        super.setBulkFromArchive(val1);
        super.setBulkFromDocument(val2);
    }
}
