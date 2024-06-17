package com.codespark.vitals.utils;

import org.springframework.stereotype.Component;

import com.codespark.core.constants.ActivityLevel;
import com.codespark.core.constants.Gender;

@Component
public class BasicVitalsCalculator {

    /**
     * Calculates BMI.
     * 
     * BMI = weight / (height * height)
     * 
     * Significance: Indicates whether an individual is underweight, normal weight,
     * overweight, or obese.
     * 
     * @param height Height in meters
     * @param weight Weight in kilograms
     * 
     * @return Calculated BMI
     */
    public float getBMI(float height, float weight) {
        return weight / (height * height);
    }

    /**
     * Harris-Benedict Equation:
     * Men: BMR = 88.362+(13.397xweight(kg))+(4.799xheight(cm))-(5.677xage(years))
     * Women: BMR = 447.593+(9.247xweight(kg))+(3.098xheight(cm))-(4.330xage(years))
     * 
     * Significance:
     * Caloric Needs at Rest: BMR represents the number of calories your body needs
     * to maintain basic physiological functions at rest, such as breathing,
     * circulation, and cell production.
     * Weight Management: Understanding BMR helps in creating a diet plan to
     * maintain, lose, or gain weight by adjusting caloric intake accordingly.
     * 
     * @param height Height in meters
     * @param weight Weight in kilograms
     * @param gender Gender
     * @param age    Age in years
     * 
     * @return Calculated BMR
     */
    public float getBMR(float height, float weight, Gender gender, int age) {
        height = height * 100; // Convert height from meters to centimeters
        switch (gender) {
            case MALE:
                return 88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age);
            case FEMALE:
                return 447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age);
        }
        return 0;
    }

    /**
     * Calculates Total Daily Energy Expenditure (TDEE).
     * 
     * TDEE = BMR * Activity Level
     * 
     * Significance:
     * Total Caloric Needs: TDEE represents the total number of calories you burn in
     * a day, accounting for all activities and exercises.
     * Customized Nutrition Plans: Helps in tailoring diet and exercise plans to
     * meet specific health and fitness goals, such as weight loss, muscle gain, or
     * maintenance.
     * 
     * @param bmr      BMR value
     * @param activity Activity level
     * @param gender   Gender
     * 
     * @return Calculated Total Daily Energy Expenditure (TDEE)
     */
    public float getTDEE(float bmr, ActivityLevel activity, Gender gender) {
        switch (activity) {
            case SEDENTARY:
                return bmr * 1.2f;
            case LIGHTLY_ACTIVE:
                return bmr * 1.375f;
            case MODERATELY_ACTIVE:
                return bmr * 1.55f;
            case VERY_ACTIVE:
                return bmr * 1.725f;
            case SUPER_ACTIVE:
                return bmr * 1.9f;
        }
        return 0;
    }

    /**
     * Calculate Body Fat Percentage.
     * 
     * Formula:
     * Men: BFP = (1.2 * BMI) + (0.23 * Age) - 16.2
     * Women: BFP = (1.2 * BMI) + (0.23 * Age) - 5.4
     * 
     * Significance:
     * Body Composition Insight: Provides a more detailed picture of body
     * composition than BMI alone, differentiating between fat and lean mass.
     * Health Risk Assessment: High body fat percentage is associated with increased
     * risk of cardiovascular diseases, diabetes, and other metabolic conditions.
     * 
     * @param bmi    BMI value
     * @param age    Age in years
     * @param gender Gender
     * 
     * @return Calculated Body Fat Percentage (BFP)
     */
    public float getBFP(float bmi, int age, Gender gender) {
        switch (gender) {
            case MALE:
                return (1.2f * bmi) + (0.23f * age) - 16.2f;
            case FEMALE:
                return (1.2f * bmi) + (0.23f * age) - 5.4f;
        }
        return 0;
    }

    /**
     * Calculates Lean Body Mass (LBM).
     * 
     * LBM = weight(kg) - (BFP * weight(kg))
     * 
     * Significance:
     * Muscle Mass Indicator: Represents the weight of all body components except
     * fat (muscles, bones, organs, etc.).
     * Fitness Tracking: Helps in monitoring changes in muscle mass and body
     * composition, which is essential for athletes and those focusing on fitness.
     * 
     * @param weight Weight in kilograms
     * @param bfp    Body Fat Percentage
     * 
     * @return Calculated Lean Body Mass (LBM)
     */
    public float getLBM(Float weight, float bfp) {
        return weight - (bfp * 0.01f * weight);
    }

    /**
     * Calculates Ideal Body Weight (IBW).
     * 
     * BJ Devine's Formula:
     * Men: IBW = 50 + 2.3 * (Height - 60)
     * Women: IBW = 45.5 + 2.3 * (Height - 60)
     * 
     * @param gender Gender
     * @param height Height in meters
     * 
     * @return Calculated Ideal Body Weight (IBW)
     */
    public float getIBW(Gender gender, Float height) {
        height = height * 39.3701f; // Convert height from meters to inches
        switch (gender) {
            case MALE:
                return 50f + 2.3f * (height - 60);
            case FEMALE:
                return 45.5f + 2.3f * (height - 60);
        }
        return 0;
    }

}
