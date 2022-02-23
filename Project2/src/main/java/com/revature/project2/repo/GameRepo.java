package com.revature.project2.repo;

import com.revature.project2.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Trevor, Jeffrey, CJ
 */
@Repository
public interface GameRepo extends JpaRepository<Game, Integer> {

    List<Game> findByNameContainingIgnoreCase(String name);

}
