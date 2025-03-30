package com.questk2.dto;

import java.time.LocalDateTime;

import com.questk2.entity.TicketPriority;
import com.questk2.entity.TicketStatus;

public class TicketDTO {
    private String title;
    private String description;
    private TicketPriority priority;
    private TicketStatus status;

    // Getters and Setters
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

	public LocalDateTime getModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}
}
