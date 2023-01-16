package project.model.entity;

import java.util.Date;

public class Order {
    private int orderID;
    private int userID;
    private Date created;
    private boolean orderStatus;
    private float totalAmount;

    public Order() {
    }

    public Order(int orderID, int userID, Date created, boolean orderStatus, float totalAmount) {
        this.orderID = orderID;
        this.userID = userID;
        this.created = created;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
