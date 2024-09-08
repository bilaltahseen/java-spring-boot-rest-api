package org.bilaltahseen.jobposting.repository;

import org.bilaltahseen.jobposting.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, Long> { }
