package com.example.projectup.models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Declined_Ad")
public class DeclinedAdModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Declined_Ad")
    private Long id;

    @Column(name = "Reason")
    private String reason;

    @ManyToOne
    @JoinColumn(name = "Estate_ID")
    private EstateModel estate;

    @ManyToOne
    @JoinColumn(name = "Moderator_ID")
    private UserModel moderator;
}
