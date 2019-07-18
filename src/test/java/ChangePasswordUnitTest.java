import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class ChangePasswordUnitTest extends UnitTest{

    @Test
    public void isOldPasswordValidWithSamePasswordTest() {
        assertEquals(changePwd.isOldPasswordValid("teST123!@","teST123!@"), true);
    }
    @Test
    public void isOldPasswordValidWithDifferentPasswordTest() {
        isOldPasswordValid("teST123!@", "teST123!");
    }
    @Test
    public void isOldPasswordValidWithLowerCasePasswordTest() {
        isOldPasswordValid("teST12","test12");
    }
    @Test
    public void lessThan80PercentMatchWithOldPassword_SamePasswordTest() {
        lessThan80PercentMatchWithOldPassword("teST123!@","teST123!@");
    }
    @Test
    public void lessThan80PercentMatchWithOldPassword_OneDifferentLetterTest() {
        lessThan80PercentMatchWithOldPassword("teST123!@","teST123!");
    }
    @Test
    public void lessThan80PercentMatchWithOldPassword_HalfDifferentPasswordTest() {
        assertEquals(changePwd.lessThan80PercentMatchWithOldPassword("teST123!@","teST456$#"), true);
    }
    @Test
    public void lessThan80PercentMatchWithOldPassword_ReversePasswordTest() {
        assertEquals(changePwd.lessThan80PercentMatchWithOldPassword("teST123!@","@!321TSet"), true);
    }
    @Test
    public void lessThan80PercentMatchWithOldPassword_LowerCasePasswordTest() {
        assertEquals(changePwd.lessThan80PercentMatchWithOldPassword("TEST1!","test1!"), true);
    }
    @Test
    public void verifySpecialCharCountWithFourSpecialCharactersTest() {
        assertEquals(changePwd.verifySpecialCharCount("test123@!%&!)"),true);
    }
    @Test
    public void verifySpecialCharCountWithFiveSpecialCharactersTest() {
        verifySpecialCharCount("test123@!%&!@)");
    }
    @Test
    public void verifySpecialCharCountWithThreeSpecialCharactersTest() {
        assertEquals(changePwd.verifySpecialCharCount("test123@!%)"),true);
    }
    @Test
    public void verifySpecialCharCountWithZeroSpecialCharactersTest() {
        assertEquals(changePwd.verifySpecialCharCount("test123)"),true);
    }
    @Test
    public void verifySpecialCharCountWithOnlySpecialCharactersTest() {
        assertEquals(changePwd.verifySpecialCharCount("!@$%"),true);
    }
    @Test
    public void verifySpecialCharCountWithOnlySpecialCharactersMoreThanFourTest() {
        verifySpecialCharCount("!!!!!");
    }
    @Test
    public void verifyNumbersNotMoreThanHalfWithNoNumbersTest() {
        assertEquals(changePwd.verifyNumbersNotMoreThanHalf("test"),true);
    }
    @Test
    public void verifyNumbersNotMoreThanHalfWithOnlyNumbersTest() {
        verifyNumbersNotMoreThanHalf("12345");
    }
    @Test
    public void verifyNumbersNotMoreThanHalfWith50PercentNumbersTest() {
        verifyNumbersNotMoreThanHalf("123aA#");
    }
    @Test
    public void verifyNumbersNotMoreThanHalfWithLessThan50PercentNumbersTest() {
        assertEquals(changePwd.verifyNumbersNotMoreThanHalf("12aA#"),true);
    }
    @Test
    public void verifyMaxOccurenceNotMoreThanFourWithlessThanFourCharEachTest() {
        assertEquals(changePwd.verifyMaxOccurenceNotMoreThanFour("test1@34"),true);
    }
    @Test
    public void verifyMaxOccurenceNotMoreThanFourWithMoreThanFourCharTest() {
        verifyMaxOccurenceNotMoreThanFour("tetst1@3t4t");
    }
    @Test
    public void verifyMaxOccurenceNotMoreThanFourWithNotMoreThanFourCharTest() {
        assertEquals(changePwd.verifyMaxOccurenceNotMoreThanFour("tetst1111@3t4"),true);
    }
    @Test
    public void validPasswordWithExactCountTest() {
        assertEquals(changePwd.validPassword("abeffABCD12345@$!&"),true);
    }
    @Test
    public void validPasswordWithMoreCountTest() {
        assertEquals(changePwd.validPassword("abeffcdABCD122345@$!&"),true);
    }
    @Test
    public void validPasswordWithoutUpperCaseTest() {
        validPassword("abeffcdabcd122345@$!&");
    }
    @Test
    public void validPasswordWithoutLowerCaseTest() {
        validPassword("ABCDEFGHIJ122345@$!&");
    }
    @Test
    public void validPasswordWithoutNumbersTest() {
        validPassword("ABCDEFGHIJAajhigh@$!&");
    }
    @Test
    public void validPasswordWithoutSpecialCharsTest() {
        validPassword("ABCDEFGHIJ122aasdree");
    }
    @Test
    public void validPasswordWithLessCountTest() {
        validPassword("abA125@$");
    }
    @Test
    public void validPasswordWithEmptyTest() {
        validPassword("");
    }
    @Test
    public void validPasswordWithOtherInvalidCharsTest() {
        validPassword("abeffAB+-}{CD12345@$!&");
    }

}
