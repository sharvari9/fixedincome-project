package com.FirstTry.First.Model;

public class securityDT {
    String SYMBOL,SECURITY,DCC,CPN_FREQ;

    Double COUPON,Day_Change,PRICE;

    public String getSYMBOL() {
        return SYMBOL;
    }

    public String getSECURITY() {
        return SECURITY;
    }

    public String getDCC() {
        return DCC;
    }

    public String getCPN_FREQ() {
        return CPN_FREQ;
    }

    public Double getCOUPON() {
        return COUPON;
    }

    public Double getDay_Change() {
        return Day_Change;
    }

    public Double getPRICE() {
        return PRICE;
    }

    @Override
    public String toString() {
        return "securityDT{" +
                "SYMBOL='" + SYMBOL + '\'' +
                ", SECURITY='" + SECURITY + '\'' +
                ", DCC='" + DCC + '\'' +
                ", CPN_FREQ='" + CPN_FREQ + '\'' +
                ", COUPON=" + COUPON +
                ", Day_Change=" + Day_Change +
                ", PRICE=" + PRICE +
                '}';
    }
}
