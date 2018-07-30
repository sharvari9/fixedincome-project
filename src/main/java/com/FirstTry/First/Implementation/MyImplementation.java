package com.FirstTry.First.Implementation;

import com.FirstTry.First.Model.*;
import com.FirstTry.First.Repository.myinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;


@Repository
public class MyImplementation implements myinterface {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public LoginResponse login(Credential cd) {
        LoginResponse loginResponse = new LoginResponse();
        String client_code = cd.getClient_code();
        if(client_code.length()  == 0){
            loginResponse.setStatus(0);
            return loginResponse;
        }
        String recievedPwd = cd.getPassword();
        String sql = "select * from client_master where CLIENT_CODE = ?";
        Credential trueCredential;
        try {
            trueCredential = jdbcTemplate.queryForObject(sql, new Object[]{client_code}, new BeanPropertyRowMapper<>(Credential.class));
        }
        catch(Exception e){
            loginResponse.setStatus(0);
            return loginResponse;
        }

        System.out.println("True Credential : \n"+trueCredential.toString());
        System.out.println("Received Credential : \n"+cd.toString());
        if(trueCredential.getPassword().equals(recievedPwd)){
            loginResponse.setStatus(1);
            loginResponse.setClient_code(cd.getClient_code());
        }
        else{
            loginResponse.setStatus(0);
        }
        return loginResponse;
    }

    @Override
    public Data getData(GetDataInput obj) {
        String clientCode=obj.getClientCode();
       // System.out.println("received "+ obj.getClientCode());
        String clientSql = "select * from client_master where CLIENT_CODE=?";
        Credential cdt = jdbcTemplate.queryForObject(clientSql, new Object[]{clientCode}, new BeanPropertyRowMapper<>(Credential.class));
       // System.out.println("hello clientdt "+cdt.toString());
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setCode(cdt.getClient_code());
        clientInfo.setCountry(cdt.getCountry());
        clientInfo.setName(cdt.getCLINET_NAME());


        String portfolioSql = "select * from portfolio where CLIENT_CODE=?";
        clientPortfolioDT cpdt = jdbcTemplate.queryForObject(portfolioSql, new Object[]{clientCode}, new BeanPropertyRowMapper<>(clientPortfolioDT.class));
        //System.out.println("hello clientportfoliodt "+cpdt.toString());


        String securitySql = "select * from security_master where SYMBOL=?";
        String symbol=cpdt.getSymbol();
        securityDT sdt = jdbcTemplate.queryForObject(securitySql, new Object[]{symbol}, new BeanPropertyRowMapper<>(securityDT.class));
        SecurityInfo securityInfo = new SecurityInfo();
       // System.out.println("hello babidi "+sdt.toString());
        securityInfo.setCouponFreq(sdt.getCpn_freq());
        securityInfo.setCouponRate(sdt.getCoupon());
        securityInfo.setName(sdt.getSecurity());
        securityInfo.setNotional(cpdt.getNotional());
        securityInfo.setPrice(sdt.getPrice());
        securityInfo.setSymbol(sdt.getSymbol());

        ResultValues rv = new ResultValues();
        rv.setCleanPrice(securityInfo.getPrice());
        String cpf = securityInfo.getCouponFreq();

        double days = 1;
        int ppy = 0;
        switch (cpf) {
            case "H":
                days = 180;
                ppy = 2;
                break;
            case "Q":
                days = 90;
                ppy = 4;
                break;
            case "Y":
                days = 360;
                ppy = 1;

        }
        double timefactor = 5.0 / days; // should change the numerator value depending on day queried
        double interestFactor = (securityInfo.getCouponRate() / 100.0) / ppy;
        double accruedInterest = timefactor * interestFactor * 100;
        rv.setAccruedInterest(accruedInterest);
        rv.setDirtyPrice(securityInfo.getPrice() + accruedInterest);

        String priceSql="select PRICE from security_price where SYMBOL=? and Date=?";
       // Date date='2018-07-1';
        priceDT pdt=jdbcTemplate.queryForObject(priceSql,new Object[]{symbol,"2018-07-25"},new BeanPropertyRowMapper<>(priceDT.class));
        System.out.println("bght price is "+pdt.getPrice());
        double diff = pdt.getPrice()-securityInfo.getPrice(), tgain = diff + accruedInterest;// change the value to purchased price..tell chinki to update dates in price table
        rv.setTotalGain(tgain);

        Data data = new Data();
        data.setClientInfo(clientInfo);
        data.setResultValues(rv);
        data.setSecurityInfo(securityInfo);
        return data;
    }
}
