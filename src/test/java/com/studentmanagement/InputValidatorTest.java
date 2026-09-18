package com.studentmanagement;
import com.studentmanagement.exception.InvalidDataException; import com.studentmanagement.utility.InputValidator; import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class InputValidatorTest {
 @Test void acceptsValidEmail(){assertTrue(InputValidator.isValidEmail("student@example.edu"));}
 @Test void rejectsInvalidEmail(){assertFalse(InputValidator.isValidEmail("not-an-email"));assertThrows(InvalidDataException.class,()->InputValidator.email("bad"));}
 @Test void rejectsBlankAndCsvDelimiter(){assertThrows(InvalidDataException.class,()->InputValidator.required(" ","Name"));assertThrows(InvalidDataException.class,()->InputValidator.required("Doe, Jane","Name"));}
}
