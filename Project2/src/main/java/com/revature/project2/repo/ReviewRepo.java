package com.revature.project2.repo;

import com.revature.project2.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Jason, Shabana
 */
@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

}
