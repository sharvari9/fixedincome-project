package com.FirstTry.First.Repository;

import com.FirstTry.First.Model.*;

import java.util.List;

public interface myinterface {

    LoginResponse login(Credential cd);


    listData getSecuritiesList(GetDataInput cc);

    Data getFullData(clickCodes codes);
}
