package repo;

import models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Jason, Shabana
 */

@Repository
public interface ReviewRepo extends JpaRepository<Review,Integer> {

    //create a .save in here? or is it in JpaRepository?

}
