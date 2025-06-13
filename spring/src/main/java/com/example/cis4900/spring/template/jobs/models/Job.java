package com.example.cis4900.spring.template.jobs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String jobTitle;
    private String location;
    private String company;

    public Job() {

    }

    public Job(Integer id, String jobTitle, String location, String company){

        this.id = id;
        this.jobTitle = jobTitle;
        this.location = location;
        this.company = company;
    }

    public Integer getId(){

        return id;
    }

    public String getJobTitle(){

        return jobTitle;
    }

    public String getLocation(){

        return location;
    }

    public String getCompany(){

        return company;
    }

}