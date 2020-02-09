package com.koisoftware.monet.client.record;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sb90320 on 11/27/2014.
 */
public class UserRecord implements Serializable {
    private static final long serialVersionUID = 6482911498605717640L;
    private int userId;
    private String login;
    private String password;
    private String email;
    private String displayName;
    private String role;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String postcode;
    private String loginSid;
    private Date loginLast;
    private String enabled;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int pp_userId) {
        this.userId = pp_userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String pp_login) {
        this.login = pp_login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pp_password) {
        this.password = pp_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String pp_email) {
        this.email = pp_email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String pp_displayName) {
        this.displayName = pp_displayName;
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

    public void setFirstName(String pp_firstName) {
        this.firstName = pp_firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String pp_lastName) {
        this.lastName = pp_lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String pp_address) {
        this.address = pp_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String pp_city) {
        this.city = pp_city;
    }

    public String getState() {
        return state;
    }

    public void setState(String pp_state) {
        this.state = pp_state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String pp_postcode) {
        this.postcode = pp_postcode;
    }

    public String getLoginSid() {
        return loginSid;
    }

    public void setLoginSid(String pp_loginSid) {
        this.loginSid = pp_loginSid;
    }

    public Date getLoginLast() {
        return loginLast;
    }

    public void setLoginLast(Date pp_loginLast) {
        this.loginLast = pp_loginLast;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String pp_enabled) {
        this.enabled = pp_enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRecord that = (UserRecord) o;

        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userId;
    }

    @Override
    public String toString() {
        return "UserRecord{" +
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
