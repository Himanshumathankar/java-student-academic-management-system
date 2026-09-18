package com.studentmanagement.utility;
import com.studentmanagement.exception.InvalidDataException;
import java.util.regex.Pattern;
/** Central validation rules shared by services and the console. */
public final class InputValidator {
    private static final Pattern EMAIL=Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"); private InputValidator(){}
    public static String required(String value,String field){if(value==null||value.isBlank())throw new InvalidDataException(field+" cannot be blank.");if(value.contains(",")||value.contains("\n"))throw new InvalidDataException(field+" cannot contain commas or new lines.");return value.trim();}
    public static String email(String value){value=required(value,"Email");if(!EMAIL.matcher(value).matches())throw new InvalidDataException("Invalid email address.");return value;}
    public static int range(int value,int min,int max,String field){if(value<min||value>max)throw new InvalidDataException(field+" must be between "+min+" and "+max+".");return value;}
    public static boolean isValidEmail(String value){return value!=null&&EMAIL.matcher(value).matches();}
}
