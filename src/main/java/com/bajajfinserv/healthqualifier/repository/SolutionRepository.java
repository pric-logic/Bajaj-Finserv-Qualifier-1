package com.bajajfinserv.healthqualifier.repository;

import com.bajajfinserv.healthqualifier.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {
    Solution findByRegNo(String regNo);
}
