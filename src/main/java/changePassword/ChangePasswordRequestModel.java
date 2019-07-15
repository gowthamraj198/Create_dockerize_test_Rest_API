package changePassword;

public class ChangePasswordRequestModel {
    private String oldPassword;
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }
    public void setoldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    public String getnewPassword() {
        return newPassword;
    }
    public void setnewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
