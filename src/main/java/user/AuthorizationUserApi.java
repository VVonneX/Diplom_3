package user;

import base.BaseClient;
import io.restassured.response.Response;

public class AuthorizationUserApi extends BaseClient {
    private final String apiPathLogin = "/api/auth/login";

    public Response postAuthUser(User user) {
        return doNotAuthPostRequest(apiPathLogin, user);
    }
}
