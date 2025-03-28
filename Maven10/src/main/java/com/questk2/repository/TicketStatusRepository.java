package com.questk2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.questk2.entity.TicketStatus;

/**
 * Repository interface for managing TicketStatus entities.
 * This interface provides CRUD operations for the TicketStatus table.
 */
@Repository
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Long> {
    // JpaRepository provides built-in methods like save(), findById(), findAll(), deleteById(), etc.
}
