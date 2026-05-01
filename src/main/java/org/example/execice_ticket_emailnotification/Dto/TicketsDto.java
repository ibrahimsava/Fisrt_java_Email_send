package org.example.execice_ticket_emailnotification.Dto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketsDto {


    private String titre;
    private String description;
    private String emailClient;

}
