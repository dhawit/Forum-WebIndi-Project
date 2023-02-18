package com.forum.forum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.forum.forum.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
    @Query(value = "select * from user where email=?1", nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Query(value = "update user set password=?1 where email = ?2", nativeQuery = true)
    Integer updatePassword(String password, String email);
}
