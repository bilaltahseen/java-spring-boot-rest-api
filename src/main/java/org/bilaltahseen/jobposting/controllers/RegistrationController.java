package org.bilaltahseen.jobposting.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bilaltahseen.jobposting.common.APIResponse;
import org.bilaltahseen.jobposting.common.BaseController;
import org.bilaltahseen.jobposting.dtos.RegistrationDto;
import org.bilaltahseen.jobposting.services.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/register")
public class RegistrationController extends BaseController {

    public final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody RegistrationDto registrationDto) {
        log.info("Registering user: {}", registrationDto);
        APIResponse<?> response = registrationService.register(registrationDto);
        return new ResponseEntity<>(response, response.getStatus());
    }


}
