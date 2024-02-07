package com.solvd.test.api;

import com.solvd.test.api.login.LoginSuccessful;
import com.solvd.test.api.login.LoginUnsuccessful;
import com.solvd.test.domain.User;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    public void verifyLoginSuccessful() {
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("cityslicka");

        LoginSuccessful loginSuccessful = new LoginSuccessful();
        loginSuccessful.addProperty("user", user);

        loginSuccessful.expectResponseStatus(HttpResponseStatusType.OK_200);
        loginSuccessful.callAPI();
    }

    @Test
    public void verifyLoginUnsuccessful() {
        User user = new User();
        user.setEmail("peter@klaven");

        LoginUnsuccessful loginUnsuccessful = new LoginUnsuccessful();
        loginUnsuccessful.addProperty("user", user);

        loginUnsuccessful.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
        loginUnsuccessful.callAPI();
    }
}