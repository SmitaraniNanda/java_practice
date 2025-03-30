package com.questk2.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "priority_id", nullable = false)
    private TicketPriority priority;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false, updatable = false)
    private User createdBy;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "assigned_to", nullable = true)
    private User assignedTo;

    @Column(name = "ticket_comment", columnDefinition = "TEXT", nullable = true)
    private String ticketComment;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;

    @Column(name = "delete_date", nullable = true)
    private LocalDateTime deleteDate;

    // Auto-set timestamps
    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now(); // Ensure modified date is set initially
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifiedDate = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getTicketComment() {
        return ticketComment;
    }

    public void setTicketComment(String ticketComment) {
        this.ticketComment = ticketComment;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", title=" + title + ", description=" + description + ", priority=" + priority
                + ", status=" + status + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedDate="
                + modifiedDate + ", assignedTo=" + assignedTo + ", ticketComment=" + ticketComment + ", deleted="
                + deleted + ", deleteDate=" + deleteDate + "]";
    }
}
