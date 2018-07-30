package com.FirstTry.First.Repository;

import com.FirstTry.First.Model.Credential;
import com.FirstTry.First.Model.Data;
import com.FirstTry.First.Model.urlObj;

public interface myinterface {

    Credential login(Credential cd);

    Data getData(urlObj clientCode);

}
