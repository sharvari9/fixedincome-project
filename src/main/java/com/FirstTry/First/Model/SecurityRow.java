package com.FirstTry.First.Model;

public class SecurityRow {

        public String getSecurityName() {
            return securityName;
        }

        public void setSecurityName(String securityName) {
            this.securityName = securityName;
        }

        public String getTradeDate() {
            return tradeDate;
        }

        public void setTradeDate(String tradeDate) {
            this.tradeDate = tradeDate;
        }

        public String getSecurityCode() {
            return securityCode;
        }

        public void setSecurityCode(String securityCode) {
            this.securityCode = securityCode;
        }

        public String getNotional() {
            return notional;
        }

        public void setNotional(String notional) {
            this.notional = notional;
        }

        public double getBoughtprice() {
            return boughtprice;
        }

        public void setBoughtprice(double boughtprice) {
            this.boughtprice = boughtprice;
        }

        public double getMarketprice() {
            return marketprice;
        }

        public void setMarketprice(double marketprice) {
            this.marketprice = marketprice;
        }

        String securityName,tradeDate,securityCode;
        String notional;
        double boughtprice,marketprice;

        double gainPercentage;

    public double getGainPercentage() {
        return gainPercentage;
    }

    public void setGainPercentage(double gainPercentage) {
        this.gainPercentage = gainPercentage;
    }
}
