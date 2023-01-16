package project.model.entity;

public class ShortCatalog {
    private int catalogID;
    private String catalogName;

    public ShortCatalog() {
    }

    public ShortCatalog(int catalogID, String catalogName) {
        this.catalogID = catalogID;
        this.catalogName = catalogName;
    }

    public int getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(int catalogID) {
        this.catalogID = catalogID;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }
}
