package Functional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AllUsersTest {
    @Test
    void testDoNotAddInvalidUser() {
        User user = new User("user", "password", "invalid");
        AllUsers.clearAll();
        AllUsers.addToList(user);
        assertFalse(AllUsers.UserList.contains(user));
    }
    @Test
    void testAddUser() {
        User user = new User("user", "password", "none");
        AllUsers.clearAll();
        AllUsers.addToList(user);
        assertTrue(AllUsers.UserList.contains(user));
    }
    @Test
    void testAddStudentToStudentsNotTeachers() {
        User user = new User("user", "password", "Student");
        AllUsers.clearAll();
        AllUsers.addToList(user);
        assertTrue(AllUsers.StudentList.contains(user));
        assertFalse(AllUsers.TeacherList.contains(user));
    }
    @Test
    void testAddTeacherToTeachersNotStudents() {
        User user = new User("user", "password", "Teacher");
        AllUsers.clearAll();
        AllUsers.addToList(user);
        assertTrue(AllUsers.TeacherList.contains(user));
        assertFalse(AllUsers.StudentList.contains(user));
    }

}