package com.FirstTry.First.Repository;

import com.FirstTry.First.Model.Credential;
import com.FirstTry.First.Model.Data;

public interface myinterface {

    int login(Credential cd);

    Data getData(String clientCode);

}
