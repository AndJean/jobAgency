package com.example.jobagency;

import java.util.*;

/**
    *@author Jean Pregnon
    *@version 20 April 2023
    */
public class Mainmenu {
    public static void main(String[] args) {

        int choice;
        String Option;
        String Employee;
        String Job;
        Double Salary;
        String JobTitle;

        // create a Scanner object
        Scanner EasyScanner = new Scanner(System.in);

        System.out.println("Welcome to Job Agency are you a Recruiter or an Employee?");
        System.out.println("***********************");
        System.out.print("Please type you choice: ");
        Option = EasyScanner.nextLine();
        System.out.println("***********************");

        if(Option.equals("Recruiter") || Option.equals("recruiter")) {
            do
            { //Menu options
                System.out.println("Welcome to Job Agency");
                System.out.println("***********************");
                System.out.println("1. Add Job");
                System.out.println("2. View Jobs");
                System.out.println("3. Edit Job");
                System.out.println("4. Delete Job");
                System.out.println("5. View recruiter profile");
                System.out.println("6. Edit recruiter profile");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                choice = EasyScanner.nextInt();

                switch (choice) {
                    case '1' -> addJob();
                    case '2' -> viewJobs();
                    case '3' -> editJob();
                    case '4' -> deleteJob();
                    case '5' -> viewRecruiterProfile();
                    case '6' -> editRecruiterProfile();
                    case '7' -> {
                        System.out.println("Thank you for using Job Agency");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid Choice - Please Try Again choose from 1-5");
                }
            }while (choice!= '7');
            System.out.println("Thank you for using Job Agency");

        } else if (Option.equals("Employee") || Option.equals("employee")) {
            do{
                System.out.println("Welcome to Job Agency");
                System.out.println("***********************");
                System.out.println("1. View Job");
                System.out.println("2. Apply for Jobs");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = EasyScanner.nextInt();
                switch (choice)
                {
                    case '1' -> viewJobs();
                    case '2' -> applyJobs();
                    case '3' -> System.exit(0);
                    default -> System.out.println("Invalid Choice - Please Try Again choose from 1-3");
                }
            }while (choice!= '3');
        }
    }

    public static void applyJobs() {


    }

    static void addJob() {
        String title;
        Double salary;
        String description;
        String category;
        String location;
        String startDate;
        String endDate;

        Scanner EasyScanner = new Scanner(System.in);
        System.out.print("Enter Job Title: ");
        title = EasyScanner.nextLine();
        System.out.print("Enter Job Salary: ");
        salary = EasyScanner.nextDouble();
        System.out.print("Enter Job Description: ");
        description = EasyScanner.nextLine();
        System.out.print("Enter Job Category: ");
        category = EasyScanner.nextLine();
        System.out.print("Enter Job Location: ");
        location = EasyScanner.nextLine();
        System.out.print("Enter Job Start Date: ");
        startDate = EasyScanner.nextLine();
        System.out.print("Enter Job End Date: ");
        endDate = EasyScanner.nextLine();
        JobList job = new JobList(title, salary, description, category, location, startDate, endDate);
        JobList.addJob(job);
    }
    static void viewJobs() {
        for(JobList job : JobList.getjobList) {
            System.out.println(job.toString());
        }
    }
    public static void editJob() {
        Scanner EasyScanner = new Scanner(System.in);
        System.out.print("Enter Job Title to edit: ");
        String Title = EasyScanner.nextLine();

        ArrayList<String> job = JobList.findJob(Title);
        if(job !=null) {
            System.out.print("Enter Job Title: ");
            String title = EasyScanner.nextLine();
            System.out.print("Enter Job Salary: ");
            double salary = EasyScanner.nextDouble();
            System.out.print("Enter Job Description: ");
            String description = EasyScanner.nextLine();
            System.out.print("Enter Job Category: ");
            String category = EasyScanner.nextLine();
            System.out.print("Enter Job Location: ");
            String location = EasyScanner.nextLine();
            System.out.print("Enter Job Start Date: ");
            String startDate = EasyScanner.nextLine();
            System.out.print("Enter Job End Date: ");
            String endDate = EasyScanner.nextLine();
        }
        else {
            System.out.println("Invalid Job Title");
        }
    }

    public static void deleteJob() {
        Scanner EasyScanner = new Scanner(System.in);
        System.out.print("Enter Job Title: ");
        String title = EasyScanner.nextLine();
        System.out.print("Enter Job Salary: ");
        double salary = EasyScanner.nextDouble();
        System.out.print("Enter Job Description: ");
        String description = EasyScanner.nextLine();
        System.out.print("Enter Job Category: ");
        String category = EasyScanner.nextLine();
        System.out.print("Enter Job Location: ");
        String location = EasyScanner.nextLine();
        System.out.print("Enter Job Start Date: ");
        String startDate = EasyScanner.nextLine();
        System.out.print("Enter Job End Date: ");
        String endDate = EasyScanner.nextLine();
    }
    public static void viewRecruiterProfile() {


    }
    public static void editRecruiterProfile() {
    }
}
