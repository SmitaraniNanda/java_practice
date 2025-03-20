package com.questk2.usermanagement.entity;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;


    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;
    @Column(name = "role_name", nullable = false)
    
    private String roleName;

    // Constructors
    public UserRole() {
    	
    }

    public UserRole(User user, String roleName) {
        this.user = user;
        this.roleName = roleName;
    }

    // Getters and Setters
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserRole [roleId=" + roleId + ", user=" + user.getId() + ", roleName=" + roleName + "]";
    }
}

