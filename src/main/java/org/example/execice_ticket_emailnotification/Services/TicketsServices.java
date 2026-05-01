package org.example.execice_ticket_emailnotification.Services;
import org.example.execice_ticket_emailnotification.Dto.TicketsDto;
import org.example.execice_ticket_emailnotification.Enity.Tickets;
import org.example.execice_ticket_emailnotification.Mapper.TicketsMapper;
import org.example.execice_ticket_emailnotification.Repository.TicketsRepository;
import org.example.execice_ticket_emailnotification.Utils.EmailTickets;
import org.springframework.stereotype.Service;
@Service
public class TicketsServices {

    private final TicketsRepository ticketsRepository;
    private final TicketsMapper ticketsMapper;
    // 1. Déclarer le composant EmailTickets
    private final EmailTickets emailTickets;

    // 2. Ajouter EmailTickets dans le constructeur pour l'injection
    public TicketsServices(TicketsRepository ticketsRepository,
                           TicketsMapper ticketsMapper,
                           EmailTickets emailTickets) {
        this.ticketsRepository = ticketsRepository;
        this.ticketsMapper = ticketsMapper;
        this.emailTickets = emailTickets;
    }

    public TicketsDto createTicket(TicketsDto ticketsDto) {
        Tickets ticketEntity = ticketsMapper.toEntity(ticketsDto);
        Tickets savedTicket = ticketsRepository.save(ticketEntity);

        try {
            this.emailTickets.sendWelcomeEmail(savedTicket.getEmailClient(), savedTicket.getTitre());
        } catch (Exception e) {
            // Mail échoué mais ticket sauvegardé
            System.err.println("Erreur envoi mail : " + e.getMessage());
        }

        return ticketsMapper.toDto(savedTicket);
    }
}



