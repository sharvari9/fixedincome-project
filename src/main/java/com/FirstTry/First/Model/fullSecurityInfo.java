package com.FirstTry.First.Model;

public class fullSecurityInfo {

    String name,secCode, CouponFreq,buyDate,notional;
    Double currrentPrice,couponRate,buyPrice;

    public void setName(String name) {
        this.name = name;
    }

    public void setSecCode(String secCode) {
        this.secCode = secCode;
    }

    public void setCouponFreq(String couponFreq) {
        CouponFreq = couponFreq;
    }

    public String getName() {
        return name;
    }

    public String getSecCode() {
        return secCode;
    }

    public String getCouponFreq() {
        return CouponFreq;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public String getNotional() {
        return notional;
    }

    public Double getCurrrentPrice() {
        return currrentPrice;
    }

    public Double getCouponRate() {
        return couponRate;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public void setNotional(String notional) {
        this.notional = notional;
    }

    public void setCurrrentPrice(Double currrentPrice) {
        this.currrentPrice = currrentPrice;
    }

    public void setCouponRate(Double couponRate) {
        this.couponRate = couponRate;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }
}
