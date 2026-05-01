package org.example.execice_ticket_emailnotification.Controller;


import org.example.execice_ticket_emailnotification.Dto.TicketsDto;
import org.example.execice_ticket_emailnotification.Enity.Tickets;
import org.example.execice_ticket_emailnotification.Repository.TicketsRepository;
import org.example.execice_ticket_emailnotification.Services.TicketsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TicketsController {

    private final TicketsServices ticketsServices;

    public TicketsController(TicketsServices ticketsServices) {
        this.ticketsServices = ticketsServices;
    }

    @PostMapping("/post")
    public TicketsDto save(@RequestBody TicketsDto ticketsDto) {
        return ticketsServices.createTicket(ticketsDto);
    }
}
