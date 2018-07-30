package com.FirstTry.First.Model;

public class Credential {
    String client_code;
    String password;
    String country;
    String CLINET_NAME;

    public String getClient_code() {
        return client_code;
    }

    public void setClient_code(String client_code) {
        this.client_code = client_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCLINET_NAME() {
        return CLINET_NAME;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "client_code='" + client_code + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", CLINET_NAME='" + CLINET_NAME + '\'' +
                '}';
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCLINET_NAME(String CLINET_NAME) {
        this.CLINET_NAME = CLINET_NAME;
    }

    public String getCountry() {
        return country;
    }
}
