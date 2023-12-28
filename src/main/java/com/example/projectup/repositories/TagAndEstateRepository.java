package com.example.projectup.repositories;

import com.example.projectup.models.TagAndEstateModel;
import com.example.projectup.models.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagAndEstateRepository extends JpaRepository<TagAndEstateModel, Long> {
}
