package com.solvd.test.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.api_url}/api/users/${user_id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/users/get_user_rs.json")
public class GetUserById extends AbstractApiMethodV2 {
    public GetUserById(int userId) {
        replaceUrlPlaceholder("user_id", String.valueOf(userId));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}