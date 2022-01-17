package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    ClassNoteBook noteBook = new ClassNoteBook();
    Student student1 = new Student(10, "Jill Doe");
    Student student2 = new Student(9, "Jack Doe");

    @Test
    void testCreate() {
        assertEquals(0, noteBook.getStudentGrades().size());
    }

    @Test
    void testAddStudent() {
        noteBook.addStudent(student1);
        assertEquals(1, noteBook.getStudentGrades().size());
        assertEquals(0, noteBook.getStudentGrades().get(student1).size());
    }

    @Test
    void testAddStudentInOrder() {
        noteBook.addStudent(student1);
        noteBook.addStudent(student2);
        assertEquals(List.of(student2, student1), new ArrayList<>(noteBook.getStudentGrades().keySet()));
        assertNotEquals(List.of(student1, student2), new ArrayList<>(noteBook.getStudentGrades().keySet()));
    }

    @Test
    void testGradeStudent() {
        noteBook.addStudent(student1);
        noteBook.gradeStudent(10, 5);
        assertEquals(1, noteBook.getStudentGrades().get(student1).size());
        assertEquals(5, noteBook.getStudentGrades().get(student1).get(0));
    }

    @Test
    void testGradeStudentInvalidId() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> noteBook.gradeStudent(10, 5));
        assertEquals("Invalid student ID", e.getMessage());
    }
}
