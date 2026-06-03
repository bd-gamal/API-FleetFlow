package com.fleetflow.service;

import com.fleetflow.dto.AuthResponse;
import com.fleetflow.dto.LoginRequest;
import com.fleetflow.dto.RegisterRequest;
import com.fleetflow.entity.User;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    AuthResponse buildAuthResponse(User user);
}
