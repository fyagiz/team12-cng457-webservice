package com.team12.service;

import com.team12.entity.AdditionalFeature;

import com.team12.repository.AdditionalFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdditionalFeatureService {
    @Autowired
    AdditionalFeatureRepository additionalFeatureRepository;

    public AdditionalFeature saveAdditionalFeature(AdditionalFeature newAdditionalFeature){
        return additionalFeatureRepository.save(newAdditionalFeature);
    }
    public AdditionalFeature getAdditionalFeature(int afId){
        return additionalFeatureRepository.findById(afId).orElse(null);
    }
}
