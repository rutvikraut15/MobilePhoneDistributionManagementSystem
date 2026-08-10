package com.mobile.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ASSIGNMENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EXECUTIVE_ID")
    private Executive executive;

    @ManyToOne
    @JoinColumn(name = "PHONE_ID")
    private Phone phone;

    @Column(name = "ASSIGNED_DATE")
    private LocalDate assignedDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    @Column(name = "STATUS")
    private String status;
}