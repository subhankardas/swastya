package com.codespark.constants;

public enum ActivityLevel {

    SEDENTARY(0),
    LIGHTLY_ACTIVE(1),
    MODERATELY_ACTIVE(2),
    VERY_ACTIVE(3),
    SUPER_ACTIVE(4);

    private Integer value;

    ActivityLevel(Integer value) {
        this.value = value;
    }

    public Integer getActivity() {
        return value;
    }

    /**
     * Convert activity level value to ActivityLevel.
     * 
     * @param activity Activity level value
     * 
     * @return ActivityLevel
     */
    public static ActivityLevel fromActivity(Integer activity) {
        switch (activity) {
            case 0:
                return SEDENTARY;
            case 1:
                return LIGHTLY_ACTIVE;
            case 2:
                return MODERATELY_ACTIVE;
            case 3:
                return VERY_ACTIVE;
            case 4:
                return SUPER_ACTIVE;
            default:
                return SEDENTARY;
        }
    }

}
