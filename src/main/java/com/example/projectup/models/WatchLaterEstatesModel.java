package com.example.projectup.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Watch_Later_Estates")
public class WatchLaterEstatesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Watch_Later_Estates")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Estate_ID")
    private EstateModel estate;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private UserModel user;
}
