package changePassword;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteJSON {
    public String readJSON() {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader("src/main/resources/current_password.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;

        String password = (String) jsonObject.get("password");
        return password;
    }

    public void writeJSON(String newPassword)
    {
        JSONObject obj = new JSONObject();

        obj.put("password", newPassword);
        try (FileWriter file = new FileWriter("src/main/resources/current_password.json")) {
            file.write(obj.toJSONString());
            file.flush();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}

