package com.example.cis4900.spring.template.jobs;

import com.example.cis4900.spring.template.jobs.models.Job;
import java.util.List;

public interface JobsService {

    public String addJob(Job newJob);

    public Job getJob(Integer id);

    public String deleteJob(Integer id);

    public Iterable<Job> allJobs();

    // public Iterable<Job> searchJobs(String jobTitle, String company, String location);
    public List<Job> searchJobs(String searchQuery);


    public Integer count();
}
