package com.questk2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.questk2.entity.Ticket;

/**
 * Repository interface for managing Ticket entities.
 * This interface provides CRUD operations for the Ticket table.
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // JpaRepository provides built-in methods like save(), findById(), findAll(), deleteById(), etc.
}
