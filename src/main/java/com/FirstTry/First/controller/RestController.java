package com.FirstTry.First.controller;

import com.FirstTry.First.Implementation.MyImplementation;
import com.FirstTry.First.Model.Credential;
import com.FirstTry.First.Model.Data;
import com.FirstTry.First.Model.LoginResponse;
import com.FirstTry.First.Model.GetDataInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

@RequestMapping(value = "/getdata")
    public Data getData(@RequestBody GetDataInput clientCode ){

       // System.out.println("calling get");
        Data d=mi.getData(clientCode);
        return d;
}
}
