package com.example.projectup.repositories;



import com.example.projectup.models.UserReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserReviewRepository extends JpaRepository<UserReviewModel, Long> {
    //ReviewModel findByReviewId (int reviewId);
   // List<ReviewModel> findReviewModelByBookContainingIgnoreCase(String name);
}
