package apiTests;

import changePassword.ReadWriteJSON;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;

public class BaseClass {
    final static String ROOT_URI = "http://localhost:7134";
    ReadWriteJSON readWriteJSON = new ReadWriteJSON();
    RequestSpecification request;
    static String existingPasswordForTest = "SDFUTRYmnbqmwebmw12!@$3";
    JSONObject requestParams = new JSONObject();


    @BeforeTest
    public void beforeTest()
    {
        request = RestAssured.given();
    }

    @BeforeMethod()
    public void beforeMethod()
    {
        readWriteJSON.writeJSON(existingPasswordForTest);
    }

    public Response postTest(JSONObject requestParams, String content_type) {
        request.header("Content-Type", content_type);
        request.body(requestParams.toJSONString());
        return request.post("http://localhost:7134/changepassword");
    }

    public Response getTest() {
        return request.get("http://localhost:7134/changepassword");
    }

    public String returnNewPassword() {
        return readWriteJSON.readJSON();
    }

    public JSONObject jsonObject(String oldPassword, String newPassword)
    {
        requestParams.put("oldPassword",oldPassword);
        requestParams.put("newPassword",newPassword);
        return requestParams;
    }

    public void  assertResponse(Response response, int statusCode, String message)
    {
        assertEquals(response.getStatusCode(), statusCode);
        if(statusCode==200)
            assertEquals(response.asString(),message);
        else if(statusCode==415)
            assert(message.contains(message));
        else
            response.then().body("message", Matchers.is(message));
    }
    public void assertGetResponse(Response response, int statusCode, String message)
    {
        assertEquals(response.getStatusCode(), statusCode);
        if(statusCode==200)
        {
            assertEquals(response.asString(),message);
        }
    }
}
