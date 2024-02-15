package com.solvd.test.api;

import com.solvd.test.api.domain.User;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class GetUserTests {
    @Test
    public void verifyUserByIdIsCorrectTest() {
        User user = new User();
        user.setId(2);
        user.setEmail("janet.weaver@reqres.in");
        user.setFirstName("Janet");
        user.setLastName("Weaver");

        GetUserByIdMethod getSingleUserById = new GetUserByIdMethod(user.getId());
        getSingleUserById.addProperty("user", user);

        getSingleUserById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getSingleUserById.callAPI();
        getSingleUserById.validateResponse();
    }

    @Test
    public void verifyGetUserNotFoundTest() {
        User user = new User();
        user.setId(23);

        GetUserByIdMethod getSingleUserById = new GetUserByIdMethod(user.getId());

        getSingleUserById.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        getSingleUserById.callAPI();
    }
}