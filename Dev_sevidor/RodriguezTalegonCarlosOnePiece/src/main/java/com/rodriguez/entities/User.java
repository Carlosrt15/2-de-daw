package com.rodriguez.entities;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_passwd")
    private String userPasswd;

    @Column(name = "user_email")
    private String userEmail;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Role> roles;

    // GETTERS Y SETTERS
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserPasswd() { return userPasswd; }
    public void setUserPasswd(String userPasswd) { this.userPasswd = userPasswd; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }
}