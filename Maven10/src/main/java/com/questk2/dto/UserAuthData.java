package com.questk2.dto;

import java.io.Serializable;

/**
 * DTO for user authentication data.
 * This class holds the username and password required for authentication.
 */
public class UserAuthData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName; // Username of the user
    private String pwd; // Password of the user

    /**
     * Gets the username.
     * @return the username of the user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username.
     * @param userName the username to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password.
     * @return the password of the user
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Sets the password.
     * @param pwd the password to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
