package com.example.jobagency;


import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveJobs(JobList jobList) {

        try {

            File file = new File("Jobs.dat");
            file.createNewFile(); // if file already exists will do nothing

            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream fw = new DataOutputStream(fos);
            fw.writeInt(jobList.getTotal());
            for (int i = 0; i < jobList.getTotal(); i++) {
                Job job = jobList.getJob(i);
                fw.writeInt(job.getJobId());
                fw.writeUTF(job.getTitle());
                fw.writeUTF(job.getCompany());
                fw.writeUTF(job.getJobLocation());
                fw.writeInt(job.getJobSalary());
                fw.writeInt(job.getSkillList().size());

                for (int j = 0; j < job.getSkillList().size(); j++) {
                    fw.writeUTF(job.getSkillList().get(j).getName());
                }
            }
            fw.flush();
            fw.close();

        } catch (IOException ioException) {
            System.out.println("Error writing file:" + ioException.getMessage());
        }
    }

    public static void readJobs(JobList jobList) {

        try {
            FileInputStream file = new FileInputStream("Jobs.dat");
            DataInputStream fr = new DataInputStream(file);

            int total = fr.readInt();
            for (int j = 0; j < total; j++) {
                int jobId = fr.readInt();
                String jobName = fr.readUTF();
                String company = fr.readUTF();
                String location = fr.readUTF();
                int salary = fr.readInt();

                int totalSkills = fr.readInt();
                ArrayList<Skill> skillList = new ArrayList<>();
                for (int k = 0; k < totalSkills; k++) {
                    String skillName = fr.readUTF();
                    Skill skill = new Skill(skillName);
                    skillList.add(skill);
                }
                Job job = new Job(jobId,jobName, company, location, salary, skillList);
                jobList.addToJobList(job);

            }
            fr.close();
        } catch (IOException ioe) {
            System.out.println("No records found");
        }

    }

    public static void saveJobSeekers(JobSeekerList jobSeekerList) {

        try {

            File file = new File("JobSeeker.dat");
            file.createNewFile(); // if file already exists will do nothing

            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream fw = new DataOutputStream(fos);
            fw.writeInt(jobSeekerList.getTotal());
            for (int i = 0; i < jobSeekerList.getTotal(); i++) {
                JobSeeker jobSeeker = jobSeekerList.getJobSeeker(i);
                fw.writeInt(jobSeeker.getJobSeekerId());
                fw.writeUTF(jobSeeker.getjobSeeekerName());
                fw.writeInt(jobSeeker.getAge());
                fw.writeUTF(jobSeeker.getjobSeekerEducation());
                fw.writeUTF(jobSeeker.getjobSeekerlocation());
                fw.writeUTF(jobSeeker.getJobSeekerEmail());
                fw.writeInt(jobSeeker.getSkillList().size());

                for (int j = 0; j < jobSeeker.getSkillList().size(); j++) {
                    fw.writeUTF(jobSeeker.getSkillList().get(j).getName());
                }
            }
            fw.flush();
            fw.close();

        } catch (IOException ioException) {
            System.out.println("Error writing file:" + ioException.getMessage());
        }
    }

    public static void readJobSeekers(JobSeekerList jobSeekerList) {

        try {
            FileInputStream file = new FileInputStream("JobSeeker.dat");
            DataInputStream fr = new DataInputStream(file);

            int total = fr.readInt();
            for (int j = 0; j < total; j++) {
                int seekerId = fr.readInt();
                String seekerName = fr.readUTF();
                int seekerAge = fr.readInt();
                String seekerEducation = fr.readUTF();
                String seekerLocation = fr.readUTF();
                String seekerEmail = fr.readUTF();

                int totalSkills = fr.readInt();
                ArrayList<Skill> skillList = new ArrayList<>();
                for (int k = 0; k < totalSkills; k++) {
                    String skillName = fr.readUTF();
                    Skill skill = new Skill(skillName);
                    skillList.add(skill);
                }
                JobSeeker jobSeeker = new JobSeeker(seekerId,seekerName, seekerAge, seekerEducation, seekerLocation,seekerEmail, skillList);
                jobSeekerList.addToJobSeekerList(jobSeeker);

            }
            fr.close();
        } catch (IOException ioe) {
            System.out.println("No records found");
        }

    }
}
