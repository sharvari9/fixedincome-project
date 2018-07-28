package com.FirstTry.First.Model;

public class SecurityInfo {
    String name,symbol, CouponFreq;
    Double notional,price,couponRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCouponFreq() {
        return CouponFreq;
    }

    public void setCouponFreq(String couponFreq) {
        CouponFreq = couponFreq;
    }

    public Double getNotional() {
        return notional;
    }

    public void setNotional(Double notional) {
        this.notional = notional;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCouponRate() {
        return couponRate;
    }

    public void setCouponRate(Double couponRate) {
        this.couponRate = couponRate;
    }
}
