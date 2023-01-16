package project.model.entity;

import java.util.Date;

public class User {
    private int userID;
    private String userAccount;
    private String userPassWord;
    private String fullName;
    private String address;
    private String email;
    private String phone;
    private Date created;
    private boolean permission;
    private boolean userStatus;

    public User() {
    }

    public User(int userID, String userAccount, String userPassWord, String fullName, String address, String email, String phone, Date created, boolean permission, boolean userStatus) {
        this.userID = userID;
        this.userAccount = userAccount;
        this.userPassWord = userPassWord;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.created = created;
        this.permission = permission;
        this.userStatus = userStatus;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
}
