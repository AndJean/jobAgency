package com.example.jobagency;

import java.util.ArrayList;
import java.util.List;

public class SearchJob {
    private List<JobList> jobs;

    public SearchJob(List<JobList> jobs) {
        this.jobs = new ArrayList<JobList>(jobs);
    }
    public List<JobList> viewsJobs() {
        return jobs;
    }
    public List<JobList> getMatchingJobs(Employee employee) {
        List<JobList> matchingJobs = new ArrayList<JobList>();
        for (JobList job : jobs) {
            if (employee.hasMatchingSkills(job.getRelevantSkills())) {
                matchingJobs.add(job);
            }
        }
        return matchingJobs;
    }
    public void applyForJob(Employee employee, JobList job) {
        employee.applyForJob(job);
        jobs.remove(job);
        jobs.add(job);
        System.out.println(employee.getName() + " applied for " + job.getName());
        System.out.println(employee.getSkills());
        System.out.println(job.getRelevantSkills());
    }
}
