package org.bilaltahseen.jobposting.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.bilaltahseen.jobposting.common.BaseController;
import org.bilaltahseen.jobposting.dtos.JobDto;
import org.bilaltahseen.jobposting.entities.JobEntity;
import org.bilaltahseen.jobposting.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/jobs")
public class JobController extends BaseController {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<?> createJob(@Valid @RequestBody JobDto jobDto) {
        JobEntity job = jobService.createJob(jobDto);
        return new ResponseEntity<>(job, HttpStatus.CREATED);
    }

}
