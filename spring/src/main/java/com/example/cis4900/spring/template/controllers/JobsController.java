package com.example.cis4900.spring.template.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.cis4900.spring.template.jobs.JobsService;
import com.example.cis4900.spring.template.jobs.models.Job;

@RestController
@RequestMapping(path = "/api/jobs")
public class JobsController {

    private JobsService JobsService;

    @Autowired
    JobsController(JobsService JobsService) {
        this.JobsService = JobsService;
    }
    
    @PostMapping("/add")
    private @ResponseBody String addJob(@RequestBody Job newJob) {
        return JobsService.addJob(newJob);
    }

    @GetMapping("/get/{id}")
    private @ResponseBody Job getJob(@PathVariable Integer id) {
        return JobsService.getJob(id);
    }

    @DeleteMapping("/delete/{id}")
    private @ResponseBody String deleteJob(@PathVariable Integer id) {
        return JobsService.deleteJob(id);
    }

    @GetMapping("/all")
    private @ResponseBody Iterable<Job> allJobs() {
        return JobsService.allJobs();
    }

    @GetMapping("/count")
    private @ResponseBody Integer count() {
        return JobsService.count();
    }

//    @GetMapping("/search/{jobtitle}/{location}/{company}")
//     private @ResponseBody Iterable<Job> searchJobs(
//             @PathVariable String jobtitle,
//             @PathVariable String location,
//             @PathVariable String company) {
//         return JobsService.searchJobs(jobtitle, location, company);
//     }

    @GetMapping("/search/{searchQuery}")
    private @ResponseBody List<Job> searchJobs(@PathVariable String searchQuery) {
        return JobsService.searchJobs(searchQuery);
    }

}