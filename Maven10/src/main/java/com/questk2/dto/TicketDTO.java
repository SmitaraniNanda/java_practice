package com.questk2.dto;

/**
 * Data Transfer Object (DTO) for Ticket entity.
 * This class is used to transfer ticket data between layers in the application.
 */
public class TicketDTO {

    private String title;
    private String description;
    private Long priority;
    private Long status;
    private Long createdBy;
    private Long assignedTo;
    private String ticketComment;

    /**
     * Gets the title of the ticket.
     * 
     * @return title of the ticket
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the ticket.
     * 
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description of the ticket.
     * 
     * @return description of the ticket
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the ticket.
     * 
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the priority ID of the ticket.
     * 
     * @return priority ID
     */
    public Long getPriority() {
        return priority;
    }

    /**
     * Sets the priority ID of the ticket.
     * 
     * @param priority the priority ID to set
     */
    public void setPriority(Long priority) {
        this.priority = priority;
    }

    /**
     * Gets the status ID of the ticket.
     * 
     * @return status ID
     */
    public Long getStatus() {
        return status;
    }

    /**
     * Sets the status ID of the ticket.
     * 
     * @param status the status ID to set
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    /**
     * Gets the ID of the user who created the ticket.
     * 
     * @return creator's user ID
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the ID of the user who created the ticket.
     * 
     * @param createdBy the creator's user ID to set
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the ID of the user to whom the ticket is assigned.
     * 
     * @return assignee's user ID
     */
    public Long getAssignedTo() {
        return assignedTo;
    }

    /**
     * Sets the ID of the user to whom the ticket is assigned.
     * 
     * @param assignedTo the assignee's user ID to set
     */
    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * Gets the comment added to the ticket.
     * 
     * @return ticket comment
     */
    public String getTicketComment() {
        return ticketComment;
    }

    /**
     * Sets the comment for the ticket.
     * 
     * @param ticketComment the ticket comment to set
     */
    public void setTicketComment(String ticketComment) {
        this.ticketComment = ticketComment;
    }

    /**
     * Checks whether the ticket is deleted.
     * 
     * @return false (default implementation)
     */
    public boolean isDeleted() {
        return false;
    }
}
