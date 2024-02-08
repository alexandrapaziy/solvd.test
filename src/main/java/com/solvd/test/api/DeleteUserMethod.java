package com.solvd.test.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.api_url}/api/users/${user_id}", methodType = HttpMethodType.DELETE)
public class DeleteUserMethod extends AbstractApiMethodV2 {
    public DeleteUserMethod(int id) {
        replaceUrlPlaceholder("user_id", String.valueOf(id));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}