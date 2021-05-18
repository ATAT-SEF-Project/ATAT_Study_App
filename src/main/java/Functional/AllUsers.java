package Functional;


import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class AllUsers {
    public static ArrayList<User> UserList = new ArrayList<>();
    public static ArrayList<User> TeacherList = new ArrayList<>();
    public static ArrayList<User> StudentList = new ArrayList<>();
    private static ArrayList<String> Types = new ArrayList<>(Arrays.asList("Teacher", "Student", "none"));

    public static void initialize() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(".\\src\\main\\resources\\Users.json"));
            if (reader.ready()) {
                clearAll();
                JsonArray jsonArray = (JsonArray) Jsoner.deserialize(reader);
                jsonArray.forEach(entry -> {
                    JsonObject jsonObject = (JsonObject) entry;
                    String email = (String) jsonObject.get("email");
                    String password = (String) jsonObject.get("password");
                    String type = (String) jsonObject.get("type");
                    addToList(new User(email, password, type));
                });
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clearAll() {
        UserList.clear();
        StudentList.clear();
        TeacherList.clear();
    }

    public static void addToList(User user) {
        if (!UserList.contains(user) && Types.contains(user.type())) {
            UserList.add(user);
            addTeacher(user);
            addStudent(user);
        }
    }

    public static void addTeacher(User user) {
        if (user.type().equals("Teacher") && !TeacherList.contains(user)) {
            TeacherList.add(user);
        }
    }

    public static void addStudent(User user) {
        if (user.type().equals("Student") && !StudentList.contains(user)) {
            StudentList.add(user);
        }
    }

    public static void addUser(User user) {
        try {
            addToList(user);
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
