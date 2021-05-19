package Functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class ClassRoom {
    public String teacher;
    public ArrayList<String> students = new ArrayList<>();
    public String classRoomName;
    public ArrayList<String> tutorials = new ArrayList<>();

    public ClassRoom(String classRoomName, String teacher){
        this.classRoomName = classRoomName;
        this.teacher = teacher;
    }

    public void addStudent(String student){
        students.add(student);
        Collections.sort(students);
    }
    public void addTutorial(String tutorial){
        tutorials.add(tutorial);
        Collections.sort(tutorials);
    }
}
