package Functional;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.Writer;

public class User implements Jsonable {
    private final String email;
    private final String password;
    private final String type;

    public User(String email, String password, String type) {
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String email() { return this.email; }
    public String password() { return this.password; }
    public String type() { return this.type; }

    public User find() {
        for (User search : AllUsers.UserList) {
            if (search.equals(this))
                return search;
        }
        return null;
    }

    public void add() {
        AllUsers.addUser(this);
    }

    private boolean checkString(String str) {
        return str.length() > 10 && str.length() < 40;
    }

    public boolean checkMail() {
        return checkString(this.email) && this.email.contains("@");
    }

    public boolean checkPassword() {
        return checkString(this.password);
    }

    public String toString() {
        return "User:\n" + "\tmail: " + email + "\n\tpassword: " + password + "\n\ttype: " + type;
    }

    public boolean equals(Object obj) {
        if (obj instanceof User) {
            return this.email.equals(((User) obj).email());
        }
        return false;
    }

    @Override
    public String toJson() {
        JsonObject json = new JsonObject();
        json.put("email", this.email);
        json.put("password", this.password);
        json.put("type", this.type);
        return json.toJson();
    }

    @Override
    public void toJson(Writer writable) {
        try {
            writable.write(this.toJson());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
