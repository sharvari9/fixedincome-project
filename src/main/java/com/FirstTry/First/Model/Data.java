package com.FirstTry.First.Model;

public class Data {
    ClientInfo clientInfo;
    ResultValues resultValues;
    SecurityInfo securityInfo;

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public void setResultValues(ResultValues resultValues) {
        this.resultValues = resultValues;
    }

    public void setSecurityInfo(SecurityInfo securityInfo) {
        this.securityInfo = securityInfo;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public ResultValues getResultValues() {
        return resultValues;
    }

    public SecurityInfo getSecurityInfo() {
        return securityInfo;
    }
}
