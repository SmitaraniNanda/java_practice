package com.questk2.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.questk2.dto.TicketDTO;
import com.questk2.entity.Ticket;
import com.questk2.entity.TicketPriority;
import com.questk2.entity.TicketStatus;
import com.questk2.entity.User;
import com.questk2.repository.TicketPriorityRepository;
import com.questk2.repository.TicketRepository;
import com.questk2.repository.TicketStatusRepository;
import com.questk2.repository.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST Controller for managing Tickets.
 * Provides APIs for creating, updating, retrieving, and deleting tickets.
 */
@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@Tag(name = "Ticket Controller", description = "APIs for managing tickets, priorities, and statuses.")
public class TicketController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketPriorityRepository ticketPriorityRepository;

    @Autowired
    private TicketStatusRepository ticketStatusRepository;

    /**
     * Retrieves all tickets from the database.
     *
     * @return List of all tickets.
     */
    @Operation(summary = "Retrieve all tickets", description = "Fetches all ticket records from the database.")
    @ApiResponse(responseCode = "200", description = "Tickets retrieved successfully")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    /**
     * Retrieves all ticket priorities.
     *
     * @return List of all ticket priorities.
     */
    @Operation(summary = "Retrieve ticket priorities", description = "Fetches all ticket priority records.")
    @ApiResponse(responseCode = "200", description = "Priorities retrieved successfully")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/ticketPriority")
    public List<TicketPriority> getAllPriorities() {
        return ticketPriorityRepository.findAll();
    }

    /**
     * Retrieves all ticket statuses.
     *
     * @return List of all ticket statuses.
     */
    @Operation(summary = "Retrieve ticket status", description = "Fetches all ticket status records.")
    @ApiResponse(responseCode = "200", description = "Status retrieved successfully")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/ticketStatus")
    public List<TicketStatus> getAllStatus() {
        return ticketStatusRepository.findAll();
    }

    /**
     * Creates a new ticket.
     *
     * @param ticketDTO Data Transfer Object containing ticket details.
     */
    @Operation(summary = "Create a new ticket", description = "Adds a new ticket with the given details.")
    @ApiResponse(responseCode = "201", description = "Ticket created successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @PostMapping("/tickets/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createTicket(@RequestBody TicketDTO ticketDTO) {
        // Fetch related entities based on IDs
        TicketPriority priority = ticketPriorityRepository.findById(ticketDTO.getPriority())
                .orElseThrow(() -> new RuntimeException("Priority not found"));
        TicketStatus status = ticketStatusRepository.findById(ticketDTO.getStatus())
                .orElseThrow(() -> new RuntimeException("Status not found"));
        User createdBy = userRepository.findById(ticketDTO.getCreatedBy())
                .orElseThrow(() -> new RuntimeException("User not found"));
        User assignedTo = userRepository.findById(ticketDTO.getAssignedTo())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create and save the ticket entity
        Ticket ticket = new Ticket();
        ticket.setTitle(ticketDTO.getTitle());
        ticket.setDescription(ticketDTO.getDescription());
        ticket.setPriority(priority);
        ticket.setStatus(status);
        ticket.setCreatedBy(createdBy);
        ticket.setAssignedTo(assignedTo);
        ticket.setTicketComment(ticketDTO.getTicketComment());
        ticket.setModifiedDate(LocalDateTime.now());
        ticket.setDeleted(false);

        ticketRepository.save(ticket);
    }

    /**
     * Updates an existing ticket by its ID.
     *
     * @param id        ID of the ticket to be updated.
     * @param ticketDTO DTO containing updated ticket details.
     * @return Updated ticket entity.
     */
    @Operation(summary = "Update an existing ticket", description = "Modifies an existing ticket based on its ID.")
    @ApiResponse(responseCode = "200", description = "Ticket updated successfully")
    @ApiResponse(responseCode = "404", description = "Ticket not found")
    @PutMapping("/tickets/update/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        return ticketRepository.findById(id).map(ticket -> {
            // Fetch related entities
            TicketPriority priority = ticketPriorityRepository.findById(ticketDTO.getPriority())
                    .orElseThrow(() -> new RuntimeException("Priority not found"));
            TicketStatus status = ticketStatusRepository.findById(ticketDTO.getStatus())
                    .orElseThrow(() -> new RuntimeException("Status not found"));
            User createdBy = userRepository.findById(ticketDTO.getCreatedBy())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            User assignedTo = userRepository.findById(ticketDTO.getAssignedTo())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Update ticket details
            ticket.setTitle(ticketDTO.getTitle());
            ticket.setDescription(ticketDTO.getDescription());
            ticket.setPriority(priority);
            ticket.setStatus(status);
            ticket.setCreatedBy(createdBy);
            ticket.setAssignedTo(assignedTo);
            ticket.setTicketComment(ticketDTO.getTicketComment());
            ticket.setModifiedDate(LocalDateTime.now());
            ticket.setDeleted(ticketDTO.isDeleted());

            // Set delete date if ticket is marked as deleted
            if (ticketDTO.isDeleted()) {
                ticket.setDeleteDate(LocalDateTime.now());
            } else {
                ticket.setDeleteDate(null);
            }

            return ticketRepository.save(ticket);
        }).orElseThrow(() -> new RuntimeException("Ticket not found: " + id));
    }

    /**
     * Deletes a ticket by its ID.
     *
     * @param id ID of the ticket to be deleted.
     */
    @Operation(summary = "Delete a ticket", description = "Removes a ticket record by its ID.")
    @ApiResponse(responseCode = "200", description = "Ticket deleted successfully")
    @ApiResponse(responseCode = "404", description = "Ticket not found")
    @DeleteMapping("/tickets/delete/{id}")
    public void removeTicket(@PathVariable Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticketRepository.delete(ticket);
    }
}
