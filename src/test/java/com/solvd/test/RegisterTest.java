package com.solvd.test;

import com.solvd.test.api.register.RegisterSuccessful;
import com.solvd.test.api.register.RegisterUnsuccessful;
import com.solvd.test.domain.User;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class RegisterTest {
    @Test
    public void verifyRegistrySuccessful() {
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("pistol");

        RegisterSuccessful registerSuccessful = new RegisterSuccessful();
        registerSuccessful.addProperty("user", user);

        registerSuccessful.expectResponseStatus(HttpResponseStatusType.OK_200);
        registerSuccessful.callAPI();
    }

    @Test
    public void verifyRegistryUnsuccessful() {
        User user = new User();
        user.setEmail("sydney@fife");

        RegisterUnsuccessful registerUnsuccessful = new RegisterUnsuccessful();
        registerUnsuccessful.addProperty("user", user);

        registerUnsuccessful.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
        registerUnsuccessful.callAPI();
    }
}