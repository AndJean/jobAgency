package com.example.jobagency;
import java.util.ArrayList;

public class JobList<Job>{
    public static JobList[] getjobList;
    public static ArrayList<String>jobList;
    private String name;
    private Object relevantSkills;

    public JobList(String title, Double salary, String description, String category, String location, String startDate, String endDate){
        jobList= new ArrayList<>();
    }
    public static void addJob(String job){
        jobList.add(job);
        System.out.println(jobList);
    }
    public static ArrayList<String> findJob(String title) {
        return jobList;
    }

    public static JobList fromString(String line) {
        String[] split = line.split(",");
        return new JobList(split[0], Double.parseDouble(split[1]), split[2], split[3], split[4], split[5], split[6]);
    }

    public static void addJob(JobList job) {
        jobList.add(String.valueOf(job));
        System.out.println(jobList);
    }

    public ArrayList<String> getJobList(){
        return jobList;
    }
    public void editJobList(ArrayList<String> jobList){
        JobList.jobList =jobList;
        System.out.println(jobList);
    }
    public void removeJob(String job){
        jobList.remove(job);
        System.out.println(jobList);
    }

    @Override
    public String toString() {
        return "JobList{" + "jobList=" + jobList +
                ", name='" + name + '\'' +  ", relevantSkills=" + relevantSkills + '}';
    }

    public Object getRelevantSkills() {
        return relevantSkills;
    }

    public void setRelevantSkills(Object relevantSkills) {
        this.relevantSkills = relevantSkills;
    }

    public void addEmployee(Employee employee) {
        relevantSkills.equals(employee);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
