package com.southsideapparel.southsideapparel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "payments")
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentType;
    private String paymentStatus;
    private LocalDateTime paymentDate;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}