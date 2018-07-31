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
}
