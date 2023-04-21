package com.example.jobagency;


import java.util.*;

public class Mainmenu {

    private static String jobId;

    public static void main(String[] args) {

        // create new JobList and JobSeekerList objects
        JobList jobList = new JobList();
        JobSeekerList jobSeekerList = new JobSeekerList();

        // read in jobs and job seekers from file
        FileHandler.readJobs(jobList);
        FileHandler.readJobSeekers(jobSeekerList);

        String choice = " ";
        do {
            try {
                // display menu options to user
                System.out.println();
                System.out.println("-------------------------------------------------------------");
                System.out.println("                     Welcome to JobSeeker Agency             ");
                System.out.println("-------------------------------------------------------------");
                System.out.println("[1.] Add Job");
                System.out.println("[2.] Remove Job");
                System.out.println("[3.] Display Jobs");
                System.out.println("[4.] Add Job Seeker");
                System.out.println("[5.] Remove Job Seeker");
                System.out.println("[6.] Display Job Seekers");
                System.out.println("[7.] Display matching jobs skills");
                System.out.println("[8.] Display matching jobs locations");
                System.out.println("[9.] Display job candidates who applied");
                System.out.println("[10.] Save and Quit");
                System.out.println("-------------------------------------------------------------");

                // get user's menu choice
                System.out.print("Enter choice (1-10): ");
                choice = EasyScanner.nextString();
                System.out.println();

                switch (choice) {
                    case "1":
                        addJob(jobList);// add a new job to the JobList object
                        break;
                    case "2":
                        removeFromJobList(jobList); // remove a job from the JobList object
                        break;
                    case "3":
                        displayJobs(jobList); // display all jobs in the JobList object
                        break;
                    case "4":
                        addJobSeeker(jobSeekerList); // add a new job seeker to the JobSeekerList object
                        break;
                    case "5":
                        removeFromJobSeekerList(jobSeekerList); // remove a job seeker from the JobSeekerList object
                        break;
                    case "6":
                        displayJobSeekers(jobSeekerList);// display all job seekers in the JobSeekerList object
                        break;
                    case "7":
                        displayMatchingJobs(jobList, jobSeekerList);   // display all jobs in the JobList object that match the skills of a job seeker
                        break;
                    case "8":
                        displayMatchingLocation(jobList, jobSeekerList);// display all jobs in the JobList object that match the location of a job seeker
                        break;
                    case "9":
                        displayJobCandidates(jobList, jobId); // display all job candidates who applied for a job
                        break;
                    case "10":
                        saveJobListToFile(jobList, jobSeekerList); // save job and job seeker lists to file and quit program
                        break;
                    default:
                        System.out.println("Enter 1-10 only");

                }
                // catch any exceptions thrown by user input
            }catch(InputMismatchException e)
            {
                System.out.println("Invalid Input");
            }
            // loop until user chooses to quit (option 10)
        } while (choice != "10");

    }
    public static void displayJobCandidates(JobList jobList, String jobId) {
        System.out.println("      List Candidates who applied for Jobs: ");
        System.out.println("+------------------+-----------------------+----------------------+");
        System.out.printf("| %-16s | %-21s | %-20s |%n",
                "Job ID", "Job Title", "No. of Applicants");
        System.out.println("+------------------+-----------------------+----------------------+");

        for (int i = 0; i < jobList.getTotal(); i++) {
            Job job = jobList.getJob(i);
            List<JobSeeker> candidatesApplied = job.getCandidates();
            int numApplicants = candidatesApplied.size();

            System.out.printf("| %-16s | %-21s | %-20s |%n",
                    job.getJobId(),
                    job.getTitle(),
                    numApplicants);

            System.out.println("+------------------+-----------------------+----------------------+");
        }
    }


    /**
     * Displays a list of jobs where job skills match with job seeker's skills
     *
     * @param jobList The list of available jobs
     * @param jobSeekerList The list of job seekers
     */
    private static void displayMatchingJobs(JobList jobList, JobSeekerList jobSeekerList) {
        System.out.println("LIST OF JOBS WHERE JOB SKILL MATCHES WITH JOB SEEKER'S SKILL:");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-20s| %-20s| %-20s|%-20s|%-20s| %n", "Job Seeker Id", "Job Seeker Name","Skills", "Job Id", "Job Title");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (int i = 0; i < jobSeekerList.getTotal(); i++) {
            JobSeeker jobSeeker = jobSeekerList.getJobSeeker(i);
            ArrayList<Skill> skills = jobSeeker.getSkillList();

            for (int j = 0; j < skills.size(); j++) {
                Skill skill = skills.get(j);

                for (int k = 0; k < jobList.getTotal(); k++) {
                    Job job = jobList.getJob(k);
                    for (int l = 0; l < job.getSkillList().size(); l++) {
                        if (job.getSkillList().get(l).getName().trim().equalsIgnoreCase(skill.getName().trim())) {
                            System.out.printf("| %-20s| %-20s| %-20s|%-20s|%-20s| %n",
                                    jobSeeker.getJobSeekerId(),
                                    jobSeeker.getjobSeeekerName(),
                                    skill.getName().trim(),
                                    job.getJobId(),
                                    job.getTitle());
                        }
                    }
                }
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------------------");
    }
    /**
     * Displays a list of jobs where job locattion match with job seeker's location
     *
     * @param jobList The list of available jobs
     * @param jobSeekerList The list of job seekers
     */
    private static void displayMatchingLocation(JobList jobList, JobSeekerList jobSeekerList) {

        System.out.println("LIST OF JOBS WHERE JOB LOCATION MATCHES WITH JOB SEEKER'S LOCATION:");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-20s| %-20s| %-20s| %-20s| %-15s| %n", "Job Id","Job Title","Job Seeker Id", "Job Seeker Name", "Location");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        for (int i = 0; i < jobSeekerList.getTotal(); i++) {

            JobSeeker jobSeeker = jobSeekerList.getJobSeeker(i);
            String jobSeekerLocation = jobSeeker.getjobSeekerlocation();

            for (int j = 0; j < jobList.getTotal(); j++) {
                Job job = jobList.getJob(j);
                String jobLocation = job.getJobLocation();

                if (jobLocation.trim().equalsIgnoreCase(jobSeekerLocation.trim())) {
                    System.out.printf("| %-20s| %-20s| %-20s| %-20s| %-15s| %n",
                            job.getJobId(),
                            job.getTitle(),
                            jobSeeker.getJobSeekerId(),
                            jobSeeker.getjobSeeekerName(),
                            jobSeekerLocation.trim());
                }
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
    }


    private static void addJobSeeker(JobSeekerList jobSeekerList) {
        boolean keepAdding = true;

        while (keepAdding) {
//            System.out.println("Enter Job Seeker ID : e.g enter max 10 digit number ");
//            int id = EasyScanner.nextInt();
            int id = jobSeekerList.getJobSeekerList().size() + 1;
            System.out.println("Enter name: ");
            String name = EasyScanner.nextString();
            System.out.println("Enter age: e.g. 25, enter only number ");
            int age = EasyScanner.nextInt();
            System.out.println("Enter your highest degree: ");
            String education = EasyScanner.nextString();
            System.out.println("Enter Location: e.g. London ");
            String location = EasyScanner.nextString();
            System.out.println("Enter your email: eg. paul@example.com");
            String email = EasyScanner.nextString();
            System.out.println("Enter skills separated by comma: eg:Javascript, Java ");
            String skills = EasyScanner.nextString();

            if (id != 0
                    && name != null && !name.equals("")
                    && age != 0
                    && education != null && !education.equals("")
                    && location != null && !location.equals("")
                    && email != null && !email.equals("")
                    && skills != null && !skills.equals("")) {


                List<String> skillAsString = Arrays.asList(skills.split(","));

                ArrayList<Skill> skillList = new ArrayList<>();
                for (String skill : skillAsString) {
                    Skill s = new Skill(skill);
                    skillList.add(s);
                }

                JobSeeker jobSeeker = new JobSeeker(id,name, age, education, location, email, skillList);
                jobSeekerList.addToJobSeekerList(jobSeeker);

                System.out.println("Do you want to add another job seeker? (y/n)");
                String response = EasyScanner.nextString();
                if (response.equals("n")) {
                    keepAdding = false;
                }
            } else {
                System.out.println("Please enter all the information asked.");
            }
        }
    }
    private static void addJob(JobList jobList) {
        boolean keepAdding = true;
        int jobCount = jobList.Total();

        while (keepAdding) {
            int id = jobCount + 1;

            System.out.println("Enter job title: ");
            String title = EasyScanner.nextString();

            System.out.println("Enter company name: ");
            String companyName = EasyScanner.nextString();

            System.out.println("Enter job location: ");
            String location = EasyScanner.nextString();

            System.out.println("Enter Salary: e.g 70000: ");
            String salaryStr = EasyScanner.nextString();
            int salary = Integer.parseInt(salaryStr.replaceAll("[^0-9]", ""));

            System.out.println("Enter skills separated by comma: ");
            String skills = EasyScanner.nextString();

            if (id != 0 && title != null && !title.equals("") && companyName != null && !companyName.equals("")
                    && skills != null && !skills.equals("") && location != null && !location.equals("")) {

                List<String> skillString = Arrays.asList(skills.split(","));

                ArrayList<Skill> skillList = new ArrayList<>();
                for (String skill : skillString) {
                    Skill s = new Skill(skill);
                    skillList.add(s);
                }

                Job job = new Job(id, title, companyName, location, salary, skillList);
                jobList.addToJobList(job);

                System.out.println("Job added successfully.");
            } else {
                System.out.println("Please enter all the information asked.");
            }

            System.out.println("Do you want to add another job? (yes/no)");
            String response = EasyScanner.nextString();

            if (response.equalsIgnoreCase("n")) {
                keepAdding = false;
            }
        }
    }
    private static void removeFromJobSeekerList(JobSeekerList jobSeekerList) {
        boolean keepRemoving = true;

        do {
            System.out.println("Enter the ID of the JobSeeker you want to remove: ");
            int jobSeekerId = EasyScanner.nextInt();

            JobSeeker jobSeekerToRemove = null;

            for (int i = 0; i <jobSeekerList.getTotal(); i++) {
                JobSeeker jobSeeker = jobSeekerList.getJobSeeker(i);
                if (jobSeeker.getJobSeekerId() == jobSeekerId) {
                    jobSeekerToRemove = jobSeeker;
                    break;
                }
            }

            if (jobSeekerToRemove != null) {
                jobSeekerList.removeJobSeeker(jobSeekerToRemove);
                System.out.println("JobSeeker removed successfully.");
                System.out.println("JobSeeker Name: " + jobSeekerToRemove.getjobSeeekerName());
                System.out.println("JobSeeker Age: " + jobSeekerToRemove.getAge());
                System.out.println("JobSeeker Education: " + jobSeekerToRemove.getjobSeekerEducation());
                System.out.println("JobSeeker Email: " + jobSeekerToRemove.getJobSeekerEmail());
                System.out.println("JobSeeker Location: " + jobSeekerToRemove.getjobSeekerlocation());
            } else {
                System.out.println("JobSeeker with ID " + jobSeekerId + " not found.");
            }

            System.out.println("Do you want to remove another JobSeeker? (Y/N)");
            String answer = EasyScanner.nextString();
            keepRemoving = answer.equalsIgnoreCase("Y");
        } while (keepRemoving);
    }

    private static void removeFromJobList(JobList jobList) {
        boolean keepRemoving = true;

        do{
        System.out.println("Enter the job ID you want to remove: ");
        int jobId = EasyScanner.nextInt();

        Job jobToRemove = null;
        for (int i = 0; i < jobList.getTotal(); i++) {
            Job job = jobList.getJob(i);
            if (job.getJobId() == jobId) {
                jobToRemove = job;
                break;
            }
        }

        if (jobToRemove != null) {
            jobList.removeJob(jobToRemove);
            System.out.println("Job removed successfully: ");
            System.out.println("Job Title: " + jobToRemove.getTitle());
            System.out.println("Company: " + jobToRemove.getCompany());
            System.out.println("Location: " + jobToRemove.getJobLocation());
        } else {
            System.out.println("No job with the entered ID found.");
        }
            System.out.println("Do you want to remove another Job? (Y/N)");
            String answer = EasyScanner.nextString();
            keepRemoving = answer.equalsIgnoreCase("Y");
        } while (keepRemoving);
    }

    private static void displayJobs(JobList jobList) {

        if (jobList.isEmpty()) {
            System.out.println("No jobs to display.");
        } else {
            System.out.println("                                           LIST OF JOBS REGISTERED :              ");
            System.out.println("+----------------------+----------------------+----------------------+--------------------------------------------------------------+------------------------------------------------------------");
            System.out.printf("| %-25s| %-25s| %-25s| %-25s| %-25s| %-55s| %n",
                    "Job Id","Job Title","Company","Salary/year in £","Location","Required Skills");
            System.out.println("+----------------------+----------------------+----------------------+--------------------------------------------------------------+------------------------------------------------------------");
            for (int i = 0; i < jobList.getTotal(); i++) {
                String skills = "";
                int j = 0;
                for (Skill s : jobList.getJob(i).getSkillList()) {
                    skills += s.getName();
                    j++;
                    if (jobList.getJob(i).getSkillList().size() != j) {
                        skills += ", ";
                    }
                }
                System.out.printf("| %-25s| %-25s| %-25s| %-25s| %-25s| %-55s| %n",
                        jobList.getJob(i).getJobId(),
                        jobList.getJob(i).getTitle(),
                        jobList.getJob(i).getCompany(),
                        jobList.getJob(i).getJobSalary(),
                        jobList.getJob(i).getJobLocation(),
                        skills);
            }
            System.out.println("+----------------------+----------------------+----------------------+--------------------------------------------------------------+---------------------------------------------------------");

            // Prompt user to apply for job
            System.out.print("Apply for a job? (y/n): ");
            String apply = EasyScanner.nextString();
            System.out.println();

            if (apply.equalsIgnoreCase("y")) {
                System.out.print("Enter the job Id: ");
                String jobId = EasyScanner.nextString();
                try {
////                    Job job = jobList.getJob(Integer.parseInt(jobId));
//                    int jobIdInt = Integer.parseInt(jobId);
                    Job job = jobList.getJobById(jobId);
                    if (job == null) {
                        System.out.println("Job not found.");
                    } else {
                        System.out.print("Enter your name: ");
                        String jobSeekerName = EasyScanner.nextString();
                        System.out.print("Enter your email address: ");
                        String jobSeekerEmail = EasyScanner.nextString();

                        JobSeeker candidate = new JobSeeker(jobSeekerName, jobSeekerEmail);
                        job.addCandidate(candidate);
                        System.out.println("Applied job successfully.");
                        displayJobCandidates(jobList, jobId);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid job ID.");
                }
            }
        }
    }


    private static void displayJobSeekers(JobSeekerList jobSeekerList) {
        if (jobSeekerList.isEmpty()) {
            System.out.println("No job seekers to display.");
        } else {
            System.out.println("                                                   LIST OF JOB SEEKERS REGISTERED : ");
            System.out.println("+----------------------+----------------------+----------------------+--------------------------------------------------------------+---------------------------------------------------------");
            System.out.printf("| %-15s| %-15s| %-7s| %-25s| %-25s| %-15s|%-40s| %n",
                    "Job Seeker Id","Name", "Age","Education", "Email","Location", "Skills Acquired");
            System.out.println("+----------------------+----------------------+----------------------+--------------------------------------------------------------+---------------------------------------------------------");
            for (int i = 0; i < jobSeekerList.getTotal(); i++) {

                String skills = "";
                String location = jobSeekerList.getJobSeeker(i).getjobSeekerlocation();

                int j = 0;
                for (Skill s : jobSeekerList.getJobSeeker(i).getSkillList()) {
                    skills += s.getName();
                    j++;
                    if (jobSeekerList.getJobSeeker(i).getSkillList().size() != j) {
                        skills += ", ";
                    }
                }

                System.out.printf("| %-15s| %-15s| %-7s| %-25s| %-25s| %-15s|%-40s| %n",
                        jobSeekerList.getJobSeeker(i).getJobSeekerId(),
                        jobSeekerList.getJobSeeker(i).getjobSeeekerName(),
                        jobSeekerList.getJobSeeker(i).getAge(),
                        jobSeekerList.getJobSeeker(i).getjobSeekerEducation(),
                        jobSeekerList.getJobSeeker(i).getJobSeekerEmail(),
                        location,
                        skills);
            }
            System.out.println("+----------------------+----------------------+----------------------+--------------------------------------------------------------+---------------------------------------------------------");
        }
    }

    private static void saveJobListToFile(JobList jobList, JobSeekerList jobSeekerList) {
        FileHandler.saveJobs(jobList);
        FileHandler.saveJobSeekers(jobSeekerList);
    }


}
