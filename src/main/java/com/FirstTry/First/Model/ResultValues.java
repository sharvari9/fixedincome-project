package com.FirstTry.First.Model;

public class ResultValues {

    Double accruedInterest, cleanPrice, dirtyPrice, totalGain,currentNotional;

    public Double getAccruedInterest() {
        return accruedInterest;
    }

    public Double getCurrentNotional() {
        return currentNotional;
    }

    public void setCurrentNotional(Double currentNotional) {
        this.currentNotional = currentNotional;
    }

    public void setAccruedInterest(Double accruedInterest) {
        this.accruedInterest = accruedInterest;
    }

    public Double getCleanPrice() {
        return cleanPrice;
    }

    public void setCleanPrice(Double cleanPrice) {
        this.cleanPrice = cleanPrice;
    }

    public Double getDirtyPrice() {
        return dirtyPrice;
    }

    public void setDirtyPrice(Double dirtyPrice) {
        this.dirtyPrice = dirtyPrice;
    }

    public Double getTotalGain() {
        return totalGain;
    }

    public void setTotalGain(Double totalGain) {
        this.totalGain = totalGain;
    }
}
