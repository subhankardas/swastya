package com.codespark.vitals.models;

import org.springframework.data.annotation.Transient;

import com.codespark.core.dto.user.UserProfileUpdateRequest;
import com.codespark.core.utils.DateUtils;
import com.codespark.vitals.utils.BasicVitalsCalculator;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BasicVitals {

    @Transient
    public static final BasicVitalsCalculator basicVitalsCalculator = new BasicVitalsCalculator();

    // Basic vitals
    private float bmi;
    private float bmr;
    private float tdee;
    private float bfp;
    private float lbm;
    private float ibw;

    public void updateBasicVitals(UserProfileUpdateRequest profile) {
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
