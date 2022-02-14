
package repo;

import models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Jason, Shabana
 */

@Repository
public interface UserRepo extends JpaRepository <User,Integer>{

    //create a .save in here? or is it in JpaRepository?

}
