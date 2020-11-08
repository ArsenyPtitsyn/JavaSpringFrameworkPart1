package ru.geekbrains.spring.firtstproject;

public class Pupil {
    private long id;
    private String fullName;
    private String grade;
    private String phoneNumber;
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pupil(long id, String fullName, String grade, String phoneNumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("id: %d, name: %s, grade: %s, phone: %s, email: %s",
                id, fullName, grade, phoneNumber, email);
    }
}
