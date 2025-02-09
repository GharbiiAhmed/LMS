package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    //Optional<Admin> findByEmail(String email);
    //boolean existsByEmail(String email);
}
