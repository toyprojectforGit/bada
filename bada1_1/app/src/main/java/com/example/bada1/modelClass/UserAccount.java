package com.example.bada1.modelClass;
/*
사용자 계정 정보 모델 클래스, 닉네임도 추후 저장해야함
 */
public class UserAccount
{
    private String idToken;    //파이어베이스 Uid (고유 토큰정보)
    private String emailId;    //이메일 아이디
    private String password;   //비밀번호
    private String location;
    private String topic;

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

    public UserAccount() { }   //파이어베이스 realtime 사용할때는 무조건 빈 객체 생성해줘야함

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
