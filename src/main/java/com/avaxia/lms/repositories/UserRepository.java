package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.Role;
import com.avaxia.lms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //User findByUsername(String username);

    //List<User> findByRolesContaining(Role role);
    Optional<User> findByEmail(String email);
    Optional<User> findByResetToken(String resetToken);

    //User findByRoles(Role role);
    boolean existsByEmail(String email);
}

