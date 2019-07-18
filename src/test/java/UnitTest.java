import changePassword.ChangePwd;
import changePassword.ErrorMessages;

import static org.junit.Assert.assertEquals;

public class UnitTest {
    ChangePwd changePwd = new ChangePwd();

    public void isOldPasswordValid(String oldPassword, String newPassword) {
        try {
            changePwd.isOldPasswordValid(oldPassword,newPassword);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), ErrorMessages.incorrectOldPasswordMessage);
        }
    }

    public void lessThan80PercentMatchWithOldPassword(String oldPassword, String newPassword) {
        try {
            changePwd.lessThan80PercentMatchWithOldPassword(oldPassword,newPassword);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), ErrorMessages.similarNewPasswordMessage);
        }
    }

    public void verifySpecialCharCount(String newPassword) {
        try {
            changePwd.verifySpecialCharCount(newPassword);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), ErrorMessages.maxSpecialCharsCountInNewPasswordMessage);
        }
    }

    public void verifyNumbersNotMoreThanHalf(String newPassword) {
        try {
            changePwd.verifyNumbersNotMoreThanHalf(newPassword);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), ErrorMessages.numbersCountInNewPasswordMessage);
        }
    }

    public void verifyMaxOccurenceNotMoreThanFour(String newPassword) {
        try {
            changePwd.verifyMaxOccurenceNotMoreThanFour(newPassword);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), ErrorMessages.numbersRepeatCountInNewPasswordMessage);
        }
    }

    public void validPassword(String newPassword) {
        try {
            changePwd.validPassword(newPassword);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), ErrorMessages.invalidNewPasswordMessage);
        }
    }

}
