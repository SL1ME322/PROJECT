package com.example.projectup.repositories;

import com.example.projectup.models.WatchLaterEstatesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchLaterEstatesRepository
        extends JpaRepository<WatchLaterEstatesModel, Long> {
}
