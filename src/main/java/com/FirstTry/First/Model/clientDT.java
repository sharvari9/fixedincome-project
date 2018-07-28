package com.FirstTry.First.Model;

public class clientDT {
    String CLINET_NAME,CLIENT_CODE, COUNTRY, PASSWORD;

    public String getCLINET_NAME() {
        return CLINET_NAME;
    }

    public String getCLIENT_CODE() {
        return CLIENT_CODE;
    }

    @Override
    public String toString() {
        return "clientDT{" +
                "CLINET_NAME='" + CLINET_NAME + '\'' +
                ", CLIENT_CODE='" + CLIENT_CODE + '\'' +
                ", COUNTRY='" + COUNTRY + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                '}';
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
}
