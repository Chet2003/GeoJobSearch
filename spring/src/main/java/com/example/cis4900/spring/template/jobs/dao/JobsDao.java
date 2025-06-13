package com.example.cis4900.spring.template.jobs.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.example.cis4900.spring.template.jobs.models.Job;

public interface JobsDao extends CrudRepository<Job, Integer> {

    @Query("SELECT COUNT(*) FROM Job")
    Integer getCount();

    // JPA
    List<Job> findByJobTitleAndLocationAndCompany(String jobTitle, String location, String company);

    @Query("SELECT j FROM Job j WHERE j.company LIKE %:searchQuery% OR j.jobTitle LIKE %:searchQuery% OR j.location LIKE %:searchQuery%")
    List<Job> searchByKeyword(String searchQuery);

}