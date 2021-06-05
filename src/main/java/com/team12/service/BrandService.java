package com.team12.service;

import com.team12.entity.Brand;
import com.team12.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    BrandRepository brandRepository;

    public Brand saveBrand(Brand newBrand){
        return brandRepository.save(newBrand);
    }

    public List<Brand> getBrands(){
        return brandRepository.findAll();
    }

    public Brand getBrandById(int brandID){
        return brandRepository.findById(brandID).orElse(null);
    }

    public Brand getBrandByBrandName(String brandName){
        return brandRepository.findBrandByBrandName(brandName);
    }

}
