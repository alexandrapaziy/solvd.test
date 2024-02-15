package com.solvd.test.api;

import com.solvd.test.api.domain.User;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class UserTests {
    @Test
    public void verifyCreateUserTest() {
        User user = new User();
        user.setName("morpheus");
        user.setJob("leader");

        CreateUserMethod createUser = new CreateUserMethod();
        createUser.addProperty("user", user);

        createUser.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        createUser.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date -> isDateValid(date));

        createUser.validateResponse(comparatorContext);
    }

    @Test
    public void verifyUpdateUserPutTest() {
        User user = new User();
        user.setId(2);
        user.setName("morpheus");
        user.setJob("zion resident");

        UpdateUserPutMethod updateUserPut = new UpdateUserPutMethod(user.getId());
        updateUserPut.addProperty("user", user);

        updateUserPut.expectResponseStatus(HttpResponseStatusType.OK_200);
        updateUserPut.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date -> isDateValid(date));

        updateUserPut.validateResponse(comparatorContext);
    }

    @Test
    public void verifyUpdateUserPatchTest() {
        User user = new User();
        user.setId(2);
        user.setName("morpheus");
        user.setJob("zion resident");

        UpdateUserPatchMethod updateUserPatch = new UpdateUserPatchMethod(user.getId());
        updateUserPatch.addProperty("user", user);

        updateUserPatch.expectResponseStatus(HttpResponseStatusType.OK_200);
        updateUserPatch.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date -> isDateValid(date));

        updateUserPatch.validateResponse(comparatorContext);
    }

    @Test
    public void verifyDeleteUserTest() {
        User user = new User();
        user.setId(2);

        DeleteUserMethod deleteUser = new DeleteUserMethod(user.getId());

        deleteUser.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        deleteUser.callAPI();
    }

    private static boolean isDateValid(String date) {
        try {
            ZonedDateTime parsedDate = ZonedDateTime.parse(date);
            return parsedDate.isAfter(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault()));
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}