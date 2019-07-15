package changePassword;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class ChangePasswordController {

    ChangePwd changePwd = new ChangePwd();
    static ReadWriteJSON readWriteJSON = new ReadWriteJSON();
    static String passwordInSystem = readWriteJSON.readJSON();

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public boolean changePassword(@RequestBody ChangePasswordRequestModel passwordsDetails)
    {
        System.out.println(passwordsDetails.getnewPassword());
        System.out.println(passwordsDetails.getOldPassword());
        System.out.println(passwordInSystem);
        return changePwd.updatePasswordAtBackend(passwordInSystem,passwordsDetails.getOldPassword(),passwordsDetails.getnewPassword());
    }
}