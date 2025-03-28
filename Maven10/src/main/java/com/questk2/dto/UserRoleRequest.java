package com.questk2.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object (DTO) for user role requests.
 * This class is used for transferring user and role data between client and server.
 */
public class UserRoleRequest {

    @Schema(required = true, description = "Username of the user")
    private String userName;

    @Schema(required = true, description = "Password of the user")
    private String password;

    @Schema(description = "Full name of the user")
    private String name;

    @Schema(description = "Email address of the user")
    private String email;

    @Schema(description = "Phone number of the user")
    private Double phoneNumber;

    @Schema(description = "Department of the user")
    private String department;

    @Schema(description = "Role assigned to the user (e.g.- ADMIN, USER)")
    private String role;

    /**
     * Gets the username.
     * @return the username
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the full name of the user.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the full name of the user.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email address of the user.
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number.
     * @return the phone number
     */
    public Double getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     * @param phoneNumber the phone number to set
     */
    public void setPhoneNumber(Double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the department of the user.
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department of the user.
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the role assigned to the user.
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role assigned to the user.
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
}
