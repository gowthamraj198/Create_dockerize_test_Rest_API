package apiTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ChangePasswordApiTest extends BaseClass{
    Response response;


    @Test(dataProvider = "validPassword", groups= "setCurrentPassword")
    public void updatePassword(String oldPassword, String newPassword) {

        response = test(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,200,"true");
        assertPasswordUpdate(newPassword);
    }

    @Test(dataProvider = "validPassword")
    public void updatePasswordRequestBodyAsPlainText(String oldPassword, String newPassword) {

        response = test(jsonObject(oldPassword,newPassword),"text/plain");
        assertResponse(response,415,"text/plain' not supported");
    }

    @Test(dataProvider = "missingBodyParameters")
    public void updatePassword_invalid(String oldPassword, String newPassword) {
        response = test(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,"Old and new password are mandatory");
    }
}
