package com.statementlabs.parking_api.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate;
    private Integer spotId;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    private Integer amount;
    private String status;

    public TicketEntity() {}

    // getters e setters
}
