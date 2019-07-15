package changePassword;

import info.debatty.java.stringsimilarity.JaroWinkler;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangePwd {

    static ReadWriteJSON readWriteJSON = new ReadWriteJSON();
    static String passwordInSystem = readWriteJSON.readJSON();

    /*
        Function to check condition - Old password should match with system
     */
    public boolean isOldPasswordValid(String oldPassword, String actualPassword) {
        if (actualPassword.equals(oldPassword))
            return true;
        else
            return false;
    }

    /*
        Function to check condition - No more than 4 special characters
     */
    public boolean verifySpecialCharCount(String password) {
        String regex = "[!@#$&*]";
        if ((password.split(regex, -1).length - 1) > 4)
            return false;
        else if ((password.split(regex, -1).length - 1) <= 4)
            return true;
        else
            return false;
    }

    /*
        Function to check condition - 50 % of password should not be a number
     */
    public boolean verifyNumbersNotMoreThanHalf(String password) {
        double actualLengthOfPassword = password.length();
        double digitsCount = password.replaceAll("\\D+", "").length();
        if (((digitsCount * 100) / actualLengthOfPassword) < 50)
            return true;
        else
            return false;
    }

    /*
        Function to check condition - password is not similar to old password < 80% match
     */
    public boolean lessThan80PercentMatchWithOldPassword(String oldPassword, String newPassword) {
        JaroWinkler jw = new JaroWinkler();

        if (jw.similarity(oldPassword, newPassword) >= 0.8)
            return false;
        else
            return true;
    }

    /*
        Function to check condition - No duplicate repeat characters more than 4 (here character include both alphabets and numbers)
     */
    public boolean verifyMaxOccurenceNotMoreThanFour(String password) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        char[] strArray = password.toCharArray();

        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        for (Map.Entry entry : charCountMap.entrySet()) {
            if (Integer.parseInt(entry.getValue().toString()) > 4) {
                return false;
            }
        }
        return true;
    }

    /*
        Function to check condition - New password should be a valid password
        a.At least 1 Upper case, 1 lower case ,least 1 numeric, 1 special character
        b. At least 18 alphanumeric characters
        c. list of special chars - !@#$&*
     */
    public boolean validPassword(String password) {
        Pattern pattern = Pattern.compile("(?=.*\\d)(?=.*[!@#$&*])(?=.*[a-z])(?=.*[A-Z])[A-Za-z0-9!@#$&*]{18,}+$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    /*
        passwordInSystem - current password stored in the system
        oldPassword - user has to give old password
        newPassword - new password that should satisfy all the conditions
     */

    public boolean checkAllConditions(String passwordInSystem,String oldPassword,String newPassword) {
        if(isOldPasswordValid(passwordInSystem,oldPassword))
        {
            if(validPassword(oldPassword))
            {
                if(lessThan80PercentMatchWithOldPassword(oldPassword, newPassword) && verifySpecialCharCount(newPassword)
                        && verifyNumbersNotMoreThanHalf(newPassword) && verifyMaxOccurenceNotMoreThanFour(newPassword))
                {
                    return true;
                }
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;
//        System.out.println(validPassword(newPassword));
//        System.out.println(isOldPasswordValid(passwordInSystem,oldPassword));
//        System.out.println(lessThan80PercentMatchWithOldPassword(oldPassword, newPassword));
//        System.out.println(verifySpecialCharCount(newPassword));
//        System.out.println(verifyNumbersNotMoreThanHalf(newPassword));
//        System.out.println(verifyMaxOccurenceNotMoreThanFour(newPassword));
    }

    /*
        Function to overwrite the current password if the new password matches all criteria
     */
    public boolean updatePasswordAtBackend(String passwordInSystem,String oldPassword,String newPassword)
    {
        if(checkAllConditions(passwordInSystem,oldPassword,newPassword))
        {
//            readWriteJSON.writeJSON(newPassword);
            return true;
        }
        else
            return false;
    }

    /*
        Function to return new password
     */
    public String returnNewPassword()
    {
        return readWriteJSON.readJSON();
    }

    public static void main(String[] args) {
        String newPassword = "abcdefghijABCDEFGH12345@$!&";
        String oldPassword = "ABCDEFGHabcdefgh24356554!$";   //this is same as password in the system
        ChangePwd changePwd = new ChangePwd();
        System.out.println(changePwd.updatePasswordAtBackend(passwordInSystem,oldPassword,newPassword));
        System.out.println(changePwd.returnNewPassword());
    }

}
