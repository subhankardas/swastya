package com.codespark.core.constants;

public enum Gender {

    MALE(0),
    FEMALE(1);

    private Integer value;

    Gender(Integer value) {
        this.value = value;
    }

    public Integer getGender() {
        return value;
    }

    public static Gender fromGender(Integer gender) {
        switch (gender) {
            case 0:
                return MALE;
            case 1:
                return FEMALE;
            default:
                return MALE;
        }
    }

}
