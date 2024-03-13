package kz.spring.tech.studentsmanagement.db;

import kz.spring.tech.studentsmanagement.model.Student;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L, "Nick", "Bruh", 80, "B"));
        students.add(new Student(2L, "Jey", "Josh", 90, "A"));
        students.add(new Student(3L, "Peter", "Holl", 80, "B"));
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }
    
    public static Student getStudentById(Long id) {
        Student currentStudent = null;
        for (int i = 0; i < students.size(); i++) {
            Student eachStudent = students.get(i);
            if (eachStudent.getId() == id) {
                currentStudent = eachStudent;
            }
        }
        return currentStudent;
    }

    public static void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    public static void updateStudent(Long id, Student newStudent) {
        int index = 0;
        for (int i = 0; i < students.size(); i++) {
            Student eachStudent = students.get(i);
            if (eachStudent.getId() == id) {
                index = i;
                return;
            }
        }
        students.set(index, newStudent);
    }

    public static void deleteStudent(Long id) {
        int index = 0;
        for (int i = 0; i < students.size(); i++) {
            Student eachStudent = students.get(i);
            if (eachStudent.getId() == id) {
                index = i;
                return;
            }
        }
        students.remove(index);
    }
}
