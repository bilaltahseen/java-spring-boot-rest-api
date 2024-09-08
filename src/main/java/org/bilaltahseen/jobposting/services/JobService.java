package org.bilaltahseen.jobposting.services;

import org.bilaltahseen.jobposting.dtos.JobDto;
import org.bilaltahseen.jobposting.entities.JobEntity;

public interface JobService {
    JobEntity createJob(JobDto jobDto);
}
