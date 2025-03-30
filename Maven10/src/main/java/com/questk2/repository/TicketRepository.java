package com.questk2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.questk2.entity.Ticket;
import com.questk2.entity.User;

/**
 * Repository interface for managing Ticket entities.
 * This interface provides CRUD operations for the Ticket table.
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // JpaRepository provides built-in methods like save(), findById(), findAll(), deleteById(), etc.
	//List<Ticket> findByUserId(Long userId); // where isDete is 'N'

	 List<Ticket> findByCreatedBy(User createdBy);

	    @Query("SELECT t FROM Ticket t WHERE t.createdBy.id = :userId")
    List<Ticket> findByUserId(@Param("userId") Long userId);
	    /**
	     * Finds tickets for a specific user that are not deleted.
	     */
	    List<Ticket> findByCreatedByIdAndDeletedFalse(Long userId);

	    /**
	     * Finds all tickets that are not deleted.
	     */
	    List<Ticket> findByDeletedFalse();

	
}
