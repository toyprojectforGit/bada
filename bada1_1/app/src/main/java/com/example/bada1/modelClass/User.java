package com.example.bada1.modelClass;

public class User {
    private String Profile;
    private String location;
    private String topic;
    private String emailId;



    public String getProfile() {
        return Profile;
    }

    public void setProfile(String profile) {
        Profile = profile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setId(String emsailId) {this.emailId = emsailId;
    }

    public User(){

    }

    public void setRole(String cap) {
    }
}

