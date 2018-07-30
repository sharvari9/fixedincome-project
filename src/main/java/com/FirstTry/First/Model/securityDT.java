package com.FirstTry.First.Model;

public class securityDT {
    String symbol,security,dcc,cpn_freq;

    Double coupon,day_change,price;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSecurity() {
        return security;
    }

    @Override
    public String toString() {
        return "securityDT{" +
                "symbol='" + symbol + '\'' +
                ", security='" + security + '\'' +
                ", dcc='" + dcc + '\'' +
                ", cpn_freq='" + cpn_freq + '\'' +
                ", coupon=" + coupon +
                ", day_change=" + day_change +
                ", price=" + price +
                '}';
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getDcc() {
        return dcc;
    }

    public void setDcc(String dcc) {
        this.dcc = dcc;
    }

    public String getCpn_freq() {
        return cpn_freq;
    }

    public void setCpn_freq(String cpn_freq) {
        this.cpn_freq = cpn_freq;
    }

    public Double getCoupon() {
        return coupon;
    }

    public void setCoupon(Double coupon) {
        this.coupon = coupon;
    }

    public Double getDay_change() {
        return day_change;
    }

    public void setDay_change(Double day_change) {
        this.day_change = day_change;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
