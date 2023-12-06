package com.example.Spring.Security.JWT.Repositories;

import com.example.Spring.Security.JWT.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository <UserModel, UUID> {
    UserDetails findByEmail(String email);
}
