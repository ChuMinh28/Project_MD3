package project.model.entity;

import java.util.Date;

public class Catalog {
    private int catalogID;
    private String catalogName;
    private String catalogTitle;
    private Date created;
    private boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogID, String catalogName, String catalogTitle, Date created, boolean catalogStatus) {
        this.catalogID = catalogID;
        this.catalogName = catalogName;
        this.catalogTitle = catalogTitle;
        this.created = created;
        this.catalogStatus = catalogStatus;
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

    public String getCatalogTitle() {
        return catalogTitle;
    }

    public void setCatalogTitle(String catalogTitle) {
        this.catalogTitle = catalogTitle;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}
