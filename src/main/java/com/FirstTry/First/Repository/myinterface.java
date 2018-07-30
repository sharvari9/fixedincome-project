package com.FirstTry.First.Repository;

import com.FirstTry.First.Model.Credential;
import com.FirstTry.First.Model.Data;
import com.FirstTry.First.Model.LoginResponse;
import com.FirstTry.First.Model.GetDataInput;

public interface myinterface {

    LoginResponse login(Credential cd);

    Data getData(GetDataInput clientCode);

}
