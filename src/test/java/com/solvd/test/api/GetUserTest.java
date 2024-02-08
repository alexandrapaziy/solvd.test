package com.solvd.test.api;

import com.solvd.test.domain.User;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class GetUserTest {
    @Test
    public void verifyGetUserByIdTest() {
        User user = new User();
        user.setId(2);
        user.setEmail("janet.weaver@reqres.in");
        user.setFirstName("Janet");
        user.setLastName("Weaver");

        GetUserById getSingleUserById = new GetUserById(user.getId());
        getSingleUserById.addProperty("user", user);

        getSingleUserById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getSingleUserById.callAPI();
        getSingleUserById.validateResponse();
    }

    @Test
    public void verifyGetUserNotFoundTest() {
        User user = new User();
        user.setId(23);

        GetUserById getSingleUserById = new GetUserById(user.getId());
        getSingleUserById.addProperty("user", user);

        getSingleUserById.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getSingleUserById.callAPI();
    }
}