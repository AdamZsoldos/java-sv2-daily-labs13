package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClassNoteBook {

    Map<Student, List<Integer>> studentGrades = new TreeMap<>();

    public Map<Student, List<Integer>> getStudentGrades() {
        return studentGrades;
    }

    public void addStudent(Student student) {
        studentGrades.put(student, new ArrayList<>());
    }

    public void gradeStudent(int studentId, int grade) {
        studentGrades.get(getStudent(studentId)).add(grade);
    }

    private Student getStudent(int studentId) {
        for (Student student : studentGrades.keySet()) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        throw new IllegalArgumentException("Invalid student ID");
    }
}
