package com.solvd.test.api;

import com.solvd.test.api.CreateUser;
import com.solvd.test.api.DeleteUser;
import com.solvd.test.api.UpdateUserPatch;
import com.solvd.test.api.UpdateUserPut;
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
    public void verifyCreateUser() {
        User user = new User();
        user.setName("morpheus");
        user.setJob("leader");

        CreateUser createUser = new CreateUser(user.getName(), user.getJob());
        createUser.addProperty("user", user);

        createUser.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        createUser.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date -> isDateValid(date) && ZonedDateTime.parse(date).isAfter(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault())));

        createUser.validateResponse(comparatorContext);
    }

    @Test
    public void verifyUpdateUserPut() {
        User user = new User();
        user.setId(2);
        user.setName("morpheus");
        user.setJob("zion resident");

        UpdateUserPut updateUserPut = new UpdateUserPut(user.getId());
        updateUserPut.addProperty("user", user);

        updateUserPut.expectResponseStatus(HttpResponseStatusType.OK_200);
        updateUserPut.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date -> isDateValid(date) && ZonedDateTime.parse(date).isAfter(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault())));

        updateUserPut.validateResponse(comparatorContext);
    }

    @Test
    public void verifyUpdateUserPatch() {
        User user = new User();
        user.setId(2);
        user.setName("morpheus");
        user.setJob("zion resident");

        UpdateUserPatch updateUserPatch = new UpdateUserPatch(user.getId());
        updateUserPatch.addProperty("user", user);

        updateUserPatch.expectResponseStatus(HttpResponseStatusType.OK_200);
        updateUserPatch.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date -> isDateValid(date) && ZonedDateTime.parse(date).isAfter(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault())));

        updateUserPatch.validateResponse(comparatorContext);
    }

    @Test
    public void verifyDeleteUser() {
        User user = new User();
        user.setId(2);

        DeleteUser deleteUser = new DeleteUser(user.getId());
        deleteUser.addProperty("user", user);

        deleteUser.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        deleteUser.callAPI();
    }

    private static boolean isDateValid(String date) {
        try {
            ZonedDateTime.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}