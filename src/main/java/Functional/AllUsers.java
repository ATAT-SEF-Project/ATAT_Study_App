package Functional;


import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AllUsers {
    public static ArrayList<User> UserList = new ArrayList<>();

    public static void initialize() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(".\\src\\main\\resources\\Users.json"));
            if (reader.ready()) {
                JsonArray jsonArray = (JsonArray) Jsoner.deserialize(reader);
                jsonArray.forEach(entry -> {
                    JsonObject jsonObject = (JsonObject) entry;
                    String email = (String) jsonObject.get("email");
                    String password = (String) jsonObject.get("password");
                    String type = (String) jsonObject.get("type");
                    UserList.add(new User(email, password, type));
                });
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addUser(User user) {
        try {
            UserList.add(user);
            Writer writer = Files.newBufferedWriter(Paths.get(".\\src\\main\\resources\\Users.json"));
            Jsoner.serialize(UserList, writer);
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void print() {
        for (User user : UserList) {
            System.out.println(user);
        }
    }
}
