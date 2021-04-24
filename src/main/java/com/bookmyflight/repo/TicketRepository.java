package com.bookmyflight.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyflight.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
