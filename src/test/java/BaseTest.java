import api.AuthApi;
import api.PingApi;
import api.payload.AuthRequestPayload;
import api.payload.AuthResponsePayload;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.emptyString;

class BaseTest {
    protected final Faker faker = new Faker();
    protected String token;

    @BeforeClass(alwaysRun = true)
    void testHealthCheckReturns201() {
        Response response = PingApi.healthCheck();

        Assert.assertEquals(response.statusCode(), SC_CREATED);
    }

    @BeforeMethod(alwaysRun = true)
    void testCreateTokenReturns200() {
        AuthRequestPayload authRequestPayload =
                AuthRequestPayload.builder().username("admin").password("password123").build();

        Response response = AuthApi.createToken(authRequestPayload);
        token = response.as(AuthResponsePayload.class).getToken();

        Assert.assertEquals(response.statusCode(), SC_OK);
    }

    @Test
    void testCreateTokenReturnsNonEmptyToken() {
        Assert.assertNotEquals(token, emptyString());
    }
}
