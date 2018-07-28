package com.FirstTry.First.Model;

public class clientPortfolioDT {
    String CLIENT_CODE,SYMBOL;
    Double NOTIONAL;

    public String getCLIENT_CODE() {
        return CLIENT_CODE;
    }

    public String getPORTFOLIO() {
        return SYMBOL;
    }

    @Override
    public String toString() {
        return "clientPortfolioDT{" +
                "CLIENT_CODE='" + CLIENT_CODE + '\'' +
                ", SYMBOL='" + SYMBOL + '\'' +
                ", NOTIONAL=" + NOTIONAL +
                '}';
    }

    public Double getNOTIONAL() {
        return NOTIONAL;
    }
}
