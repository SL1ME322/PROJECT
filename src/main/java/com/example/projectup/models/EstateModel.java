package com.example.projectup.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Estate")
public class EstateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Estate")
    private Long id;

    @Column(name = "Ad_Name")
    private String adName;

    @Column(name = "Location")
    private String location;

    @Column(name = "Price")
    private int price;

    @Column(name = "Price_For_Month")
    private int priceForMonth;

    @Column(name = "Mortgage_Price")
    private int mortgagePrice;

    @Column(name = "Area")
    private int area;

    @Column(name = "House_Area")
    private int houseArea;

    @Column(name = "Metro_Station")
    private String metroStation;

    @Column(name = "Train_Station")
    private String trainStation;

    @Column(name = "Description")
    private String description;

    //@Column(name = "Ad_Date")
    //private Date adDate;
//
    //@Column(name = "Building_Date")
    //private Date buildingDate;

    @Column(name = "Status")
    private String status;

    @Column(name = "Estate_Rating")
    private Integer estateRating;

    @ManyToOne
    @JoinColumn(name = "User_ID")
    private UserModel user;
}