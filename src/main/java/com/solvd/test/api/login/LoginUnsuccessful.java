package com.solvd.test.api.login;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.api_url}/api/login", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/users/login/login_unsuccessful_rq.json")
@ResponseTemplatePath(path = "api/users/login/login_unsuccessful_rs.json")
public class LoginUnsuccessful extends AbstractApiMethodV2 {
    public LoginUnsuccessful() {
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}