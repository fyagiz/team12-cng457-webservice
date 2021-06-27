package com.team12.controller;

import com.team12.entity.AdditionalFeature;
import com.team12.service.AdditionalFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionalFeatureController {
    @Autowired
    AdditionalFeatureService additionalFeatureService;

    /***
     * This is the method which allows to set the new additional feature.
     * An example usage is as follows: {@code saveAdditionalFeature({
     *     "additionalFeature":"Long battery life",
     *     "productList":[
     *     ]
     *
     * });}
     * @param newAdditionalFeature represents the additional feature object that is saved.
     * @return new Additional Feature object that is taken from service.
     */
    @PostMapping("/addAdditionalFeature")
    public AdditionalFeature saveAdditionalFeature(@RequestBody AdditionalFeature newAdditionalFeature){
        return additionalFeatureService.saveAdditionalFeature(newAdditionalFeature);
    }
}
