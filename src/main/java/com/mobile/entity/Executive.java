package com.mobile.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EXECUTIVE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Executive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRESENT_STATUS")
    private String presentStatus;

}