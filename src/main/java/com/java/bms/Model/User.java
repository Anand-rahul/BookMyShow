package com.java.bms.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "userData")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String mobile;
    @Column(name = "userName")
    public String userName;
    public String emailId;
    public String password;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public User(String mobile, String userName, String password) {
        this.mobile = mobile;
        this.userName = userName;
        this.password = password;
    }

    public User(){

    }
}
