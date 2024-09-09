package org.bilaltahseen.jobposting.repository;

import org.bilaltahseen.jobposting.entities.JobEntity;
import org.bilaltahseen.jobposting.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public UserEntity findByEmail(String email);
}
