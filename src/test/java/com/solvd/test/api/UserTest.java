package com.solvd.test.api;

import com.solvd.test.domain.User;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class UserTest {
    @Test
    public void verifyCreateUserTest() {
        User user = new User();
        user.setName("morpheus");
        user.setJob("leader");

        CreateUser createUser = new CreateUser();
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

        UpdateUserPut updateUserPut = new UpdateUserPut(user.getId());
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

        UpdateUserPatch updateUserPatch = new UpdateUserPatch(user.getId());
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

        DeleteUser deleteUser = new DeleteUser(user.getId());

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