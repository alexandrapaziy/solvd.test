package com.solvd.test.api;

import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUsersTest {
    @Test
    public void verifyUsersAreCorrectTest() {
        int pageNumber = 2;
        int perPage = 6;
        int total = 12;
        int totalPages = 2;

        List<Map<String, Object>> dataList = new ArrayList<>();
        dataList.add(createUserData(7, "michael.lawson@reqres.in", "Michael", "Lawson"));
        dataList.add(createUserData(8, "lindsay.ferguson@reqres.in", "Lindsay", "Ferguson"));
        dataList.add(createUserData(9, "tobias.funke@reqres.in", "Tobias", "Funke"));
        dataList.add(createUserData(10, "byron.fields@reqres.in", "Byron", "Fields"));
        dataList.add(createUserData(11, "george.edwards@reqres.in", "George", "Edwards"));
        dataList.add(createUserData(12, "rachel.howell@reqres.in", "Rachel", "Howell"));

        GetUsersMethod getUsers = new GetUsersMethod(pageNumber);
        getUsers.addProperties(Map.of(
                "page_number", pageNumber,
                "per_page", perPage,
                "total", total,
                "total_pages", totalPages,
                "data", dataList
        ));

        getUsers.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUsers.callAPI();
        getUsers.validateResponse();
    }

    private Map<String, Object> createUserData(int id, String email, String firstName, String lastName) {
        Map<String, Object> userData = new HashMap<>();
        userData.put("id", id);
        userData.put("email", email);
        userData.put("first_name", firstName);
        userData.put("last_name", lastName);
        return userData;
    }
}