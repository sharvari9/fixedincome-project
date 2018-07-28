package com.FirstTry.First.Model;

public class Credential {
    String client_code;
    String password;
    String country;
    String clinet_name;

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

    @Override
    public String toString() {
        return "Credential{" +
                "client_code='" + client_code + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", client_name='" + clinet_name + '\'' +
                '}';
    }

    public void setClient_name(String client_name) {
        this.clinet_name = client_name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getClient_name() {
        return clinet_name;
    }

    public String getCountry() {
        return country;
    }
}
