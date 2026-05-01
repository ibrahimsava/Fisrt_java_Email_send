package org.example.execice_ticket_emailnotification.Enity;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Tickets {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String titre;
    @Column(nullable=false)
    private String description;
    @Column(nullable=false)
    private String emailClient;

}
