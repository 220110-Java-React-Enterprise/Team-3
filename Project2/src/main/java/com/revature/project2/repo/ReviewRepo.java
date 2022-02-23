package com.revature.project2.repo;

import com.revature.project2.models.Game;
import com.revature.project2.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Jason, Shabana
 */
@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

    List<Review> findByGameId(Game gameId);

}
