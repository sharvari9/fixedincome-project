package com.FirstTry.First.Model;

public class listPortfolioDT {

    String CLIENT_CODE;
    String PORTFOLIO;
    String NOTIONAL;
    String BUY_DATE;
    Double BUY_PRICE;
    String SECURITY_NAME;

    public String getClient_code() {
        return CLIENT_CODE;
    }

    public void setCLIENT_CODE(String CLIENT_CODE) {
        this.CLIENT_CODE = CLIENT_CODE;
    }

    public void setPORTFOLIO(String PORTFOLIO) {
        this.PORTFOLIO = PORTFOLIO;
    }

    public void setNOTIONAL(String NOTIONAL) {
        this.NOTIONAL = NOTIONAL;
    }

    public void setBUY_DATE(String BUY_DATE) {
        this.BUY_DATE = BUY_DATE;
    }

    public void setBUY_PRICE(Double BUY_PRICE) {
        this.BUY_PRICE = BUY_PRICE;
    }

    public void setSECURITY_NAME(String SECURITY_NAME) {
        this.SECURITY_NAME = SECURITY_NAME;
    }

    public String getPortfolio() {
        return PORTFOLIO;
    }

    public String getNotional() {
        return NOTIONAL;
    }

    public String getBuy_date() {
        return BUY_DATE;
    }

    public Double getBuy_price() {
        return BUY_PRICE;
    }

    public String getSecurity_name() {
        return SECURITY_NAME;
    }

    @Override
    public String toString() {
        return "listPortfolioDT{" +
                "CLIENT_CODE='" + CLIENT_CODE + '\'' +
                ", PORTFOLIO='" + PORTFOLIO + '\'' +
                ", NOTIONAL='" + NOTIONAL + '\'' +
                ", BUY_DATE='" + BUY_DATE + '\'' +
                ", BUY_PRICE=" + BUY_PRICE +
                ", SECURITY_NAME='" + SECURITY_NAME + '\'' +
                '}';
    }
}
