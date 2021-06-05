package com.team12.controller;

import com.team12.entity.Brand;
import com.team12.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {
    @Autowired
    BrandService brandService;

    @PostMapping("/addBrand")
    public Brand saveBrand(@RequestBody Brand newBrand){
        return brandService.saveBrand(newBrand);
    }

    @GetMapping("/getBrands")
    public List<Brand> getBrands(){
        return brandService.getBrands();
    }

    @GetMapping("/getBrand/{brandID}")
    public Brand getBrandById(@PathVariable int brandID){
        return brandService.getBrandById(brandID);
    }

    @GetMapping("/getBrand/name/{brandName}")
    public Brand getBrandByName(@PathVariable String brandName){
        return brandService.getBrandByBrandName(brandName);
    }
}
