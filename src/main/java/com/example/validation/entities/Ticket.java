package com.example.validation.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hall")
    private String hall;

    @Column(name = "datetime")
    private LocalDateTime dateTime;

    @Column(name = "seat")
    private String seat;

    @Column(name = "price")
    private Float price;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "film_name")
    private String filmName;

    @Column(nullable = false)
    private Boolean validated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "validated_by", referencedColumnName = "worker_id")
    private StaffWorker validatedBy;

    @Column(name = "validated_at")
    private LocalDateTime validatedAt;

    @Column(name = "additional_services")
    private String additionalServices;

    public Boolean isValidated() {
        return validated;
    }
}
