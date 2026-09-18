package com.studentmanagement;
import com.studentmanagement.exception.InvalidDataException; import com.studentmanagement.model.AcademicRecord; import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class AcademicRecordTest {
 @Test void calculatesMarksAndAttendance(){var r=new AcademicRecord("S1","C1",18,25,42,40,30);assertEquals(85,r.total());assertEquals(75,r.attendancePercentage());}
 @Test void rejectsInvalidMarksAndAttendance(){assertThrows(InvalidDataException.class,()->new AcademicRecord("S1","C1",21,0,0,0,0));assertThrows(InvalidDataException.class,()->new AcademicRecord("S1","C1",0,0,0,10,11));}
}
