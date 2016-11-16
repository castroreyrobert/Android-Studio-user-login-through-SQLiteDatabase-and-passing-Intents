package com.mysamples.basiclogin;


public class Students {
    int id;
    String username, password, firstname, lastname, grades;


    public Students(){}


    public Students(String username, String password,  String firstname,String lastname, String  grades) {
        this.password = password;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.grades = grades;
    }

    public String  getGrades() {
        return this.grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
