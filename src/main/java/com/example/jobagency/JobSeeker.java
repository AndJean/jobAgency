package com.example.jobagency;


import java.util.ArrayList;
/**
 * Represents a JobSeeker posting that includes JobSeeker details
 * JobSeeker unique identifier,
 * JobSeeeker Name
 * JobSeeker Age,
 * JobSeeeker Education,
 * JobSeeker Location,
 * JobSeeker Email,
 * and required skills.
 */
public class JobSeeker {//JobSeeker constructor
    /**
     * Constructor for creating a JobSeeker object.
     * @param jobSeekerId the unique identifier of the JobSeeker
     * @param name the JobSeeker name
     * @param age the age of the JobSeeker
     * @param jobSeekerEducation the Education of the JobSeeker
     * @param jobSeekerlocation the location of the JobSeeker
     * @param skillList the required skills acquired  by the JobSeeker
     */
    private int jobSeekerId;
    private String jobSeeekerName;
    private int age;
    private String jobSeekerEducation;
    private String jobSeekerlocation;
    private String jobSeekerEmail;
    private String dateApplied;
    private ArrayList<Skill> skillList;

    public JobSeeker(int jobSeekerId,String jobSeeekerName, int age, String jobSeekerEducation, String jobSeekerEmail, String jobSeekerlocation, ArrayList<Skill> skillList) {
        this.jobSeekerId = jobSeekerId;
        this.jobSeeekerName = jobSeeekerName;
        this.age = age;
        this.jobSeekerEducation = jobSeekerEducation;
        this.jobSeekerEmail = jobSeekerEmail;
        this.jobSeekerlocation = jobSeekerlocation;
        this.skillList = skillList;
    }

//    public JobSeeker(String jobSeekerName, String jobSeekerEmail) {
//
//    }

    public JobSeeker(String jobSeeekerName, String jobSeekerEmail) {
        return;
    }

    /**
     * Returns the unique identifier of the JobSeeker.
     * @return the JobSeeker ID
     */
    public int getJobSeekerId() {
        return jobSeekerId;
    }
    /**
     * Sets the unique identifier of the job.
     * @param jobSeekerId the jobSeekerId
     */
    public void setJobSeekerId(int jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }
    /**
     * Returns the name of the JobSeeker.
     * @return the JobSeeker name
     */
    public String getjobSeeekerName() {

        return jobSeeekerName;
    }
    /**
     * Sets the unique identifier of the job.
     * @param jobSeeekerName the jobSeeker
     */
    public void setjobSeeekerName(String jobSeeekerName) {

        this.jobSeeekerName = jobSeeekerName;
    }
    /**
     * Returns the age of the JobSeeker.
     * @return the JobSeeker age
     */
    public int getAge() {

        return age;
    }

    /**
     * Sets the age of the JobSeeker.
     * @param age the JobSeeker age
     */
    public void setAge(int age) {

        this.age = age;
    }

    /**
     * Returns the education of the JobSeeker.
     * @return the JobSeeker education
     */
    public String getjobSeekerEducation() {
        return jobSeekerEducation;
    }

    /**
     * Sets the education of the JobSeeker.
     * @param jobSeekerEducation the JobSeeker education to set
     */
    public void setjobSeekerEducation(String jobSeekerEducation) {
        this.jobSeekerEducation = jobSeekerEducation;
    }

/**
 * Returns the location of the JobSeeker.
 * @return the JobSeeker location
 * */
    public String getjobSeekerlocation() {
        return jobSeekerlocation;
    }
    public void setjobSeekerlocation(String location) {
        this.jobSeekerlocation = location;
    }
    /**
     * Returns the location of the JobSeeker.
     * @return the jobSeekerEmail skill
     * */
    public String getJobSeekerEmail() {
        return jobSeekerEmail;
    }
    /**
     * Sets the education of the JobSeeker.
     * @param jobSeekerEmail the JobSeeker
     */
    public void setjobSeekerEmail(String jobSeekerEmail) {
        this.jobSeekerEmail = jobSeekerEmail;
    }
    /**
     * Returns the location of the JobSeeker.
     * @return the skillList skill
     * */
    public ArrayList<Skill> getSkillList() {

        return skillList;
    }
    /**
     * Sets the education of the JobSeeker.
     * @param skillList the JobSeeker skill
     */
    public void setSkillList(ArrayList<Skill> skillList) {
        this.skillList = skillList;
    }
}
