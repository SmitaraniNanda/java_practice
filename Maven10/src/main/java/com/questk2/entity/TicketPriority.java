package com.questk2.entity;

import javax.persistence.*;

@Entity
@Table(name = "ticket_priority")
public class TicketPriority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    // Default Constructor
    public TicketPriority() {
    }

    // Parameterized Constructor
    public TicketPriority(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ToString Method
    @Override
    public String toString() {
        return "TicketPriority [id=" + id + ", description=" + description + "]";
    }
}
