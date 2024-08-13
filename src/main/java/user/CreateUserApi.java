package user;

import base.BaseClient;
import io.restassured.response.Response;

public class CreateUserApi extends BaseClient {
    private final String apiPostRegister = "/api/auth/register";

    public Response postCreateUser(User user) {
        return doNotAuthPostRequest(apiPostRegister, user);
    }

}
