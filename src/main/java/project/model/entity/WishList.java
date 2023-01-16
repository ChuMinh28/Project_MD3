package project.model.entity;

public class WishList {
    private int userID;
    private Product product;

    public WishList() {
    }

    public WishList(int userID, Product product) {
        this.userID = userID;
        this.product = product;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
