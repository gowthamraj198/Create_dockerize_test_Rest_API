package apiTests;

import changePassword.ErrorMessages;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ChangePasswordApiTest extends DataProviders{
    Response response;


    @Test(dataProvider = "validPassword")
    public void updatePassword(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,200,ErrorMessages.updateMessage);
        assertGetResponse(getTest(),200,newPassword);
    }

    @Test(dataProvider = "validPassword")
    public void updatePasswordRequestBodyAsPlainText(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"text/plain");
        assertResponse(response,415, ErrorMessages.invlaidContentTypeMessage);
    }

    @Test(dataProvider = "missingBodyParameters")
    public void invalidBodyParameters(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,"Old and new password are mandatory");
    }

    @Test(dataProvider = "incorrectOldPassword")
    public void incorrectOldPassword(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.incorrectOldPasswordMessage);
    }

    @Test(dataProvider = "incorrectNewPasswordWithInvalidChars")
    public void incorrectNewPasswordWithInvalidChars(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.invalidNewPasswordMessage);
    }

    @Test(dataProvider = "incorrectNewPasswordWithoutLowerCase")
    public void incorrectNewPasswordWithoutLowerCase(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.invalidNewPasswordMessage);
    }

    @Test(dataProvider = "incorrectNewPasswordWithoutUpperCase")
    public void incorrectNewPasswordWithoutUpperCase(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.invalidNewPasswordMessage);
    }

    @Test(dataProvider = "incorrectNewPasswordWithoutNumbers")
    public void incorrectNewPasswordWithoutNumbers(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.invalidNewPasswordMessage);
    }

    @Test(dataProvider = "incorrectNewPasswordWithoutSpecialChars")
    public void incorrectNewPasswordWithoutSpecialChars(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.invalidNewPasswordMessage);
    }

    @Test(dataProvider = "incorrectNewPasswordWith17Chars")
    public void incorrectNewPasswordWith17Chars(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.invalidNewPasswordMessage);
    }

    @Test(dataProvider = "incorrectNewPasswordWithTMoreThan4Times")
    public void incorrectNewPasswordWithTMoreThan4Times(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.numbersRepeatCountInNewPasswordMessage);
    }

    @Test(dataProvider = "incorrectNewPasswordWith5MoreThan4Times")
    public void incorrectNewPasswordWith5MoreThan4Times(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.numbersRepeatCountInNewPasswordMessage);
    }

    @Test(dataProvider = "incorrectNewPasswordWithSameSpecialCharMoreThan4Times")
    public void incorrectNewPasswordWithSameSpecialCharMoreThan4Times(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.maxSpecialCharsCountInNewPasswordMessage);
    }

    @Test(dataProvider = "incorrectNewPasswordWithSpecialCharMoreThan4SpecialChar")
    public void incorrectNewPasswordWithSpecialCharMoreThan4SpecialChar(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.maxSpecialCharsCountInNewPasswordMessage);
    }

    @Test(dataProvider = "incorrectNewPasswordWithExactly50PercentNumbers")
    public void incorrectNewPasswordWithExactly50PercentNumbers(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.numbersCountInNewPasswordMessage);
    }

    @Test(dataProvider = "validPassword")
    public void updatePassword1(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,200,ErrorMessages.updateMessage);
        assertGetResponse(getTest(),200,newPassword);
    }

    @Test(dataProvider = "incorrectNewPasswordWith81PercentMatch")
    public void incorrectNewPasswordWith81PercentMatch(String oldPassword, String newPassword) {
        response = postTest(jsonObject(oldPassword,newPassword),"application/json");
        assertResponse(response,400,ErrorMessages.similarNewPasswordMessage);
    }

}
