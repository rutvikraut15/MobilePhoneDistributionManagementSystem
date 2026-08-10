package com.mobile.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "WAITING_LIST")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WaitingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EXECUTIVE_ID")
    private Executive executive;

    @Column(name = "WAITING_DATE")
    private LocalDate waitingDate;

    @Column(name = "REASON")
    private String reason;

}