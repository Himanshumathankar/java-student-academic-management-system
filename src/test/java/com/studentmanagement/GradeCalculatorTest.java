package com.studentmanagement;
import com.studentmanagement.exception.InvalidDataException; import com.studentmanagement.utility.GradeCalculator; import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class GradeCalculatorTest {
 @Test void calculatesEveryBoundary(){assertEquals("A+",GradeCalculator.calculate(90));assertEquals("A",GradeCalculator.calculate(89.99));assertEquals("B+",GradeCalculator.calculate(70));assertEquals("B",GradeCalculator.calculate(60));assertEquals("C",GradeCalculator.calculate(50));assertEquals("D",GradeCalculator.calculate(40));assertEquals("F",GradeCalculator.calculate(39.99));}
 @Test void rejectsOutOfRange(){assertThrows(InvalidDataException.class,()->GradeCalculator.calculate(101));}
}
