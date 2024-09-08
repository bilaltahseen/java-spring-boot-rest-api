package org.bilaltahseen.jobposting.mappers;

import org.bilaltahseen.jobposting.dtos.JobDto;
import org.bilaltahseen.jobposting.entities.JobEntity;


public class JobMapper {

    public static JobEntity toEntity(JobDto jobDto) {
        JobEntity jobEntity = new JobEntity();
        jobEntity.setName(jobDto.getName());
        jobEntity.setDescription(jobDto.getDescription());
        return jobEntity;
    }

    public static JobDto toDto(JobEntity jobEntity) {
        JobDto jobDto = new JobDto();
        jobDto.setName(jobEntity.getName());
        jobDto.setDescription(jobEntity.getDescription());
        return jobDto;
    }
}
