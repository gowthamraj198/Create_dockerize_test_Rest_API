package apiTests;

import org.testng.annotations.DataProvider;

public class DataProviders extends BaseClass{
    @DataProvider(name = "validPassword")
    public static Object[][] validpasswords() {
        return new Object[][]{{"SDFUTRYmnbqmwebmw12!@$3", "abcdefghijABCDEFGH123@$!"}};
    }

    @DataProvider(name = "invalidPassword")
    public static Object[][] invalidpasswords() {
        return new Object[][]{{"SDFUTRYmnbqmwebmw12!@$3", "abcdefghijABCDEFGH123@$!"}};
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
                {"SDFUTRYmnbqmwebmw12!@$3", "abcdefghijABCDEFGH123@$!+"},
                {"SDFUTRYmnbqmwebmw12!@$3", "abcdefghijABCDEFG_H123@$!"},
                {"SDFUTRYmnbqmwebmw12!@$3", "abcdefghij(ABCDEFGH123@$!"},
                {"SDFUTRYmnbqmwebmw12!@$3", ".abcdefghijABCDEFGH123@$!"},
        };
    }

    @DataProvider(name = "incorrectNewPasswordWithoutLowerCase")
    public static Object[][] incorrectNewPasswordWithoutLowerCase() {
        return new Object[][]{
                {"SDFUTRYmnbqmwebmw12!@$3", "IJKLMNOPQRABCDEFGH123@$!"}
        };
    }

    @DataProvider(name = "incorrectNewPasswordWithoutUpperCase")
    public static Object[][] incorrectNewPasswordWithoutUpperCase() {
        return new Object[][]{
                {"SDFUTRYmnbqmwebmw12!@$3", "abcdefghijklmnop123@$!"}
        };
    }
}
