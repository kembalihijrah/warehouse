/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

/**
 *
 * @author Fajar-PC
 */
public class StorageDB {
    private String[] fieldsProfile = new String[]{"id_profile", "name_profile", "date_profile", "status_profile", "borrow_profile", "motto_profile"};
    private String[] fieldsAuth = new String[]{"id_auth", "username_auth", "password_auth"};
    private String[] fieldsQuery = new String[]{"id_query", "name_query"};
    private String[] fieldsArchive = new String[]{"id_archive", "name_archive", "date_archive", "theme_archive", "bulk_archive"};
    private String[] fieldsDocument = new String[]{"id_document", "name_document", "date_document", "theme_document", "bulk_document"};
    private String[] fieldsArticle = new String[]{"id_article", "name_article", "date_article", "content_article"};
    public StorageDB() {}
    public String[] getFieldsProfile() { return this.fieldsProfile; }
    public String[] getFieldsAuth() { return this.fieldsAuth; }
    public String[] getFieldsQuery() { return this.fieldsQuery; }
    public String[] getFieldsArchive() { return this.fieldsArchive; }
    public String[] getFieldsDocument() { return this.fieldsDocument; }
    public String[] getFieldsArticle() { return this.fieldsArticle; }
}
