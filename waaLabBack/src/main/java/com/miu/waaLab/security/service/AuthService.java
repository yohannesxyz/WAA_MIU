package com.miu.waaLab.security.service;


import com.miu.waaLab.security.dto.LoginRequest;
import com.miu.waaLab.security.dto.LoginResponse;
import com.miu.waaLab.security.dto.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
