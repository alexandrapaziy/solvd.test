package com.solvd.test.api;

import com.solvd.test.api.login.LoginSuccessful;
import com.solvd.test.api.login.LoginUnsuccessful;
import com.solvd.test.domain.User;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class LoginTests {
    @Test
    public void verifyLoginSuccessfulTest() {
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("cityslicka");

        LoginSuccessful loginSuccessful = new LoginSuccessful();
        loginSuccessful.addProperty("user", user);

        loginSuccessful.expectResponseStatus(HttpResponseStatusType.OK_200);
        loginSuccessful.callAPI();
        loginSuccessful.validateResponse();
    }

    @Test
    public void verifyLoginUnsuccessfulTest() {
        User user = new User();
        user.setEmail("peter@klaven");

        LoginUnsuccessful loginUnsuccessful = new LoginUnsuccessful();
        loginUnsuccessful.addProperty("user", user);

        loginUnsuccessful.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
        loginUnsuccessful.callAPI();
        loginUnsuccessful.validateResponse();
    }
}