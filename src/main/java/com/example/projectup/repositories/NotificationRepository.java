package com.example.projectup.repositories;

import com.example.projectup.models.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NotificationRepository extends JpaRepository<NotificationModel, Long> {
     NotificationModel findById(int libraryId);
     //List<NotificationModel> findLibraryModelByNameContainingIgnoreCase(String name);
}
