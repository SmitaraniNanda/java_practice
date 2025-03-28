package com.questk2.entity;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_department")
    private String department;

    @Column(name = "user_number")
    private Double phoneNumber;

    @Column(name = "user_password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<UserRole> roles;

    /**
     * Default constructor.
     */
    public User() {}

    /**
     * Parameterized constructor to initialize User attributes.
     * 
     * @param name        User's full name
     * @param userName    Unique username
     * @param email       Email address
     * @param department  Department of the user
     * @param phoneNumber Contact number
     * @param password    User password
     */
    public User(String name, String userName, String email, String department, Double phoneNumber, String password) {
        super();
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    /**
     * Gets the ID of the user.
     * @return User ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     * @param id User ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the user.
     * @return User name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * @param name User name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the user.
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     * @param email Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the department of the user.
     * @return Department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department of the user.
     * @param department Department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the phone number of the user.
     * @return Phone number
     */
    public Double getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the user.
     * @param phoneNumber Phone number
     */
    public void setPhoneNumber(Double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the password of the user.
     * @return Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * @param password Password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the roles assigned to the user.
     * @return List of roles
     */
    public List<UserRole> getRoles() {
        return roles;
    }

    /**
     * Sets the roles assigned to the user.
     * @param roles List of roles
     */
    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    /**
     * Gets the username.
     * @return Username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username.
     * @param userName Username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Returns a string representation of the User object.
     * @return User details as a string
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", email=" + email + ", department="
                + department + ", phoneNumber=" + phoneNumber + ", password=" + password + ", roles=" + roles + "]";
    }
}
