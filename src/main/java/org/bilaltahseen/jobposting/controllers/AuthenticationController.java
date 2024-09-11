package org.bilaltahseen.jobposting.controllers;

import lombok.AllArgsConstructor;
import org.bilaltahseen.jobposting.common.APIResponse;
import org.bilaltahseen.jobposting.common.BaseController;
import org.bilaltahseen.jobposting.dtos.LoginUserDto;
import org.bilaltahseen.jobposting.dtos.RefreshTokenDto;
import org.bilaltahseen.jobposting.dtos.RegisterUserDto;
import org.bilaltahseen.jobposting.entities.UserEntity;
import org.bilaltahseen.jobposting.response.LoginResponse;
import org.bilaltahseen.jobposting.services.AuthenticationService;
import org.bilaltahseen.jobposting.services.JWTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthenticationController{

    private final JWTService jwtService;

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<APIResponse<UserEntity>> register(@RequestBody RegisterUserDto registerUserDto) {
        UserEntity registeredUser = authenticationService.signup(registerUserDto);
        APIResponse<UserEntity> response = new APIResponse<UserEntity>("User registered successfully", HttpStatus.CREATED, registeredUser);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse<LoginResponse>> authenticate(@RequestBody LoginUserDto loginUserDto) {
        UserEntity authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);
        String refreshToken = jwtService.generateRefreshToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse(jwtToken,refreshToken,jwtService.getExpirationTime());

        return ResponseEntity.ok(new APIResponse<LoginResponse>("User authenticated successfully", HttpStatus.OK, loginResponse));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<APIResponse<LoginResponse>> refreshToken(@RequestBody RefreshTokenDto refreshTokenDto) {

        LoginResponse loginResponse = authenticationService.refreshToken(refreshTokenDto);
        return ResponseEntity.ok(new APIResponse<LoginResponse>("Token refreshed successfully", HttpStatus.OK, loginResponse));
    }
}