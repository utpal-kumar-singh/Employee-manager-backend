package com.utpal.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity

public class Employee  implements Serializable {
    @Column(nullable = false,updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phoneNumber;
    private  String imageUrl;
    @Column(nullable = false,updatable = false)
    private  String employeeCode;

    public Employee()
    {}
    public  Employee(String email, String name, String jobTitle, String phoneNumber, String imageUrl, String employeeCode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.jobTitle = jobTitle;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;



    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name =name;
    }


    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email= email;
    }


    public String getJobTitle(){
        return jobTitle;

    }
    public void setJobTitle(String jobTitle){

        this.jobTitle =jobTitle;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber =phoneNumber;
    }
    public  String getImageUrl(){
        return imageUrl;

    }
    public void setImageUrl(String imageUrl){
        this.imageUrl =imageUrl;
    }
    public  String getEmployeeCode(){
        return employeeCode;
    }
    public void setEmployeeCode(String employeeCode){
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString(){
        return "Employee{" +
                "id=" + id +
                ", name= ' " + '\''+
                ", email= ' " +'\''+
                ",jobTitle= ' " +'\''+
                ",phoneNumber= ' " + '\''+
                ",imageUrl " + '\''+
                '}';
    }

}
