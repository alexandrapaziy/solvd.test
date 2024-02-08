package com.solvd.test.api.register;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.api_url}/api/register", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/register/register_unsuccessful_rq.json")
@ResponseTemplatePath(path = "api/register/register_unsuccessful_rs.json")
public class RegisterUnsuccessful extends AbstractApiMethodV2 {
    public RegisterUnsuccessful() {
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
