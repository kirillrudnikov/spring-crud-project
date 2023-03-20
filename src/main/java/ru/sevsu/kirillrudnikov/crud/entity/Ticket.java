package ru.sevsu.kirillrudnikov.crud.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(
        name = "app_ticket"
)
@Table(
        name = "app_ticket"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @SequenceGenerator(
            name = "app_ticket_sequence",
            sequenceName = "app_ticket_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_ticket_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "tariff"
    )
    private String tariff;

    @Column(
            name = "arrived_at"
    )
    private LocalDateTime arrivedAt;

    @Column(
            name = "departured_at"
    )
    private LocalDateTime departuredAt;

    @Column(
            name = "is_actual"
    )
    private Boolean isActual;

    @ManyToOne
    @JoinColumn(
            name = "linked_user_id"
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "linked_car_id"
    )
    private Car car;

}