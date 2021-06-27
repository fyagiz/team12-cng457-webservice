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

    /***
     * This is the method that allows to communicate brand service to post the new brand and saves it.
     * An example usage is as follows: {@code saveBrand({
     *     "brandName": "Apple"
     * });}
     * @param newBrand represents the new brand object
     * @return new Brand object that is taken from the service.
     */
    @PostMapping("/addBrand")
    public Brand saveBrand(@RequestBody Brand newBrand){
        return brandService.saveBrand(newBrand);
    }

    /***
     *This is the get method that allows to get the all brand objects without sending any parameter.
     * An example usage is as follows: {@code getBrands();}
     * @return all Brand objects- the brand objects in a list is returned. Brand object has brandID as integer and brandName as string
     */
    @GetMapping("/getBrands")
    public List<Brand> getBrands(){
        return brandService.getBrands();
    }

    /***
     *This is the method that allows to get the brands by sending the specific brand id as a parameter.
     * An example usage is as follows: {@code getBrandById(1);}
     * @param brandID represents the id of a brand as integer to be posted.
     * @return Brand object- the brand object which has the integer brandID and string brandName
     */

    @GetMapping("/getBrand/{brandID}")
    public Brand getBrandById(@PathVariable int brandID){
        return brandService.getBrandById(brandID);
    }

    /***
     *This is the get method that allows to get the brand objects that have the following parameter.
     * An example usage is as follows: {@code getBrandByName("Apple");}
     * @param brandName string-represents the value of the brand name that is sent to the service.
     * @return Brand objects- The output of the method, brand objects has integer brandID and string brandName.
     */

    @GetMapping("/getBrand/name/{brandName}")
    public Brand getBrandByName(@PathVariable String brandName){
        return brandService.getBrandByBrandName(brandName);
    }
}
