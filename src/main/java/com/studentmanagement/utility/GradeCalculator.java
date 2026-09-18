package com.studentmanagement.utility;
import com.studentmanagement.exception.InvalidDataException;
/** Converts a percentage into the institution's letter-grade scale. */
public final class GradeCalculator { private GradeCalculator(){} public static String calculate(double p){if(p<0||p>100)throw new InvalidDataException("Percentage must be between 0 and 100.");if(p>=90)return"A+";if(p>=80)return"A";if(p>=70)return"B+";if(p>=60)return"B";if(p>=50)return"C";if(p>=40)return"D";return"F";} }
