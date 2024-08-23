package user;

import base.BaseClient;
import io.restassured.response.Response;

public class CreateUserApi extends BaseClient {
    private final String apiPathRegister = "/api/auth/register";

    public Response postCreateUser(User user) {
        return doNotAuthPostRequest(apiPathRegister, user);
    }

}
