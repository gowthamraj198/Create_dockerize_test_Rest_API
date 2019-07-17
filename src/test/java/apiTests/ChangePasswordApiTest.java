package apiTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ChangePasswordApiTest extends BaseClass{
    Response response;


    @Test(dataProvider = "validPassword")
    public void updatePassword(String oldPassword, String newPassword) {
        System.out.println("Old : "+  oldPassword);
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,200,"true");
        assertGetResponse(getTest(),200,newPassword);
    }

    @Test(dataProvider = "validPassword")
    public void updatePasswordRequestBodyAsPlainText(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"text/plain");
        assertResponse(response,415,"text/plain' not supported");
    }

    @Test(dataProvider = "missingBodyParameters")
    public void updatePassword_invalidBodyParameters(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,"Old and new password are mandatory");
    }

    @Test(dataProvider = "incorrectOldPassword")
    public void updatePassword_incorrectOldPassword(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,"New Password is not meeting all criteria");
    }
}
