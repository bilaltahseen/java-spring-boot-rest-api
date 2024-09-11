package org.bilaltahseen.jobposting.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bilaltahseen.jobposting.constants.Role;
import org.bilaltahseen.jobposting.dtos.LoginUserDto;
import org.bilaltahseen.jobposting.dtos.RefreshTokenDto;
import org.bilaltahseen.jobposting.dtos.RegisterUserDto;
import org.bilaltahseen.jobposting.entities.UserEntity;
import org.bilaltahseen.jobposting.repository.UserRepository;
import org.bilaltahseen.jobposting.response.LoginResponse;
import org.bilaltahseen.jobposting.services.AuthenticationService;
import org.bilaltahseen.jobposting.services.JWTService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;



    @Override
    @Transactional
    public UserEntity signup(RegisterUserDto registerUserDto) {
        UserEntity existingUser = userRepository.findByEmail(registerUserDto.getEmail()).orElse(null);

        if (existingUser != null) {
            throw new RuntimeException("User already exists");
        }

        UserEntity user = new UserEntity();
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        user.setFirstName(registerUserDto.getFirstName());
        user.setLastName(registerUserDto.getLastName());
        user.setRoles(Set.of(Role.USER));

        return userRepository.save(user);
    }

    @Override
    public UserEntity authenticate(LoginUserDto loginUserDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword()));
        return userRepository.findByEmail(loginUserDto.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenDto refreshToken) {
        String username = jwtService.extractUsername(refreshToken.getRefreshToken());
        UserEntity user = userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found"));

        if(jwtService.isTokenValid(refreshToken.getRefreshToken(),user)) {
            return new LoginResponse(jwtService.generateToken(user), jwtService.generateRefreshToken(user),jwtService.getExpirationTime());
        } else {
            throw new RuntimeException("Invalid token");
        }
    }
}
