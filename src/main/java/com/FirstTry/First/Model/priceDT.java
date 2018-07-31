package com.FirstTry.First.Model;

import java.sql.Date;

public class priceDT {
  String symbol;
  Double price;
  String date;

    public String getSymbol() {
        return symbol;
    }

    public Double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "priceDT{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }

    public void setDate(String date) {
        this.date = date;
    }
}
