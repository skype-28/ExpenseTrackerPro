package com.skp.expensetrackerpro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skp.expensetrackerpro.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
