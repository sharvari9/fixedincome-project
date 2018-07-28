package com.FirstTry.First.Implementation;

import com.FirstTry.First.Model.*;
import com.FirstTry.First.Repository.myinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class MyImplementation implements myinterface {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int login(Credential cd) {
        String uname = cd.getClient_code();
        String recievedPwd = cd.getPassword();

        String sql = "select * from client_master where CLIENT_CODE = ?";
         Credential originalCd = jdbcTemplate.queryForObject(sql,new Object[]{uname},new BeanPropertyRowMapper<>(Credential.class));
        System.out.println("login object"+originalCd.toString());
        System.out.println("Received PWD :"+ cd.getPassword());
        System.out.println("Password form db"+originalCd.getPassword());
        if(originalCd.getPassword().equals(recievedPwd)){

            return 1;
        }
        else
            return 0;
    }

    @Override
    public Data getData(String clientCode) {
        String clientSql = "select * from client_master where CLIENT_CODE=?";
        clientDT cdt = jdbcTemplate.queryForObject(clientSql, new Object[]{clientCode}, new BeanPropertyRowMapper<>(clientDT.class));
        System.out.println("hello clientdt "+cdt.toString());
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setCode(cdt.getCLIENT_CODE());
        clientInfo.setCountry(cdt.getCOUNTRY());
        clientInfo.setName(cdt.getCLINET_NAME());

//String portfolioSql="select PORTFOLIO from Portfolio where CLIENT_CODE=?";
        // String portfolio=jdbcTemplate.queryForObject(portfolioSql,new Object[]{clientCode},String.class);
        String portfolioSql = "select * from portfolio where CLIENT_CODE=?";
        clientPortfolioDT cpdt = jdbcTemplate.queryForObject(portfolioSql, new Object[]{clientCode}, new BeanPropertyRowMapper<>(clientPortfolioDT.class));
        System.out.println("hello clientportfoliodt "+cpdt.toString());
        String securitySql = "select * from security_master where SYMBOL='TLT'";

        //String symbol=cpdt.getPORTFOLIO();
        //securityDT sdt = jdbcTemplate.queryForObject(securitySql, new Object[]{symbol}, new BeanPropertyRowMapper<>(securityDT.class));
       securityDT sdt=jdbcTemplate.queryForObject(securitySql,new BeanPropertyRowMapper<>(securityDT.class));
        SecurityInfo securityInfo = new SecurityInfo();
        System.out.println("hello babidi "+sdt.toString());
        securityInfo.setCouponFreq(sdt.getCPN_FREQ());
        securityInfo.setCouponRate(sdt.getCOUPON());
        securityInfo.setName(sdt.getSECURITY());
        securityInfo.setNotional(cpdt.getNOTIONAL());
        securityInfo.setPrice(sdt.getPRICE());
        securityInfo.setSymbol(sdt.getSYMBOL());

        ResultValues rv = new ResultValues();
        rv.setCleanPrice(securityInfo.getPrice());
        String cpf = securityInfo.getCouponFreq();

        double days = 2;
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
        double timefactor = 5.0 / days;
        double interestFactor = (securityInfo.getCouponRate() / 100.0) / ppy;
        double accruedInterest = timefactor * interestFactor * 100;
        rv.setAccruedInterest(accruedInterest);
        rv.setDirtyPrice(securityInfo.getPrice() + accruedInterest);
        double diff = securityInfo.getPrice() - 60, tgain = diff + accruedInterest;
        rv.setTotalGain(tgain);

        Data data = new Data();
        data.setClientInfo(clientInfo);
        data.setResultValues(rv);
        data.setSecurityInfo(securityInfo);
        return data;
    }
}
