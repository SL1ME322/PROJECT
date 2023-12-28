package com.example.projectup.repositories;

import com.example.projectup.models.UserHistoryWatchedModel;
import com.example.projectup.models.UserReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryWatchedRepository extends JpaRepository<UserHistoryWatchedModel, Long> {
}
