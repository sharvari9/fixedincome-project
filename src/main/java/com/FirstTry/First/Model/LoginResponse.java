package com.FirstTry.First.Model;

public class LoginResponse {

    int status; //0 for failed login, 1 for successful login.
    String client_code; // if successful, client_code will be set to something.

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "status=" + status +
                ", client_code='" + client_code + '\'' +
                '}';
    }

    public String getClient_code() {
        return client_code;
    }

    public void setClient_code(String client_code) {
        this.client_code = client_code;
    }
}
