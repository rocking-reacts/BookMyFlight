package com.bookmyflight.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyflight.entity.Ticket;
import com.bookmyflight.entity.User;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	List<Ticket> findByUser(User user);
}
