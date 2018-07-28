package com.FirstTry.First.Model;

import java.sql.Date;

public class priceDT {

    String SYMBOL;
    Date DATE;
    Double PRICE;

    public String getSYMBOL() {
        return SYMBOL;
    }

    @Override
    public String toString() {
        return "priceDT{" +
                "SYMBOL='" + SYMBOL + '\'' +
                ", DATE=" + DATE +
                ", PRICE=" + PRICE +
                '}';
    }

    public Date getDATE() {
        return DATE;
    }

    public Double getPRICE() {
        return PRICE;
    }
}
