package org.bilaltahseen.jobposting.services;

import org.bilaltahseen.jobposting.dtos.LoginUserDto;
import org.bilaltahseen.jobposting.dtos.RefreshTokenDto;
import org.bilaltahseen.jobposting.dtos.RegisterUserDto;
import org.bilaltahseen.jobposting.entities.UserEntity;
import org.bilaltahseen.jobposting.response.LoginResponse;

public interface AuthenticationService {
    UserEntity signup(RegisterUserDto registerUserDto);
    UserEntity authenticate(LoginUserDto loginUserDto);
    LoginResponse refreshToken(RefreshTokenDto refreshTokenDto);
}
