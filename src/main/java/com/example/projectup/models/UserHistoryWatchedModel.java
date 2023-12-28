package com.example.projectup.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User_History_Watched")
public class UserHistoryWatchedModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_User_History_Watched")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Estate_ID")
    private EstateModel estate;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private UserModel user;
}