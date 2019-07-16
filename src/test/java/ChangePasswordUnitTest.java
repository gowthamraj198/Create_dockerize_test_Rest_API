import changePassword.ChangePwd;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class ChangePasswordUnitTest {
    ChangePwd changePwd = new ChangePwd();

    @Test
    public void isOldPasswordValidWithSamePassword() {
        assertEquals(changePwd.isOldPasswordValid("teST123!@","teST123!@"), true);
    }
    @Test
    public void isOldPasswordValidWithDifferentPassword() {
        assertEquals(changePwd.isOldPasswordValid("teST123!@","teST123!"), false);
    }
    @Test
    public void isOldPasswordValidWithLowerCasePassword() {
        assertEquals(changePwd.isOldPasswordValid("teST123!@","test123!@"), false);
    }
    @Test
    public void lessThan80PercentMatchWithOldPassword_SamePassword() {
        assertEquals(changePwd.lessThan80PercentMatchWithOldPassword("teST123!@","teST123!@"), false);
    }
    @Test
    public void lessThan80PercentMatchWithOldPassword_OneDifferentLetter() {
        assertEquals(changePwd.lessThan80PercentMatchWithOldPassword("teST123!@","teST123!"), false);
    }
    @Test
    public void lessThan80PercentMatchWithOldPassword_HalfDifferentPassword() {
        assertEquals(changePwd.lessThan80PercentMatchWithOldPassword("teST123!@","teST456$#"), true);
    }
    @Test
    public void lessThan80PercentMatchWithOldPassword_ReversePassword() {
        assertEquals(changePwd.lessThan80PercentMatchWithOldPassword("teST123!@","@!321TSet"), true);
    }
    @Test
    public void lessThan80PercentMatchWithOldPassword_LowerCasePassword() {
        assertEquals(changePwd.lessThan80PercentMatchWithOldPassword("TEST1!","test1!"), true);
    }
    @Test
    public void verifySpecialCharCountWithFourSpecialCharacters() {
        assertEquals(changePwd.verifySpecialCharCount("test123@!%&!)"),true);
    }
    @Test
    public void verifySpecialCharCountWithFiveSpecialCharacters() {
        assertEquals(changePwd.verifySpecialCharCount("test123@!%&!@)"),false);
    }
    @Test
    public void verifySpecialCharCountWithThreeSpecialCharacters() {
        assertEquals(changePwd.verifySpecialCharCount("test123@!%)"),true);
    }
    @Test
    public void verifySpecialCharCountWithZeroSpecialCharacters() {
        assertEquals(changePwd.verifySpecialCharCount("test123)"),true);
    }
    @Test
    public void verifySpecialCharCountWithOnlySpecialCharacters() {
        assertEquals(changePwd.verifySpecialCharCount("!@$%"),true);
    }
    @Test
    public void verifySpecialCharCountWithOnlySpecialCharactersMoreThanFour() {
        assertEquals(changePwd.verifySpecialCharCount("!!!!!"),false);
    }
    @Test
    public void verifyNumbersNotMoreThanHalfWithNoNumbers() {
        assertEquals(changePwd.verifyNumbersNotMoreThanHalf("test"),true);
    }
    @Test
    public void verifyNumbersNotMoreThanHalfWithOnlyNumbers() {
        assertEquals(changePwd.verifyNumbersNotMoreThanHalf("12345"),false);
    }
    @Test
    public void verifyNumbersNotMoreThanHalfWith50PercentNumbers() {
        assertEquals(changePwd.verifyNumbersNotMoreThanHalf("123aA#"),false);
    }
    @Test
    public void verifyNumbersNotMoreThanHalfWithLessThan50PercentNumbers() {
        assertEquals(changePwd.verifyNumbersNotMoreThanHalf("12aA#"),true);
    }
    @Test
    public void verifyMaxOccurenceNotMoreThanFourWithlessThanFourCharEach() {
        assertEquals(changePwd.verifyMaxOccurenceNotMoreThanFour("test1@34"),true);
    }
    @Test
    public void verifyMaxOccurenceNotMoreThanFourWithMoreThanFourChar() {
        assertEquals(changePwd.verifyMaxOccurenceNotMoreThanFour("tetst1@3t4t"),false);
    }
    @Test
    public void verifyMaxOccurenceNotMoreThanFourWithMoreFourChar() {
        assertEquals(changePwd.verifyMaxOccurenceNotMoreThanFour("tetst1111@3t4"),true);
    }
    @Test
    public void validPasswordWithExactCount() {
        assertEquals(changePwd.validPassword("abeffABCD12345@$!&"),true);
    }
    @Test
    public void validPasswordWithMoreCount() {
        assertEquals(changePwd.validPassword("abeffcdABCD122345@$!&"),true);
    }
    @Test
    public void validPasswordWithoutUpperCase() {
        assertEquals(changePwd.validPassword("abeffcdabcd122345@$!&"),false);
    }
    @Test
    public void validPasswordWithoutLowerCase() {
        assertEquals(changePwd.validPassword("ABCDEFGHIJ122345@$!&"),false);
    }
    @Test
    public void validPasswordWithoutNumbers() {
        assertEquals(changePwd.validPassword("ABCDEFGHIJAajhigh@$!&"),false);
    }
    @Test
    public void validPasswordWithoutSpecialChars() {
        assertEquals(changePwd.validPassword("ABCDEFGHIJ122aasdree"),false);
    }
    @Test
    public void validPasswordWithLessCount() {
        assertEquals(changePwd.validPassword("abA125@$"),false);
    }
    @Test
    public void validPasswordWithEmpty() {
        assertEquals(changePwd.validPassword(""),false);
    }
    @Test
    public void validPasswordWithOtherInvalidChars() {
        assertEquals(changePwd.validPassword("abeffAB+-}{CD12345@$!&"),false);
    }

}
