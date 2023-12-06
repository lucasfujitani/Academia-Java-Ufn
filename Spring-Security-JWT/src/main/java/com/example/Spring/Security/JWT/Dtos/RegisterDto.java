package com.example.Spring.Security.JWT.Dtos;

import com.example.Spring.Security.JWT.Enums.UserRole;
import jakarta.validation.constraints.NotNull;

public record RegisterDto(@NotNull String email, @NotNull String password,@NotNull UserRole role) {
}
