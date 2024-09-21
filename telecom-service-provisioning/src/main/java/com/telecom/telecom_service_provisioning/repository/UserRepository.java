package com.telecom.telecom_service_provisioning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.telecom_service_provisioning.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    public Optional<User> findByEmail(String email);

    public Optional<User> findByUsername(String username);
}
