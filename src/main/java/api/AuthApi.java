package api;

import api.payload.AuthRequestPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.util.ApiEndpoints.AUTH_ENDPOINT;
import static api.util.ApiEndpoints.BASE_URL;
import static io.restassured.RestAssured.given;

public final class AuthApi {
    private AuthApi() {
    }

    public static Response createToken(AuthRequestPayload authRequestPayload) {
        return given().contentType(ContentType.JSON)
                .body(authRequestPayload)
                .when()
                .post(BASE_URL + AUTH_ENDPOINT);
    }
}
