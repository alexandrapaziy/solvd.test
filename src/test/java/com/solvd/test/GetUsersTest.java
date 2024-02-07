package com.solvd.test;

import com.solvd.test.api.GetUsers;
import com.solvd.test.domain.User;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class GetUsersTest {
    @Test
    public void verifyGetUsers() {
        int pageNumber = 2;
        int perPage = 6;
        int total = 12;
        int totalPages = 2;
        User user = new User();

        GetUsers getUsers = new GetUsers(pageNumber);
        getUsers.addProperty("page_number", pageNumber);
        getUsers.addProperty("per_page", perPage);
        getUsers.addProperty("total", total);
        getUsers.addProperty("total_pages", totalPages);
        getUsers.addProperty("user", user);

        getUsers.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUsers.callAPI();
    }
}