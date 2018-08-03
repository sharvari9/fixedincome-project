package com.FirstTry.First.Model;

import java.util.List;

public class listData {

    ClientInfo clientInfo;
    List<SecurityRow> rows;

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public List<SecurityRow> getRows() {
        return rows;
    }

    public void setRows(List<SecurityRow> rows) {
        this.rows = rows;
    }

    double totalNotional, totalGain, totalCurrentValue;

    public double getTotalNotional() {
        return totalNotional;
    }

    public void setTotalNotional(double totalNotional) {
        this.totalNotional = totalNotional;
    }

    public double getTotalGain() {
        return totalGain;
    }

    public void setTotalGain(double totalGain) {
        this.totalGain = totalGain;
    }

    public double getTotalCurrentValue() {
        return totalCurrentValue;
    }

    public void setTotalCurrentValue(double totalCurrentValue) {
        this.totalCurrentValue = totalCurrentValue;
    }
}
