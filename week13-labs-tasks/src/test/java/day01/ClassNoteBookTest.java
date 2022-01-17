package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    ClassNoteBook noteBook = new ClassNoteBook();
    Student student = new Student(10, "Jill Doe");

    @Test
    void testCreate() {
        assertEquals(0, noteBook.getStudentGrades().size());
    }

    @Test
    void testAddStudent() {
        noteBook.addStudent(student);
        assertEquals(1, noteBook.getStudentGrades().size());
        assertEquals(0, noteBook.getStudentGrades().get(student).size());
    }

    @Test
    void testGradeStudent() {
        noteBook.addStudent(student);
        noteBook.gradeStudent(10, 5);
        assertEquals(1, noteBook.getStudentGrades().get(student).size());
        assertEquals(5, noteBook.getStudentGrades().get(student).get(0));
    }

    @Test
    void testGradeStudentInvalidId() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> noteBook.gradeStudent(10, 5));
        assertEquals("Invalid student ID", e.getMessage());
    }
}
