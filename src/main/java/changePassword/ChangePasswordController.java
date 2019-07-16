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

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public boolean changePassword(@RequestBody ChangePasswordRequestModel passwordsDetails)
    {
        System.out.println(passwordsDetails.getnewPassword());
        System.out.println(passwordsDetails.getOldPassword());
        passwordInSystem = readWriteJSON.readJSON();
        System.out.println(passwordInSystem);
        if (changePwd.updatePasswordAtBackend(passwordInSystem,passwordsDetails.getOldPassword(),passwordsDetails.getnewPassword())) {
            return true;
        }
        else
        {
            throw new IllegalArgumentException("New Password is not meeting all criterias");
        }

    }

    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}