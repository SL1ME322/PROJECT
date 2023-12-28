package com.example.projectup.repositories;


import com.example.projectup.models.DeclinedAdModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeclinedAdRepository extends JpaRepository<DeclinedAdModel, Integer> {
    //DeclinedAdModel findDeclinedAdModelByEstate(int id);
    //List<BookModel> findBookModelByNameContainingIgnoreCase(String name);
}
