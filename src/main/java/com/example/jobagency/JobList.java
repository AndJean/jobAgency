package com.example.jobagency;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// This class represents a list of job postings.
public class JobList {

    private ArrayList<Job> jobList;// list of jobs

    // Constructor for the JobList class. Initializes the job list.
    public JobList() {
        this.jobList = new ArrayList<>();
    }
    // Adds a job posting to the job list.
    public  void  addToJobList(Job j) {
        jobList.add(j);
    }
    // Returns the total number of job postings in the job list.
    public int getTotal() {
        return jobList.size();
    }
    // Returns whether or not the job list is empty.
    public boolean isEmpty()
    {
        return jobList.isEmpty();
    }
    // Returns the job posting at the specified index in the job list.
    public Job getJob(int i) {
         return jobList.get(i);
    }
    // Removes a job posting from the job list.
    public void removeJob(Job j) {jobList.remove(j);}

    public JobSeeker jobSeekerName(String jobSeeekerName) {
        for (Job job : jobList) {
            for (JobSeeker candidate : job.getCandidates()) {
                if (candidate.getjobSeeekerName().equals(jobSeeekerName)) {
                    return candidate;
                }
            }
        }
        return null;
    }


    public Job getJobById(String jobId) {
        for (int i = 0; i < jobList.size(); i++) {
            if (String.valueOf(jobList.get(i).getJobId()).equals(jobId)) {
                return jobList.get(i);
            }
        }
        return null;
    }


    public int Total() {
        return jobList.size();
    }
}
