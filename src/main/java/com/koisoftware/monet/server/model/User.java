package com.koisoftware.monet.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 8851919592911267916L;

    public User() {
        super();
    }

    public User(String login, String password, String enabled) {
        this.login = login;
        this.password = password;
        this.enabled = enabled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", unique = true, nullable = false)
    private int userId;
    @Column(name = "login", nullable = false, length = 80)
    private String login;
    @Column(name = "password", nullable = false, length = 40)
    private String password;
    @Column(name = "email", nullable = false, length = 80)
    private String email;
    @Column(name = "displayName", nullable = false, length = 50)
    private String displayName;
    @Column(name = "role", nullable = true, length = 50)
    private String role;
    @Column(name = "firstName", nullable = true, length = 50)
    private String firstName;
    @Column(name = "lastName", nullable = true, length = 50)
    private String lastName;
    @Column(name = "address", nullable = true, length = 50)
    private String address;
    @Column(name = "city", nullable = true, length = 50)
    private String city;
    @Column(name = "state", nullable = true, length = 50)
    private String state;
    @Column(name = "postcode", nullable = true, length = 50)
    private String postcode;
    @Column(name = "loginSid", nullable = true, length = 50)
    private String loginSid;
    @Column(name = "loginLast", nullable = true, length = 50)
    private Date loginLast;
    @Column(name = "enabled", nullable = true, length = 50)
    private String enabled;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLoginSid() {
        return loginSid;
    }

    public void setLoginSid(String loginSid) {
        this.loginSid = loginSid;
    }

    public Date getLoginLast() {
        return loginLast;
    }

    public void setLoginLast(Date loginLast) {
        this.loginLast = loginLast;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postcode='" + postcode + '\'' +
                ", loginSid='" + loginSid + '\'' +
                ", loginLast=" + loginLast +
                ", enabled='" + enabled + '\'' +
                '}';
    }
}
