package changePassword;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/changepassword")
public class ChangePasswordController {

    ChangePwd changePwd = new ChangePwd();
    static ReadWriteJSON readWriteJSON = new ReadWriteJSON();
    static String passwordInSystem;

    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public String currentPassword()
    {
        return new ReadWriteJSON().readJSON();
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public boolean changePassword(@RequestBody ChangePasswordRequestModel passwordsDetails) {
        passwordInSystem = readWriteJSON.readJSON();

        if(passwordsDetails.getOldPassword()==null || passwordsDetails.getOldPassword()=="" || passwordsDetails.getnewPassword()==null || passwordsDetails.getnewPassword()=="")
        {
            throw new IllegalArgumentException("Old and new password are mandatory");
        }
        else
        {
            if (changePwd.updatePasswordAtBackend(passwordInSystem, passwordsDetails.getOldPassword(), passwordsDetails.getnewPassword())) {
                return true;
            } else {
                throw new IllegalArgumentException("New Password is not meeting all criteria");
            }
        }
    }

    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}