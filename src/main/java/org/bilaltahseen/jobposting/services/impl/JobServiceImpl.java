package org.bilaltahseen.jobposting.services.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bilaltahseen.jobposting.dtos.JobDto;
import org.bilaltahseen.jobposting.entities.JobEntity;
import org.bilaltahseen.jobposting.mappers.JobMapper;
import org.bilaltahseen.jobposting.repository.JobRepository;
import org.bilaltahseen.jobposting.services.JobService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public JobEntity createJob(JobDto jobDto) {
        JobEntity job = JobMapper.toEntity(jobDto);

        log.info("Creating job: {}", job);
        return jobRepository.save(job);
    }
}
