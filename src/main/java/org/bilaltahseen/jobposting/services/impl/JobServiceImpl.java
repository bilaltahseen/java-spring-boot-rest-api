package org.bilaltahseen.jobposting.services.impl;

import org.bilaltahseen.jobposting.dtos.JobDto;
import org.bilaltahseen.jobposting.entities.JobEntity;
import org.bilaltahseen.jobposting.mappers.JobMapper;
import org.bilaltahseen.jobposting.repository.JobRepository;
import org.bilaltahseen.jobposting.services.JobService;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    JobServiceImpl(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    @Override
    public JobEntity createJob(JobDto jobDto) {
        JobEntity job = JobMapper.toEntity(jobDto);
        return jobRepository.save(job);
    }
}
