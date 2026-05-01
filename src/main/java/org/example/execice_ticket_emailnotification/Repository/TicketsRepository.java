package org.example.execice_ticket_emailnotification.Repository;

import org.example.execice_ticket_emailnotification.Enity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository  extends JpaRepository<Tickets, Long> {

}
