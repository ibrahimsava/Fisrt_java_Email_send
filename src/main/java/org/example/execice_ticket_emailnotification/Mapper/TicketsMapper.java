package org.example.execice_ticket_emailnotification.Mapper;

import org.example.execice_ticket_emailnotification.Dto.TicketsDto;
import org.example.execice_ticket_emailnotification.Enity.Tickets;
import org.springframework.stereotype.Component;

@Component // Indispensable pour pouvoir l'injecter dans le Service
public class TicketsMapper {

    // Convertit DTO -> Entité
    public Tickets toEntity(TicketsDto ticketsDto) {
        if (ticketsDto == null) return null;

        return Tickets.builder()
                .description(ticketsDto.getDescription())
                .emailClient(ticketsDto.getEmailClient())
                .titre(ticketsDto.getTitre())
                .build();
    }

    // Convertit Entité -> DTO
    public TicketsDto toDto(Tickets tickets) {
        if (tickets == null) return null;

        return TicketsDto.builder()
                .description(tickets.getDescription())
                .emailClient(tickets.getEmailClient())
                .titre(tickets.getTitre())
                .build();
    }
}
