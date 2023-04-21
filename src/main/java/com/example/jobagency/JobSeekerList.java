package com.example.jobagency;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class JobSeekerList {
    // ArrayList to store job seekers
    private ArrayList<JobSeeker> jobSeekerList;
    // Constructor initializes empty job seeker list
    public JobSeekerList() {
        this.jobSeekerList = new ArrayList<>();
    }
    // Add a job seeker to the list
    public  void  addToJobSeekerList(JobSeeker j) {
        jobSeekerList.add(j);
    }
    // Remove a job seeker from the list
    public void removeJobSeeker(JobSeeker j) {
        jobSeekerList.remove(j);
    }
    // Get the total number of job seekers in the list
    public int getTotal() {
        return jobSeekerList.size();
    }
    // Check if the job seeker list is empty
    public boolean isEmpty()
    {
        return jobSeekerList.isEmpty();
    }
    // Get a job seeker from the list by index
    public JobSeeker getJobSeeker(int i) {
        return jobSeekerList.get(i);
    }

    public Collection<Object> getJobSeekerList() {
        return Collections.unmodifiableCollection(jobSeekerList);
    }
}
