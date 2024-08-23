package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseClient {
    private RequestSpecification baseRequestSpecNotAuth() {
        return new RequestSpecBuilder()
                .setBaseUri(URL.HOST)
                .addHeader("Content-type", "application/json")
                .setRelaxedHTTPSValidation()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .build();
    }

    private RequestSpecification baseRequestSpecAuth(String token) {
        return new RequestSpecBuilder()
                .setBaseUri(URL.HOST)
                .addHeader("Authorization", token)
                .setRelaxedHTTPSValidation()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .build();
    }

    protected Response doNotAuthPostRequest(String path, Object body) {
        return given()
                .spec(baseRequestSpecNotAuth())
                .body(body)
                .post(path)
                .thenReturn();
    }

    protected Response doDeleteRequest(String apiPathDelete, String token) {
        return given()
                .spec(baseRequestSpecAuth(token))
                .delete("/api/auth/user")
                .thenReturn();
    }
}
