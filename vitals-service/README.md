# Swastya Vitals Service - Health Metrics & Analytics

## Overview
This application calculates various health metrics based on user inputs such as height, weight, age, and activity levels. These metrics provide insights into an individual's health status, body composition, and caloric needs, aiding in fitness assessment and goal setting.

## Formulas

### 1. Body Mass Index (BMI)
- Formula: BMI = weight (kg) / (height (m)^2)
- Significance: Indicates body fatness and associated health risks.

### 2. Basal Metabolic Rate (BMR)
- Formulas:
  - Harris-Benedict Equation
  - Mifflin-St Jeor Equation
- Significance: Estimates daily calorie needs at rest.

### 3. Total Daily Energy Expenditure (TDEE)
- Formula: TDEE = BMR × Activity Level
- Significance: Calculates total daily calorie needs based on activity level.

### 4. Body Fat Percentage
- Formula: Body Fat % = (1.20 × BMI) + (0.23 × Age) - (16.2 for men, 5.4 for women)
- Significance: Provides insights into body composition and health risks.

### 5. Lean Body Mass (LBM)
- Formula: LBM = Weight (kg) × (1 - Body Fat %)
- Significance: Represents non-fat body mass, crucial for fitness assessment.

### 6. Ideal Body Weight (IBW)
- Formulas:
  - Devine Formula
  - Robinson Formula
- Significance: Offers target weight range for optimal health.

### 7. Caloric Needs for Weight Management
- Formula: 
  - To Lose Weight: Daily Calories = TDEE - 500
  - To Gain Weight: Daily Calories = TDEE + 500
- Significance: Guides caloric intake for weight loss or gain.

### 8. Physical Fitness Age
- Estimate: Derived based on activity level compared to average fitness levels for specific ages.
- Significance: Indicates overall fitness relative to age.

## Usage
1. Input user data (height, weight, age, activity level).
2. Obtain calculated health metrics.

## Contributing
Contributions are welcome! Please submit issues or pull requests.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
