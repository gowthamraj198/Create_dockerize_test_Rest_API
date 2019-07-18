package changePassword;

public class ErrorMessages {
    public final static String invlaidContentTypeMessage = "text/plain' not supported";
    public final static String updateMessage = "Password updated successfully!";
    public final static String incorrectOldPasswordMessage = "Old password and current password don't match!";
    public final static String similarNewPasswordMessage = "Old password and new password have 80% match!";
    public final static String maxSpecialCharsCountInNewPasswordMessage = "new password should only have max of 4 special chars!";
    public final static String numbersCountInNewPasswordMessage = "new password should have less than 50% of numbers!";
    public final static String numbersRepeatCountInNewPasswordMessage = "Chars should not repeat more than 4 times!";
    public final static String invalidNewPasswordMessage = "1. Chars should be atleast 18 chars 2. At least 1 Upper case, 1 lower case ,least 1 numeric, 1 special character 3. use only !,@,#,$,&,* special chars";
}
