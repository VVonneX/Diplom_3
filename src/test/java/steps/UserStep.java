package steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import user.AuthorizationUserApi;
import user.CreateUserApi;
import user.DeleteUserApi;
import user.User;

public class UserStep {

    private CreateUserApi createUserApi = new CreateUserApi();
    private DeleteUserApi deleteUserApi = new DeleteUserApi();
    private AuthorizationUserApi authorizationUserApi = new AuthorizationUserApi();

    @Step("Checking the status code and response of the POST request when creating a user")
    public void postCreateUser(User user) {
        ValidatableResponse response = createUserApi.postCreateUser(user).then();
        response.assertThat().statusCode(200);
    }

    @Step("asdasdasda")
    public void deleteUser(User user) {
        ValidatableResponse response = authorizationUserApi.postAuthUser(user).then();
        user = response.extract().body().as(User.class);
        String token = user.getAccessToken();

        ValidatableResponse responseDelete = deleteUserApi.deleteUser(token).then();
        responseDelete.assertThat().statusCode(202);
    }
}
