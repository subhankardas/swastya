package com.codespark.core.utils;

import java.time.LocalDate;
import java.time.Period;

public class DateUtils {

    /**
     * Calculate age based on date of birth.
     * 
     * @param dateOfBirth Date of birth
     * 
     * @return Age in years
     */
    public static int getAge(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            return 0;
        }
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

}
