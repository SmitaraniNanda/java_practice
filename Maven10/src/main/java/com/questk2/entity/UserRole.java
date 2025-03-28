package com.questk2.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity class representing the User Role.
 * This entity is used to define roles assigned to users.
 */
@Entity
@Table(name = "user_role")
public class UserRole {

    /** Primary key for UserRole table */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** User associated with this role */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference // Prevents infinite recursion in bidirectional JSON serialization
    private User user;

    /** Role assigned to the user */
    @Column(name = "role", nullable = false)
    private String role;

    /**
     * Default constructor.
     */
    public UserRole() {
    }

    /**
     * Parameterized constructor.
     * 
     * @param user The user associated with this role.
     * @param role The role assigned to the user.
     */
    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }

    /** @return The ID of the user role */
    public Long getId() {
        return id;
    }

    /** @param id The ID to set */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return The assigned role */
    public String getRole() {
        return role;
    }

    /** @param role The role to set */
    public void setRole(String role) {
        this.role = role;
    }

    /** @return The user associated with this role */
    public User getUser() {
        return user;
    }

    /** @param user The user to set */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Returns a string representation of the UserRole object.
     */
    @Override
    public String toString() {
        return "UserRole [id=" + id + ", user=" + user + ", role=" + role + "]";
    }
}
