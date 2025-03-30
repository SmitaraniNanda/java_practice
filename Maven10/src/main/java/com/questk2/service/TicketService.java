package com.questk2.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
     * Creates a new ticket.
     */
    @Transactional
    public Ticket createTicket(String title, String description, Long priorityId, Long statusId, Long createdById) {
        try {
            logger.info("Creating a new ticket: {}", title);

            TicketPriority priority = ticketPriorityRepository.findById(priorityId)
                .orElseThrow(() -> new RuntimeException("Priority not found"));

            TicketStatus status = ticketStatusRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException("Status not found"));

            User createdBy = userRepository.findById(createdById)
                .orElseThrow(() -> new RuntimeException("User not found"));

            Ticket ticket = new Ticket();
            ticket.setTitle(title);
            ticket.setDescription(description);
            ticket.setPriority(priority);
            ticket.setStatus(status);
            ticket.setCreatedBy(createdBy);
            ticket.setCreatedDate(LocalDateTime.now());
            ticket.setModifiedDate(LocalDateTime.now());
            ticket.setDeleted(false);

            return ticketRepository.save(ticket);
        } catch (Exception e) {
            logger.error("Error while creating ticket", e);
            throw new RuntimeException("Failed to create ticket", e);
        }
    }

    /**
     * Retrieves a ticket by ID.
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
     * Retrieves all tickets.
     */
    public List<Ticket> getAllTickets(Long userId) {
        try {
            logger.info("Fetching all tickets for user ID: {}", userId);
            
            if (userId == null) {
                throw new IllegalArgumentException("User ID cannot be null");
            }
            
            Optional<UserRole> userRole = userRoleRepository.findByUserId(userId);
            if (!userRole.isPresent()) {
                throw new IllegalArgumentException("User role not found for user ID: " + userId);
            }
            
            String role = userRole.get().getRole();
            if ("admin".equalsIgnoreCase(role)) {
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
     * Retrieves all ticket priorities.
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
     * Retrieves all ticket statuses.
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
     * Updates an existing ticket.
     */
    @Transactional
    public Ticket updateTicket(Long id, String title, String description, Long priorityId, Long statusId) {
        try {
            logger.info("Updating ticket with ID: {}", id);
            return ticketRepository.findById(id).map(existingTicket -> {
                existingTicket.setTitle(title);
                existingTicket.setDescription(description);

                TicketPriority priority = ticketPriorityRepository.findById(priorityId)
                        .orElseThrow(() -> new RuntimeException("Priority not found"));

                TicketStatus status = ticketStatusRepository.findById(statusId)
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
     * Deletes a ticket by ID.
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

	public Ticket updateTicket(Long id, TicketDTO ticketdto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createTicket(TicketDTO ticket) {
		// TODO Auto-generated method stub
		
	}
}
