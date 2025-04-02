package com.questk2.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.questk2.dto.TicketDTO;
import com.questk2.entity.Ticket;
import com.questk2.entity.TicketPriority;
import com.questk2.entity.TicketStatus;
import com.questk2.entity.User;
import com.questk2.entity.UserRole;
import com.questk2.repository.TicketPriorityRepository;
import com.questk2.repository.TicketRepository;
import com.questk2.repository.TicketStatusRepository;
import com.questk2.repository.UserRepository;
import com.questk2.repository.UserRoleRepository;

/**
 * Service class for handling ticket-related operations.
 */
@Service
public class TicketService {
    
    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketPriorityRepository ticketPriorityRepository;

    @Autowired
    private TicketStatusRepository ticketStatusRepository;
    
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;


    /**
     * Retrieves a ticket by its ID.
     *
     * @param id The ID of the ticket to retrieve.
     * @return The Ticket object if found.
     * @throws RuntimeException If the ticket is not found.
     */
    public Ticket getTicketById(Long id) {
        try {
            logger.info("Fetching ticket with ID: {}", id);
            return ticketRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Ticket not found with ID: " + id));
        } catch (Exception e) {
            logger.error("Error fetching ticket with ID: {}", id, e);
            throw new RuntimeException("Failed to fetch ticket", e);
        }
    }

    /**
     * Retrieves all tickets based on the user's role.
     *
     * @param userId The ID of the user requesting tickets.
     * @return List of tickets. If the user is an admin, all tickets are returned.
     *         If the user is not an admin, only their tickets are returned.
     * @throws IllegalArgumentException If userId is null or the user role is not found.
     */
    public List<Ticket> getAllTickets(Long userId) {
        try {
            logger.info("Fetching all tickets for user ID: {}", userId);
            
            if (userId == null) {
                throw new IllegalArgumentException("User ID cannot be null");
            }
            
            Optional<List<UserRole>> userRole = userRoleRepository.findByUserId(userId);
            if (!userRole.isPresent()) {
                throw new IllegalArgumentException("User role not found for user ID: " + userId);
            }
            
            List<UserRole> roles = userRole.get();
            List<String> role = roles.stream().map(UserRole::getRole).collect(Collectors.toList());
            if (role.contains("Admin")) {
                logger.info("Admin role detected, fetching all tickets");
                return ticketRepository.findAll();
            } else {
                logger.info("User role detected, fetching user-specific tickets");
                return ticketRepository.findByUserId(userId);
            }
        } catch (Exception e) {
            logger.error("Error fetching tickets for user ID: {}", userId, e);
            throw new RuntimeException("Failed to fetch tickets", e);
        }
    }

    /**
     * Retrieves all available ticket priorities.
     *
     * @return List of all ticket priorities.
     * @throws RuntimeException If there is an error fetching priorities.
     */
    public List<TicketPriority> getAllPriorities() {
        try {
            logger.info("Fetching all ticket priorities");
            return ticketPriorityRepository.findAll();
        } catch (Exception e) {
            logger.error("Error fetching ticket priorities", e);
            throw new RuntimeException("Failed to fetch ticket priorities", e);
        }
    }

    /**
     * Retrieves all available ticket statuses.
     *
     * @return List of all ticket statuses.
     * @throws RuntimeException If there is an error fetching statuses.
     */
    public List<TicketStatus> getAllStatus() {
        try {
            logger.info("Fetching all ticket statuses");
            return ticketStatusRepository.findAll();
        } catch (Exception e) {
            logger.error("Error fetching ticket statuses", e);
            throw new RuntimeException("Failed to fetch ticket statuses", e);
        }
    }


    /**
     * Marks a ticket as deleted by setting its deleted flag.
     *
     * @param id The ID of the ticket to delete.
     * @throws RuntimeException If the ticket is not found or fails to delete.
     */
    @Transactional
    public void removeTicket(Long id) {
        try {
            logger.info("Attempting to delete ticket with ID: {}", id);
            Optional<Ticket> existsById = ticketRepository.findById(id);
            if (!existsById.isPresent()) {
                logger.warn("Ticket with ID {} not found for deletion", id);
                throw new RuntimeException("Ticket not found with ID: " + id);
            }
            Ticket ticket = existsById.get();
            ticket.setDeleted(true);
            ticket.setDeleteDate(LocalDateTime.now());
            ticketRepository.save(ticket);
            logger.info("Successfully deleted ticket with ID: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting ticket with ID: {}", id, e);
            throw new RuntimeException("Failed to delete ticket", e);
        }
    }

    /**
     * Updates an existing ticket with new data.
     *
     * @param id The ID of the ticket to update.
     * @param ticketDto The new ticket data.
     * @return The updated Ticket object.
     * @throws RuntimeException If the ticket, priority, or status is not found.
     */
    @Transactional
    public Ticket updateTicket(Long id, TicketDTO ticketdto) {
        try {
            logger.info("Updating ticket with ID: {}", id);
            return ticketRepository.findById(id).map(existingTicket -> {
                existingTicket.setTitle(ticketdto.getTitle());
                existingTicket.setDescription(ticketdto.getDescription());

                TicketPriority priority = ticketPriorityRepository.findById(ticketdto.getPriority().getId())
                        .orElseThrow(() -> new RuntimeException("Priority not found"));

                TicketStatus status = ticketStatusRepository.findById(ticketdto.getStatus().getId())
                        .orElseThrow(() -> new RuntimeException("Status not found"));

                existingTicket.setPriority(priority);
                existingTicket.setStatus(status);
                existingTicket.setModifiedDate(LocalDateTime.now());
                return ticketRepository.save(existingTicket);
            }).orElseThrow(() -> new RuntimeException("Ticket not found with ID: " + id));
        } catch (Exception e) {
            logger.error("Error updating ticket with ID: {}", id, e);
            throw new RuntimeException("Failed to update ticket", e);
        }
    }

    /**
     * Creates a new ticket in the system.
     *
     * @param ticketDto The data transfer object containing ticket details.
     * @return The created Ticket object.
     * @throws RuntimeException If the priority, status, or user is not found.
     */
    @Transactional
    public Ticket createTicket(TicketDTO ticketDto) {
        String title = ticketDto.getTitle();
        try {
            logger.info("Creating a new ticket: {}", title);

            TicketPriority priority = ticketPriorityRepository.findById(ticketDto.getPriority().getId())
                .orElseThrow(() -> new RuntimeException("Priority not found"));

            TicketStatus status = ticketStatusRepository.findById(ticketDto.getStatus().getId())
                .orElseThrow(() -> new RuntimeException("Status not found"));

            User createdBy = userRepository.findById(ticketDto.getCreatedBy().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
            
            User assignedTo = userRepository.findById(ticketDto.getAssignedTo().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            Ticket ticket = new Ticket();
            ticket.setTitle(title);
            ticket.setDescription(ticketDto.getDescription());
            ticket.setPriority(priority);
            ticket.setStatus(status);
            ticket.setCreatedBy(createdBy);
            ticket.setCreatedDate(LocalDateTime.now());
            ticket.setModifiedDate(LocalDateTime.now());
            ticket.setDeleted(false);
            ticket.setAssignedTo(assignedTo);

            return ticketRepository.save(ticket);
        } catch (Exception e) {
            logger.error("Error while creating ticket", e);
            throw new RuntimeException("Failed to create ticket", e);
        }
    }
}
