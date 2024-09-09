package org.bilaltahseen.jobposting.services;

import org.bilaltahseen.jobposting.common.APIResponse;
import org.bilaltahseen.jobposting.dtos.RegistrationDto;

public interface RegistrationService {
    APIResponse<?> register(RegistrationDto registrationDto);
}
