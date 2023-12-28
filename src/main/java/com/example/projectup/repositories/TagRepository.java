package com.example.projectup.repositories;


import com.example.projectup.models.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<TagModel, Long> {
   TagModel findById(int id);
   // List<TagRepository> findLibrarianRepositoriesByName(String name);
}
