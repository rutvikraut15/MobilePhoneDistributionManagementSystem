package com.mobile.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PHONE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PHONE_NAME", nullable = false)
    private String phoneName;

    @Column(name = "STATUS")
    private String status;
    
    
    
}