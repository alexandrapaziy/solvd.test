package com.solvd.test.api.login;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.api_url}/api/login", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/login/login_successful_rq.json")
@ResponseTemplatePath(path = "api/login/login_successful_rs.json")
public class LoginSuccessful extends AbstractApiMethodV2 {
    public LoginSuccessful() {
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}