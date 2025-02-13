package com.avaxia.lms.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.avaxia.lms.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
