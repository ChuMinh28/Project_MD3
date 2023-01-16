package project.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int productID;
    private String productName;
    private float price;
    private int quantity;
    private String productTitle;
    private int catalog;
    private String productImage;
    private String descriptions;
    private List<String> listImageLink = new ArrayList<>();
    private boolean productStatus;

    public Product() {
    }

    public Product(int productID, String productName, float price, int quantity, String productTitle, int catalog, String productImage, String descriptions, List<String> listImageLink, boolean productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productTitle = productTitle;
        this.catalog = catalog;
        this.productImage = productImage;
        this.descriptions = descriptions;
        this.listImageLink = listImageLink;
        this.productStatus = productStatus;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public List<String> getListImageLink() {
        return listImageLink;
    }

    public void setListImageLink(List<String> listImageLink) {
        this.listImageLink = listImageLink;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
}
