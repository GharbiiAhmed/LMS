package com.avaxia.lms.repositories;

import com.avaxia.lms.entities.User;
import com.avaxia.lms.entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    VerificationToken findByToken(String token);
    void deleteByUser(User user);
    List<VerificationToken> findByUser(User user);
    VerificationToken findByCode(String code);
}
