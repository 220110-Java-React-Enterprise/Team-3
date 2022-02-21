package com.revature.project2.repo;

import com.revature.project2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Jason, Shabana
 */
@Repository
public interface UserRepo extends JpaRepository <User, Integer>{

}
