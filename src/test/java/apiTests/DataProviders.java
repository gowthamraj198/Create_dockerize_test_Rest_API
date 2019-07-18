package apiTests;

import org.testng.annotations.DataProvider;

public class DataProviders extends BaseClass{
    @DataProvider(name = "validPassword")
    public static Object[][] validpasswords() {
        return new Object[][]{
                {existingPasswordForTest, "abcdefghijABCDEFGH123@$!"},
                {existingPasswordForTest, "trewfdAPOIU8654@$!"},
                {existingPasswordForTest, "SDAdqwer15824367@$"},
                {existingPasswordForTest, "SqFUwyTRYebebmw12!@i3"}
        };
    }

    @DataProvider(name = "missingBodyParameters")
    public static Object[][] missingBodyParameters() {
        return new Object[][]{
                {null, "abcdefghijABCDEFGH123@$!"},
                {"missingBodyParameters", null},
                {"missingBodyParameters", ""},
                {"", "missingBodyParameters"}
        };
    }

    @DataProvider(name = "incorrectOldPassword")
    public static Object[][] incorrectOldPassword() {
        return new Object[][]{
                {"SDFUTRYmnbqmwebmw12!@$34", "abcdefghijABCDEFGH123@$!"}
        };
    }

    @DataProvider(name = "incorrectNewPasswordWithInvalidChars")
    public static Object[][] incorrectNewPasswordWithInvalidChars() {
        return new Object[][]{
                {existingPasswordForTest, "abcdefghijABCDEFGH123@$!+"},
                {existingPasswordForTest, "abcdefghijABCDEFG_H123@$!"},
                {existingPasswordForTest, "abcdefghij(ABCDEFGH123@$!"},
                {existingPasswordForTest, ".abcdefghijABCDEFGH123@$!"},
        };
    }

    @DataProvider(name = "incorrectNewPasswordWithoutLowerCase")
    public static Object[][] incorrectNewPasswordWithoutLowerCase() {
        return new Object[][]{
                {existingPasswordForTest, "IJKLMNOPQRABCDEFGH123@$!"}
        };
    }

    @DataProvider(name = "incorrectNewPasswordWithoutUpperCase")
    public static Object[][] incorrectNewPasswordWithoutUpperCase() {
        return new Object[][]{
                {existingPasswordForTest, "abcdefghijklmnop123@$!"}
        };
    }

    @DataProvider(name = "incorrectNewPasswordWithoutNumbers")
    public static Object[][] incorrectNewPasswordWithoutNumbers() {
        return new Object[][]{
                {existingPasswordForTest, "abcdefghijKLMnopwer@$!"},
        };
    }

    @DataProvider(name = "incorrectNewPasswordWithoutSpecialChars")
    public static Object[][] incorrectNewPasswordWithoutSpecialChars() {
        return new Object[][]{
                {existingPasswordForTest, "abcdefghijKLMopwer123"}
        };
    }

    @DataProvider(name = "incorrectNewPasswordWith17Chars")
    public static Object[][] incorrectNewPasswordWith17Chars() {
        return new Object[][]{
                {existingPasswordForTest, "sdfvsdfKLMnr123@!"}
        };
    }

    @DataProvider(name = "incorrectNewPasswordWithTMoreThan4Times")
    public static Object[][] incorrectNewPasswordWithTMoreThan4Times() {
        return new Object[][]{
                {existingPasswordForTest, "sdfvstttdfKLMntr123@t!"}
        };
    }

    @DataProvider(name = "incorrectNewPasswordWith5MoreThan4Times")
    public static Object[][] incorrectNewPasswordWith5MoreThan4Times() {
        return new Object[][]{
                {existingPasswordForTest, "sdfv5sttdf5KL5Mnr515@!"}
        };
    }

    @DataProvider(name = "incorrectNewPasswordWithSameSpecialCharMoreThan4Times")
    public static Object[][] incorrectNewPasswordWithSpecialCharMoreThan4Times() {
        return new Object[][]{
                {existingPasswordForTest, "abcdefghijABCDEFGH123!!!!!"}
        };
    }

    @DataProvider(name = "incorrectNewPasswordWithSpecialCharMoreThan4SpecialChar")
    public static Object[][] incorrectNewPasswordWithSpecialCharMoreThan4SpecialChar() {
        return new Object[][]{
                {existingPasswordForTest, "abcdefghijABCDEFGH123!@$&*"}
        };
    }

    @DataProvider(name = "incorrectNewPasswordWithExactly50PercentNumbers")
    public static Object[][] incorrectNewPasswordWithExactly50PercentNumbers() {
        return new Object[][]{
                {existingPasswordForTest, "trewfdA123486549@$"}
        };
    }

    @DataProvider(name = "incorrectNewPasswordWith81PercentMatch")
    public static Object[][] incorrectNewPasswordWith81PercentMatch() {
        return new Object[][]{
                {existingPasswordForTest, "SDqFUwyTebebmw12r!@$t3"},
                {existingPasswordForTest, "SqFUwyTRYebebmw12!@$t3"}
        };
    }
}
