package com.example.jobagency;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents a job posting that includes job details
 * Unique IDs,
 * Job Title,
 * Job Company,
 * Job Location,
 * Job Salary,
 * and required skills.
 */
public class Job {
    public JobSeeker getJobId;
    private int jobId; // the unique identifier of the job
    private String title; // the job title
    private String company; // the name of the company posting the job
    private String joblocation; // the location of the job
    private int jobSalary; // the salary for the job
    private List<JobSeeker> candidates = new ArrayList<>();
    private ArrayList<Skill> skillList; // the required skills for the job
    /**
     * Constructor for creating a job object.
     * @param jobId the unique identifier of the job
     * @param title the job title
     * @param company the name of the company posting the job
     * @param joblocation the location of the job
     * @param jobSalary the salary for the job
     * @param skillList the required skills for the job
     */
    public Job(int jobId, String title, String company, String joblocation,int jobSalary, ArrayList<Skill> skillList) {
        this.jobId = jobId;
        this.title = title;
        this.company = company;
        this.joblocation = joblocation;
        this.jobSalary = jobSalary;
        this.skillList = skillList;
        this.candidates = new ArrayList<>();

    }
    /**
     * Returns the unique identifier of the job.
     * @return the job ID
     */
    public int getJobId() {
        return jobId;
    }
    /**
     * Sets the unique identifier of the job.
     * @param jobId the job ID
     */
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
    /**
     * Returns the job title.
     * @return the job title
     */
    public String getTitle() {

        return title;
    }
    /**
     * Sets the job title.
     * @param title the job title
     */
    public void setTitle(String title) {

        this.title = title;
    }
    /**
     * Returns the name of the company posting the job.
     * @return the company name
     */
    public String getCompany() {

        return company;
    }
    /**
     * Sets the name of the company posting the job.
     * @param company the company name
     */
    public void setCompany(String company) {

        this.company = company;
    }
    /**
     * Returns the location of the job.
     * @return the job location
     */
    public String getJobLocation() {

        return joblocation;
    }
    /**
     * Sets the location of the job.
     * @param JobLocation the job location
     */
    public void setJobLocation(String JobLocation) {

        this.joblocation = JobLocation;
    }
    /**
     * Returns the salary for the job.
     * @return the job salary
     */
    public int getJobSalary() {
        return jobSalary;
    }
    /**
     * Sets the salary for the job.
     * @param jobSalary the job salary
     */
    public void setJobSalary(int jobSalary) {
        this.jobSalary = jobSalary;
    }
    /**
     * Returns the required skills for the job.
     * @return the skill list
     */
    public ArrayList<Skill> getSkillList() {

        return skillList;
    }
    /**
     * Sets the required skills for the job.
     * @param skillList the skill list
     */
    public void setSkillList(ArrayList<Skill> skillList) {

        this.skillList = skillList;
    }
    public List<JobSeeker> getCandidates() {
        return candidates;
    }
    // Returns a list of all candidates who have applied for this job
    public void addCandidate(JobSeeker candidate) {
        candidates.add(candidate);
    }

}
