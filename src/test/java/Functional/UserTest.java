package Functional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    void basic() {
        assertEquals(2, 2);
    }
    @Test
    void testEmailTooShort() {
        User user = new User("short", "", "");
        assertFalse(user.checkMail());
    }
    @Test
    void testEmailNotValid() {
        User user = new User("longbutnotvalid", "", "");
        assertFalse(user.checkMail());
    }
    @Test
    void testPasswordTooShort() {
        User user = new User("", "short", "");
        assertFalse(user.checkPassword());
    }
    @Test
    void testCorrectEmail() {
        User user = new User("good@email.com", "", "");
        assertTrue(user.checkMail());
    }
    @Test
    void testCorrectPassword() {
        User user = new User("", "good_password123", "");
        assertTrue(user.checkPassword());
    }

    @Test
    void testHashFunctionChangesPassword() {
        User user = new User("email", "password", "type");
        String before = user.password();
        user.hashPassword();
        String after = user.password();
        assertNotEquals(before, after);
    }
    @Test
    void testIdenticalUsersAreEqual() {
        User user1 = new User("email", "password", "type");
        User user2 = new User("email", "password", "type");
        assertEquals(user1, user2);
    }

    @Test
    void testIdenticalUsersHaveSameHash() {
        User user1 = new User("email", "password", "type");
        User user2 = new User("email", "password", "type");
        user1.hashPassword();
        user2.hashPassword();
        assertEquals(user1.password(), user2.password());
    }
    @Test
    void testDifferentUsersHaveDifferentHash() {
        User user1 = new User("email1", "password1", "type");
        User user2 = new User("email2", "password2", "type");
        user1.hashPassword();
        user2.hashPassword();
        assertNotEquals(user1.password(), user2.password());
    }
    @Test
    void testDifferentEmailGeneratesDifferentHash() {
        User user1 = new User("email1", "password", "type");
        User user2 = new User("email2", "password", "type");
        user1.hashPassword();
        user2.hashPassword();
        assertNotEquals(user1.password(), user2.password());
    }
}