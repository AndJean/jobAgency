package com.example.jobagency;

import java.util.ArrayList;
import java.util.List;

public class Recruiter {
  private String firstName;
  private String lastName;
  private String email;
  private String CompanyName;
  private List<JobList> jobs;

  public Recruiter(String firstName, String lastName, String email, String CompanyName) {
     this.firstName = firstName;
     this.lastName = lastName;
     this.email = email;
     this.CompanyName = CompanyName;
     this.jobs = new ArrayList<>();
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getCompanyName() {
    return CompanyName;
  }

  public List<JobList> getJobs() {
    return jobs;
  }
  public void addJob(JobList job) {
     this.jobs.add(job);
  }
  public void editJob(JobList job) {
     this.jobs.remove(job);
     this.jobs.add(job);
  }
  public void deleteJob(JobList job, int index) {
     this.jobs.remove(job);
     this.jobs.remove(index);
  }
  public void editProfile(String firstName, String lastName, String email, String CompanyName) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.CompanyName = CompanyName;
  }
  @Override
    public String toString() {
        return "Recruiter{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", jobs=" + jobs +
                '}';
    }
}
