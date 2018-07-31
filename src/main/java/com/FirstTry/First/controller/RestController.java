package com.FirstTry.First.controller;

import com.FirstTry.First.Implementation.MyImplementation;
import com.FirstTry.First.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(allowedHeaders = {"Origin","X-Requested-With","Content-Type","Accept" },methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.HEAD})
public class RestController {
    @Autowired
    MyImplementation mi;

    @RequestMapping(value = "/login")
    public LoginResponse login(@RequestBody Credential cd)//database obj
    {
        return mi.login(cd);
    }

    @RequestMapping(value = "/getlistdata")
    public listData getListData(@RequestBody GetDataInput clientCode ){

        // System.out.println("calling get");
        listData d=mi.getSecuritiesList(clientCode);
        return d;
    }

    @RequestMapping(value = "/getFulldata")
    public Data getListData(@RequestBody clickCodes codes ){

        // System.out.println("calling get");
        Data d=mi.getFullData(codes);
        return d;
    }
}
