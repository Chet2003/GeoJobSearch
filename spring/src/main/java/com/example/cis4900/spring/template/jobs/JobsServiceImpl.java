package com.example.cis4900.spring.template.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.cis4900.spring.template.jobs.dao.JobsDao;
import com.example.cis4900.spring.template.jobs.models.Job;

@Service
public class JobsServiceImpl implements JobsService{
    @Autowired
    private JobsDao JobsDao;

    @Override
    public String addJob(Job newJob) {
        try {
            JobsDao.save(newJob);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Saved a new job";
    }

    @Override
    public Job getJob(Integer id) {
        return JobsDao.findById(id).get();
    }

    @Override
    public String deleteJob(Integer id) {
        try {
            JobsDao.deleteById(id);
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Deleted a job";
    }

    @Override
    public Iterable<Job> allJobs() {
        return JobsDao.findAll();
    }

    @Override
    public Integer count() {
        return JobsDao.getCount();
    }

    // @Override
    // public Iterable<Job> searchJobs(String query1, String query2, String query3) {
    //     return JobsDao.findByJobTitleAndLocationAndCompany(query1, query2, query3);
    // }

    @Override
    public List<Job> searchJobs(String searchQuery) {
        return JobsDao.searchByKeyword(searchQuery);
    }

}