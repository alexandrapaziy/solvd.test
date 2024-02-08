package com.solvd.test.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.api_url}/api/users?page=${page_number}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/users/get_users_rs.json")
public class GetUsersMethod extends AbstractApiMethodV2 {
    public GetUsersMethod(int pageNumber) {
        replaceUrlPlaceholder("page_number", String.valueOf(pageNumber));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}