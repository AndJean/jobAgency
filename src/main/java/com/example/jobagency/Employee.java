package com.example.jobagency;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private String education;
    private String experience;
    private String skills;


    public Employee(String name, String email,String phone, String address, String gender, String education,String experience, String skills)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.education = education;
        this.experience = experience;
        this.skills = skills;


    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public String getExperience() {
        return experience;
    }
    public void setExperience(String experience) {
        this.experience = experience;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + ", gender=" + gender + ", education=" + education + experience + ", skills=" + skills + '}';
    }

    public boolean hasMatchingSkills(Object relevantSkills) {
        if (relevantSkills == null) {
            return false;
        }
        if (relevantSkills instanceof String) {
            return skills.contains(relevantSkills.toString());
        }
        if (relevantSkills instanceof String[]) {
            for (String s : (String[]) relevantSkills) {
                if (skills.contains(s)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void applyForJob(JobList job) {
        job.addEmployee(this);
        System.out.println(this.name + " has applied for " + job.getName());
    }
}
