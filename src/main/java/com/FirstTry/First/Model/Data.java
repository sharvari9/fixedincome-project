package com.FirstTry.First.Model;

import java.util.ArrayList;

public class Data {
    ClientInfo clientInfo;
    ResultValues resultValues;
    fullSecurityInfo securityInfo;
    ArrayList<marketPrice> priceList;

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public void setResultValues(ResultValues resultValues) {
        this.resultValues = resultValues;
    }

    public void setSecurityInfo(fullSecurityInfo securityInfo) {
        this.securityInfo = securityInfo;
    }

    public void setPriceList(ArrayList<marketPrice> priceList) {
        this.priceList = priceList;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public ResultValues getResultValues() {
        return resultValues;
    }

    public fullSecurityInfo getSecurityInfo() {
        return securityInfo;
    }

    public ArrayList<marketPrice> getPriceList() {
        return priceList;
    }
}
