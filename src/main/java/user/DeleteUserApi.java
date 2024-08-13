package user;

import base.BaseClient;
import io.restassured.response.Response;

public class DeleteUserApi extends BaseClient {
    private final String apiDelete = "/api/auth/user";

    public Response deleteUser(String token) {
        return doDeleteRequest(apiDelete, token);
    }
}
