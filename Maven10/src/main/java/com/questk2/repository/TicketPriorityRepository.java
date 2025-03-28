package com.questk2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.questk2.entity.TicketPriority;

/**
 * Repository interface for managing TicketPriority entities.
 * This interface provides CRUD operations for the TicketPriority table.
 */
@Repository
public interface TicketPriorityRepository extends JpaRepository<TicketPriority, Long> {
    // JpaRepository provides built-in methods like save(), findById(), findAll(), deleteById(), etc.
}
