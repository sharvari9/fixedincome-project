package com.FirstTry.First.controller;

import com.FirstTry.First.Implementation.MyImplementation;
import com.FirstTry.First.Model.Credential;
import com.FirstTry.First.Model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(allowedHeaders = {"Origin","X-Requested-With","Content-Type","Accept" },methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.HEAD})
public class RestController {
    @Autowired
    MyImplementation mi;

    @RequestMapping(value = "/login")
    public int login(@RequestBody Credential cd){
        return mi.login(cd);
    }

@RequestMapping(value = "/getdata")
    public Data getData(){
        Data d=mi.getData("A002");
        return d;
}
}
