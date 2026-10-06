package com.example.backend.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String itemId;

    @Column(nullable = false, length = 150)
    private String itemName;

    @Column()
    @ManyToOne(cascade = { CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn()
}
