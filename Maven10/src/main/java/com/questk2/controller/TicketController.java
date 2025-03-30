package com.questk2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.questk2.dto.TicketDTO;
import com.questk2.entity.Ticket;
import com.questk2.entity.TicketPriority;
import com.questk2.entity.TicketStatus;
import com.questk2.service.TicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST Controller for managing Tickets.
 */
@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@Tag(name = "Ticket Controller", description = "APIs for managing tickets, priorities, and statuses.")
public class TicketController {
    Logger logger = LoggerFactory.getLogger(TicketController.class);

    @Autowired
    private TicketService ticketService;

    /**
     * Retrieves all tickets.
     */
    @Operation(summary = "Retrieve all tickets", description = "Fetches all ticket records from the database.")
    @ApiResponse(responseCode = "200", description = "Tickets retrieved successfully")
    @GetMapping("/tickets/{userId}")
    public ResponseEntity<?> getAllTickets(@PathVariable Long userId) {
        if (userId == null) {
            return ResponseEntity.badRequest().body("User ID cannot be null");
        }
        
        logger.info("Fetching all tickets for user ID: {}", userId);
        
        List<Ticket> tickets;
        try {
            tickets = ticketService.getAllTickets(userId);
            return ResponseEntity.ok(tickets); 
        } catch (Exception e) {
            logger.error("Error while fetching tickets", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch tickets");
        }
    }


    /**
     * Retrieves all ticket priorities.
     */
    @Operation(summary = "Retrieve ticket priorities", description = "Fetches all ticket priority records.")
    @ApiResponse(responseCode = "200", description = "Priorities retrieved successfully")
    @GetMapping("/ticketPriority")
    public ResponseEntity<?> getAllPriorities() {
        logger.info("Fetching all ticket priorities");
        try {
            List<TicketPriority> priorities = ticketService.getAllPriorities();
            return ResponseEntity.ok(priorities);
        } catch (Exception e) {
            logger.error("Error while fetching ticket priorities", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch ticket priorities");
        }
    }

    /**
     * Retrieves all ticket statuses.
     */
    @Operation(summary = "Retrieve ticket status", description = "Fetches all ticket status records.")
    @ApiResponse(responseCode = "200", description = "Status retrieved successfully")
    @GetMapping("/ticketStatus")
    public ResponseEntity<?> getAllStatus() {
        logger.info("Fetching all ticket statuses");
        try {
            List<TicketStatus> statuses = ticketService.getAllStatus();
            return ResponseEntity.ok(statuses);
        } catch (Exception e) {
            logger.error("Error while fetching ticket statuses", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch ticket statuses");
        }
    }

    /**
     * Creates a new ticket.
     */
    @Operation(summary = "Create a new ticket", description = "Adds a new ticket with the given details.")
    @ApiResponse(responseCode = "201", description = "Ticket created successfully")
    @PostMapping("/tickets/add")
    public ResponseEntity<?> createTicket(@RequestBody TicketDTO ticket) {
        logger.info("Creating new ticket: {}", ticket.getTitle());
        try {
            if (ticket == null || ticket.getTitle() == null || ticket.getTitle().isEmpty() || ticket.getDescription() == null || ticket.getDescription().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ticket details");
            }
            ticketService.createTicket(ticket);
            return ResponseEntity.status(HttpStatus.CREATED).body("Ticket created successfully");
        } catch (Exception e) {
            logger.error("Error while creating ticket", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create ticket");
        }
    }

    /**
     * Updates an existing ticket.
     */
    @Operation(summary = "Update an existing ticket", description = "Modifies an existing ticket based on its ID.")
    @ApiResponse(responseCode = "200", description = "Ticket updated successfully")
    @PutMapping("/tickets/update/{id}")
    public ResponseEntity<?> updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketdto) {
        logger.info("Updating ticket with ID: {}", id);
        try {
            if (ticketdto == null || ticketdto.getTitle() == null || ticketdto.getTitle().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ticket details");
            }
            Ticket updatedTicket = ticketService.updateTicket(id, ticketdto);
            return ResponseEntity.ok(updatedTicket);
        } catch (Exception e) {
            logger.error("Error while updating ticket", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update ticket");
        }
    }

    /**
     * Deletes a ticket by ID.
     */
    @Operation(summary = "Delete a ticket", description = "Removes a ticket record by its ID.")
    @ApiResponse(responseCode = "200", description = "Ticket deleted successfully")
    @DeleteMapping("/tickets/delete/{id}")
    public ResponseEntity<?> removeTicket(@PathVariable Long id) {
        logger.info("Deleting ticket with ID: {}", id);
        try {
            ticketService.removeTicket(id);
            return ResponseEntity.ok("Ticket deleted successfully");
        } catch (Exception e) {
            logger.error("Error while deleting ticket", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete ticket");
        }
    }
} 