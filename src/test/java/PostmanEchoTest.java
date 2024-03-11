import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @BeforeClass
    public void setup() {
        final String URL = "https://postman-echo.com";
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecification());
    }

    @Test
    public void checkGetRequest() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .get("/get?foo1=bar1&foo2=bar2")
                .then().log().all()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void checkPostRawText() {
        given()
                .when()
                .contentType(ContentType.TEXT)
                .body("")
                .post("/post")
                .then().log().all()
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.content-length", equalTo("0"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("json", equalTo(null));
    }

    @Test
    public void checkPutRequest() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .put("/put")
                .then().log().all()
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.content-length", equalTo("0"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/put"))
                .body("json", equalTo(null));
    }

    @Test
    public void checkPatchRequest() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .patch("/patch")
                .then().log().all()
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.content-length", equalTo("0"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/patch"))
                .body("json", equalTo(null));
    }

    @Test
    public void checkDeleteRequest() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .delete("/delete")
                .then()
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/delete"))
                .body("json", equalTo(null));
    }
}
