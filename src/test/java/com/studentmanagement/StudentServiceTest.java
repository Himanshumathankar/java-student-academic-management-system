package com.studentmanagement;
import com.studentmanagement.exception.DuplicateStudentException; import com.studentmanagement.repository.FileStudentRepository; import com.studentmanagement.service.StudentService; import org.junit.jupiter.api.*; import org.junit.jupiter.api.io.TempDir; import java.nio.file.Path; import static org.junit.jupiter.api.Assertions.*;
class StudentServiceTest {
 @TempDir Path temp; private StudentService service;
 @BeforeEach void setup(){service=new StudentService(new FileStudentRepository(temp.resolve("students.csv")));}
 @Test void addsAndFindsStudent(){service.add("S1","Asha Rao","asha@example.edu","CSE",3);assertEquals("Asha Rao",service.find("S1").getName());}
 @Test void preventsDuplicateIds(){service.add("S1","Asha Rao","asha@example.edu","CSE",3);assertThrows(DuplicateStudentException.class,()->service.add("S1","Other","other@example.edu","ECE",2));}
 @Test void searchesPartialNameIgnoringCase(){service.add("S1","Asha Rao","asha@example.edu","CSE",3);assertEquals(1,service.searchByName("SHA").size());}
 @Test void persistsAcrossRepositoryInstances(){service.add("S1","Asha Rao","asha@example.edu","CSE",3);var loaded=new StudentService(new FileStudentRepository(temp.resolve("students.csv")));assertEquals(1,loaded.all().size());}
}
