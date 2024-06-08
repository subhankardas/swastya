package com.codespark.vitals.models;

import org.springframework.data.annotation.Transient;

import com.codespark.dto.user.UserProfileUpdateRequest;
import com.codespark.utils.DateUtils;
import com.codespark.vitals.utils.BasicVitalsCalculator;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BasicVitals {

    @Transient
    public static final BasicVitalsCalculator basicVitalsCalculator = new BasicVitalsCalculator();
    @Transient
    private final UserProfileUpdateRequest profile;

    // Basic vitals
    private float bmi;
    private float bmr;
    private float tdee;
    private float bfp;
    private float lbm;
    private float ibw;

    @Builder
    public BasicVitals(UserProfileUpdateRequest profile) {
        this.profile = profile;
        int age = DateUtils.getAge(profile.getDateOfBirth());

        // Calculate basic vitals
        this.bmi = basicVitalsCalculator.getBMI(profile.getHeight(), profile.getWeight());
        this.bmr = basicVitalsCalculator.getBMR(profile.getHeight(), profile.getWeight(), profile.getGender(), age);
        this.tdee = basicVitalsCalculator.getTDEE(this.bmr, profile.getActivity(), profile.getGender());
        this.bfp = basicVitalsCalculator.getBFP(this.bmi, age, profile.getGender());
        this.lbm = basicVitalsCalculator.getLBM(profile.getWeight(), this.bfp);
        this.ibw = basicVitalsCalculator.getIBW(profile.getGender(), profile.getHeight());
    }

}
