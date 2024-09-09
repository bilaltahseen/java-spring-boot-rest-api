package org.bilaltahseen.jobposting.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.bilaltahseen.jobposting.common.APIResponse;
import org.bilaltahseen.jobposting.dtos.RegistrationDto;
import org.bilaltahseen.jobposting.entities.UserEntity;
import org.bilaltahseen.jobposting.repository.UserRepository;
import org.bilaltahseen.jobposting.services.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;

    RegistrationServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public APIResponse<?> register(RegistrationDto registrationDto) {

        UserEntity userExists = this.userRepository.findByEmail(registrationDto.getEmail());

        if (userExists != null) {
            return new APIResponse<>("User already exists", HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setRole("USER");
        log.info("Registering user: {}", user);
        userRepository.save(user);

        return new APIResponse<>("User registered successfully", HttpStatus.CREATED);

    }
}
