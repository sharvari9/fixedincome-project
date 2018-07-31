package com.FirstTry.First.Implementation;

import com.FirstTry.First.Model.*;
import com.FirstTry.First.Repository.myinterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class MyImplementation implements myinterface {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public LoginResponse login(Credential cd) {
        LoginResponse loginResponse = new LoginResponse();
        String client_code = cd.getClient_code();
        if (client_code.length() == 0) {
            loginResponse.setStatus(0);
            return loginResponse;
        }
        String recievedPwd = cd.getPassword();
        String sql = "select * from client_master where CLIENT_CODE = ?";
        Credential trueCredential;
        try {
            trueCredential = jdbcTemplate.queryForObject(sql, new Object[]{client_code}, new BeanPropertyRowMapper<>(Credential.class));
        } catch (Exception e) {
            loginResponse.setStatus(0);
            return loginResponse;
        }

        System.out.println("True Credential : \n" + trueCredential.toString());
        System.out.println("Received Credential : \n" + cd.toString());
        if (trueCredential.getPassword().equals(recievedPwd)) {
            loginResponse.setStatus(1);
            loginResponse.setClient_code(cd.getClient_code());
        } else {
            loginResponse.setStatus(0);
        }
        return loginResponse;
    }


    @Override
    public listData getSecuritiesList(GetDataInput cc) {
        String client_code = cc.getClientCode();

        String clientSql = "select * from client_master where CLIENT_CODE=?";
        Credential cdt = jdbcTemplate.queryForObject(clientSql, new Object[]{client_code}, new BeanPropertyRowMapper<>(Credential.class));
        // System.out.println("hello clientdt "+cdt.toString());
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setCode(cdt.getClient_code());
        clientInfo.setCountry(cdt.getCountry());
        clientInfo.setName(cdt.getCLINET_NAME());

        System.out.println("hello clientcode is " + client_code);
        String portfolioSql = "select * from portfolio where CLIENT_CODE=?";
        List<listPortfolioDT> list = jdbcTemplate.query(portfolioSql, new Object[]{client_code}, new BeanPropertyRowMapper<>(listPortfolioDT.class));
        System.out.println("hello list is " + list.toString());

        ArrayList<Double> prices = new ArrayList<>(list.size());
        String priceSql = "select PRICE from security_price where SYMBOL=? and DATE=? ";
        String date, secCode;
        for (listPortfolioDT l : list) {
            secCode = l.getPortfolio();
           // date = l.getBuy_date();
            Double price = jdbcTemplate.queryForObject(priceSql, new Object[]{secCode, "07/22/2018"}, Double.class);
            prices.add(price);
        }
        int size = list.size();
        ArrayList<SecurityRow> rows = new ArrayList<>(size);
        double bp,cp,n,tg,diff;
        for (int i = 0; i < size; i++) {
            SecurityRow sr = new SecurityRow();
            sr.setBoughtprice(list.get(i).getBuy_price());
            sr.setNotional(list.get(i).getNotional());
            sr.setSecurityCode(list.get(i).getPortfolio());
            sr.setTradeDate(list.get(i).getBuy_date());
            sr.setMarketprice(prices.get(i));
            sr.setSecurityName(list.get(i).getSecurity_name());
            bp=sr.getBoughtprice();
            cp=sr.getMarketprice();
            n=new Double(sr.getNotional());
            diff=cp-bp;
            diff/=bp;
            tg=diff*n;
            tg=tg/n;
            tg*=100;
            tg*=100;
            tg=Math.round(tg)/100.0;
            sr.setGainPercentage(tg);
            rows.add(sr);
        }

        listData ld=new listData();
        ld.setClientInfo(clientInfo);
        ld.setRows(rows);
        return ld;
    }

    @Override
    public Data getFullData(clickCodes codes) {
        String clientCode = codes.getClientCode();
        String secCode = codes.getSecurityCode();

        String clientSql = "select * from client_master where CLIENT_CODE=?";
        Credential cdt = jdbcTemplate.queryForObject(clientSql, new Object[]{clientCode}, new BeanPropertyRowMapper<>(Credential.class));
        // System.out.println("hello clientdt "+cdt.toString());
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setCode(cdt.getClient_code());
        clientInfo.setCountry(cdt.getCountry());
        clientInfo.setName(cdt.getCLINET_NAME());

        String portfolioSql = "select * from portfolio where CLIENT_CODE=? and PORTFOLIO=?";
        listPortfolioDT lpdt = jdbcTemplate.queryForObject(portfolioSql, new Object[]{clientCode, secCode}, new BeanPropertyRowMapper<>(listPortfolioDT.class));

        String securitySql = "select * from security_master where SYMBOL=?";
        securityDT sdt = jdbcTemplate.queryForObject(securitySql, new Object[]{secCode}, new BeanPropertyRowMapper<>(securityDT.class));

        fullSecurityInfo fsi = new fullSecurityInfo();
        fsi.setBuyDate(lpdt.getBuy_date());
        fsi.setBuyPrice(lpdt.getBuy_price());
        fsi.setCouponFreq(sdt.getCpn_freq());
        fsi.setCouponRate(sdt.getCoupon());
        fsi.setCurrrentPrice(sdt.getPrice());
        fsi.setName(lpdt.getSecurity_name());
        fsi.setNotional(lpdt.getNotional());
        fsi.setSecCode(sdt.getSymbol());


        ResultValues rv = new ResultValues();
        double cleanPrice=fsi.getCurrrentPrice();
        double accruedInterest, timeFactor,interestFactor;
        String cpf=fsi.getCouponFreq();
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
         timeFactor = 5.0 / days; // should change the numerator value depending on day queried
         interestFactor = (fsi.getCouponRate() / 100.0) / ppy;
         accruedInterest = timeFactor * interestFactor * 100;
         accruedInterest*=1000;
         long ai=Math.round(accruedInterest);
         double accinterest=ai/1000.0;

        rv.setAccruedInterest(accinterest);
        rv.setCleanPrice(cleanPrice);

        rv.setDirtyPrice(cleanPrice + accinterest);
        double diff=fsi.getCurrrentPrice()-fsi.getBuyPrice();
        System.out.println("notional value is "+fsi.getNotional());
        double tGain=(diff/fsi.getBuyPrice())*new Double(fsi.getNotional());
        tGain*=100;
        tGain=Math.round(tGain)/100.0;
        rv.setTotalGain(tGain);

        String marketPricesSql = "select * from security_price where SYMBOL=?";
        List<priceDT> pricesList = jdbcTemplate.query(marketPricesSql, new Object[]{secCode},new BeanPropertyRowMapper<>(priceDT.class));
        System.out.println(pricesList.toString());
        ArrayList<marketPrice> prices=new ArrayList<>(pricesList.size());
        for(priceDT p:pricesList){
            marketPrice mp=new marketPrice();
            mp.setDate(p.getDate());
            mp.setPrice(p.getPrice());
            prices.add(mp);
        }

        Data d=new Data();
        d.setClientInfo(clientInfo);
        d.setPriceList(prices);
        d.setResultValues(rv);
        d.setSecurityInfo(fsi);
        return d;
    }


}
