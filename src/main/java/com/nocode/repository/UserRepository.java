package com.nocode.repository;

import com.nocode.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import com.jcabi.aspects.Loggable;

@Repository // Marks the interface as a JPA repository
@Loggable(prepend = true, logThis = true)
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByUserId(String userId);
    void deleteUserByUserId(String userId);
}
