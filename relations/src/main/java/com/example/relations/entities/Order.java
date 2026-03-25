package com.example.relations.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant moment;

    private OrderStatus status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private User client;
//
//    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
//    private Payment payment;

//    @OneToMany(mappedBy = "id.order")
//    private Set<OrderItem> items = new HashSet<>();

}
