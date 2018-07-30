package com.FirstTry.First.Model;

public class clientPortfolioDT {
    String client_code,symbol;
    Double notional;

    public String getClient_code() {
        return client_code;
    }

    @Override
    public String toString() {
        return "clientPortfolioDT{" +
                "client_code='" + client_code + '\'' +
                ", symbol='" + symbol + '\'' +
                ", notional=" + notional +
                '}';
    }

    public void setClient_code(String client_code) {
        this.client_code = client_code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getNotional() {
        return notional;
    }

    public void setNotional(Double notional) {
        this.notional = notional;
    }
}
