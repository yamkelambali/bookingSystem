package com.startup.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Yamkela Mbali
 * desc : Entity for User
 */

@Entity
public class User{
    @Id
    private String username;
    private String password, userId, name, surname, cellNo, emailAddress;

    protected User(){}

    private User(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
        this.userId = builder.userId;
        this.name = builder.name;
        this.surname = builder.name;
        this.cellNo = builder.cellNo;
        this.emailAddress = builder.emailAddress;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCellNo() {
        return cellNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cellNo='" + cellNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +

                '}';
    }

    public static class Builder {

        private String username, password, userId, name, surname, cellNo, emailAddress, loginStatus;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setSurName(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setCellNo(String cellNo) {
            this.cellNo = cellNo;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }
        public Builder setLoginStatus(String loginStatus) {
            this.loginStatus = loginStatus;
            return this;
        }

        public Builder copy(User user){
            this.username = user.username;
            this.password = user.password;
            this.name = user.name;
            this.surname = user.surname;
            this.userId = user.userId;
            this.cellNo = user.cellNo;
            this.emailAddress = user.emailAddress;


            return this;
        }

        public User build(){
            return new User(this);
        }

    }

}
